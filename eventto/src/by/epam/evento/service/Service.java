package by.epam.evento.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.epam.evento.entity.User;

import java.util.ArrayList;

public abstract class Service<E> {
    static Logger log= LogManager.getLogger();

    public abstract ArrayList<E> getData();

    public abstract  void read();

    public boolean isEntityExist(E entity) {
        ArrayList<E> arr = getData();
        for (E item : arr) {
            if (item.hashCode() == entity.hashCode()) {
                return true;
            }

        }
        return false;
    }
    public  abstract  void save();
    public abstract void create(E entity);

    public abstract void update(E entity);

    public abstract void delete(E entity);

}
