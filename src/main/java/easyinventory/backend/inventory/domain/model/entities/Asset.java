package easyinventory.backend.inventory.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private EasyInventoryIdentifier assetIdentifier;

    protected Asset() {
        this.assetIdentifier = new EasyInventoryIdentifier();
    }

    public Object getContent() {
        return "";
    }
}
