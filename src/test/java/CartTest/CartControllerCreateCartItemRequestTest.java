package CartTest;

import ShoppingCart.Cart.Controller.CartController;
import ShoppingCart.Cart.Model.CartItemDao;
import ShoppingCart.Cart.View.CreateCartItemRequest;
import ShoppingCart.Cart.View.CreateCartItemResponse;
import ShoppingCart.Product.Model.ProductDao;
import ShoppingCart.User.Model.UserDao;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class CartControllerCreateCartItemRequestTest extends EasyMockSupport {
    private UserDao userDao;
    private ProductDao productDao;
    private CartItemDao cartItemDao;
    private CartController cartController;
    private CreateCartItemRequest createCartItemRequest = new CreateCartItemRequest(11L, 11L, 11L);

    @Before
    public void setupOrder() {
        userDao = createStrictMock(UserDao.class);
        productDao = createStrictMock(ProductDao.class);
        cartItemDao = createStrictMock(CartItemDao.class);
    }

    @Test
    public void shouldCreateCartItemSuccessfully() {
        //Testing CreateCartItemResponse
        cartController = new CartController(userDao, productDao, cartItemDao);
        ResponseEntity<CreateCartItemResponse> response = cartController.createCartItem(createCartItemRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
