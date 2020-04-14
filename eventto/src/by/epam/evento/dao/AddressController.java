package by.epam.evento.dao;

import by.epam.evento.entity.Address;

public class AddressController extends Controller<Address> {
    private static final String dir = "data/address.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
