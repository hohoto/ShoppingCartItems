package ShoppingCart.User.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User getById(long id);

    User getByName(String name);

    List<User> findAll();

    User save(User user);
}

