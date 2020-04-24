package by.epam.eventto.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface DAO<T, K> {
    boolean create(T item);
    T get(K key);
    List<T> getAll();
    boolean update(T updated);
    boolean delete(K key);
}
