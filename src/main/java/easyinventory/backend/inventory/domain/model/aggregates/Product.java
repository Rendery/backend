package easyinventory.backend.inventory.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Integer unitPrice;
    private Integer realPrice;
    private Integer discount;
    private Integer stock;
    private Integer currentStock;
    private Long userId;

    public Product(String name, Integer unitPrice, Integer realPrice, Integer discount, Integer stock, Integer currentStock, Long userId) {
        if (isValidProduct(name, unitPrice, realPrice, discount, stock, currentStock, userId)) {
            this.name = name;
            this.unitPrice = unitPrice;
            this.realPrice = realPrice;
            this.discount = discount;
            this.stock = stock;
            this.currentStock = currentStock;
            this.userId = userId;
            return;
        }
        throw new IllegalArgumentException("Invalid product");
    }

    //is valid product
    public boolean isValidProduct(String nombre, Integer precioUnitario, Integer precioReal, Integer descuento, Integer stock, Integer stockActual, Long userId) {
        if (nombre == null) throw new IllegalArgumentException("Product name is required") ;
        if (precioUnitario <= 0) throw new IllegalArgumentException("Product price is invalid") ;
        if (precioReal <= 0) throw new IllegalArgumentException("Product real price is invalid") ;
        if (descuento == null) throw new IllegalArgumentException("Product discount is required") ;
        if (stock <= 0) throw new IllegalArgumentException("Product stock is invalid") ;
        if (stockActual <= 0) throw new IllegalArgumentException("Product current stock is invalid") ;
        if (userId == null) throw new IllegalArgumentException("Product user id is required") ;
        return true;
    }

    //validate stock
    public boolean hasStock() {
        return this.currentStock > 0;
    }



    public void discountStock(Integer quantity) {
        if (quantity > this.currentStock) throw new IllegalArgumentException("Not enough stock") ;
        this.currentStock -= quantity;
    }




    public Product() {}
}
