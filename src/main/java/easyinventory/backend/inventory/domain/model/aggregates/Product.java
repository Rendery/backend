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
        this.name = name;
        this.unitPrice = unitPrice;
        this.realPrice = realPrice;
        this.discount = discount;
        this.stock = stock;
        this.currentStock = currentStock;
        this.userId = userId;
    }

    public Product() {}
}
