package easyinventory.backend.inventory.interfaces.rest.resources;

public record CreateCustomerResource(String name, String lastName, String birthday, String email, Integer phone) {
}
