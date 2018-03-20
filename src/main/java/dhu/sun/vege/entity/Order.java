package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by think on 2018/3/18.
 */
@Table(name = "order")
public class Order extends BaseEntity{
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="cust_id")
    private Long custId;

    @Column(name="address")
    private String address;

    @Column(name="tel")
    private String tel;

    @Column(name="driver_id")
    private Long driverId;

    @Column(name="msg")
    private String msg;

    @Column(name="totalprice")
    private BigDecimal totalprice;

    @Column(name="totalweight")
    private int totalweight;

    @Column(name="state")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public int getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(int totalweight) {
        this.totalweight = totalweight;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
