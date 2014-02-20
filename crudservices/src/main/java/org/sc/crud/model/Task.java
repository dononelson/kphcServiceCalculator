package org.sc.crud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TASKS database table.
 * 
 */
@Entity
@Table(name = "TASKS")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id", nullable = false)
    @TableGenerator(name = "Tasks", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "TASKS.Id", valueColumnName = "APP_SEQ_VALUE", initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Tasks")
    private Long id;
    @Column(name = "Activity_desc", length = 255)
    private String activity_desc;

    @Column(length = 25)
    private String CRQ_no;

    @Column(name = "Env_type", length = 4)
    private String env_type;

    @Column(name = "No_of_env")
    private short no_of_env;

    @Column(name = "Region", length = 2)
    private String region;

    @Temporal(TemporalType.DATE)
    @Column(name = "Start_Date")
    private Date start_Date;

    @Column(length = 10)
    private String status;

    @Temporal(TemporalType.DATE)
    private Date tEnd_date;

    @Temporal(TemporalType.DATE)
    private Date tStart_date;

    // bi-directional many-to-one association to Services
    @ManyToOne
    @JoinColumn(name = "Service_id")
    private Service service;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getActivity_desc() {
        return activity_desc;
    }

    public void setActivity_desc(final String activity_desc) {
        this.activity_desc = activity_desc;
    }

    public String getCRQ_no() {
        return CRQ_no;
    }

    public void setCRQ_no(final String CRQ_no) {
        this.CRQ_no = CRQ_no;
    }

    public String getEnv_type() {
        return env_type;
    }

    public void setEnv_type(final String env_type) {
        this.env_type = env_type;
    }

    public short getNo_of_env() {
        return no_of_env;
    }

    public void setNo_of_env(final short no_of_env) {
        this.no_of_env = no_of_env;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(final Date start_Date) {
        this.start_Date = start_Date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Date getTEnd_date() {
        return tEnd_date;
    }

    public void setTEnd_date(final Date tEnd_date) {
        this.tEnd_date = tEnd_date;
    }

    public Date getTStart_date() {
        return tStart_date;
    }

    public void setTStart_date(final Date tStart_date) {
        this.tStart_date = tStart_date;
    }

    public Service getService() {
        return service;
    }

    public void setService(final Service service) {
        this.service = service;
    }

}