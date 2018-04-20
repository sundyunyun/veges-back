package dhu.sun.vege.controller;

import com.sun.jmx.remote.util.OrderClassLoaders;
import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.Outstore;
import dhu.sun.vege.model.view.OrderlistView;
import dhu.sun.vege.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/4/9.
 */
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getallorder")
    @ApiOperation("获取所有订单信息")
   /* @PreAuthorize("hasAnyAuthority('all')")*/
    public List<OrderlistView> getAll()
    {
        return orderService.getAll();
    }

    @GetMapping("/getorderById")
    @ApiOperation("根据订单id获取订单")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public OrderlistView getOrderById(@RequestParam Long orderId)
    {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/getorderBydriverId")
    @ApiOperation("根据司机id查询司机历史出货单")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<OrderlistView> getOrdersBydriverId(@RequestParam Long driverId)
    {
        return orderService.getOrdersBydriverId(driverId);
    }

    @GetMapping("/confimBydriver")
    @ApiOperation("司机确认送达订单给客户")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Order confirmOrderBydriver(@RequestParam Long orderId)
    {
        return orderService.confirmOrderBydriver(orderId);
    }

    @GetMapping("/getcurrentorders")
    @ApiOperation("根据司机id和订单待配送状态显示给司机页面")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<OrderlistView> getCurrrentOrdersBydriver(@RequestParam Long driverId)
    {
        return orderService.getCurrentOrdersBydriver(driverId);
    }

    @GetMapping("/getordersBycustomerId")
    @ApiOperation("根据客户id查询历史订单")
   /* @PreAuthorize("hasAnyAuthority('all')")*/
    public List<OrderlistView> getOrdersBycustomerId(@RequestParam Long custId)
    {
        return orderService.getOrdersBycustId(custId);
    }

    @GetMapping("/orderdonebycust")
    @ApiOperation("客户确认收货修改订单状态为客户确认收货")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Order confirmOrderBycustomer(@RequestParam Long orderId)
    {
        return orderService.confirmOrderBycustomer(orderId);
    }

    @GetMapping("getcurrentorderBycust")
    @ApiOperation("/采购员查看当前客户已下好的订单，根据订单状态“订单完成”显示，安排司机进行派送")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<OrderlistView> getCurrentOrders()
    {
        return orderService.getCurrentOrders();
    }

    @GetMapping("arrangedriver")
    @ApiOperation("为订单安排司机并修改相关状态和订单内容")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Order arrangeDriverForOrder(@RequestParam Long orderId,@RequestParam Long driverId)
    {
        return orderService.arrangeDriverForOrder(orderId,driverId);
    }
}
