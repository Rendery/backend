package easyinventory.backend.inventory.domain.services;

import easyinventory.backend.inventory.domain.model.aggregates.Provider;
import easyinventory.backend.inventory.domain.model.commands.CreateProviderCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteProviderCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateProviderCommand;

import java.util.Optional;

public interface ProviderCommandService {
    Long handle(CreateProviderCommand command);
    Optional<Provider> handle(UpdateProviderCommand command);
    Long handle(DeleteProviderCommand command);
}
