package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.model.view.OrderlistView;
import dhu.sun.vege.util.core.BaseMapper;

import javax.swing.plaf.BorderUIResource;
import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> getOrdersBydriverId(Long driverId);
    List<Order> getCurrentOrdersBydriver(Long driverId);
    List<Order> getOrdersBycustId(Long custId);
    List<Order> getCurrentOrders();
}
