package by.epam.evento.serviceDB;

import by.epam.evento.daodb.MembersDao;
import by.epam.evento.entity.Members;
import by.epam.evento.exception.ServiceException;

import java.util.ArrayList;

public class MembersServiceDB extends ServiceDB<Members> {

    private MembersDao membersDao;

    public MembersServiceDB(){
         membersDao = new MembersDao();
    }

    @Override
    public void read() {
        membersDao.read();
    }

    @Override
    public ArrayList<Members> getData() {
        return membersDao.getData();
    }

    @Override
    public void create(Members entity) {
        try {
            if (!(isEntityExist(entity))) {
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
            if ((isEntityExist(entity))) {
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
    public void delete(Members entity) {
        try {

            if (isEntityExist(entity)) {
                membersDao.delete(entity.getMemberId());
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }
}
