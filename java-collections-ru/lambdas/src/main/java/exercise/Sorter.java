package exercise;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return users.stream()
                .filter(man -> man.get("gender").equals("male"))
                .sorted(Comparator.comparing(m -> LocalDate.parse(m.get("birthday"), formatter)))
                .map(man -> man.get("name"))
                .collect(Collectors.toList());
    }
}
// END
