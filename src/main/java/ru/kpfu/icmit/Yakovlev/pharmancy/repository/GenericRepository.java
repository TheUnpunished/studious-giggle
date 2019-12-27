package ru.kpfu.icmit.Yakovlev.pharmancy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.BaseEntity;

@NoRepositoryBean
public interface GenericRepository<T extends BaseEntity> extends CrudRepository<T, Long> {

}
