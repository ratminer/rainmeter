import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class CreateWidget {

    public Element measureTotal(String disk) {
        return
            new Element("measureTotal" + disk) {
                {
                    addField("Measure", "FreeDiskSpace");
                    addField("Drive", disk);
                    addField("Total", "1");
                    addField("UpdateDivier", "120");
                }
            };
    }

    public Element measureUsed(String disk) {
        return new Element("measureUsed" + disk) {
            {
                addField("Measure", "FreeDiskSpace");
                addField("Drive", disk);
                addField("Total","1");
                addField("UpdateDivier", "120");
                addField("InvertMeasure", "1");
            }
        };
    }

    public Element styleTitle() {
        return new Element("styleTitle") {
            {
                addField("StringAlign","Center");
                addField("StringCase","Upper");
                addField("StringStyle","Bold");
                addField("StringEffect","Shadow");
                addField("FontEffectColor","0,0,0,50");
                addField("FontColor","#colorText#");
                addField("FontFace","#fontName#");
                addField("FontSize","10");
                addField("AntiAlias","1");
                addField("ClipString","1");
            }
        };
    }

    public Element styleLeftText() {
        return new Element("styleLeftText") {
            {
                addField("StringAlign","Left");
                addField("StringCase","None");
                addField("StringStyle","Bold");
                addField("StringEffect","Shadow");
                addField("FontEffectColor","0,0,0,20");
                addField("FontColor","#colorText#");
                addField("FontFace","#fontName#");
                addField("FontSize","#textSize#");
                addField("AntiAlias","1");
                addField("ClipString","1");
            }
        };
    };

    public Element styleRightText() {
        return new Element("styleRightText") {
            {
                addField("StringAlign","Right");
                addField("StringCase","None");
                addField("StringStyle","Bold");
                addField("StringEffect","Shadow");
                addField("FontEffectColor","0,0,0,20");
                addField("FontColor","#colorText#");
                addField("FontFace","#fontName#");
                addField("FontSize","#textSize#");
                addField("AntiAlias","1");
                addField("ClipString","1");
            }
        };
    }

    public Element styleBar() {
        return new Element("styleBar") {
            {
                addField("BarColor","#colorBar#");
                addField("BarOrientation","HORIZONTAL");
                addField("SolidColor","255,255,255,15");
            }
        };
    }

    public Element meterTitle() {
        return new Element("meterTitle") {
            {
                addField("Meter","String");
                addField("MeterStyle","styleTitle");
                addField("X","100");
                addField("Y","12");
                addField("W","190");
                addField("H","18");
                addField("Text","Disks");
            }
        };
    }

    public Element meterLabel(String disk) {
        return new Element("meterLabel" + disk) {
            {
                addField("Meter", "String");
                addField("MeterStyle", "styleLeftText");
                addField("Text", disk);
                addField("x", "10");
                addField("y", "40");
                addField("w","190");
                addField("h", "14");
            }
        };
    }

    public Element meterValue(String disk, Element e, Element e2) {
        return new Element("meterValue" + disk) {
            {
                addField("Meter","String");
                addField("MeterStyle","styelRightText");
                addField("MeasureName", e.getName());
                addField("MeasureName2", e2.getName());
                addField("x", "200");
                addField("Y","0r");
                addField("w","190");
                addField("h","14");
                addField("Text","%1B/%2B used");
                addField("NumOfDecimals","1");
                addField("AutoScale","1");
            }
        };
    }

    public Element meterBar(String disk, Element e) {
        return new Element("meterBar" + disk) {
            {
                addField("Meter","Bar");
                addField("MeterStyle","styleBar");
                addField("MeasureName",e.getName());
                addField("x", "10");
                addField("y","72");
                addField("w","190");
                addField("H","1");
            }
        };
    }

    public void run() {
        Document doc = new Document("asdf");
        doc.setBackground("#@#Background.png");

        doc.addVariable("fontName", "Trebuchet MS");
        doc.addVariable("textSize", "8");
        doc.addVariable("colorBar", "235,170,0,255");
        doc.addVariable("colorText","255,255,255,205");
        doc.addVariable("disk1", "C:");
        doc.addVariable("disk2", "D:");

        // measures

        Element totalDisk1 = measureTotal(doc.variable("disk1"));
        Element usedDisk1 = measureTotal(doc.variable("disk1"));
        Element totalDisk2 = measureTotal(doc.variable("disk2"));
        Element usedDisk2 = measureTotal(doc.variable("disk2"));

        doc.addMeasure(totalDisk1);
        doc.addMeasure(usedDisk1);

        // styles
        doc.addStyle(styleTitle());
        doc.addStyle(styleLeftText());
        doc.addStyle(styleRightText());
        doc.addStyle(styleBar());

        // meters
        doc.addMeter(meterTitle());
        doc.addMeter(meterLabel(doc.variable("disk1")));
        doc.addMeter(meterValue(doc.variable("disk1"), totalDisk1, usedDisk1));
        doc.addMeter(meterBar(doc.variable("disk1"), totalDisk1));

        doc.compile("C:\\Users\\robert.fernandes\\Documents\\Rainmeter\\Skins\\illustro\\Disk");
    }

    public static void main(String[] args) {
        new CreateWidget().run();
    }
}