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
            StringBuilder str = new StringBuilder();
            for (Map.Entry<String, String> book : elem.entrySet()) {
                str.append(book.getKey()).append(book.getValue());
            }
            String word = getString(words);
            if (str.toString().contains(word)) {
                result.add(elem);
            }
        }

        return result;
    }

    public static String getString(Map<String, String> map) {

        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, String> el : map.entrySet()) {
            str.append(el.getKey()).append(el.getValue());
        }

        return str.toString();
    }

}
//END
