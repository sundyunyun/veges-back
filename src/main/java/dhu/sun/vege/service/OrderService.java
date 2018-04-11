package dhu.sun.vege.service;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.Outstore;
import dhu.sun.vege.model.view.OrderlistView;

import java.util.List;

/**
 * Created by think on 2018/4/9.
 */
public interface OrderService {
    List<OrderlistView> getAll();
    Order getOrderById(Long orderId);
}
