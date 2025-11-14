interface LightPattern {
    void activate();
}

public class SmartLight{
    public static void main(String[] args) {

        LightPattern motionTrigger = () -> System.out.println("Motion detected → Turning ON soft yellow lights.");
        LightPattern nightTrigger = () -> System.out.println("Night mode → Dim lights activated.");
        LightPattern voiceCommand = () -> System.out.println("Voice command → Party lights ON!");

        motionTrigger.activate();
        nightTrigger.activate();
        voiceCommand.activate();
    }
}

