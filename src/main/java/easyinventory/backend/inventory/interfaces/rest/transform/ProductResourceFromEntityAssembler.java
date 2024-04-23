package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.aggregates.Product;
import easyinventory.backend.inventory.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product product){
        return new ProductResource(product.getId(), product.getName(), product.getUnitPrice(),
                product.getRealPrice(), product.getDiscount(), product.getStock(), product.getCurrentStock(),
                product.getUserId());
    }
}
