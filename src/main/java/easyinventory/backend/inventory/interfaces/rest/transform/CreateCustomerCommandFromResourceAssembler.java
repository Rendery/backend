package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.commands.CreateCustomerCommand;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateCustomerResource;

public class CreateCustomerCommandFromResourceAssembler {

    public static CreateCustomerCommand toCommandFromResource(CreateCustomerResource resource){
        return new CreateCustomerCommand(resource.name(), resource.lastName(), resource.birthday(),
                resource.email(), resource.phone());
    }
}
