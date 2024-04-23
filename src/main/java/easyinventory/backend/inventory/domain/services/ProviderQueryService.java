package easyinventory.backend.inventory.domain.services;

import easyinventory.backend.inventory.domain.model.aggregates.Provider;
import easyinventory.backend.inventory.domain.model.queries.GetProviderByIdQuery;

import java.util.Optional;

public interface ProviderQueryService {
    Optional<Provider> handle(GetProviderByIdQuery query);
}
