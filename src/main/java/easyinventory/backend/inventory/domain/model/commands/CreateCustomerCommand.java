package easyinventory.backend.inventory.domain.model.commands;

public record CreateCustomerCommand(String name, String lastName, String birthday, String email, Integer phone) {
}
