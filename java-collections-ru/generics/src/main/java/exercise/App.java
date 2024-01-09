package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> list, Map<String, String> words) {

        List<Map<String, String>> result = new ArrayList<>();

        for (var elem : list) {
            ArrayList<String> arrayList = getArray(elem);
            ArrayList<String> arrayList2 = getArray(words);
            if (arrayList.containsAll(arrayList2)) {
                result.add(elem);
            }
        }

        return result;
    }

    public static ArrayList<String> getArray(Map<String, String> map) {

        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, String> elem : map.entrySet()) {
            arrayList.add(elem.getValue());
        }

        return arrayList;
    }

}
//END
