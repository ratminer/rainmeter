import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data public class Document {

    private int update;
    private String background;
    private int backgroundMode;

    private List<Measure> measures = new ArrayList<>();

    private List<Meter> meters = new ArrayList<>();

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[Rainmeter]\n");
        sb.append("update=" + update + "\n");
        sb.append("backgroundMode=" + backgroundMode + "\n");
        if (background != null)
            sb.append("background=" + background + "\n");

        sb.append("\n");

        for (Measure m : measures) {
            sb.append(m);
            sb.append("\n");
        }

        for(Meter m : meters) {
            sb.append(m);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addMeter(Meter meter) {
        meters.add(meter);
    }

    public void addMeasure(Measure measure) {
        measures.add(measure);
    }
}
