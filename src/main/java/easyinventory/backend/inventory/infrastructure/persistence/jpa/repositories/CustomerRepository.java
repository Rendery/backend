package easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories;

import easyinventory.backend.inventory.domain.model.aggregates.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);
}
