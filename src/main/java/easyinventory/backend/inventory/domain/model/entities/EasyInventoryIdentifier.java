package easyinventory.backend.inventory.domain.model.entities;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record EasyInventoryIdentifier(UUID identifier) {
    public EasyInventoryIdentifier(){
        this(UUID.randomUUID());
    }
}
