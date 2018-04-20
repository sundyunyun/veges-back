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
    OrderlistView getOrderById(Long orderId);
    List<OrderlistView> getOrdersBydriverId(Long driverId);
    Order confirmOrderBydriver(Long orderId);
    List<OrderlistView> getCurrentOrdersBydriver(Long driverId);
    List<OrderlistView> getOrdersBycustId(Long custId);
    Order confirmOrderBycustomer(Long orderId);
    List<OrderlistView> getCurrentOrders();
    Order arrangeDriverForOrder(Long orderId,Long driverId);
}
