package by.epam.eventto.service;

import by.epam.eventto.dao.AddressDao;
import by.epam.eventto.dao.CommentDao;
import by.epam.eventto.dao.AddressDao;
import by.epam.eventto.entity.Address;
import by.epam.eventto.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressService extends Service<Address, Long> {

    @Autowired
    private AddressDao addressDao;

//    public AddressService(){
//        addressDao = new AddressDao();
//    }
//
//    @Override
//    public void read() {
//        addressDao.getAll();
//    }



    @Override
    public List<Address> getData() {
        return addressDao.getAll();

    }

    @Override
    public Address getEntity(Long key) {
        return  addressDao.get(key);
    }

    @Override
    public void create(Address entity) {
        try {

            if (!(isEntityExist(entity.getAddressId()))) {
                addressDao.create(entity);
            } else {
                throw  new ServiceException("such user already exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void update(Address entity) {
        try {
            if ((isEntityExist(entity.getAddressId()))) {
                addressDao.update(entity);
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
                addressDao.delete(key);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }
}
