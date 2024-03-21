package exercise;

import java.util.Map;


// BEGIN
public class App {


    public static void swapKeyValue(KeyValueStorage storage) {

        Map<String, String> start = storage.toMap();

        for (var key : start.keySet()) {
            String value = start.get(key);
            storage.unset(key);
            storage.set(value, key);
        }
    }

}
// END
