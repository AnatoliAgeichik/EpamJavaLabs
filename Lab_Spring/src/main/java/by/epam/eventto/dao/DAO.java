package by.epam.eventto.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface DAO<T, K> {
    void create(T item);
    Optional<T> get(K key);
    List<T> getAll(Integer page);
    T update(T updated);
    void delete(K key);
}
