package org.sc.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * The persistent class for the REGIONS database table.
 * 
 */
@Entity
@Table(name = "REGIONS")
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "Descr")
    private String descr;

    @Id
    @Column(name = "Id", nullable = false)
    @TableGenerator(name = "Regions", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "REGIONS.Id", valueColumnName = "APP_SEQ_VALUE", initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Regions")
    private Long id;

    @Column(name = "Region_Code")
    private String region_Code;

    public Region() {
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(final String descr) {
        this.descr = descr;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getRegion_Code() {
        return region_Code;
    }

    public void setRegion_Code(final String region_Code) {
        this.region_Code = region_Code;
    }

}