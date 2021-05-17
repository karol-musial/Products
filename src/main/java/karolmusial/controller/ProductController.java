package karolmusial.controller;

import karolmusial.model.Product;
import karolmusial.model.ProductRepository;
import org.h2.mvstore.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ProductController {
    ProductRepository repository;

    public ProductController(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    @GetMapping(value = "/products", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Product>> readAllProducts() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/products")
    ResponseEntity<List<Product>> readAllProducts(Pageable page) {
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> readProduct(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        Product result = repository.save(product);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PutMapping("/products/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody @Valid Product toUpdate) {
        if(!repository.existsById(id)){
            ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(product -> {
                    product.updateFrom(toUpdate);
                    repository.save(product);
                });
        return ResponseEntity.noContent().build();
    }
}
