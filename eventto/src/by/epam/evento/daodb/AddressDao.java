package by.epam.evento.daodb;

import by.epam.evento.entity.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDao extends Dao<Address> {
    {
        setTableName("Address");
        setInsertSql("INSERT INTO Address " +
                "(country, town, street, house)" +
                "VALUES(?,?,?,?)");
        setDeleteSql("DELETE FROM Address WHERE address_id = ");
    }
    @Override
    public Address makeEntity(ResultSet sqlResponse) {
        Address Address = new Address();
        try {
            Address.setAddressId(sqlResponse.getInt("address_id"));
            Address.setCountry(sqlResponse.getString("country").trim());
            Address.setHouse(sqlResponse.getString("house").trim());
            Address.setStreet(sqlResponse.getString("street").trim());
            Address.setTown(sqlResponse.getString("town").trim());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Address;
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Address Address) {
        try {
            preparedStatement.setString(1, Address.getCountry());
            preparedStatement.setString(2, Address.getTown());
            preparedStatement.setString(3, Address.getStreet());
            preparedStatement.setString(4, Address.getHouse());
        } catch (SQLException e) {
            e.printStackTrace();
            //добавить лог
        }
        return preparedStatement;
    }

    @Override
    public String makeUpdateQuery(Address address) {
        String str;
        str = "UPDATE Address ";
        str += "set country = '" + address.getCountry() + "',";
        str += "town = '" + address.getTown() + "',";
        str += "street = '" + address.getStreet() + "',";
        str += "house = '" + address.getHouse() + "' ";
        str += "WHERE address_id = '" + address.getAddressId() + "'";
        return str;
    }
}
