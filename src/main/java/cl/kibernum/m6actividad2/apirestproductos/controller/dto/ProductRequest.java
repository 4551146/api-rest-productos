package cl.kibernum.m6actividad2.apirestproductos.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductRequest {
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Size(max = 50)
    private String description;
    @NotBlank
    @Size(max = 50)
    private int stock;
    @NotBlank
    @Size(max = 50)
    private int price;
    

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getStock() { return stock; }
    public void setStock(int stock) {this.stock = stock; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
