package ru.kpfu.icmit.Yakovlev.pharmancy.service;

import org.springframework.stereotype.Service;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Purchase;
import ru.kpfu.icmit.Yakovlev.pharmancy.repository.PurchaseRepository;

@Service
public class PurchaseService extends CrudServiceImpl<Purchase, PurchaseRepository> {
    public PurchaseService(PurchaseRepository genericRepository) {
        super(genericRepository);
    }
}
