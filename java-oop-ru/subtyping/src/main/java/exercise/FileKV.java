package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    public FileKV(String path, Map<String, String> start) {
        this.path = path;
        this.start = start;
    }

    private String path;
    private Map<String, String> start;

    @Override
    public void set(String key, String value) {

    }

    @Override
    public void unset(String key) {

    }

    @Override
    public String get(String key, String defaultValue) {
        return null;
    }

    @Override
    public Map<String, String> toMap() {
        return null;
    }
}
// END
