package com.makeev.mvchibernate.DAO;

import java.util.List;
import java.util.Set;

public interface DAO<T, K>{
    public void save(T t);
    public T readById(K k);
    public List<T> readAll();
    public void update(T t);
    public void delete(T t);
    public void deleteById(K k);
}
