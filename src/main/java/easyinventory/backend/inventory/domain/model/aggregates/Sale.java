package easyinventory.backend.inventory.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
        this.products = new ArrayList<>();
    }

    //obtener cantidad de productos
    public Integer getProductsCount(){
        return this.products.size();
    }

    //agregar producto a la venta
    public void addProducts(List<Product> product){
        this.products.addAll(product);
    }


    //eliminar producto de la venta
    public void removeProduct(Product product){
        this.products.remove(product);
    }

    //calcular el total de la venta
    public Integer calculateTotalCost(){
        this.totalCost = 0;
        for(Product product : this.products){
            this.totalCost += product.getRealPrice();
        }
        return this.totalCost;
    }





    public Sale() {}
}
