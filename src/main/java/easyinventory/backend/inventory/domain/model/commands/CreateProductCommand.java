package easyinventory.backend.inventory.domain.model.commands;

public record CreateProductCommand(String name, Integer unitPrice, Integer realPrice, Integer discount, Integer stock, Integer currentStock, Long userId) {
}
