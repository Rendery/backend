package easyinventory.backend.inventory.domain.model.aggregates;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testIsValidPhone() {
        Customer customer = new Customer("Juan", "Perez", "27-11-2002","juan@gmail.com",909022321);
        boolean esperado = true;
        assertEquals(customer.isValidPhone(customer.getPhone()), esperado);
    }

    @Test
    public void testIsValidEmail() {
        Customer customer = new Customer("Juan", "Perez", "27-11-2002","juan@gmail.com" ,928232121);
        boolean esperado = true;
        assertEquals(customer.isValidEmail(customer.getEmail()), esperado);
    }
}