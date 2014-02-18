package org.sc.calc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Date;
import java.util.List;

public class CalendarTask extends Task {

    private List<DatedEffort> datedEfforts;

    public CalendarTask(TaskState state, Date startDate, Region region, String CRQ, String description, Integer envCount, String serviceId, EnvType envType, List<DatedEffort> des) {
        super(state, startDate, region, CRQ, description, envCount, serviceId, envType);
        this.datedEfforts = des;
    }

    public List<DatedEffort> getDatedEfforts() {
        return datedEfforts;
    }

    public void setDatedEfforts(List<DatedEffort> datedEfforts) {
        this.datedEfforts = datedEfforts;
    }

    @Override
    public String toString() {
        return "CalendarTask{" +
                "task attrs=" + super.toString() +
                "datedEfforts=" + datedEfforts +
                '}';
    }
}
