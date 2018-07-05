package be.kdg.springproject.persistence.api;

import be.kdg.springproject.dom.stock.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByDescription(String description);

    Collection<Product> findProductsByCategoryName(String categoryName);

    @Query(value = "SELECT distinct p.categoryName from Product p")
    Collection<String> getCategories();
}
