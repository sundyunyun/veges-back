package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by think on 2018/3/19.
 */
@Table(name = "outstoreitem")
public class OutstoreItem extends BaseEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "outstore_id")
    private Long outstoreId;

    @Column(name = "veges_id")
    private Long vegesId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "number")
    private int number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOutstoreId() {
        return outstoreId;
    }

    public void setOutstoreId(Long outstoreId) {
        this.outstoreId = outstoreId;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
