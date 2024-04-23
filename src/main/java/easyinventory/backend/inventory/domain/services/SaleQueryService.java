package easyinventory.backend.inventory.domain.services;

import easyinventory.backend.inventory.domain.model.aggregates.Sale;
import easyinventory.backend.inventory.domain.model.queries.GetSaleByIdQuery;

import java.util.Optional;

public interface SaleQueryService {
    Optional<Sale> handle(GetSaleByIdQuery query);
}
