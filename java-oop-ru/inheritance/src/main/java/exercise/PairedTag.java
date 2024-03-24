package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String body;
    List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    public String toString() {

        String result = "<" + super.getName();

        for (var e : super.getAttributes().entrySet()) {
            result += " ";
            String str = e.getKey() + "=" + "\"" + e.getValue() + "\"";
            result += str;
        }
        result += ">";

        for (var child : children) {
            result += utils(child);
        }

        result += body + "</" + super.getName() + ">";

        return result;
    }


    public String utils(Tag child) {

        String res = "<" + child.getName();

        for (var e : child.getAttributes().entrySet()) {
            res += " ";
            String str = e.getKey() + "=" + "\"" + e.getValue() + "\"";
            res += str;
        }
        return res + ">";
    }
}
// END
