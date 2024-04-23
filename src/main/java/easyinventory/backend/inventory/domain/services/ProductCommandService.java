package easyinventory.backend.inventory.domain.services;

import easyinventory.backend.inventory.domain.model.aggregates.Product;
import easyinventory.backend.inventory.domain.model.commands.CreateProductCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteProductCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateProductCommand;

import java.util.Optional;

public interface ProductCommandService {
    Long handle(CreateProductCommand command);
    Optional<Product> handle(UpdateProductCommand command);
    Long handle(DeleteProductCommand command);
}
