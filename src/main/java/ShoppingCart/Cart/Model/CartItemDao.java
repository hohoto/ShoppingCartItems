package ShoppingCart.Cart.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDao extends CrudRepository<CartItem, Long> {
    CartItem getById(long id);

    List<CartItem> findAll();

    CartItem save(CartItem cartItem);
}
