package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.commands.UpdateCustomerCommand;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateCustomerResource;

public class UpdateCustomerCommandFromResourceAssembler {
    public static UpdateCustomerCommand toCommandFromResource(Long customerId, CreateCustomerResource resource){
        return new UpdateCustomerCommand(customerId, resource.name(), resource.lastName(), resource.birthday(),
                resource.email(), resource.phone());
    }
}
