package by.epam.eventto.service;

import by.epam.eventto.dao.MembersDao;
import by.epam.eventto.entity.Members;
import by.epam.eventto.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MembersService extends Service<Members, Long> {

    @Autowired
    private MembersDao membersDao;

   // public MembersService(){
     //    membersDao = new MembersDao();
    //}

    @Override
    public List<Members> getData() {
        return membersDao.getAll();
    }

    @Override
    public Members getEntity(Long key) {
        return membersDao.get(key);
    }

    @Override
    public void create(Members entity) {
        try {
            if (!(isEntityExist(entity.getMemberId()))) {
                membersDao.create(entity);
            } else {
                throw  new ServiceException("such user already exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

    }

    @Override
    public void update(Members entity) {
        try {
            if ((isEntityExist(entity.getMemberId()))) {
                membersDao.update(entity);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Long key) {
        try {

            if (isEntityExist(key)) {
                membersDao.delete(key);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }
}
