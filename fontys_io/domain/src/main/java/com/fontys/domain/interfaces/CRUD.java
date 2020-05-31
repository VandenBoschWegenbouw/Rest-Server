package com.fontys.domain.interfaces;

public interface CRUD<T, R> {
    T create(T entity) throws Exception;

    T read(R id);

    Iterable<T> readAll();

    T update(T entity);

    boolean delete(R id);
}
