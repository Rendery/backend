package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.aggregates.Customer;
import easyinventory.backend.inventory.interfaces.rest.resources.CustomerResource;

public class CustomerResourceFromEntityAssembler {
    public static CustomerResource toResourceFromEntity(Customer customer){
        return new CustomerResource(customer.getId(), customer.getName(), customer.getLastName(),
                customer.getBirthday(), customer.getEmail(), customer.getPhone());
    }
}
