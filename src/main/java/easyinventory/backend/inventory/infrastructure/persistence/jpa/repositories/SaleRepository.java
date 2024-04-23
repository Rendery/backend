package easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories;

import easyinventory.backend.inventory.domain.model.aggregates.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Optional<Sale> findByName(String name);
}
