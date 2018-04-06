package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by think on 2018/3/19.
 */
@Table(name = "instoreitem")
public class InstoreItem extends BaseEntity{
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "instore_id")
    private Long instoreId;

    @Column(name = "veges_id")
    private Long vegesId;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Double number;

    @Column(name = "price")
    private Double price;

    @Column(name = "total")
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInstoreId() {
        return instoreId;
    }

    public void setInstoreId(Long instoreId) {
        this.instoreId = instoreId;
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

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
