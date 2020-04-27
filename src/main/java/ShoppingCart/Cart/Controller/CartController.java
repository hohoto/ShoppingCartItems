package ShoppingCart.Cart.Controller;

import ShoppingCart.Cart.Model.CartItem;
import ShoppingCart.Cart.Model.CartItemDao;
import ShoppingCart.Cart.View.*;
import ShoppingCart.Product.Model.Product;
import ShoppingCart.Product.Model.ProductDao;
import ShoppingCart.User.Model.User;
import ShoppingCart.User.Model.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private UserDao userDao;
    private ProductDao productDao;
    private CartItemDao cartItemDao;

    public CartController(UserDao userDao, ProductDao productDao, CartItemDao cartItemDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.cartItemDao = cartItemDao;
    }

    /**
     * List cart items
     */
    @GetMapping("/cartItems")
    public ResponseEntity<ListCartItemsResponse> listCartItems() {
        List<CartItem> items = cartItemDao.findAll();
        return new ResponseEntity<>(new ListCartItemsResponse(items), HttpStatus.OK);
    }

    /**
     * Get cart item
     */
    @GetMapping("/cartItems/{cartItemId")
    public ResponseEntity<GetCartItemResponse> getCartItem(@PathVariable long cartItemId) {
        CartItem item = cartItemDao.getById(cartItemId);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GetCartItemResponse(item), HttpStatus.OK);
        }
    }

    /**
     * Create (Add) product to an item
     */
    @PostMapping("/createCartItems")
    public ResponseEntity<CreateCartItemResponse> createCartItem(@RequestBody CreateCartItemRequest createCartItemRequest) {
        User user = userDao.getById(createCartItemRequest.getUserId());
        Product product = productDao.getById(createCartItemRequest.getProductId());
        CartItem cartItem = cartItemDao.save(new CartItem(user, product, createCartItemRequest.getQuantity()));
        return new ResponseEntity<>(new CreateCartItemResponse(cartItem), HttpStatus.CREATED);
    }

    /**
     * Update cart item
     */
    @PutMapping("/UpdateCartItems/{cartItemId}")
    public ResponseEntity<UpdateCartItemResponse> updateCartItem(@PathVariable long cartItemId, @RequestBody UpdateCartItemRequest updateCartItemRequest) {
        CartItem cartItem = cartItemDao.getById(cartItemId);
        if (cartItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cartItem.setQuantity(updateCartItemRequest.getQuantity());
        cartItem = cartItemDao.save(cartItem);
        return new ResponseEntity<>(new UpdateCartItemResponse(cartItem), HttpStatus.OK);
    }

    /**
     * Remove cart item
     */
    @DeleteMapping("/DeleteCartItems/{cartItemId}")
    public ResponseEntity deleteCartItem(@PathVariable long cartItemId) {
        CartItem cartItem = cartItemDao.getById(cartItemId);
        if (cartItem == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        cartItemDao.delete(cartItem);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}