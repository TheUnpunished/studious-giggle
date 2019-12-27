package ru.kpfu.icmit.Yakovlev.pharmancy.service;

import org.springframework.stereotype.Service;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Product;
import ru.kpfu.icmit.Yakovlev.pharmancy.repository.ProductRepository;

@Service
public class ProductService extends CrudServiceImpl<Product, ProductRepository>{
    public ProductService(ProductRepository genericRepository) {
        super(genericRepository);
    }
}
