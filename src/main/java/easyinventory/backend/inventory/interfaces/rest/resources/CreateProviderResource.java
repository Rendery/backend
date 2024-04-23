package easyinventory.backend.inventory.interfaces.rest.resources;

public record CreateProviderResource(String name, Integer phone, Long ruc, String email) {
}
