package ctbe.lydia_mihretab.product_service.exception;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class ResourceNotFoundException extends RuntimeException {
    private final Long id;
    public ResourceNotFoundException(Long id) {
        super("Product " + id + " not found");
        this.id = id;
    }
    public Long getId() { return id; }
}
