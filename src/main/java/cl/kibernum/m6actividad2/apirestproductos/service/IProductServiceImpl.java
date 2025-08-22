package cl.kibernum.m6actividad2.apirestproductos.service;

import org.springframework.stereotype.Service;

import cl.kibernum.m6actividad2.apirestproductos.repository.IProductRepository;
import cl.kibernum.m6actividad2.apirestproductos.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
public class IProductServiceImpl implements IProductService {
    private final IProductRepository repository;

    public IProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> listAllProducts() {
        return repository.findAllByActiveTrue();
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product updatedProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Optional<Product> productOpt = repository.findById(id);
        productOpt.ifPresent(product -> {
            product.setActive(false);
            repository.save(product);
        });
    }
}
