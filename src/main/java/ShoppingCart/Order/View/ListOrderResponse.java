package ShoppingCart.Order.View;

import ShoppingCart.Order.Model.Order;

import java.util.List;

public class ListOrderResponse {
    List<Order> orders;

    public ListOrderResponse() {
    }

    public ListOrderResponse(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

