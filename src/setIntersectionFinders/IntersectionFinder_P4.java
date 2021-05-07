package setIntersectionFinders;

import interfaces.MySet;
import mySetImplementations.Set2;


import java.util.HashMap;
import java.util.Map;
/**
 * @author Andre Clavell
 * 843-15-1170
 * CIIC4020-086
 * */
public class IntersectionFinder_P4<E> extends AbstractIntersectionFinder<E>{
    public IntersectionFinder_P4(String name) {
        super(name);
    }

    /**
     *
     * @param t array containing the family of sets to be intersected.
     * @return result MySet containing only numbers found across the t MySet array
     */
    @Override
    @SuppressWarnings("unchecked")
    public MySet<E> intersectSets(MySet<E>[] t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        MySet<E> result = new Set2<>();

        for (MySet<E> es : t) {
            for (E e : es) {
                Integer c = map.getOrDefault(e, 0);//checks if the the current 'e' is stored in the map and returns its value
                map.put((Integer) e, c + 1);// adds 'e' with an updated value into the hashmap
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(t.length)) {//compares if the current entry has a frequency equal to the amount of MySets stored in t
                result.add((E) entry.getKey());//adds those that meet the previous condition
            }
        }


        return result;
    }//end of intersectSets
}
