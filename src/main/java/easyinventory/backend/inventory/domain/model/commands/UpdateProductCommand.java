package easyinventory.backend.inventory.domain.model.commands;

public record UpdateProductCommand(Long id, String name, Integer unitPrice, Integer realPrice, Integer discount, Integer stock, Integer currentStock, Long userId) {
}
