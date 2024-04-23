package easyinventory.backend.inventory.interfaces.rest.resources;

public record CustomerResource(Long id, String name, String lastName, String birthday, String email, Integer phone) {
}
