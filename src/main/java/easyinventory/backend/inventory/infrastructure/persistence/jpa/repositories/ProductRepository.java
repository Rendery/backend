package easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories;

import easyinventory.backend.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUserId(Long userId);
    Optional<Product> findByName(String name);
}
