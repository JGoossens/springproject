package be.kdg.springproject;

import be.kdg.springproject.dom.stock.Product;
import be.kdg.springproject.dom.stock.exceptions.StockException;
import be.kdg.springproject.persistence.api.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static  org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringprojectApplicationTests {

	@Autowired
	ProductRepository productRepository;

	private Product product;
	private Integer id;



	@Before
	public void init(){
		product = new Product("Cara", 0.33, "Drank");
		productRepository.save(product);
		id = product.getProductId();
	}

	@Test
	public void contextLoads() {
		boolean ladenLukt = true;
		assertThat(ladenLukt, is(true));
	}

	@Test
	public void addProduct(){
		Product dbProduct = productRepository.findById(id).get();
		assertThat(dbProduct, is(product));
	}

	@Test
	public void updateProduct(){
		Product dbProduct = productRepository.findById(id).get();
		dbProduct.setDescription("Cara Pils");
		productRepository.save(dbProduct);

		Product updatedProd = productRepository.findProductByDescription("Cara Pils");
		assertThat(updatedProd.getDescription(), is("Cara Pils"));
	}

	@Test
	public void deleteProduct() {
		productRepository.deleteById(id);

		Product dbProduct = productRepository.findById(id).orElse(null);

		assertThat(dbProduct, nullValue());
	}

	/*@Test(expected = StockException.class)
	public void getUnexistingProduct(){
		productRepository.findProductByDescription("Maes");
	}*/


}
