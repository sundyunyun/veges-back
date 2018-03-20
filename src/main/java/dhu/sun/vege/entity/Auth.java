package dhu.sun.vege.entity;

import dhu.sun.vege.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色表
 *
 * @author Tan Jie
 * @date 2017/12/9
 */
@Table(name = "sys_auth")
public class Auth extends BaseEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "auth")
    private String auth;

    @Column(name = "auth_name")
    private String authName;

    @Column(name = "note")
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
