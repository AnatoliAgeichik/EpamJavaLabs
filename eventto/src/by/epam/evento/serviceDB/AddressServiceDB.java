package by.epam.evento.serviceDB;

import by.epam.evento.dao.AddressController;
import by.epam.evento.dao.CommentController;
import by.epam.evento.daodb.AddressDao;
import by.epam.evento.entity.Address;
import by.epam.evento.exception.ServiceException;
import by.epam.evento.serviceDB.ServiceDB;

import java.util.ArrayList;

public class AddressServiceDB extends ServiceDB<Address> {

    private AddressDao addressDao;

    public AddressServiceDB(){
        addressDao = new AddressDao();
    }

    @Override
    public void read() {
        addressDao.read();
    }

    @Override
    public ArrayList<Address> getData() {
        return addressDao.getData();

    }

    @Override
    public void create(Address entity) {
        try {

            if (!(isEntityExist(entity))) {
                addressDao.create(entity);
            } else {
                throw  new ServiceException("such address already exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void update(Address entity) {
        try {
            if ((isEntityExist(entity))) {
                addressDao.update(entity);
            } else {
                throw  new ServiceException("such address does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Address entity) {
        try {
            if (isEntityExist(entity)) {
                addressDao.delete(entity.getAddressId());
            } else {
                throw  new ServiceException("such address does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }
}
