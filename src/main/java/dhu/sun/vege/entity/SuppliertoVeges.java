package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by think on 2018/3/21.
 */
@Table(name = "supplier_veges")
public class SuppliertoVeges extends BaseEntity {

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "veges_id")
    private Long veges_id;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getVeges_id() {
        return veges_id;
    }

    public void setVeges_id(Long veges_id) {
        this.veges_id = veges_id;
    }
}
