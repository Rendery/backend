package easyinventory.backend.inventory.domain.services;

import easyinventory.backend.inventory.domain.model.aggregates.Customer;
import easyinventory.backend.inventory.domain.model.commands.CreateCustomerCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteCustomerCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateCustomerCommand;

import java.util.Optional;

public interface CustomerCommandService {
    Long handle(CreateCustomerCommand command);
    Optional<Customer> handle(UpdateCustomerCommand command);
    Long handle(DeleteCustomerCommand command);
}
