package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.List;

public interface Zip<Tin1,Tin2,Tout> {
    public List<Tout> apply(List<Tin1> t1s, List<Tin2> t2s);
}
