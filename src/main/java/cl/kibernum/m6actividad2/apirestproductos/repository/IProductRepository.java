package cl.kibernum.m6actividad2.apirestproductos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import cl.kibernum.m6actividad2.apirestproductos.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long>{
    List<Product> findAllByActiveTrue();
}
