package dhu.sun.vege.service;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.OrderItem;

import java.util.List;

/**
 * Created by think on 2018/4/11.
 */
public interface OrderItemService {
    List<OrderItem> getItemByorderId(Long orderId);
    OrderItem addOrderItem(OrderItem orderItem);
}
