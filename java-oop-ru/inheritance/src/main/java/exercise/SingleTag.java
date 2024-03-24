package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    public String toString() {
        String res = "<" + super.getName();

        for (var e : super.getAttributes().entrySet()) {
            res += " ";
            String str = e.getKey() + "=" + "\"" + e.getValue() + "\"";
            res += str;
        }
        return res + ">";

    }
}
// END
