package ShoppingCart.Product.View;

import org.springframework.stereotype.Component;

@Component
public class CreateProductRequestValidator {
    public static boolean validate(CreateProductRequest createProductRequest) {
        if (createProductRequest.getPrice() < 0)
            return false;
        if (createProductRequest.getName().length() <= 0)
            return false;
        return true;
    }
}