package org.sc.calc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Date;

public class DatedEffort {
    public Date date;
    public Float effort;
    public DatedEffort(Date d, Float e) { this.date = d; this.effort = e; }

    @Override
    public String toString() {
        return "DatedEffort{" +
                "date=" + date +
                ", effort=" + effort +
                '}';
    }
}
