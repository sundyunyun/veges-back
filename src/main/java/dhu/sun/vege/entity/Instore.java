package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by think on 2018/3/19.
 */
@Table(name = "instore")
public class Instore extends BaseEntity{
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "import_id")
    private Long importId;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "keeper_id")
    private Long keeperId;

    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "totalprice")
    private Double totalprice;

    @Column(name = "totalweight")
    private Double totalweight;

    @Column(name = "state")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getKeeperId() {
        return keeperId;
    }

    public void setKeeperId(Long keeperId) {
        this.keeperId = keeperId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Double getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(Double totalweight) {
        this.totalweight = totalweight;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
