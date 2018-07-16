package be.kdg.springproject.services.impl;

import be.kdg.springproject.dom.shopping.Cart;
import be.kdg.springproject.dom.shopping.Order;
import be.kdg.springproject.dom.stock.Product;
import be.kdg.springproject.dom.user.User;
import be.kdg.springproject.dom.user.exceptions.UserException;
import be.kdg.springproject.dom.user.roles.Client;
import be.kdg.springproject.dom.user.roles.Role;
import be.kdg.springproject.persistence.api.CartRepository;
import be.kdg.springproject.persistence.api.ProductRepository;
import be.kdg.springproject.persistence.api.UserRepository;
import be.kdg.springproject.services.api.UserService;
import be.kdg.springproject.services.exceptions.ProductServiceException;
import be.kdg.springproject.services.exceptions.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.security.auth.login.LoginException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, CartRepository cartRepo, ProductRepository productRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addUser(User user) {

        if(user == null){
            throw new UserServiceException("There's no user to add");
        }

        user.setEncryptedPassword(passwordEncoder.encode(user.getEncryptedPassword()));

        return userRepo.save(user);
    }

    @Override
    public User findUserByUsername(String username) throws LoginException {
        User foundUser = userRepo.findUserByUsername(username);
        if(foundUser == null){
            throw new UserServiceException("User with username: " + username + " not found");
        }
        return foundUser;
    }

    @Override
    public User findUserById(Integer id) {
        User foundUser = userRepo.findById(id).get();

        if(foundUser == null){
            throw new UserServiceException("User not found");
        }

        return foundUser;
    }

    @Override
    public void removeUser(Integer userId) {
        User user = userRepo.findById(userId).get();
        if(user == null){
            throw new UserServiceException("User not found");
        }
        userRepo.delete(user);
    }

    @Override
    public List<User> findUsers() {
        return userRepo.findAll();
    }

    @Override
    public Cart getCartByUserId(Integer userId) {
        User u = findUserById(userId);
        Client client = tryCast(u);
        Cart c = client.getCart();

        return c;
    }

    @Override
    public Cart updateCart(User user, Product product, int amount) {
        Client client = tryCast(user);
        Cart c = client.getCart();
        c.updateProduct(product, amount);

        if(user == null){
            throw new UserServiceException("No user found");
        }else if(product == null){
            throw new ProductServiceException("No product found");
        }

        return c;
    }

    @Override
    public Order checkOut(Integer userId) {
        Order order = null;
        User u = userRepo.findById(userId).get();
        if (u == null)
            throw new UserServiceException("User not found");
        if(Role.hasRole(u, Client.class)){
            Client client = Role.loadRole(u, Client.class);
            order = client.createOrder();
        }
        if(order == null)
            throw new UserServiceException("Failed to create order");
        userRepo.save(u);
        return order;
    }

    @Override
    public Integer getCartItemAmount(Integer userId, Integer productId) {
        User u = userRepo.findById(userId).get();
        Product p = productRepo.findById(productId).get();
        if(p == null)
            throw new ProductServiceException("Product not found");
        if(u == null)
            throw new UserServiceException("User not found");
        Client c = tryCast(u);
        Cart cart = c.getCart();

        return cart.getCartItemAmount(p);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    /**
     * This method tries to cast a user object to a client object and wraps any errors
     * in a new UserServiceException
     * @param u the user to be casted
     * @return the client that is derived from the user
     * @throws UserServiceException when the user is not in the client role.
     */
    private Client tryCast(User u) throws UserServiceException {
        try {
            Client c = Role.loadRole(u, Client.class);
            return c;
        } catch (UserException e) {
            throw new UserServiceException("User is not a client.");
        }
    }
}
