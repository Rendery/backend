package easyinventory.backend.inventory.application.internal.queryservices;

import easyinventory.backend.inventory.domain.model.aggregates.Provider;
import easyinventory.backend.inventory.domain.model.queries.GetProviderByIdQuery;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.ProviderRepository;
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
public class ProviderQueryServiceImplTest {

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private ProviderQueryServiceImpl providerQueryService;

    private Provider provider;

    @Before
    public void setUp() {
        provider = new Provider("Proveedor", 123456789, 12345678901L, "proveedor@example.com");
        when(providerRepository.findById(anyLong())).thenReturn(Optional.of(provider));
    }

    @Test
    public void testHandleGetProviderByIdQuery() {
        GetProviderByIdQuery query = new GetProviderByIdQuery(1L);
        Optional<Provider> foundProvider = providerQueryService.handle(query);
        assertEquals(provider.getName(), foundProvider.get().getName());
        verify(providerRepository, times(1)).findById(anyLong());
    }
}
