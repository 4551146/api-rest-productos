package cl.kibernum.m6actividad2.apirestproductos.controller;

import cl.kibernum.m6actividad2.apirestproductos.entity.Product;
import cl.kibernum.m6actividad2.apirestproductos.entity.User;
import cl.kibernum.m6actividad2.apirestproductos.service.IProductService;
import cl.kibernum.m6actividad2.apirestproductos.service.IUserService;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
public class ProductController {

    private final IProductService service;

    public ProductController(IProductService service){
        this.service = service;
    }
    
    @GetMapping({"/products", "/"})
    public String listarProductos(Model model) {
        model.addAttribute("products", service.listAllProducts());
        return "products";
    }

    @GetMapping("/users/new")
    public String createProductForm(Model model) {
        User product = new Product();
        model.addAttribute("product", product);
        return "create-product";
  }

  @GetMapping("/products/edit/{id}")
  public String showFormEditUser(@PathVariable Long id, Model model) {
    Optional<Product> optionalProduct = service.getProductById(id);
    if (!optionalUser.isPresent()) {
      throw new ProductNotFoundException("No se encontró un producto con id: " + id);
    }
    User productExists = optionalUser.get();
    model.addAttribute("product", productExists);
    return "edit_product";
  }

  @PostMapping("/productos/{id}")
  public String updatedProduct(@PathVariable Long id, @ModelAttribute("product") User product, Model model ) {
    Optional<Product> optionalProduct = service.getProductById(id);
    System.out.println(optionalProduct.isPresent());
    if (!optionalProduct.isPresent()) {
      throw new ProductNotFoundException("No se encontró un producto con id: " + id);
    }
    Product productExists = optionalProduct.get();
    
    productExists.setId(id);
    productExists.setName(product.getName());
    productExists.setDescription(product.getDescription());
    productExists.setStock(product.getStock());
    productExists.setPrice(product.getPrice());
    //productExists.setActive(product.getActive());

    service.updatedProduct(productExists);
    return "redirect:/products";
  }

  @GetMapping("/products-delete/{id}")
  public String eliminarProducto(@PathVariable Long id) {
    service.deleteProductById(id);
    return "redirect:/products";
  }


}

class ProductNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
    
}
