import lombok.Data;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data public class Document {

    private int update;
    private String background;
    private int backgroundMode;

    private String name;

    private List<Element> measures = new ArrayList<>();

    private List<Element> meters = new ArrayList<>();

    private List<Element> styles = new ArrayList<>();

    private HashMap<String, String> variables = new HashMap<>();

    public Document(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[Rainmeter]\n");
        sb.append("update=" + update + "\n");
        sb.append("backgroundMode=" + backgroundMode + "\n");
        if (background != null)
            sb.append("background=" + background + "\n");

        sb.append("\n");

        if (!variables.isEmpty()) {
            sb.append("[Variables]\n");
            for (String key : variables.keySet()) {
                sb.append(key + "=" + variables.get(key) + "\n");
            }
            sb.append("\n");
        }

        if (!measures.isEmpty()) {
            sb.append(";-----------------------------\n; Measures \n;-----------------------------\n");
            for (Element m : measures) {
                sb.append(m);
                sb.append("\n");
            }
        }

        if (!styles.isEmpty()) {
            sb.append(";-----------------------------\n; Styles \n;-----------------------------\n");
            for(Element s : styles) {
                sb.append(s);
                sb.append("\n");
            }
        }

        if (!meters.isEmpty()) {
            sb.append(";-----------------------------\n; Meters \n;-----------------------------\n");
            for(Element m : meters) {
                sb.append(m);
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public void addStyle(Element style) { styles.add(style); }

    public void addMeter(Element meter) {
        meters.add(meter);
    }

    public void addMeasure(Element measure) {
        measures.add(measure);
    }

    public void addVariable(String key, String value) {
        variables.put(key, value);
    }

    public String variable(String key) {
        return variables.get(key);
    }

    public void compile(String path) {
        System.out.println(toString());

        File f = new File(path + "\\" + name + ".ini");
        try (FileWriter writer = new FileWriter(f)){
            writer.write(toString());

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
