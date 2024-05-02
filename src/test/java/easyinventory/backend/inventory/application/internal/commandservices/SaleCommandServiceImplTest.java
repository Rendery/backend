package easyinventory.backend.inventory.application.internal.commandservices;

import easyinventory.backend.inventory.domain.model.aggregates.Sale;
import easyinventory.backend.inventory.domain.model.commands.*;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.SaleRepository;
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
public class SaleCommandServiceImplTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleCommandServiceImpl saleCommandService;

    private Sale sale;

    @Before
    public void setUp() {
        sale = new Sale("Venta", "2022-01-01", 100);
        when(saleRepository.save(any(Sale.class))).thenReturn(sale);
        when(saleRepository.findByName(anyString())).thenReturn(Optional.of(sale));
    }

    @Test
    public void testHandleCreateSaleCommand() {
        CreateSaleCommand command = new CreateSaleCommand("Venta", "2022-01-01", 100);
        Long saleId = saleCommandService.handle(command);
        assertEquals(sale.getId(), saleId);
        verify(saleRepository, times(1)).save(any(Sale.class));
    }

    @Test
    public void testHandleUpdateSaleCommand() {
        UpdateSaleCommand command = new UpdateSaleCommand(1L, "Venta", "2022-01-01", 100);
        Optional<Sale> updatedSale = saleCommandService.handle(command);
        assertEquals(sale.getName(), updatedSale.get().getName());
        verify(saleRepository, times(1)).findByName(anyString());
        verify(saleRepository, times(1)).save(any(Sale.class));
    }

    @Test
    public void testHandleDeleteSaleCommand() {
        DeleteSaleCommand command = new DeleteSaleCommand("Venta");
        Long deletedSaleId = saleCommandService.handle(command);
        assertEquals(sale.getId(), deletedSaleId);
        verify(saleRepository, times(1)).findByName(anyString());
        verify(saleRepository, times(1)).delete(any(Sale.class));
    }
}