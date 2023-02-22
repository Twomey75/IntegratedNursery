import java.util.HashMap;

/**
 * This class represents a single zone a plant can belong to
 * 
 * @version 2/22/2023
 * @author Sean Twomey
 * @author Mary Lisicki
 * New change
 */

public class Zone {
    private int lowTemperature;
    private int highTemperature;
    private int zoneNumber;

    private Zone(int zoneNumber, int lowTemperature, int highTemperature)
    {
        this.lowTemperature = lowTemperature;
        this.highTemperature = highTemperature;
        this.zoneNumber = zoneNumber;
        
        public static HashMap<Integer, Zone> zones = new HashMap<Integer, Zone>();
        static {
            zones.put(1, new Zone(1, -50));
            zones.put(2, new Zone(2, -50, -40));
            zones.put(3, new Zone(3, -40, -30));
            zones.put(4, new Zone(4, -30, -20));
            zones.put(5, new Zone(5, -20, -10));
            zones.put(6, new Zone(6, -10, 0));
            zones.put(7, new Zone(7, 0, 10));
            zones.put(8, new Zone(8, 10, 20));
            zones.put(9, new Zone(9, 20, 30));
            zones.put(10, new Zone(10, 30, 40));
            zones.put(11, new Zone(11, 40, 50));
        }
    }

    //Special condition for zone 1 where only the high is defined at -50 degrees
    private Zone(int zoneNumber, int singleTemp)
    {
        if(zoneNumber == 1){
            this.lowTemperature = -51;
            this.highTemperature = singleTemp;
            this.zoneNumber = zoneNumber;
        }
    }

    public int getLowTemp()
    {
        return lowTemperature;
    }

    public int getHighTemp()
    {
        return highTemperature;
    }
}
