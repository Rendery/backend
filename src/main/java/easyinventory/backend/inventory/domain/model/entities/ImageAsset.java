package easyinventory.backend.inventory.domain.model.entities;

import lombok.Getter;

import java.net.URI;

@Getter
public class ImageAsset extends Asset{
    private final URI imageUri;

    public ImageAsset(String imageUrl) {
        this.imageUri = URI.create(imageUrl);
    }

    @Override
    public String getContent() {
        return imageUri.toString();
    }
}
