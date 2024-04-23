package easyinventory.backend.inventory.domain.model.commands;

public record UpdateSaleCommand(Long id, String name, String saleDate, Integer totalCost) {
}
