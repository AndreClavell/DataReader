package setIntersectionFinders;

import interfaces.MySet;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Andre Clavell
 * 843-15-1170
 * CIIC4020-086
 * */
public class IntersectionFinder_P1P2<E> extends AbstractIntersectionFinder<E> {
    public IntersectionFinder_P1P2(String name) {
        super(name);
    }

    /**
     *
     * @param t array containing the family of sets to be intersected.
     * @return result MySet containing only numbers found across the t MySet array
     * @throws CloneNotSupportedException
     */
    @SuppressWarnings("unchecked")
    @Override
    public MySet<E> intersectSets(MySet<E>[] t) throws CloneNotSupportedException {
        MySet<E> result = (MySet<E>) t[0].clone();

        for (int i = 1; i < t.length; i++) {
            Iterator<E> iter = result.iterator();
            while(iter.hasNext()) {
                if (!t[i].contains(iter.next()))
                    iter.remove();
            }
        }
        return result;
    }
}
