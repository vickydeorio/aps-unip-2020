package com.aps.cc.unip.DAO;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    T get(long id);

    List<T> getAll();

    void save(T t);

    void delete(T t);
}
