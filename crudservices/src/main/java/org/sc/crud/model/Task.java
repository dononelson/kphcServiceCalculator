package org.sc.crud.model;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the TASKS database table.
 * 
 */
@Entity
@Table(name="TASKS")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id", nullable=false)
	@TableGenerator( name = "Tasks", table = "APP_SEQ_STORE", 
	                 pkColumnName = "APP_SEQ_NAME", pkColumnValue = "TASKS.Id", 
                     valueColumnName = "APP_SEQ_VALUE", initialValue = 0, 
                     allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.TABLE, generator = "Tasks" )
	private Long id;
	@Column(name="Activity_desc", length=255)
	private String activity_desc;

	@Column(length=25)
	private String CRQ_no;

	@Column(name="Env_type", length=4)
	private String env_type;

	@Column(name="No_of_env")
	private short no_of_env;

	@Column(name="Region", length=2)
	private String region;

	@Temporal(TemporalType.DATE)
	@Column(name="Start_Date")
	private Date start_Date;

	@Column(length=10)
	private String status;

	@Temporal(TemporalType.DATE)
	private Date tEnd_date;

	@Temporal(TemporalType.DATE)
	private Date tStart_date;

	//bi-directional many-to-one association to Services
	@ManyToOne
	@JoinColumn(name="Service_id")
	private Service service;

	public Task() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivity_desc() {
		return this.activity_desc;
	}

	public void setActivity_desc(String activity_desc) {
		this.activity_desc = activity_desc;
	}

	public String getCRQ_no() {
		return this.CRQ_no;
	}

	public void setCRQ_no(String CRQ_no) {
		this.CRQ_no = CRQ_no;
	}

	public String getEnv_type() {
		return this.env_type;
	}

	public void setEnv_type(String env_type) {
		this.env_type = env_type;
	}

	public short getNo_of_env() {
		return this.no_of_env;
	}

	public void setNo_of_env(short no_of_env) {
		this.no_of_env = no_of_env;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getStart_Date() {
		return this.start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTEnd_date() {
		return this.tEnd_date;
	}

	public void setTEnd_date(Date tEnd_date) {
		this.tEnd_date = tEnd_date;
	}

	public Date getTStart_date() {
		return this.tStart_date;
	}

	public void setTStart_date(Date tStart_date) {
		this.tStart_date = tStart_date;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}