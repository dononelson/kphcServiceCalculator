package org.sc.crud.model;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the RESOURCES database table.
 * 
 */
@Entity
@Table(name="RESOURCES")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="Effective_date")
	private Date effective_date;

	@Column(name="Hours_per_staff")
	private short hours_per_staff;

	@Id
	@Column(name="Id", nullable=false)
	@TableGenerator( name = "Resources", table = "APP_SEQ_STORE", 
	                 pkColumnName = "APP_SEQ_NAME", pkColumnValue = "RESOURCES.Id", 
                     valueColumnName = "APP_SEQ_VALUE", initialValue = 0, 
                     allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.TABLE, generator = "Resources" )
	private Long id;
	

	@Column(name="No_of_staffs")
	private short no_of_staffs;

	public Resource() {
	}

	public Date getEffective_date() {
		return this.effective_date;
	}

	public void setEffective_date(Date effective_date) {
		this.effective_date = effective_date;
	}

	public short getHours_per_staff() {
		return this.hours_per_staff;
	}

	public void setHours_per_staff(short hours_per_staff) {
		this.hours_per_staff = hours_per_staff;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getNo_of_staffs() {
		return this.no_of_staffs;
	}

	public void setNo_of_staffs(short no_of_staffs) {
		this.no_of_staffs = no_of_staffs;
	}

}