package com.demo.task.helpers;

import java.util.List;

public interface BasicDataCrud<T> {
    void save(T t);
    T findById(int id);
    List<T> findByNameStartsWith(String name);
    void update(T t);
    void delete(int id);
    List<T> findAll();
}
