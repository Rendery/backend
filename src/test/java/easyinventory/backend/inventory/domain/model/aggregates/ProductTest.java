package easyinventory.backend.inventory.domain.model.aggregates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductHasStock() {
        Product product = new Product( "Laptop", 10, 10, 10, 10, 10, 1L);
        Boolean esperado = true;
        assertEquals(product.hasStock(), esperado);
    }

    @Test
    void testProductIsValidToAdd() {
        Product product = new Product();
        Boolean esperado = true;
        assertEquals(product.isValidProduct("Laptop", 10, 10, 10, 10, 10, 1L), esperado);
    }

    @Test
    void testProductDiscountStock() {
        Product product = new Product( "Laptop", 10, 10, 10, 10, 10, 1L);
        Integer cantidad = 9;
        product.discountStock(cantidad);
        Integer esperado = 1;
        assertEquals(product.getCurrentStock(), esperado);
    }

}