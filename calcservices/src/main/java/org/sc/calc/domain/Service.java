package org.sc.calc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;
import java.util.Date;

public class Service {

    public static final int PRIOR_LEN = 3;
    private String id;
    private String description;
    // note that the first PRIOR_LEN entries in this list are to be interpreted as 'prior to start date' effort hours
    private List<Float> efforts;
    // note that a service has an implicit 'endDate' due to the services' set being ordered
    // on 'effective Date'
    private Date effectiveDate;

    public Service(String id, String description, List<Float> efforts) {
        this.id = id;
        this.description = description;
        this.efforts = efforts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Float> getEfforts() {
        return efforts;
    }

    public void setEfforts(List<Float> efforts) {
        this.efforts = efforts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < efforts.size(); i++) {
            sb.append(efforts.get(i)).append(" ");
        }
        sb.append("]");

        return "Service{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", efforts=" + sb.toString() +
                '}';
    }
}
