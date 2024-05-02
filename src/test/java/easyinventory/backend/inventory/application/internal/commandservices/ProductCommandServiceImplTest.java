package easyinventory.backend.inventory.application.internal.commandservices;

import easyinventory.backend.inventory.domain.model.aggregates.Product;
import easyinventory.backend.inventory.domain.model.commands.CreateProductCommand;
import easyinventory.backend.inventory.domain.model.commands.DeleteProductCommand;
import easyinventory.backend.inventory.domain.model.commands.UpdateProductCommand;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ProductCommandServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductCommandServiceImpl productCommandService;

    @Test
    public void testHandleCreateProductCommand() {
        CreateProductCommand command = new CreateProductCommand("Laptop", 10, 10, 10, 10, 10, 1L);
        Product product = new Product("Laptop", 10, 10, 10, 10, 10, 1L);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Long productId = productCommandService.handle(command);

        assertEquals(product.getId(), productId);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void testHandleUpdateProductCommand() {
        UpdateProductCommand command = new UpdateProductCommand(1L, "Laptop", 10, 10, 10, 10, 10, 1L);
        Product product = new Product("Laptop", 10, 10, 10, 10, 10, 1L);
        when(productRepository.findByName(anyString())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Optional<Product> updatedProduct = productCommandService.handle(command);

        assertTrue(updatedProduct.isPresent());
        assertEquals(product.getName(), updatedProduct.get().getName());
        verify(productRepository, times(1)).findByName(anyString());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void testHandleDeleteProductCommand() {
        DeleteProductCommand command = new DeleteProductCommand(1L);
        Product product = new Product("Laptop", 10, 10, 10, 10, 10, 1L);
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        Long deletedProductId = productCommandService.handle(command);

        assertEquals(product.getId(), deletedProductId);
        verify(productRepository, times(1)).findById(anyLong());
        verify(productRepository, times(1)).delete(any(Product.class));
    }
}