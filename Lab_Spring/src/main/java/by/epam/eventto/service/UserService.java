package by.epam.eventto.service;

import by.epam.eventto.dao.UserDao;
import by.epam.eventto.entity.User;
import by.epam.eventto.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserService extends Service<User, String> {


    @Autowired
    private UserDao userDao;

//    public UserService(){
//        userDao = new UserDao();
//    }

    public List<User> getData() {
        return userDao.getAll();
    }

    @Override
    public User getEntity(String key) {
        return userDao.get(key);
    }

    public void create(User user) {
        try {
            if (!(isEntityExist(user.getEmail()))) {
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
            if ((isEntityExist(user.getEmail()))) {
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
    public void delete(String key) {
        try {
            if (isEntityExist(key)) {
                userDao.delete(key);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }
}
