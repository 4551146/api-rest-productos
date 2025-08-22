package cl.kibernum.m6actividad2.apirestproductos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.kibernum.m6actividad2.apirestproductos.entity.Product;
import cl.kibernum.m6actividad2.apirestproductos.service.IProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

  private final IProductService service;

  public ProductController(IProductService service) {
    this.service = service;
  }

  // Listar productos
  @GetMapping
  public List<Product> listarProductos() {
    return service.listAllProducts();
  }

  // Crear nuevo producto
  @PostMapping
  public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
    if (product.getId() == null && !product.isActive()) {
      product.setActive(true); // Por defecto, activo
    }
    Product saved = service.saveProduct(product);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }

  // Ver detalles de un producto
  @GetMapping("/{id}")
  public ResponseEntity<Product> viewProduct(@PathVariable Long id) {
    Optional<Product> optionalProduct = service.getProductById(id);
    if (!optionalProduct.isPresent()) {
      throw new ProductNotFoundException("No se encontró un producto con id: " + id);
    }
    return ResponseEntity.ok(optionalProduct.get());
  }

  // Actualizar producto existente (PUT)
  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    Optional<Product> optionalProduct = service.getProductById(id);
    if (!optionalProduct.isPresent()) {
      throw new ProductNotFoundException("No se encontró un producto con id: " + id);
    }
    Product productExists = optionalProduct.get();
    productExists.setName(product.getName());
    productExists.setDescription(product.getDescription());
    productExists.setStock(product.getStock());
    productExists.setPrice(product.getPrice());
    Product updated = service.updatedProduct(productExists);
    return ResponseEntity.ok(updated);
  }

  // Eliminar producto (DELETE)
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    service.deleteProductById(id);
    return ResponseEntity.noContent().build();
  }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super(message);
  }
}
