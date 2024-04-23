package easyinventory.backend.inventory.application.internal.commandservices;

import easyinventory.backend.inventory.domain.model.aggregates.Provider;
import easyinventory.backend.inventory.domain.model.commands.CreateProviderCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteProviderCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateProviderCommand;
import easyinventory.backend.inventory.domain.services.ProviderCommandService;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderCommandServiceImpl implements ProviderCommandService {

    private final ProviderRepository providerRepository;

    public ProviderCommandServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Long handle(CreateProviderCommand command) {
        var provider = new Provider(command.name(), command.phone(), command.ruc(), command.email());
        providerRepository.save(provider);
        return provider.getId();
    }

    @Override
    public Optional<Provider> handle(UpdateProviderCommand command) {
        var providerToUpdate = providerRepository.findByName(command.name()).orElseThrow(() -> new RuntimeException("Provider not found"));
        if(command.name() != null)
            providerToUpdate.setName(command.name());
        if(command.email() != null)
            providerToUpdate.setEmail(command.email());
        if(command.phone() != null)
            providerToUpdate.setPhone(command.phone());
        if(command.ruc() != null)
            providerToUpdate.setRuc(command.ruc());
        providerRepository.save(providerToUpdate);
        return Optional.of(providerToUpdate);
    }

    @Override
    public Long handle(DeleteProviderCommand command) {
        var existingProvider = providerRepository.findById(command.id()).orElseThrow(() -> new RuntimeException("Provider not found"));
        providerRepository.delete(existingProvider);
        return existingProvider.getId();
    }
}
