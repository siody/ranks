package siody.guava;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rl
 */
public class CollectionsSio {
    public static void main(String[] args) {
        List<Integer> intList = Lists.newArrayList();
        Map<String, Integer> siMap = Maps.newHashMap();
        Set<Integer> intSet = Sets.newHashSet(23,24,56,23);
        List<Integer> initIntList = Lists.newArrayList(23,23,123,4,1,4);
        List<Integer> exactly100 = Lists.newArrayListWithCapacity(100);
        List<Integer> approx100 = Lists.newArrayListWithExpectedSize(100);
        Set<Integer> approx100Set = Sets.newHashSetWithExpectedSize(100);
        Iterable<Integer> concatenated = Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6));
        // concatenated包括元素 1, 2, 3, 4, 5, 6
        int lastAdded = Iterables.getLast(intSet);
        // int theElement = Iterables.getOnlyElement(intSet);
        List<List<Integer>> first3 = Lists.partition(initIntList,3);
    }
}
