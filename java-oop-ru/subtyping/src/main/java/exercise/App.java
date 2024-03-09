package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {

//    public static void main(String[] args) {
//        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
//        App.swapKeyValue(storage);
//        System.out.println(storage.get("key", "default")); // "default"
//        System.out.println(storage.get("value", "default")); // "key"
//
//        System.out.println(storage.toMap()); // => {value=key, value2=key2}
    //   KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
    // Получение значения по ключу
    // System.out.println(storage.get("key", "default")); // "10"
    //   System.out.println(storage.get("unknown", "default")); // "default"
//        // Установка нового значения
    //    storage.set("key2", "value2");
    //   System.out.println(storage.get("key2", "default")); // "value2"
//        // Удаление ключа
    //   storage.unset("key2");
    //   System.out.println(storage.get("key2", "default")); // "default"
    // Получение всех данных из базы
    //   Map<String, String> data = storage.toMap();
    //   System.out.println(data); // => {key=10};

    //  }

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
