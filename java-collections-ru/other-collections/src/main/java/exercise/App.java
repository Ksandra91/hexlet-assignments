package exercise;

import java.util.*;

// BEGIN
public class App {
    public static LinkedHashMap<String, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        SortedMap<String, Object> sortedMap = new TreeMap<>();

        Set<String> keys1 = data1.keySet();
        Set<String> keys2 = data2.keySet();

        for (var key : keys1) {
            if (keys2.contains(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    sortedMap.put(key, "unchanged");
                } else {
                    sortedMap.put(key, "changed");
                }

            } else {
                sortedMap.put(key, "deleted");
            }
        }
        for (var key : keys2) {
            if (!keys1.contains(key)) {
                sortedMap.put(key, "added");
            }
        }


        return new LinkedHashMap<>(sortedMap);
    }
}
//END
