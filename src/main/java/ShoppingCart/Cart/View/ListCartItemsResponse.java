package ShoppingCart.Cart.View;

import ShoppingCart.Cart.Model.CartItem;

import java.util.List;

public class ListCartItemsResponse {
    private List<CartItem> items;

    public ListCartItemsResponse(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
