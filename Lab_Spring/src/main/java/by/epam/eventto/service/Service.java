package by.epam.eventto.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.epam.eventto.entity.User;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Service<E, K> {
    static Logger log= LogManager.getLogger();

    public abstract List<E> getData();

    //public abstract  void read();

//    public boolean isEntityExist(E entity) {
//        List<E> arr = getData();
//        for (E item : arr) {
//            if (item.hashCode() == entity.hashCode()) {
//                return true;
//            }
//
//        }
//        return false;
//    }
//    public boolean isEntityExist(K key) {
//        List<E> arr = getData();
//        E entity = getEntity(key);
//        for (E item : arr) {
//            if (item.hashCode() == entity.hashCode()) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isEntityExist(K key) {
        try{
           E entity = getEntity(key).get();
        }catch (DataAccessException e){
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    public abstract Optional<E> getEntity(K key);

    public abstract void create(E entity);

    public abstract void update(E entity);

    public abstract void delete(K key);

}
