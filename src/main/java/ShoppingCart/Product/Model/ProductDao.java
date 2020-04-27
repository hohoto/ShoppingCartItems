package ShoppingCart.Product.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
    // 根据ORM的命名惯例, 声明操作方法

    Product getById(long id);

    List<Product> findAll();

    Product save(Product product);
}

