package OrderTest;

import ShoppingCart.Order.Controller.OrderController;
import ShoppingCart.Order.Model.Order;
import ShoppingCart.Order.Model.OrderDao;
import ShoppingCart.Order.View.CreateOrderRequest;
import ShoppingCart.Order.View.CreateOrderResponse;
import ShoppingCart.Product.Model.ProductDao;
import ShoppingCart.User.Model.UserDao;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class OrderControllerCreateResponseTest extends EasyMockSupport {
    private UserDao userDao;
    private ProductDao productDao;
    private OrderDao orderDao;
    private OrderController orderController;
    private Order order;
    private CreateOrderRequest createOrderRequest = new CreateOrderRequest(11L, 11L, 11L, "pending", "China");

    @Before
    public void setupOrder() {
        userDao = createStrictMock(UserDao.class);
        productDao = createStrictMock(ProductDao.class);
        orderDao = createStrictMock(OrderDao.class);
        order = createStrictMock(Order.class);
    }

    @Test
    public void shouldCreateOrderSuccessfully() {
        //Testing CreateOrderResponse
        orderController = new OrderController(userDao, productDao, orderDao);
        ResponseEntity<CreateOrderResponse> response = orderController.createOrder(createOrderRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}