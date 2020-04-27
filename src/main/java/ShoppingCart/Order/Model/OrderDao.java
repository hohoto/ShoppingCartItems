package ShoppingCart.Order.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {
    Order getById(long id);

    List<Order> findAll();

    Order save(Order order);

    default void delete(Order order) {
    }
}