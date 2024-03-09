package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    String str;

    public ReversedSequence(String str) {
        this.str = reverse(str);
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int i) {
        return  str.charAt(1);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        String string = str;
        char[] chars = string.toCharArray();
        String result = "";
        for (int j = i; j < i1; j++) {
            result += chars[j];
        }
        return result;
    }

    public String toString() {
        return reverse(str);
    }

    public String reverse(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i];
        }
        return result;
    }
}

// END
