package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var words = sentence.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        if (sentence.isEmpty()) {
            return map;
        }

        for (var word : words) {
            if (map.containsKey(word)) {
                var count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        StringBuilder result = new StringBuilder();
        if (map.isEmpty()) {
            return "{}";
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.append("\n").append("  ").append(entry.getKey()).append(": ").append(entry.getValue());
        }
        return "{" + result + "\n}";
    }
}
//END
