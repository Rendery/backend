package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.commands.UpdateProductCommand;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateProductResource;

public class UpdateProductCommandFromResourceAssembler {
    public static UpdateProductCommand toCommandFromResource(Long productId, CreateProductResource resource){
        return new UpdateProductCommand(productId, resource.name(), resource.unitPrice(), resource.realPrice(),
                resource.discount(), resource.stock(), resource.currentStock(), resource.userId());
    }
}
