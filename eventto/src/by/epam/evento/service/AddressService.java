package by.epam.evento.service;

import by.epam.evento.dao.AddressController;
import by.epam.evento.entity.Address;
import by.epam.evento.exception.ServiceException;

import java.util.ArrayList;

public class AddressService extends by.epam.evento.service.Service<Address> {

    private AddressController addressController;

    public AddressService(){
        addressController = new AddressController();
    }

    @Override
    public void read() {
        addressController.read();
    }

    @Override
    public void save() {
        addressController.save();
    }

    @Override
    public ArrayList<Address> getData() {
        return addressController.getData();

    }

    @Override
    public void create(Address entity) {
        try {

            if (!(isEntityExist(entity))) {
                addressController.create(entity);
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
            if ((isEntityExist(entity))) {
                addressController.update(entity);
            } else {
                throw  new ServiceException("such user does not exist");

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
                addressController.delete(entity);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }
}
