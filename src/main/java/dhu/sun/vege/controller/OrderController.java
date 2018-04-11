package dhu.sun.vege.controller;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.Outstore;
import dhu.sun.vege.model.view.OrderlistView;
import dhu.sun.vege.service.OrderService;
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
    public Order getOrderById(@RequestParam Long orderId)
    {
        return orderService.getOrderById(orderId);
    }



}
