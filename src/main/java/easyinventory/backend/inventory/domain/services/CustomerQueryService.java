package easyinventory.backend.inventory.domain.services;

import easyinventory.backend.inventory.domain.model.aggregates.Customer;
import easyinventory.backend.inventory.domain.model.queries.GetCustomerByIdQuery;

import java.util.Optional;

public interface CustomerQueryService {
    Optional<Customer> handle(GetCustomerByIdQuery query);
}
