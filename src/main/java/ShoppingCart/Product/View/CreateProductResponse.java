package ShoppingCart.Product.View;

import ShoppingCart.Product.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class CreateProductResponse {
    private Product product;

    public CreateProductResponse() {
    }

    public CreateProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
