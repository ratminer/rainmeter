public class CreateWidget {

    public static void main(String[] args) {
        Meter meter = new Meter("meter");
        meter.setRelativeX(10);
        meter.setRelativeY(10);

        compile(meter);
    }

    public static void compile(Meter meter) {
        System.out.println(meter.toString());
    }
}
