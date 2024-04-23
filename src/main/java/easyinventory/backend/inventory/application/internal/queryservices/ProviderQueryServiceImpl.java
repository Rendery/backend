package easyinventory.backend.inventory.application.internal.queryservices;

import easyinventory.backend.inventory.domain.model.aggregates.Provider;
import easyinventory.backend.inventory.domain.model.queries.GetProviderByIdQuery;
import easyinventory.backend.inventory.domain.services.ProviderQueryService;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderQueryServiceImpl implements ProviderQueryService {

    private final ProviderRepository providerRepository;

    public ProviderQueryServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Optional<Provider> handle(GetProviderByIdQuery query) {
        return providerRepository.findById(query.id());
    }
}
