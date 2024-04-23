package easyinventory.backend.inventory.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String saleDate ;
    private Integer totalCost ;
    @OneToMany
    private List<Product> products;

    public Sale(String name, String saleDate, Integer totalCost) {
        this.name = name;
        this.saleDate = saleDate;
        this.totalCost = totalCost;
    }

    public Sale() {}
}
