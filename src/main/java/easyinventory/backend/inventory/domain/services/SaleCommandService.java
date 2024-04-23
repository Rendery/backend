package easyinventory.backend.inventory.domain.services;

import easyinventory.backend.inventory.domain.model.aggregates.Sale;
import easyinventory.backend.inventory.domain.model.commands.CreateSaleCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteSaleCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateSaleCommand;

import java.util.Optional;

public interface SaleCommandService {
    Long handle(CreateSaleCommand command);
    Optional<Sale> handle(UpdateSaleCommand command);
    Long handle(DeleteSaleCommand command);
}
