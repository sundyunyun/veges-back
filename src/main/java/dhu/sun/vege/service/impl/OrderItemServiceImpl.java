package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.OrderItem;
import dhu.sun.vege.mapper.OrderItemMapper;
import dhu.sun.vege.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by think on 2018/4/11.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> getItemByorderId(Long orderId)
    {
        try{
            return orderItemMapper.getItemByorderId(orderId);
        }catch (Exception e)
        {
            return  null;
        }
    }

}
