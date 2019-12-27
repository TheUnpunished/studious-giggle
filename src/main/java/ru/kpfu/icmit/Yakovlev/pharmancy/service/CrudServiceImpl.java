package ru.kpfu.icmit.Yakovlev.pharmancy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.icmit.Yakovlev.pharmancy.repository.GenericRepository;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public abstract class CrudServiceImpl<T extends BaseEntity, R extends GenericRepository<T>> implements CrudService<T>{

    protected final R genericRepository;

    @Autowired
    public CrudServiceImpl(R genericRepository){
        this.genericRepository = genericRepository;
    }

    public List<T> getAll() {
        return StreamSupport
                .stream(genericRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public T add(T t) {
        return genericRepository.save(t);
    }

    public T update(T t) {
        return genericRepository.save(t);
    }

    @Override
    public void deleteById(Long id) {
        genericRepository.deleteById(id);
    }

    public void deleteAll(){
        genericRepository.deleteAll();
    }

    public void delete(T t) {
        genericRepository.delete(t);
    }

    public Optional<T> getOneById(Long id) {
        return genericRepository.findById(id);
    }
}
