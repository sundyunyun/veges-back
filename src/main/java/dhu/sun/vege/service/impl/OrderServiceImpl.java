package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.User;
import dhu.sun.vege.mapper.OrderMapper;
import dhu.sun.vege.mapper.UserMapper;
import dhu.sun.vege.model.view.OrderlistView;
import dhu.sun.vege.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/9.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<OrderlistView> getAll()
    {
        try{
           List<Order> orders=orderMapper.selectAll();
           List<OrderlistView> orderlistViews=new ArrayList<>();

           for(int i=0;i<orders.size();i++)
           {
               OrderlistView orderlistView=new OrderlistView();
               orderlistView.setOrder(orders.get(i));
               orderlistView.setDriver(userMapper.selectByPrimaryKey(orders.get(i).getDriverId()));
               orderlistView.setCustomer(userMapper.selectByPrimaryKey(orders.get(i).getCustId()));

               orderlistViews.add(orderlistView);
           }
           return orderlistViews;
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public OrderlistView getOrderById(Long orderId)
    {
        try{
            Order order=orderMapper.selectByPrimaryKey(orderId);
            OrderlistView orderlistView=new OrderlistView();
            orderlistView.setCustomer(userMapper.selectByPrimaryKey(order.getCustId()));
            orderlistView.setDriver(userMapper.selectByPrimaryKey(order.getDriverId()));
            orderlistView.setOrder(order);
            return orderlistView;
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<OrderlistView> getOrdersBydriverId(Long driverId){
        try {
            List<Order> orders=orderMapper.getOrdersBydriverId(driverId);
            List<OrderlistView> orderlistViews=new ArrayList<>();

            for(int i=0;i<orders.size();i++)
            {
                OrderlistView orderlistView=new OrderlistView();
                orderlistView.setOrder(orders.get(i));
                orderlistView.setDriver(userMapper.selectByPrimaryKey(orders.get(i).getDriverId()));
                orderlistView.setCustomer(userMapper.selectByPrimaryKey(orders.get(i).getCustId()));

                orderlistViews.add(orderlistView);
            }
            return orderlistViews;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Order confirmOrderBydriver(Long orderId)
    {
        try{
            Order order=orderMapper.selectByPrimaryKey(orderId);
            order.setState("司机确认送达");
            order.setLastUpdateDate(new Date());
            orderMapper.updateByPrimaryKey(order);
            return orderMapper.selectByPrimaryKey(orderId);
        }catch (Exception e)
        {
            return  null;
        }
    }


    @Override
    public List<OrderlistView> getCurrentOrdersBydriver(Long driverId)
    {
        try{
            List<Order> orders=orderMapper.getCurrentOrdersBydriver(driverId);
            List<OrderlistView> orderlistViews=new ArrayList<>();

            for(int i=0;i<orders.size();i++)
            {
                OrderlistView orderlistView=new OrderlistView();
                orderlistView.setOrder(orders.get(i));
                orderlistView.setDriver(userMapper.selectByPrimaryKey(orders.get(i).getDriverId()));
                orderlistView.setCustomer(userMapper.selectByPrimaryKey(orders.get(i).getCustId()));

                orderlistViews.add(orderlistView);
            }
            return orderlistViews;
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<OrderlistView> getOrdersBycustId(Long custId)
    {
        try{
            List<Order> orders=orderMapper.getOrdersBycustId(custId);
            List<OrderlistView> orderlistViews=new ArrayList<>();
            for(int i=0;i<orders.size();i++)
            {
                OrderlistView orderlistView=new OrderlistView();
                orderlistView.setOrder(orders.get(i));
                orderlistView.setDriver(userMapper.selectByPrimaryKey(orders.get(i).getDriverId()));
                orderlistView.setCustomer(userMapper.selectByPrimaryKey(orders.get(i).getCustId()));

                orderlistViews.add(orderlistView);
            }
            return orderlistViews;

       }catch (Exception e)
        {
            return null;
        }
    }

  @Override
    public Order confirmOrderBycustomer(Long orderId)
  {
      try{
          Order order=orderMapper.selectByPrimaryKey(orderId);
          order.setLastUpdateDate(new Date());
          order.setState("客户确认收货");
          orderMapper.updateByPrimaryKey(order);
          return orderMapper.selectByPrimaryKey(orderId);
      }catch (Exception e)
      {
          return null;
      }
  }

  @Override
    public List<OrderlistView> getCurrentOrders()
  {
      try{
          List<Order> orders=orderMapper.getCurrentOrders();
          List<OrderlistView> orderlistViews=new ArrayList<>();
          for(int i=0;i<orders.size();i++)
          {
              OrderlistView orderlistView=new OrderlistView();
              orderlistView.setOrder(orders.get(i));
              orderlistView.setDriver(userMapper.selectByPrimaryKey(orders.get(i).getDriverId()));
              orderlistView.setCustomer(userMapper.selectByPrimaryKey(orders.get(i).getCustId()));

              orderlistViews.add(orderlistView);
          }
          return orderlistViews;
      }catch (Exception e)
      {
          return null;
      }
  }

  @Override
    public Order arrangeDriverForOrder(Long orderId,Long driverId)
  {
      try{
          User driver=userMapper.selectByPrimaryKey(driverId);
          driver.setLastUpdateDate(new Date());
          driver.setState("配送中");
          userMapper.updateByPrimaryKey(driver);

          Order order=orderMapper.selectByPrimaryKey(orderId);
          order.setState("待配送");
          order.setLastUpdateDate(new Date());
          order.setDriverId(driverId);
          orderMapper.updateByPrimaryKey(order);

          return orderMapper.selectByPrimaryKey(orderId);

      }catch (Exception e)
      {
          return null;
      }
  }
}
