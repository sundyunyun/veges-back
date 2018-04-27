package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.OrderItem;
import dhu.sun.vege.mapper.OrderItemMapper;
import dhu.sun.vege.mapper.VegesMapper;
import dhu.sun.vege.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/11.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private VegesMapper vegesMapper;

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

    @Override
    public OrderItem addOrderItem(OrderItem orderItem)
    {
        try{
            orderItem.setCreationDate(new Date());
            orderItem.setVegesId(vegesMapper.selectVegesByName(orderItem.getName()).getId());
            orderItem.setTotal(orderItem.getNumber()*orderItem.getPrice());
            orderItemMapper.insertUseGeneratedKeys(orderItem);

            return orderItemMapper.selectByPrimaryKey(orderItem.getId());

        }catch (Exception e)
        {
            return null;
        }
    }

}
