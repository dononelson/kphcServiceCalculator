package org.sc.crud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the RESOURCES database table.
 * 
 */
@Entity
@Table(name = "RESOURCES")
public class Resource implements Serializable {
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "Effective_date")
    private Date effective_date;

    @Column(name = "Hours_per_staff")
    private short hours_per_staff;

    @Id
    @Column(name = "Id", nullable = false)
    @TableGenerator(name = "Resources", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "RESOURCES.Id", valueColumnName = "APP_SEQ_VALUE", initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Resources")
    private Long id;

    @Column(name = "No_of_staffs")
    private short no_of_staffs;

    public Resource() {
    }

    public Date getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(final Date effective_date) {
        this.effective_date = effective_date;
    }

    public short getHours_per_staff() {
        return hours_per_staff;
    }

    public void setHours_per_staff(final short hours_per_staff) {
        this.hours_per_staff = hours_per_staff;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public short getNo_of_staffs() {
        return no_of_staffs;
    }

    public void setNo_of_staffs(final short no_of_staffs) {
        this.no_of_staffs = no_of_staffs;
    }

}