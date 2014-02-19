package org.sc.crud.model;

import java.io.Serializable;
import javax.persistence.*;

import org.testng.Assert;

import java.lang.Float;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SERVICES database table.
 * 
 */
@Entity
@Table(name="SERVICES")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id", nullable=false)
	@TableGenerator( name = "Services", table = "APP_SEQ_STORE", 
	                 pkColumnName = "APP_SEQ_NAME", pkColumnValue = "SERVICES.Id", 
                     valueColumnName = "APP_SEQ_VALUE", initialValue = 0, 
                     allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.TABLE, generator = "Services" )
	private Long id;

	@Column(name="Days_Array", nullable=false, length=512)
	private String daysArray;

	@Column(name="Description", nullable=false, length=255)
	private String description;

	@Column(name="Effort", nullable=false, length=10)
	private String effort;

	@Column(name="Lead_Time", nullable=false, precision=10, scale=2)
	private Float lead_Time;

	@Column(name="Lead_Time_Unit", length=10)
	private String lead_Time_Unit;

	@Column(name="Max_Hours", nullable=false, precision=10, scale=2)
	private Float max_Hours;

	@Column(name="Start_Prior_days", nullable=false)
	private short start_Prior_days;

	@Column(name="Type", nullable=false, length=4)
	private String type;

	// feb.13.2014 new field
	@Temporal(TemporalType.DATE)
	@Column(name="Effective_Date")
	private Date effective_date;	
	//

	//bi-directional many-to-one association to Tasks
	@OneToMany(mappedBy="service")
	private List<Task> tasks;

	public Service() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDaysArray() {
		return this.daysArray;
	}

	public void setDaysArray(String daysArray) {
		this.daysArray = daysArray;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEffort() {
		return this.effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public Float getLead_Time() {
		return this.lead_Time;
	}

	public void setLead_Time(Float lead_Time) {
		this.lead_Time = lead_Time;
	}

	public String getLead_Time_Unit() {
		return this.lead_Time_Unit;
	}

	public void setLead_Time_Unit(String lead_Time_Unit) {
		this.lead_Time_Unit = lead_Time_Unit;
	}

	public Float getMax_Hours() {
		return this.max_Hours;
	}

	public void setMax_Hours(Float max_Hours) {
		this.max_Hours = max_Hours;
	}

	public short getStart_Prior_days() {
		return this.start_Prior_days;
	}

	public void setStart_Prior_days(short start_Prior_days) {
		this.start_Prior_days = start_Prior_days;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setService(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setService(null);

		return task;
	}

	// feb.13.2014 getter/setter for new effective_date field
	public Date getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(Date effective_date) {
		this.effective_date = effective_date;
	}
	
	//
	// the following methods provided for service calculator module
	// Without these methods, persistence still works
	// These method are utility methods
	
	public List<Float> getDaysArrayList() {

		String [] items = daysArray.split(",");
		Float[] floatArray = new Float[items.length];
		int j = 0;
		for (int i=0; i<items.length; i++) {
			floatArray[j++] = new Float(Float.parseFloat(items[i]));
		}
			
		return Arrays.asList(floatArray);
	}
}