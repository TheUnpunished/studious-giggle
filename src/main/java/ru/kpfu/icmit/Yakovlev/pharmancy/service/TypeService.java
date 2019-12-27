package ru.kpfu.icmit.Yakovlev.pharmancy.service;

import org.springframework.stereotype.Service;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Type;
import ru.kpfu.icmit.Yakovlev.pharmancy.repository.TypeRepository;

@Service
public class TypeService extends CrudServiceImpl<Type, TypeRepository> {
    public TypeService(TypeRepository genericRepository) {
        super(genericRepository);
    }
}
