package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by think on 2018/3/18.
 */
@Table(name="type")
public class Type extends BaseEntity {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="type")
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
