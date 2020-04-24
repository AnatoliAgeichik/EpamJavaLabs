package by.epam.eventto.mapper;

import by.epam.eventto.entity.Address;
import by.epam.eventto.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {

    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();
        address.setAddressId(rs.getLong("ADDRESS_ID"));
        address.setCountry(rs.getString("COUNTRY").trim());
        address.setTown(rs.getString("TOWN").trim());
        address.setStreet(rs.getString("STREET").trim());
        address.setHouse(rs.getString("HOUSE").trim());
        return address;
    }
}
