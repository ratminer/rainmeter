import lombok.Data;

@Data public class Measure {

    public enum Type {
        Calc, CPU, FreeDiskSpace, Loop, MediaKey, Memory, Net, NowPlaying, Plugin,
        RecycleManager, Registry, Script, String, Time, Uptime, WebParser
    }

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

}
