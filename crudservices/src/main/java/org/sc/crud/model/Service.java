package org.sc.crud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the SERVICES database table.
 * 
 */
@Entity
@Table(name = "SERVICES")
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id", nullable = false)
    @TableGenerator(name = "Services", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "SERVICES.Id", valueColumnName = "APP_SEQ_VALUE", initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Services")
    private Long id;

    @Column(name = "Days_Array", nullable = false, length = 512)
    private String daysArray;

    @Column(name = "Description", nullable = false, length = 255)
    private String description;

    @Column(name = "Effort", nullable = false, length = 10)
    private String effort;

    @Column(name = "Lead_Time", nullable = false, precision = 10, scale = 2)
    private Float lead_Time;

    @Column(name = "Lead_Time_Unit", length = 10)
    private String lead_Time_Unit;

    @Column(name = "Max_Hours", nullable = false, precision = 10, scale = 2)
    private Float max_Hours;

    @Column(name = "Start_Prior_days", nullable = false)
    private short start_Prior_days;

    @Column(name = "Type", nullable = false, length = 4)
    private String type;

    // feb.13.2014 new field
    @Temporal(TemporalType.DATE)
    @Column(name = "Effective_Date")
    private Date effective_date;
    //

    // bi-directional many-to-one association to Tasks
    @OneToMany(mappedBy = "service")
    private List<Task> tasks;

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDaysArray() {
        return daysArray;
    }

    public void setDaysArray(final String daysArray) {
        this.daysArray = daysArray;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getEffort() {
        return effort;
    }

    public void setEffort(final String effort) {
        this.effort = effort;
    }

    public Float getLead_Time() {
        return lead_Time;
    }

    public void setLead_Time(final Float lead_Time) {
        this.lead_Time = lead_Time;
    }

    public String getLead_Time_Unit() {
        return lead_Time_Unit;
    }

    public void setLead_Time_Unit(final String lead_Time_Unit) {
        this.lead_Time_Unit = lead_Time_Unit;
    }

    public Float getMax_Hours() {
        return max_Hours;
    }

    public void setMax_Hours(final Float max_Hours) {
        this.max_Hours = max_Hours;
    }

    public short getStart_Prior_days() {
        return start_Prior_days;
    }

    public void setStart_Prior_days(final short start_Prior_days) {
        this.start_Prior_days = start_Prior_days;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task addTask(final Task task) {
        getTasks().add(task);
        task.setService(this);

        return task;
    }

    public Task removeTask(final Task task) {
        getTasks().remove(task);
        task.setService(null);

        return task;
    }

    // feb.13.2014 getter/setter for new effective_date field
    public Date getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(final Date effective_date) {
        this.effective_date = effective_date;
    }

    //
    //

    /**
     * the following methods provided for service calculator module Without these methods, persistence still works These method are utility methods
     * 
     * TODO move this to a utility method
     * 
     * @return
     */
    public List<Float> getDaysArrayList() {
        final String[] items = daysArray.split(",");
        final List<Float> daysAsFloat = new ArrayList<>(items.length);
        // final Float[] floatArray = new Float[items.length];
        // int j = 0;
        for (int i = 0; i < items.length; i++) {
            final float dayAsFloat = Float.parseFloat(items[i]);
            daysAsFloat.add(dayAsFloat);
            // floatArray[j++] = new Float(Float.parseFloat(items[i]));
        }

        return daysAsFloat;
    }
}