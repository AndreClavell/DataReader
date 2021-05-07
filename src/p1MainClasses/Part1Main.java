package p1MainClasses;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import mySetImplementations.dataGenerator.DataReader;
import setIntersectionFinders.IntersectionFinder_P1P2;
import setIntersectionFinders.IntersectionFinder_P3;
import setIntersectionFinders.IntersectionFinder_P4;

import java.io.FileNotFoundException;
/**
 * @author Andre Clavell
 * 843-15-1170
 * CIIC4020-086
 * */

public class Part1Main {
    /**
     *
     * @param args
     * @throws FileNotFoundException
     * @throws CloneNotSupportedException
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {
        int parm = 0;
        if (args.length > 1) {
            System.out.println("Unexpected number of parameters. Must be <= 1.");
            return;
        }
        if (args.length == 1)
            parm = Integer.parseInt(args[0]);
        DataReader dR = new DataReader();
        final int M = dR.getM();
        final int N = dR.getN();
        IntersectionFinder_P1P2<Object> p1 = new IntersectionFinder_P1P2<>("1");
        IntersectionFinder_P3<Object> p3 = new IntersectionFinder_P3<>("3");
        IntersectionFinder_P4<Object> p4 = new IntersectionFinder_P4<>("4");
        Object[][][] allElements =  dR.readDataFiles();//creates a 2D object array from what is read in the files
        MySet<Object>[] MySet1 = new Set1[M];
        MySet<Object>[] MySet2 = new Set2[M];
        for (int i = 0; i < M; i++) {
            MySet<Object> temp1 = new Set1<>();
            MySet<Object> temp2 = new Set2<>();
            for (int j = 0; j < N; j++) {
                if(allElements[j][i]!=null) {//makes sure the current Object array
                    for (Object o : allElements[j][i]) {//The content of the current array is added into a Set1 and Set2
                        temp1.add(o);
                        temp2.add(o);
                    }
                }
            }//the temp1 and temp2 are added to their respective MySet array
            MySet1[i] = (MySet<Object>) temp1.clone();
            MySet2[i] = (MySet<Object>) temp2.clone();
        }
        if (parm == 0 || parm == 1) {
            System.out.println("Final Set by P1: " + p1.intersectSets(MySet1).toString());//displays result for P1
        }//End of 1
        if (parm == 0 || parm == 2) {
            System.out.println("Final Set by P2: " + p1.intersectSets(MySet2).toString());//displays result for P2
        }//End of 2
        if (parm == 0 || parm == 3){
            System.out.println("Final Set by P3: " + p3.intersectSets(MySet2).toString());//displays result for P3
        }//End of 3
        if (parm == 0 || parm == 4){
            System.out.println("Final Set by P4: " + p4.intersectSets(MySet2).toString());//displays result for P4
        }//End of 4
    }//End of main
}//End of Part1Main class
