package by.epam.evento.service;

import by.epam.evento.dao.MembersController;
import by.epam.evento.entity.Members;
import by.epam.evento.exception.ServiceException;

import java.util.ArrayList;

public class MembersService extends Service<Members> {

    private MembersController membersController;

    public MembersService(){
         membersController = new MembersController();
    }

    @Override
    public void read() {
        MembersController mc = new MembersController();
        membersController.read();
    }

    @Override
    public void save() {
        membersController.save();
    }

    @Override
    public ArrayList<Members> getData() {
        return membersController.getData();
    }

    @Override
    public void create(Members entity) {
        try {
            if (!(isEntityExist(entity))) {
                membersController.create(entity);
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
                membersController.update(entity);
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
                membersController.delete(entity);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }
}
