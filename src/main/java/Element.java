import lombok.Data;

import java.util.*;

@Data public class Element {

    private String name;

    private Map<String, String> fields;

    public Element(String name) {
        this.name = name;
        fields = new HashMap<>();

        initialize();
    }

    public void addField(String key, String value) {
        fields.put(key, value);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[" + name +  "]\n");

        for (String s : fields.keySet()) {
            sb.append(s + "=" + fields.get(s) + "\n");
        }

        return sb.toString();
    }

    public void initialize() {

    }
}
