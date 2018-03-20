package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by think on 2018/3/19.
 */
@Table(name="orderitem")
public class OrderItem extends BaseEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name="veges_id")
    private Long vegesId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "number")
    private int number;

    @Column(name="total")
    private BigDecimal total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getVegesId() {
        return vegesId;
    }

    public void setVegesId(Long vegesId) {
        this.vegesId = vegesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
