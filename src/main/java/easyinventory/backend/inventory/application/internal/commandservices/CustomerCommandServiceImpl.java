package easyinventory.backend.inventory.application.internal.commandservices;

import easyinventory.backend.inventory.domain.model.aggregates.Customer;
import easyinventory.backend.inventory.domain.model.commands.CreateCustomerCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteCustomerCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateCustomerCommand;
import easyinventory.backend.inventory.domain.services.CustomerCommandService;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {


    private final CustomerRepository customerRepository;

    public CustomerCommandServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Long handle(CreateCustomerCommand command) {
        var customer = new Customer(command.name(), command.lastName(), command.birthday(),
                command.email(), command.phone());
        customerRepository.save(customer);
        return customer.getId();
    }

    @Override
    public Optional<Customer> handle(UpdateCustomerCommand command) {
        var customerToUpdate = customerRepository.findByName(command.name()).orElseThrow(() -> new RuntimeException("Customer not found"));
        if(command.name() != null)
            customerToUpdate.setName(command.name());
        if(command.lastName() != null)
            customerToUpdate.setLastName(command.lastName());
        if(command.birthday() != null)
            customerToUpdate.setBirthday(command.birthday());
        if(command.email() != null)
            customerToUpdate.setEmail(command.email());
        if(command.phone() != null)
            customerToUpdate.setPhone(command.phone());
        customerRepository.save(customerToUpdate);
        return Optional.of(customerToUpdate);
    }

    @Override
    public Long handle(DeleteCustomerCommand command) {
        var customerToDelete = customerRepository.findById(command.id()).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customerToDelete);
        return customerToDelete.getId();
    }
}
