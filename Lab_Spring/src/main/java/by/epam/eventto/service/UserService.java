package by.epam.eventto.service;

import by.epam.eventto.dao.UserDao;
import by.epam.eventto.entity.User;
import by.epam.eventto.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class UserService extends Service<User, String> {

    public static final Logger log = LogManager.getLogger();

    @Autowired
    private UserDao userDao;

//    public UserService(){
//        userDao = new UserDao();
//    }

    public List<User> getData() {
        return userDao.getAll(10);
    }

    @Override
    public Optional<User> getEntity(String key) {
//        try{
//            log.info("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
//            User user = Optional.of(userDao.get(key)).orElseThrow(ServiceException::new);
//            log.info("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
//        }catch (ServiceException e){
//            log.info(e.getMessage());
//        }
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
