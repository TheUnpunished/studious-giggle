package ru.kpfu.icmit.Yakovlev.pharmancy.service;

import org.springframework.stereotype.Service;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Shop;
import ru.kpfu.icmit.Yakovlev.pharmancy.repository.ShopRepository;

@Service
public class ShopService extends CrudServiceImpl<Shop, ShopRepository> {
    public ShopService(ShopRepository genericRepository) {
        super(genericRepository);
    }
}
