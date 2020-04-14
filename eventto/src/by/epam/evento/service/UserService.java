package by.epam.evento.service;

import by.epam.evento.dao.UserController;
import by.epam.evento.entity.User;
import by.epam.evento.exception.ServiceException;
import java.util.ArrayList;

public class UserService extends Service<User> {

    private UserController userController;

    public  UserService(){
        userController = new UserController();
    }

    public ArrayList<User> getData() {
        return userController.getData();
    }

    @Override
    public void read() {
        userController.read();
    }

    @Override
    public void save() {
        userController.save();
    }

    public void create(User user) {
        try {
            if (!(isEntityExist(user))) {
                userController.create(user);
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
                userController.update(user);
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
                userController.delete(user);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }
}
