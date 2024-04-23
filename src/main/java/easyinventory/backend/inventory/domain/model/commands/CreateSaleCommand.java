package easyinventory.backend.inventory.domain.model.commands;

public record CreateSaleCommand(String name, String saleDate, Integer totalCost) {
}
