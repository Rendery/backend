package easyinventory.backend.inventory.interfaces.rest;

import easyinventory.backend.inventory.domain.model.commands.DeleteProviderCommand;
import easyinventory.backend.inventory.domain.model.queries.GetProviderByIdQuery;
import easyinventory.backend.inventory.domain.services.ProviderCommandService;
import easyinventory.backend.inventory.domain.services.ProviderQueryService;
import easyinventory.backend.inventory.interfaces.rest.resources.CreateProviderResource;
import easyinventory.backend.inventory.interfaces.rest.resources.ProviderResource;
import easyinventory.backend.inventory.interfaces.rest.transform.CreateProviderCommandFromResourceAssembler;
import easyinventory.backend.inventory.interfaces.rest.transform.ProviderResourceFromEntityAssembler;
import easyinventory.backend.inventory.interfaces.rest.transform.UpdateProviderCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/providers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Providers", description = "Providers Management Endpoints")
public class ProviderController {
    private final ProviderCommandService providerCommandService;
    private final ProviderQueryService providerQueryService;

    public ProviderController(ProviderCommandService providerCommandService, ProviderQueryService providerQueryService) {
        this.providerCommandService = providerCommandService;
        this.providerQueryService = providerQueryService;
    }

    @PostMapping
    public ResponseEntity<ProviderResource> createProvider(@RequestBody CreateProviderResource resource){
        var createProviderCommand = CreateProviderCommandFromResourceAssembler.toCommandFromResource(resource);
        var providerId = providerCommandService.handle(createProviderCommand);
        if(providerId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getProviderByIdQuery = new GetProviderByIdQuery(providerId);
        var provider = providerQueryService.handle(getProviderByIdQuery);
        if(provider.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var providerResource = ProviderResourceFromEntityAssembler.toResourceFromEntity(provider.get());
        return new ResponseEntity<>(providerResource, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderResource> putProvider(@PathVariable Long id, @RequestBody CreateProviderResource resource){
        var updateProviderCommand = UpdateProviderCommandFromResourceAssembler.toCommandFromResource(id, resource);
        var updatedProvider = providerCommandService.handle(updateProviderCommand);
        if(updatedProvider.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var providerResource = ProviderResourceFromEntityAssembler.toResourceFromEntity(updatedProvider.get());
        return ResponseEntity.ok(providerResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderResource> getProviderById(@PathVariable Long id){
        var getProviderByIdQuery = new GetProviderByIdQuery(id);
        var provider = providerQueryService.handle(getProviderByIdQuery);
        if (provider.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var providerResource = ProviderResourceFromEntityAssembler.toResourceFromEntity(provider.get());
        return ResponseEntity.ok(providerResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProvider(@PathVariable Long id){
        var deleteProviderCommand = new DeleteProviderCommand(id);
        var providerId = providerCommandService.handle(deleteProviderCommand);
        return ResponseEntity.ok(providerId);
    }
}
