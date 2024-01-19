package exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String conf) {

        String[] array = conf.split("\n");

        List<String> listStr = Arrays.stream(array)
                .filter(s -> s.startsWith("environment="))
                .map(s -> s.replace("environment=", ""))
                .filter(s -> s.contains("X_FORWARDED"))
                .collect(Collectors.toList());


        String[][] splitStrArray = new String[listStr.size()][];
        int k = 0;
        for (var str : listStr) {
            splitStrArray[k] = str.split(",");
            k++;
        }

        return Stream.of(splitStrArray)
                .flatMap(Stream::of)
                .filter(s -> s.contains("X_FORWARDED"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .map(s -> s.replace("\"", ""))
                .collect(Collectors.joining(","));
    }
}
//END
