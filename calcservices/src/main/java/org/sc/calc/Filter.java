package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.List;

public interface Filter<T,Tf> {
    public List<T> apply(List<T> ts, Tf f);
}
