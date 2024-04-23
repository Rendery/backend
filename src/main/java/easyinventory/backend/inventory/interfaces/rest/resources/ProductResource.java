package easyinventory.backend.inventory.interfaces.rest.resources;

public record ProductResource(Long id, String name, Integer unitPrice, Integer realPrice, Integer discount, Integer stock, Integer currentStock, Long userId) {
}
