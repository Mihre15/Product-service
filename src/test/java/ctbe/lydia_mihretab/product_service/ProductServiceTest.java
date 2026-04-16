package ctbe.lydia_mihretab.product_service;
import ctbe.lydia_mihretab.product_service.dto.ProductResponse;
import ctbe.lydia_mihretab.product_service.model.Product;
import ctbe.lydia_mihretab.product_service.repository.ProductRepository;

import ctbe.lydia_mihretab.product_service.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository; // fake database
    @InjectMocks
    private ProductService productService; // class under test
    @Test
    void findById_returnsProduct_whenProductExists() {
// Arrange — define what the mock should return
        Product laptop = new Product("Laptop", 1200.0, 10, "Electronics");
        laptop.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(laptop));
// Act — call the method under test
        ProductResponse result = productService.findById(1L);
// Assert — verify the result
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Laptop");
        assertThat(result.getPrice()).isEqualTo(1200.0);
    }
    @Test
    void findById_returnsException_orNull_whenProductNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> productService.findById(99L))
                .isInstanceOf(ctbe.lydia_mihretab.product_service.exception.ResourceNotFoundException.class);
}
}
