package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.OrderItem;
import dhu.sun.vege.entity.OutstoreItem;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    List<OrderItem> getItemByorderId(Long orderId);
}
