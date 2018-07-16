package be.kdg.springproject.services.impl;


import be.kdg.springproject.dom.stock.Product;
import be.kdg.springproject.persistence.api.ProductRepository;
import be.kdg.springproject.services.api.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Service that provides general information about repairs
 * <p>
 * https://programmeren3-repaircafe.rhcloud.com/repair-cafe-applicatie/repair-cafe-backend/backend-service-layer/
 *
 * @author wouter
 */
@Service("informationService")
@Transactional
public class InformationServiceImpl implements InformationService {

    private final ProductRepository productRepo;

    @Autowired
    public InformationServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    /**
     * Return all known product categories
     *
     * @return List of categories
     */
    @Override
    public List<String> getAllCategories() {
        List<Product> products = productRepo.findAll();
        List<String> categories = new ArrayList<>();
        for (Product p: products) {
            String category = p.getCategoryName();
            if(!categories.contains(category))
                categories.add(category);
        }

        return categories;
    }

}
