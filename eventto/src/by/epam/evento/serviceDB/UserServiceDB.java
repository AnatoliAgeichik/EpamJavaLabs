package by.epam.evento.serviceDB;

import by.epam.evento.daodb.UserDao;
import by.epam.evento.entity.User;
import by.epam.evento.exception.ServiceException;
import java.util.ArrayList;

public class UserServiceDB extends ServiceDB<User> {

    private UserDao userDao;

    public UserServiceDB(){
        userDao = new UserDao();
    }

    public ArrayList<User> getData() {
        return userDao.getData();
    }

    @Override
    public void read() {
        userDao.read();
    }

    public void create(User user) {
        try {
            if (!(isEntityExist(user))) {
                userDao.create(user);
            } else {
                throw new ServiceException("such user already exists");
            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

    }

    @Override
    public void update(User user) {
        try {
            if ((isEntityExist(user))) {
                userDao.update(user);
            } else {
                throw  new ServiceException("such user does not exist");
            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(User user) {
        try {
            if (isEntityExist(user)) {
                userDao.delete(user.getEmail());
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }
}
