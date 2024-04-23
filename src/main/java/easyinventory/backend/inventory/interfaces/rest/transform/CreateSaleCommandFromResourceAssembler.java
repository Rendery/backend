package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.commands.CreateSaleCommand;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateSaleResource;

public class CreateSaleCommandFromResourceAssembler {
    public static CreateSaleCommand toCommandFromResource(CreateSaleResource resource){
        return new CreateSaleCommand(resource.name(), resource.saleDate(), resource.totalCost());
    }
}
