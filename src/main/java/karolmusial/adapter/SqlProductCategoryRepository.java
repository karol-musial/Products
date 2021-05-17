package karolmusial.adapter;

import karolmusial.model.Product;
import karolmusial.model.ProductCategoryRepository;
import karolmusial.model.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlProductCategoryRepository extends ProductCategoryRepository, JpaRepository<Product, Integer> {
}
