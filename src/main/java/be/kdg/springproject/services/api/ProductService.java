package be.kdg.springproject.services.api;

import be.kdg.springproject.dom.stock.Product;
import be.kdg.springproject.dom.stock.exceptions.StockException;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
public interface ProductService {
    Product addProduct(Product product) throws StockException;
    List<Product> findAll();
    Product findProductById(Integer productId);
    Collection<Product> findProductsOfCategory(String categoryName);
    Collection<String> getCategories();
    Product getProductByDescription(String productName);
    Integer getStockCount(Integer productId) throws StockException;
    Product updateProduct(Integer productId, int amount) throws StockException;
    void removeProduct(Integer productId) throws StockException;
}
