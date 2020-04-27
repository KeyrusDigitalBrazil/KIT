package com.keyrus.kit.repository;

import java.util.List;

public interface KitRepository<T> {

    boolean add(T object);

    boolean update(T object);

    boolean remove(Long id);

    T get(Long id);

    List<T> getAll();

}
