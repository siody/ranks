package siody.ranks;

import java.util.*;

public class QSort{
    static public void main(String[] args){
        int start=0;
        int end=Numbers.list1.size()-1;
        Stack<Integer> rangeToSort = new Stack<>();
        rangeToSort.push(start);
        rangeToSort.push(end);
        QSort.qSort(Numbers.list1, rangeToSort);
        System.out.println(Numbers.list1.size());
    }
    static <T extends Comparable<T>> void qSort(List<T> toSort, Stack<Integer> range){
        while (!range.empty()) {
            Integer end = range.pop();
            Integer start =range.pop();
            Integer toPushStart = start;
            Integer toPushEnd = end;
            T key = toSort.get(start);
            while (start < end) {
                while (start < end && toSort.get(end).compareTo(key)==1)
                    end--;
                toSort.set(start,toSort.get(end));
                while (start < end && toSort.get(start).compareTo(key)==-1)
                    start++;
                toSort.set(end,toSort.get(start));
                toSort.set(start,key);
            }

            if (toPushStart<start-1) {
                range.push(toPushStart);
                range.push(start - 1);
            }
            if (toPushEnd > start+1) {
                range.push(start + 1);
                range.push(toPushEnd);
            }
        }
    }
}
