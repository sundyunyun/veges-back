package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by think on 2018/3/18.
 */
@Table(name="department")
public class Department extends BaseEntity {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="deptname")
    private String deptname;

    @Column(name="number")
    private Long number;

    @Column(name="des")
    private String des;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
