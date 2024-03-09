package exercise;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> start;

    public InMemoryKV(Map<String, String> start) {
        this.start = start;
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> copy = new HashMap<>(start);
        for (Map.Entry<String, String> entry : start.entrySet()) {
            String key1 = entry.getKey();
            if (key1.equals(key)) {
                String strRemove = start.get(key);
                copy.remove(strRemove);
                copy.put(key, value);
            } else {
                copy.put(key, value);
            }
        }
        start = copy;
    }

    @Override
    public void unset(String key) {
        Map<String, String> copy = new HashMap<>(start);
        for (Map.Entry<String, String> entry : start.entrySet()) {
            String key1 = entry.getKey();
            if (key1.equals(key)) {
                String strRemove = start.get(key);
                copy.remove(key, strRemove);
            }
        }
        start = copy;
    }

    @Override
    public String get(String key, String defaultValue) {
        Set<String> keys = start.keySet();
        if (keys.contains(key)) {
            return start.get(key);
        } else {
            return defaultValue;
        }
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(start);
    }
}
// END
