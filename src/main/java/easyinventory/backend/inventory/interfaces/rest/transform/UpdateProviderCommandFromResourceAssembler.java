package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.commands.UpdateProviderCommand;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateProviderResource;

public class UpdateProviderCommandFromResourceAssembler {
    public static UpdateProviderCommand toCommandFromResource(Long providerId, CreateProviderResource resource){
        return new UpdateProviderCommand(providerId, resource.name(), resource.phone(), resource.ruc(),
                resource.email());
    }
}
