package cl.kibernum.m6actividad2.apirestproductos.service;

import java.util.List;
import java.util.Optional;

import cl.kibernum.m6actividad2.apirestproductos.entity.Product;

public interface IProductService {
    public List<Product> listAllProducts();
    public Product saveProduct(Product product);
    public Optional<Product> getProductById(Long id);
    public Product updatedProduct(Product product);
    public void deleteProductById(Long id);
    
}
