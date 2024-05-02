package easyinventory.backend.inventory.application.internal.commandservices;

import easyinventory.backend.inventory.domain.model.aggregates.Customer;
import easyinventory.backend.inventory.domain.model.commands.CreateCustomerCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteCustomerCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateCustomerCommand;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerCommandServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerCommandServiceImpl customerCommandService;

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("John", "Doe", "2000-01-01", "john.doe@example.com", 1234567890);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        when(customerRepository.findByName(anyString())).thenReturn(Optional.of(customer));
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
    }

    @Test
    public void testHandleCreateCustomerCommand() {
        CreateCustomerCommand command = new CreateCustomerCommand("John", "Doe", "2000-01-01", "john.doe@example.com", 1234567890);
        Long customerId = customerCommandService.handle(command);
        assertEquals(customer.getId(), customerId);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    public void testHandleUpdateCustomerCommand() {
        UpdateCustomerCommand command = new UpdateCustomerCommand(1L,"John", "Doe", "2000-01-01", "john.doe@example.com", 1234567890);
        Optional<Customer> updatedCustomer = customerCommandService.handle(command);
        assertEquals(customer.getName(), updatedCustomer.get().getName());
        verify(customerRepository, times(1)).findByName(anyString());
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    public void testHandleDeleteCustomerCommand() {
        DeleteCustomerCommand command = new DeleteCustomerCommand(1L);
        Long deletedCustomerId = customerCommandService.handle(command);
        assertEquals(customer.getId(), deletedCustomerId);
        verify(customerRepository, times(1)).findById(anyLong());
        verify(customerRepository, times(1)).delete(any(Customer.class));
    }
}