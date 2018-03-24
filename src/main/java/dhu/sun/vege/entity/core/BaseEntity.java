package dhu.sun.vege.entity.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import dhu.sun.vege.constants.AppConst;

import javax.persistence.*;
import java.util.Date;

/**
 * 基础信息
 *
 */
public class BaseEntity {

  /*  @Column(name = "object_version_number")
    private Long objectVersionNumber;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "created_by")
    private String createdBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;*/
  @Column(name = "object_version_number")
  private Long objectVersionNumber;

    @JsonFormat(pattern = AppConst.FORMAT_SECOND, timezone = "GMT+8")
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "created_by")
    private String createdBy;

    @JsonFormat(pattern = AppConst.FORMAT_SECOND, timezone = "GMT+8")
    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
