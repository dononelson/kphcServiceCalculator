package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.List;

public interface Fold<Tin,Tout, Tf> {
    public Tout apply(List<Tin> ts, Tf f);
}
