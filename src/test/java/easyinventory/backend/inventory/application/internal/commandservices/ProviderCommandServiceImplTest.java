package easyinventory.backend.inventory.application.internal.commandservices;

import easyinventory.backend.inventory.domain.model.aggregates.Provider;
import easyinventory.backend.inventory.domain.model.commands.*;
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
public class ProviderCommandServiceImplTest {

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private ProviderCommandServiceImpl providerCommandService;

    private Provider provider;

    @Before
    public void setUp() {
        provider = new Provider("Proveedor", 123456789, 12345678901L, "proveedor@example.com");
        when(providerRepository.save(any(Provider.class))).thenReturn(provider);
        when(providerRepository.findByName(anyString())).thenReturn(Optional.of(provider));
        when(providerRepository.findById(anyLong())).thenReturn(Optional.of(provider));
    }

    @Test
    public void testHandleCreateProviderCommand() {
        CreateProviderCommand command = new CreateProviderCommand("Proveedor", 123456789, 12345678901L, "proveedor@example.com");
        Long providerId = providerCommandService.handle(command);
        assertEquals(provider.getId(), providerId);
        verify(providerRepository, times(1)).save(any(Provider.class));
    }

    @Test
    public void testHandleUpdateProviderCommand() {
        UpdateProviderCommand command = new UpdateProviderCommand(1L, "Proveedor", 123456789, 12345678901L, "proveedor@example.com");
        Optional<Provider> updatedProvider = providerCommandService.handle(command);
        assertEquals(provider.getName(), updatedProvider.get().getName());
        verify(providerRepository, times(1)).findByName(anyString());
        verify(providerRepository, times(1)).save(any(Provider.class));
    }

    @Test
    public void testHandleDeleteProviderCommand() {
        DeleteProviderCommand command = new DeleteProviderCommand(1L);
        Long deletedProviderId = providerCommandService.handle(command);
        assertEquals(provider.getId(), deletedProviderId);
        verify(providerRepository, times(1)).findById(anyLong());
        verify(providerRepository, times(1)).delete(any(Provider.class));
    }
}
