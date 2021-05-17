package karolmusial.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository {
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    Product save(Product entity);
    boolean existsById(Integer id);
}
