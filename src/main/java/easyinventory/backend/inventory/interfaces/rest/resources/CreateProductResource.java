package easyinventory.backend.inventory.interfaces.rest.resources;

public record CreateProductResource(String name, Integer unitPrice, Integer realPrice, Integer discount, Integer stock, Integer currentStock, Long userId) {
}
