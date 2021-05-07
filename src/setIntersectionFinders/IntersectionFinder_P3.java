package setIntersectionFinders;

import interfaces.MySet;
import mySetImplementations.Set2;



import java.util.ArrayList;

/**
 * @author Andre Clavell
 * 843-15-1170
 * CIIC4020-086
 * */
public class IntersectionFinder_P3<E> extends AbstractIntersectionFinder<E> {

    public IntersectionFinder_P3(String name) {
        super(name);
    }

    /**
     *
     * @param t array containing the family of sets to be intersected.
     * @return result MySet containing only numbers found across the t MySet array
     */
    @Override
    public MySet<E> intersectSets(MySet<E>[] t) {
        ArrayList<E> allElements = new ArrayList<>();

        for (MySet<E> es : t) {
                for (E e : es) {
                    allElements.add(e);// copying all elements from t into an ArrayList
                }
        }
        allElements.sort(null);     //sorts all elements stored in the ArrayList
        MySet<E> result = new Set2<>();  // sets in P3's solution are of type Set2
        E e = allElements.get(0);
            int c = 1;
            for (int i = 1; i < allElements.size(); i++) {
                if (allElements.get(i).equals(e))//keeps count of the amount of times the element appears across the sorted ArrayList
                    c++;
                else {
                    if (c == t.length)
                        result.add(e);    //adds all elements that have a frequency that meets the condition
                    e = allElements.get(i);
                    c = 1;
                }
            }
            if (c == t.length) {
                result.add(e);//adds all elements that have a frequency that meets the condition
            }

        return result;
    }//end of intersectSets



}
