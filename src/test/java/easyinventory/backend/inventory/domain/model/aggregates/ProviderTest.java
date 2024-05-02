package easyinventory.backend.inventory.domain.model.aggregates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {

    @Test
    void testIsValidRuc() {
        Provider provider = new Provider("Juan", 928388221 , 10769027217L , "juan@gmail.com");
        boolean esperado = true;
        assertEquals(provider.isValidRuc(provider.getRuc()), esperado);
    }

    @Test
    void testIsValidPhone() {
        Provider provider = new Provider("Juan", 928388221 , 10769027217L , "juan@gmail.com");
        boolean esperado = true;
        assertEquals(provider.isValidPhone(provider.getPhone()), esperado);
    }



}