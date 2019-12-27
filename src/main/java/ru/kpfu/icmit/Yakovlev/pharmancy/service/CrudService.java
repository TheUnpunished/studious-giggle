package ru.kpfu.icmit.Yakovlev.pharmancy.service;

import ru.kpfu.icmit.Yakovlev.pharmancy.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService<T extends BaseEntity>{
    List<T> getAll();
    T add(T t);
    T update(T t);
    void delete(T t);
    void deleteById(Long id);
    Optional<T> getOneById(Long id);
    void deleteAll();
}
