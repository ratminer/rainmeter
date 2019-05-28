import lombok.Data;

@Data public class StringMeter extends Meter {

    public StringMeter(String name) {
        super(name);
        setMeter(Type.String);
    }

    private String text;

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("text=" + text);

        return super.toString() + sb.toString();
    }
}
