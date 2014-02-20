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
 * The persistent class for the HOLIDAYS database table.
 * 
 */
@Entity
@Table(name = "HOLIDAYS")
public class Holiday implements Serializable {
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "Created_Date")
    private Date created_Date;

    @Temporal(TemporalType.DATE)
    @Column(name = "Holiday")
    private Date holiday;

    @Id
    @Column(name = "Id", nullable = false)
    @TableGenerator(name = "Holidays", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "HOLIDAYS.Id", valueColumnName = "APP_SEQ_VALUE", initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Holidays")
    private Long id;

    public Holiday() {
    }

    public Date getCreated_Date() {
        return created_Date;
    }

    public void setCreated_Date(final Date created_Date) {
        this.created_Date = created_Date;
    }

    public Date getHoliday() {
        return holiday;
    }

    public void setHoliday(final Date holiday) {
        this.holiday = holiday;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}