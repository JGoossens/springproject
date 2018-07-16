package be.kdg.springproject.services.impl;

import be.kdg.springproject.dom.stock.Product;
import be.kdg.springproject.dom.stock.exceptions.StockException;
import be.kdg.springproject.persistence.api.ProductRepository;
import be.kdg.springproject.services.api.ProductService;
import be.kdg.springproject.services.exceptions.ProductServiceException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) throws StockException {
        if(product == null)
            throw new ProductServiceException("Product not found");
        return productRepo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findProductById(Integer productId) {
        Product p = productRepo.findById(productId).get();
        if(p == null)
            throw new ProductServiceException("Product not found");

        return p;
    }

    @Override
    public Collection<Product> findProductsOfCategory(String categoryName) {
        return productRepo.findProductsByCategoryName(categoryName);
    }

    @Override
    public Collection<String> getCategories() {
        List<Product> products = productRepo.findAll();
        Collection<String> categories = new ArrayList<>();
        for (Product p: products) {
            String category = p.getCategoryName();
            if(!categories.contains(category))
                categories.add(category);
        }

        return categories;
    }

    @Override
    public Product getProductByDescription(String productName) {
        Product p = productRepo.findProductByDescription(productName);
        if(p==null)
            throw new ProductServiceException("Product not found");
        return p;
    }

    @Override
    public Integer getStockCount(Integer productId) throws StockException {
        Product p = productRepo.findById(productId).get();
        if(p == null)
            throw new ProductServiceException("Product not found");

        return p.getStockItem().getAmount();
    }

    @Override
    public Product updateProduct(Integer productId, int amount) throws StockException {
        Product p = productRepo.findById(productId).get();
        if(p == null)
            throw new ProductServiceException("Product not found");
        p.getStockItem().setAmount(amount);
        return p;
    }

    @Override
    public void removeProduct(Integer productId) throws StockException {
        Product p = productRepo.findById(productId).get();
        if(p == null)
            throw new ProductServiceException("Product not found");
        productRepo.delete(p);

    }
}
