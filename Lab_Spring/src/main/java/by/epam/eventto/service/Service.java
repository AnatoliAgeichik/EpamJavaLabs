package by.epam.eventto.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.epam.eventto.entity.User;

import java.util.ArrayList;
import java.util.List;

public abstract class Service<E, K> {
    static Logger log= LogManager.getLogger();

    public abstract List<E> getData();

    //public abstract  void read();

    public boolean isEntityExist(E entity) {
        List<E> arr = getData();
        for (E item : arr) {
            if (item.hashCode() == entity.hashCode()) {
                return true;
            }

        }
        return false;
    }

    public abstract E getEntity(K key);

    public abstract void create(E entity);

    public abstract void update(E entity);

    public abstract void delete(E entity);

}
