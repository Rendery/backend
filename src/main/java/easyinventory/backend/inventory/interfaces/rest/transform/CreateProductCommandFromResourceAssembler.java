package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.commands.CreateProductCommand;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource){
        return new CreateProductCommand(resource.name(), resource.unitPrice(), resource.realPrice(),
                resource.discount(), resource.stock(), resource.currentStock(), resource.userId());
    }
}
