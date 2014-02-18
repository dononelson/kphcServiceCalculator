package org.sc.calc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Date;

public class Task {
    private TaskState state;
    private Date startDate;
    private Region region;
    private String CRQ;
    private String description;
    private Integer envCount;
    private String serviceId;
    private EnvType envType;


    public Task(TaskState state, Date startDate, Region region, String CRQ, String description, Integer envCount, String serviceId, EnvType envType) {
        this.state = state;
        this.startDate = startDate;
        this.region = region;
        this.CRQ = CRQ;
        this.description = description;
        this.envCount = envCount;
        // note: points to the specific service instance - i.e., with a specific
        // effectiveDate
        this.serviceId = serviceId;
        this.envType = envType;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public EnvType getEnvType() {
        return envType;
    }

    public void setEnvType(EnvType envType) {
        this.envType = envType;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCRQ() {
        return CRQ;
    }

    public void setCRQ(String CRQ) {
        this.CRQ = CRQ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEnvCount() {
        return envCount;
    }

    public void setEnvCount(Integer envCount) {
        this.envCount = envCount;
    }

    @Override
    public String toString() {
        return "Task{" +
                "state=" + state +
                ", startDate=" + startDate +
                ", region=" + region +
                ", CRQ='" + CRQ + '\'' +
                ", description='" + description + '\'' +
                ", envCount=" + envCount +
                ", serviceId='" + serviceId + '\'' +
                ", envType=" + envType +
                '}';
    }
}
