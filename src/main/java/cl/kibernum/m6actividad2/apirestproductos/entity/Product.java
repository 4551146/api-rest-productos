package cl.kibernum.m6actividad2.apirestproductos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")

public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="name", nullable = false, length = 50)
  private String name;
  @Column(name="description", nullable = false, length = 50)
  private String description;
  @Column(name="stock", nullable = false, length = 50)
  private int stock;
  @Column(name="price", nullable = false, length = 50, unique = true)
  private int price;

  public Product(){
    
  }

  public Product(String name, String description, int stock, int price) {
    this.name = name;
    this.description = description;
    this.stock = stock;
    this.price = price;
    
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public int getStock() {
    return stock;
  }
  public void setStock(int stock) {
    this.stock = stock;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }

    @Override
  public String toString() {
    return "Usuario{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", stock='" + stock + '\'' +
            ", price='" + price + '\'' +
            '}';
  }
  
  
}
