package be.kdg.springproject.model.user;

import be.kdg.springproject.model.shopping.Order;
import be.kdg.springproject.model.stock.Product;
import be.kdg.springproject.model.user.roles.Client;
import be.kdg.springproject.model.user.roles.Role;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class UserTest {
    private Person person;
    private Address address;
    private Client client;

    @Before
    public void runBeforeEachTest() {
        person = mock(Person.class);
        address = mock(Address.class);
        client = new Client();
    }

    @Test
    public void createUserWithRoleClient() {
        String password = "piano123";

        List<Role> roles = new ArrayList<>();
        roles.add(client);

        User user = new User(person, "wouter.deketelaere@kdg.be", password, roles);
        assertThat(person, equalTo(user.getPerson()));
        assertThat(user.getRoles(), hasItem(isA(Client.class)));
    }

    @Test
    public void addProductToCart() throws Exception {
        Product product = new Product("Vijzen",3.14,"Ijzerwaren");
        client.getCart().updateProduct(product, 10);

        assertEquals(client.createOrder().getLineItems().size(),1);

    }
}