package siody.ranks;

import java.util.Comparator;
import java.util.List;

public class ShellSort {
    static public void main(String[] args){
        Integer increace = 5;
        Numbers.print("Before:");
        ShellSort.shellSort(Numbers.list1,increace);
        Numbers.print("After:");
    }
    static <T extends Comparable<T>> void shellSort(List<T> toSort, Integer increace) {
        for (;increace!=1;increace/=2)
            for (int i=0; i<increace; ++i){
                int j=i+increace;
                while (j<toSort.size()){
                    boolean flag =true;
                    int toCom = j;
                    while (flag) {
                        if (toSort.get(toCom).compareTo(toSort.get(toCom - increace))==1){
                            T temp = toSort.get(toCom);
                            toSort.set(toCom,toSort.get(toCom-increace));
                            toSort.set(toCom-increace,temp);
                            toCom -= increace;
                            if (toCom < increace) {
                                flag = false;
                            }
                        }else
                            flag =false;
                    }
                    j+=increace;
                }
            }
    }
}
