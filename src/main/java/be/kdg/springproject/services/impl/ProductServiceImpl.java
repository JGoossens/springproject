package be.kdg.springproject.services.impl;

import be.kdg.springproject.dom.stock.Product;
import be.kdg.springproject.dom.stock.exceptions.StockException;
import be.kdg.springproject.services.api.ProductService;

import java.util.Collection;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public Product addProduct(Product product) throws StockException {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findProductById(Integer productId) {
        return null;
    }

    @Override
    public Collection<Product> findProductsOfCategory(String categoryName) {
        return null;
    }

    @Override
    public Collection<String> getCategories() {
        return null;
    }

    @Override
    public Product getProductByDescription(String productName) {
        return null;
    }

    @Override
    public Integer getStockCount(Integer productId) throws StockException {
        return null;
    }

    @Override
    public Product updateProduct(Integer productId, int amount) throws StockException {
        return null;
    }

    @Override
    public void removeProduct(Integer productId) throws StockException {

    }
}
