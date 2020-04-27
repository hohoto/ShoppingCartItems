package ProductTest;

import ShoppingCart.Product.Controller.ProductController;
import ShoppingCart.Product.Model.ProductDao;
import ShoppingCart.Product.View.CreateProductRequestValidator;
import ShoppingCart.Product.View.GetProductResponse;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class ProductControllerTest extends EasyMockSupport {
    private ProductDao productDao;

    @Before
    public void setupOrder() {
        productDao = createStrictMock(ProductDao.class);
    }

    @Test
    public void shouldGetProductSuccessfully() {
        ProductController productController = new ProductController(new CreateProductRequestValidator(), productDao);
        ResponseEntity<GetProductResponse> response = productController.getProduct(123L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}