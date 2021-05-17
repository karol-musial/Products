package karolmusial.adapter;

import karolmusial.model.Product;
import karolmusial.model.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlProductRepository extends ProductRepository, JpaRepository<Product, Integer> {
}
