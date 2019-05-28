import lombok.Data;

@Data public class Measure {

    public enum Type {
        Calc, CPU, FreeDiskSpace, Loop, MediaKey, Memory, Net, NowPlaying, Plugin,
        RecycleManager, Registry, Script, String, Time, Uptime, WebParser
    }

    public Measure(String name) {
        this.name = name;
    }
    private String name;
    private Type measure;

    private int updateDivider;
    private Action onUpdateAction;
    private Action onChangeAction;

    private boolean invertMeasure;

    private double maxValue = 1.0;
    private double minValue = 1.0;

    private int averageSize = 1;

    private int dynamicVariables = 0;

    private boolean paused = false;

    private Group group;


    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[" + name + "]\n");

        append(sb, "measure", measure.toString());
        append(sb, "updateDivider", updateDivider);

        return sb.toString();
    }

    private void append(StringBuilder sb, String name, String value) {
        sb.append(name);
        sb.append("=");
        sb.append(value);
        sb.append("\n");
    }

    private void append(StringBuilder sb, String name, boolean value) {
        sb.append(name);
        sb.append("=");
        sb.append(value);
        sb.append("\n");
    }

    private void append(StringBuilder sb, String name, int value) {
        sb.append(name);
        sb.append("=");
        sb.append(value);
        sb.append("\n");
    }

    private void append(StringBuilder sb, String name, double value) {
        sb.append(name);
        sb.append("=");
        sb.append(value);
        sb.append("\n");
    }
}
