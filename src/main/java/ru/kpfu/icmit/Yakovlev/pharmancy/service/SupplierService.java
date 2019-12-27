package ru.kpfu.icmit.Yakovlev.pharmancy.service;

import org.springframework.stereotype.Service;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Supplier;
import ru.kpfu.icmit.Yakovlev.pharmancy.repository.SupplierRepository;

@Service
public class SupplierService extends CrudServiceImpl<Supplier, SupplierRepository> {
    public SupplierService(SupplierRepository genericRepository) {
        super(genericRepository);
    }
}
