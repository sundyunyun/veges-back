package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by think on 2018/3/18.
 */
@Table(name="storeitem")
public class StoreItem extends BaseEntity{
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="store_id")
    private Long storeId;

    @Column(name="veges_id")
    private Long vegesId;

    @Column(name="name")
    private String name;

    @Column(name="number")
    private int number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
