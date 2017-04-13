package org.rbc.document.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lena on 2017-04-04.bnvgvhghs
 */
@Entity
@Table(name="configuration_tbl", uniqueConstraints=
@UniqueConstraint(columnNames={"app_code", "version"}))
public class Configuration {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;

    @Column(name = "app_code")
    @NotBlank
    private String appCode;

    @Column
    @NotBlank
    private String version;

    @Column(name="config_doc")
    @NotBlank
    @JsonFormat
    private String configDoc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", insertable = true, updatable = true)
    private Date updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", insertable = true, updatable = true)
    private Date createdDate = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getConfigDoc() {
        return configDoc;
    }

    public void setConfigDoc(String configDoc) {
        this.configDoc = configDoc;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}

