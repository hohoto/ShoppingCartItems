package ShoppingCart.Cart.View;

import ShoppingCart.Cart.Model.CartItem;

public class GetCartItemResponse {
    private CartItem item;

    public GetCartItemResponse(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }

    public void setItem(CartItem item) {
        this.item = item;
    }
}

