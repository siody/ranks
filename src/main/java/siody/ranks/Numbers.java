package siody.ranks;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    static List<Integer> list1 = Arrays.asList(12,3,2,5,8456,324,67,23,78,233,566);
    static void print(String msg) {
        System.out.println(msg);
        for (int i=0;i<list1.size();++i) {
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();
    }
    static void print() {
        System.out.println();
        for (int i=0;i<list1.size();++i) {
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();
    }
}
