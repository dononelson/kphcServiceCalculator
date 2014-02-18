package org.sc.calc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Date;

public class Resources {
    private Double hoursPerStaff;
    private Integer staffCount;
    // note that resources has an implicit 'endDate' due to the resources' set being ordered
    // on 'effective Date'
    private Date effectiveDate;

    public Resources(Double hoursPerStaff, Integer staffCount, Date effectiveDate) {
        this.hoursPerStaff = hoursPerStaff;
        this.staffCount = staffCount;
        this.effectiveDate = effectiveDate;
    }

    public Double getHoursPerStaff() {
        return hoursPerStaff;
    }

    public void setHoursPerStaff(Double hoursPerStaff) {
        this.hoursPerStaff = hoursPerStaff;
    }

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
