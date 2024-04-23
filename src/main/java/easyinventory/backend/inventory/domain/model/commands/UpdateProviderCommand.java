package easyinventory.backend.inventory.domain.model.commands;

public record UpdateProviderCommand(Long id, String name, Integer phone, Long ruc, String email) {
}
