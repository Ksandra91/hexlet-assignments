package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        long freeEmailsCount = 0;
        if (emails != null) {
            freeEmailsCount = emails.stream()
                    .filter(email -> email.contains("@gmail.com") || email.contains("@yandex.ru")
                            || email.contains("@hotmail.com"))
                    .count();
        } else {
            return freeEmailsCount;
        }
        return freeEmailsCount;
    }
}
// END
