package easyinventory.backend.inventory.application.internal.queryservices;

import easyinventory.backend.inventory.domain.model.aggregates.Product;
import easyinventory.backend.inventory.domain.model.queries.GetProductByIdQuery;
import easyinventory.backend.inventory.domain.model.queries.GetProductsByUserIdQuery;
import easyinventory.backend.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductQueryServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductQueryServiceImpl productQueryService;

    private Product product;
    private List<Product> productList;

    @Before
    public void setUp() {
        product = new Product("Laptop", 10, 10, 10, 10, 10, 1L);
        productList = List.of(product);
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        when(productRepository.findByUserId(anyLong())).thenReturn(productList);
    }

    @Test
    public void testHandleGetProductByIdQuery() {
        GetProductByIdQuery query = new GetProductByIdQuery(1L);
        Optional<Product> foundProduct = productQueryService.handle(query);
        assertEquals(product.getName(), foundProduct.get().getName());
        verify(productRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testHandleGetProductsByUserIdQuery() {
        GetProductsByUserIdQuery query = new GetProductsByUserIdQuery(1L);
        List<Product> foundProducts = productQueryService.handle(query);
        assertEquals(productList.size(), foundProducts.size());
        verify(productRepository, times(1)).findByUserId(anyLong());
    }
}
