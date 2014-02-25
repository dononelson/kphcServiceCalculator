package org.sc.crud.model;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the HOLIDAYS database table.
 * 
 */
@Entity
@Table(name="HOLIDAYS")
public class Holiday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="Created_Date")
	private Date created_Date;

	@Temporal(TemporalType.DATE)
	@Column(name="Holiday")
	private Date holiday;

	@Id
	@Column(name="Id", nullable=false)
	@TableGenerator( name = "Holidays", table = "APP_SEQ_STORE", 
	                 pkColumnName = "APP_SEQ_NAME", pkColumnValue = "HOLIDAYS.Id", 
                     valueColumnName = "APP_SEQ_VALUE", initialValue = 0, 
                     allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.TABLE, generator = "Holidays" )
	private Long id;
	public Holiday() {
	}

	public Date getCreated_Date() {
		return this.created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public Date getHoliday() {
		return this.holiday;
	}

	public void setHoliday(Date holiday) {
		this.holiday = holiday;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}