package ShoppingCart.Cart.View;

import ShoppingCart.Cart.Model.CartItem;

public class UpdateCartItemResponse {
    private CartItem item;

    public UpdateCartItemResponse() {
    }

    public UpdateCartItemResponse(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }

    public void setItem(CartItem item) {
        this.item = item;
    }
}
