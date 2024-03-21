package exercise;

import java.util.Map;
import java.util.HashMap;


// BEGIN
public class InMemoryKV implements KeyValueStorage {
    //    private Map<String, String> start;
//
//    public InMemoryKV(Map<String, String> start) {
//        this.start = start;
//    }
//
//    @Override
//    public void set(String key, String value) {
//        Map<String, String> copy = new HashMap<>(start);
//        for (Map.Entry<String, String> entry : start.entrySet()) {
//            String key1 = entry.getKey();
//            if (key1.equals(key)) {
//                String strRemove = start.get(key);
//                copy.remove(strRemove);
//                copy.put(key, value);
//            } else {
//                copy.put(key, value);
//            }
//        }
//        start = copy;
//    }
//
//    @Override
//    public void unset(String key) {
//        Map<String, String> copy = new HashMap<>(start);
//        for (Map.Entry<String, String> entry : start.entrySet()) {
//            String key1 = entry.getKey();
//            if (key1.equals(key)) {
//                String strRemove = start.get(key);
//                copy.remove(key, strRemove);
//            }
//        }
//        start = copy;
//    }
//
//    @Override
//    public String get(String key, String defaultValue) {
//        Set<String> keys = start.keySet();
//        if (keys.contains(key)) {
//            return start.get(key);
//        } else {
//            return defaultValue;
//        }
//    }
//
//    @Override
//    public Map<String, String> toMap() {
//        return new HashMap<>(start);
//    }
    private Map<String, String> data = new HashMap<>();

    InMemoryKV(Map<String, String> initial) {
        data.putAll(initial);
    }

    public void set(String key, String value) {
        data.put(key, value);
    }

    public void unset(String key) {
        data.remove(key);
    }

    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }
}
// END
