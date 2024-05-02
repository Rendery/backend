package easyinventory.backend.inventory.domain.model.aggregates;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProviderTest {

    @Test
    public void testIsValidRuc() {
        Provider provider = new Provider("Juan", 928388221 , 10769027217L , "juan@gmail.com");
        boolean esperado = true;
        assertEquals(provider.isValidRuc(provider.getRuc()), esperado);
    }

    @Test
    public void testIsValidPhone() {
        Provider provider = new Provider("Juan", 928388221 , 10769027217L , "juan@gmail.com");
        boolean esperado = true;
        assertEquals(provider.isValidPhone(provider.getPhone()), esperado);
    }



}