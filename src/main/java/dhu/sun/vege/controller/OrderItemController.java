package dhu.sun.vege.controller;

import dhu.sun.vege.entity.OrderItem;
import dhu.sun.vege.service.OrderItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/4/11.
 */
@RestController
@RequestMapping("/api")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;


    @GetMapping("/getitemByorderid")
    @ApiOperation("根据订单id获取订单明细")
    @PreAuthorize("hasAnyAuthority('customer','office','driver','keeper','buyer')")
    public List<OrderItem> getItemByorderId(@RequestParam Long orderId)
    {
        return orderItemService.getItemByorderId(orderId);
    }

    @PostMapping("/addorderitem")
    @ApiOperation("添加订单明细")
    @PreAuthorize("hasAnyAuthority('customer')")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem)
    {
        return orderItemService.addOrderItem(orderItem);
    }
}
