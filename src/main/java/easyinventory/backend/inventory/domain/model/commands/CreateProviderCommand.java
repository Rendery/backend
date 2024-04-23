package easyinventory.backend.inventory.domain.model.commands;

public record CreateProviderCommand(String name, Integer phone, Long ruc, String email) {
}
