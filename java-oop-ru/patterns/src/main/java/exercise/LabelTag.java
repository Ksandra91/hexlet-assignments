package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface inputTag;
    String value;

    public LabelTag(String value, TagInterface inputTag) {
        this.inputTag = inputTag;
        this.value = value;
    }

    @Override
    public String render() {
        return "<label>" + value + inputTag.render() + "</label>";
    }
}
// END
