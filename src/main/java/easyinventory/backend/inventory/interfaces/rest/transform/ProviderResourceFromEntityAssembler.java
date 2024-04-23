package easyinventory.backend.inventory.interfaces.rest.transform;

import easyinventory.backend.inventory.domain.model.aggregates.Provider;
import easyinventory.backend.inventory.interfaces.rest.resources.ProviderResource;

public class ProviderResourceFromEntityAssembler {
    public static ProviderResource toResourceFromEntity(Provider provider){
        return new ProviderResource(provider.getId(), provider.getName(), provider.getPhone(),
                provider.getRuc(), provider.getEmail());
    }
}
