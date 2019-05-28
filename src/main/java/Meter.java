import lombok.Data;

import java.lang.reflect.Field;
import java.util.*;
import java.awt.Color;
import java.util.stream.Collectors;

@Data public class Meter {

    public enum Type {
        Bar, Bitmap, Button, Histogram, Image,
        Line, Rotator, Roundline, Shape, String,
    }

    public Meter(String name) {
        this.name = name;
    }

    private String name;

    private int x = 0;
    private int y = 0;

    private Type meter;

    private List<Meter> styles;
    private int w;
    private int h;

    private boolean relativeX = false;
    private boolean relativeY = false;

    // left, top, right, bottom
    private int[] padding = {0, 0, 0, 0};

    private boolean hidden = false;

    private Meter container;

    private int updateDivider = 1;

    private Action onUpdateAction;

    private int[] solidColor = {0, 0, 0, 0};
    private int[] solidColor2;
    private int gradientAngle;
    private int bevelType = 0;
    private boolean antiAlias = false;

    private int dynamicVariables = 0;

    // scale x, skew y, skew x, scale y, move x, move y
    private int[] transformationMatrix = {0, 0, 0, 0, 0};

    private Group group;

    public void setX(int x) {
        this.x = x;
        this.relativeX = false;
    }

    public void setRelativeX(int x) {
        this.x = x;
        this.relativeX = true;
    }

    public void setY(int y) {
        this.y = y;
        this.relativeY = false;
    }

    public void setRelativeY(int y) {
        this.y = y;
        this.relativeY = true;
    }



    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("[" + name + "]\n");

        sb.append("x=" + x + (relativeX ? "r\n" : "\n"));
        sb.append("y=" + y + (relativeY ? "r\n" : "\n"));
        append(sb, "Meter", meter.toString());
        append(sb, "w", w);
        append(sb, "h", h);

        append(sb, "padding", padding);
        append(sb, "hidden", hidden);
        //append(sb, "container", container);
        append(sb, "updateDivider", updateDivider);
        //append(sb, "onUpdateAction", onUpdateAction);
        append(sb, "solidColor", solidColor);
        append(sb, "antiAlias", antiAlias);
        append(sb, "dynamicVariables", dynamicVariables);

        return sb.toString();
    }

    private void append(StringBuilder sb, String name, int[] values) {
        sb.append(name);
        sb.append("=");
        sb.append(values[0]);

        for(int i = 1; i < values.length; i++) {
            sb.append(",");
            sb.append(values[i]);

        }
        sb.append('\n');
    }

    private void append(StringBuilder sb, String name, List<Object> values) {
        sb.append(name);
        sb.append("=");
        for(Object i : values) {
            sb.append(i);
            sb.append(",");
        }
        sb.append('\n');
    }

    private void append(StringBuilder sb, String name, int value) {
        sb.append(name);
        sb.append("=");
        sb.append(value);
        sb.append('\n');
    }

    private void append(StringBuilder sb, String name, boolean value) {
        sb.append(name);
        sb.append("=");
        sb.append(value);
        sb.append('\n');
    }

    private void append(StringBuilder sb, String name, String value) {
        sb.append(name);
        sb.append("=");
        sb.append(value);
        sb.append('\n');
    }

}
