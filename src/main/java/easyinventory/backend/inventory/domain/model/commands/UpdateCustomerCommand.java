package easyinventory.backend.inventory.domain.model.commands;

public record UpdateCustomerCommand(Long id, String name, String lastName, String birthday, String email, Integer phone) {
}
