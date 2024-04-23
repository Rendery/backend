package easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories;

import easyinventory.backend.inventory.domain.model.aggregates.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Optional<Provider> findByName(String name);
}
