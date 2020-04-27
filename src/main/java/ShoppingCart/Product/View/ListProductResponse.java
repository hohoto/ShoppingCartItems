package ShoppingCart.Product.View;

import ShoppingCart.Product.Model.Product;

import java.util.List;

public class ListProductResponse {
    public List<Product> products;

    public ListProductResponse() {
    }

    public ListProductResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}