package easyinventory.backend.inventory.application.internal.commandservices;

import easyinventory.backend.inventory.domain.model.aggregates.Product;
import easyinventory.backend.inventory.domain.model.commands.CreateProductCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteProductCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateProductCommand;
import easyinventory.backend.inventory.domain.services.ProductCommandService;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long handle(CreateProductCommand command) {
        var product = new Product(command.name(), command.unitPrice(), command.realPrice(),
                command.discount(), command.stock(), command.currentStock(), command.userId());
        productRepository.save(product);
        return product.getId();

    }

    @Override
    public Optional<Product> handle(UpdateProductCommand command) {
        var productToUpdate = productRepository.findByName(command.name()).orElseThrow(() -> new RuntimeException("Product not exist"));
        if(command.stock() != null)
            productToUpdate.setStock(command.stock());
        if(command.discount() != null)
            productToUpdate.setDiscount(command.discount());
        if(command.name() != null)
            productToUpdate.setName(command.name());
        if(command.realPrice() != null)
            productToUpdate.setRealPrice(command.realPrice());
        if(command.unitPrice() != null)
            productToUpdate.setUnitPrice(command.unitPrice());
        if(command.currentStock() != null)
            productToUpdate.setCurrentStock(command.currentStock());
        productRepository.save(productToUpdate);
        return Optional.of(productToUpdate);
    }

    @Override
    public Long handle(DeleteProductCommand command) {
        Product existingProduct = productRepository.findById(command.id()).orElseThrow(() -> new RuntimeException("Product not exist"));
        productRepository.delete(existingProduct);
        return existingProduct.getId();
    }
}
