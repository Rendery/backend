package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.commands.CreateProviderCommand;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateProviderResource;

public class CreateProviderCommandFromResourceAssembler {
    public static CreateProviderCommand toCommandFromResource(CreateProviderResource resource){
        return new CreateProviderCommand(resource.name(), resource.phone(), resource.ruc(),
                resource.email());
    }
}
