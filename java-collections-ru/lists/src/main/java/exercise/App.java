package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {

public static boolean scrabble(String str, String word) {
        String lowerWord = word.toLowerCase();

        ArrayList<Character> symbols = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            symbols.add(str.charAt(i));
        }

        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i < lowerWord.length(); i++) {
            letters.add(lowerWord.charAt(i));
        }
        ArrayList<Character> copy = new ArrayList<>(letters);

        if (!copy.isEmpty()) {
            for (var sym : symbols) {
                if (letters.contains(sym)) {
                    copy.remove(sym);
                }
            }
        }
        
        return copy.isEmpty();
    }
}
//END
