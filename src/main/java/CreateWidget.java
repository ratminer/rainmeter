public class CreateWidget {

    public static void main(String[] args) {

        Document doc = new Document();

        doc.setBackground("#@#Background.png");

        StringMeter title = new StringMeter("title");
        title.setX(100);
        title.setY(12);
        title.setW(190);
        title.setH(18);
        title.setText("asdf");

        doc.addMeter(title);
        compile(doc);
    }

    public static void compile(Document doc) {
        System.out.println(doc.toString());
    }
}

/*
; Lines starting ; (semicolons) are commented out.
; That is, they do not affect the code and are here for demonstration purposes only.
; ----------------------------------

[Rainmeter]
; This section contains general settings that can be used to change how Rainmeter behaves.
Update=1000
Background=#@#Background.png
; #@# is equal to Rainmeter\Skins\illustro\@Resources
BackgroundMode=3
BackgroundMargins=0,34,0,14

[Metadata]
; Contains basic information of the skin.
Name=System
Author=poiru
Information=Displays basic system stats.
License=Creative Commons BY-NC-SA 3.0
Version=1.0.0

[Variables]
; Variables declared here can be used later on between two # characters (e.g. #MyVariable#).
fontName=Trebuchet MS
textSize=8
colorBar=235,170,0,255
colorText=255,255,255,205

; ----------------------------------
; MEASURES return some kind of value
; ----------------------------------

[measureCPU]
; This measure returns the average CPU load between all cores.
Measure=CPU
Processor=0

[measureRAM]
; Returns the amount of RAM used in bytes.
Measure=PhysicalMemory
UpdateDivider=20
; UpdateDivider sets the rate at which the value of the measure is updated. It is
; calculated as follows: UpdateDivider x Update. In this case, Update is set to
; 1000 milliseconds (in the [Rainmeter] section). 1000 x 20 = 20000 ms or 20 seconds.

[measureSWAP]
; Returns the amount of SWAP (pagefile) used in bytes.
Measure=SwapMemory
UpdateDivider=20

; ----------------------------------
; STYLES are used to "centralize" options
; ----------------------------------

[styleTitle]
StringAlign=Center
StringCase=Upper
StringStyle=Bold
StringEffect=Shadow
FontEffectColor=0,0,0,50
FontColor=#colorText#
FontFace=#fontName#
FontSize=10
AntiAlias=1
ClipString=1

[styleLeftText]
StringAlign=Left
; Meters using styleLeftText will be left-aligned.
StringCase=None
StringStyle=Bold
StringEffect=Shadow
FontEffectColor=0,0,0,20
FontColor=#colorText#
FontFace=#fontName#
FontSize=#textSize#
AntiAlias=1
ClipString=1

[styleRightText]
StringAlign=Right
StringCase=None
StringStyle=Bold
StringEffect=Shadow
FontEffectColor=0,0,0,20
FontColor=#colorText#
FontFace=#fontName#
FontSize=#textSize#
AntiAlias=1
ClipString=1

[styleBar]
BarColor=#colorBar#
BarOrientation=HORIZONTAL
SolidColor=255,255,255,15

; ----------------------------------
; METERS display images, text, bars, etc.
; ----------------------------------

[meterTitle]
Meter=String
MeterStyle=styleTitle
; Using MeterStyle=styleTitle will basically "copy" the
; contents of the [styleTitle] section here during runtime.
X=100
Y=12
W=190
H=18
Text=System
; Even though the text is set to System, Rainmeter will display
; it as SYSTEM, because styleTitle contains StringCase=Upper.
LeftMouseUpAction=["taskmgr.exe"]
; Left-clicking this meter will launch taskmgr.exe (the Task Manager).
ToolTipText=Open Task Manager
; Hovering over this meter will display a tooltip with the text above.

[meterLabelCPU]
Meter=String
MeterStyle=styleLeftText
X=10
Y=40
W=190
H=14
Text=CPU Usage

[meterValueCPU]
Meter=String
MeterStyle=styleRightText
MeasureName=measureCPU
X=200
Y=0r
; r stands for relative. In this case, the Y position of meterValueCPU is 0 pixels
; below the Y value of the previous meter (i.e it's the same as in meterLabelCPU).
W=190
H=14
Text=%1%
; %1 stands for the value of MeasureName (measureCPU in this case).

[meterBarCPU]
Meter=Bar
MeterStyle=styleBar
MeasureName=measureCPU
X=10
Y=52
W=190
H=1

[meterLabelRAM]
Meter=String
MeterStyle=styleLeftText
X=10
Y=60
W=190
H=14
Text=RAM Usage

[meterValueRAM]
Meter=String
MeterStyle=styleRightText
MeasureName=measureRAM
X=200
Y=0r
W=190
H=14
Text=%1%
Percentual=1
; Percentual=1 needs to be added her because measureRAM returns the amount
; of RAM used in bytes. Using Percentual=1 will convert that into a percentual value.

[meterBarRAM]
Meter=Bar
MeterStyle=styleBar
MeasureName=measureRAM
X=10
Y=72
W=190
H=1

[meterLabelSWAP]
Meter=String
MeterStyle=styleLeftText
X=10
Y=80
W=190
H=14
Text=SWAP Usage

[meterValueSWAP]
Meter=String
MeterStyle=styleRightText
MeasureName=measureSWAP
X=200
Y=0r
W=190
H=14
Text=%1%
Percentual=1

[meterBarSWAP]
Meter=Bar
MeterStyle=styleBar
MeasureName=measureSWAP
X=10
Y=92
W=190
H=1
 */