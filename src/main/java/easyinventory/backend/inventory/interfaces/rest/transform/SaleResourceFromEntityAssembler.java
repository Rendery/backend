package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.aggregates.Sale;
import easyinventory.backend.inventory.interfaces.rest.resources.SaleResource;

public class SaleResourceFromEntityAssembler {
    public static SaleResource toResourceFromEntity(Sale sale){
        return new SaleResource(sale.getId(), sale.getName(), sale.getSaleDate(), sale.getTotalCost());
    }
}
