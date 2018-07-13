package be.kdg.springproject.services.api;

import be.kdg.springproject.dom.shopping.Cart;
import be.kdg.springproject.dom.shopping.Order;
import be.kdg.springproject.dom.stock.Product;
import be.kdg.springproject.dom.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.security.auth.login.LoginException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Transactional
public interface UserService extends UserDetailsService {
    User addUser(User user);

    User findUserByUsername(String username) throws LoginException;

    User findUserById(Integer id);

    void removeUser(Integer userId);

    List<User> findUsers();

    Cart getCartByUserId(Integer userId);

    Cart updateCart(User user, Product product, int amount);

    Order checkOut(Integer userId);

    Integer getCartItemAmount(Integer userId, Integer productId);
}
