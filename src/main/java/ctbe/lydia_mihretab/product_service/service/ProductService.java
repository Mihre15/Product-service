package ctbe.lydia_mihretab.product_service.service;
import ctbe.lydia_mihretab.product_service.exception.ResourceNotFoundException;
import ctbe.lydia_mihretab.product_service.model.Product;
import ctbe.lydia_mihretab.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import ctbe.lydia_mihretab.product_service.dto.ProductRequest;
import ctbe.lydia_mihretab.product_service.dto.ProductResponse;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    // Constructor injection — preferred over @Autowired on a field
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<ProductResponse> findAll(){
        return productRepository.findAll().stream().map(this::toResponse).toList();
    }
    public ProductResponse findById(Long id) {
        return toResponse(productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }
    public ProductResponse create(ProductRequest req) {
        return toResponse(productRepository.save(toEntity(req)));
    }
    public ProductResponse update(Long id, ProductRequest req) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        existing.setName(req.getName());
        existing.setPrice(req.getPrice());
        existing.setStockQty(req.getStockQty());
        existing.setCategory(req.getCategory());
        return toResponse(productRepository.save(existing));
    }
    // ── Delete ───────────────────────────────────────────────
    public void delete(Long id) {
        if (!productRepository.existsById(id))
            throw new ResourceNotFoundException(id);
        productRepository.deleteById(id);
    }
    // ── Mapping helpers ───────────────────────────────────────
    private ProductResponse toResponse(Product p) {
        return new ProductResponse(p.getId(), p.getName(),
                p.getPrice(), p.getStockQty(), p.getCategory());
    }
    private Product toEntity(ProductRequest req) {
        return new Product(req.getName(), req.getPrice(),
                req.getStockQty(), req.getCategory());
    }
}
