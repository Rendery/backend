package easyinventory.backend.inventory.application.internal.queryservices;

import easyinventory.backend.inventory.domain.model.aggregates.Customer;
import easyinventory.backend.inventory.domain.model.queries.GetCustomerByIdQuery;
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
public class CustomerQueryServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerQueryServiceImpl customerQueryService;

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("John", "Doe", "2000-01-01", "john.doe@example.com", 1234567890);
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
    }

    @Test
    public void testHandleGetCustomerByIdQuery() {
        GetCustomerByIdQuery query = new GetCustomerByIdQuery(1L);
        Optional<Customer> foundCustomer = customerQueryService.handle(query);
        assertEquals(customer.getName(), foundCustomer.get().getName());
        verify(customerRepository, times(1)).findById(anyLong());
    }
}