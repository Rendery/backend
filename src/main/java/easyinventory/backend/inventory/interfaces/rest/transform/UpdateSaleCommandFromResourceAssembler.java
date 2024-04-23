package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.commands.UpdateSaleCommand;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateSaleResource;

public class UpdateSaleCommandFromResourceAssembler {
    public static UpdateSaleCommand toCommandFromResource(Long saleId, CreateSaleResource resource){
        return new UpdateSaleCommand(saleId, resource.name(), resource.saleDate(), resource.totalCost());
    }
}
