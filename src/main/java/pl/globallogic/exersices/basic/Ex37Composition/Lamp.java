package pl.globallogic.exersices.basic.Ex37Composition;

public class Lamp {
    private final String style;
    private final boolean battery;
    private final int globRating ;

    public Lamp(String style, boolean battery, int globalRating){
        this.style = style;
        this.battery = battery;
        this.globRating  = globalRating;
    }

    public void turnOn() {
        System.out.println("Lamp -> Turning on");
    }

    public String getStyle() {
        return style;
    }

    public boolean isBattery() {
        return battery;
    }

    public int getGlobalRating() {
        return globRating ;
    }
}
