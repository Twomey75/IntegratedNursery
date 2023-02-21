/**
 * 
 * This class represents a single zone a plant can belong to
 * 
 * @version 2/20/2023
 * @author Sean Twomey
 */

public class Zone {
    private int lowTemperature;
    private int highTemperature;
    private int zoneNumber;

    public Zone(int zoneNumber, int lowTemperature, int highTemperature)
    {
        this.lowTemperature = lowTemperature;
        this.highTemperature = highTemperature;
        this.zoneNumber = zoneNumber;
    }

    //Special condition for zone 1 where only the high is defined at -50 degrees
    public Zone(int zoneNumber, int singleTemp)
    {
        if(zoneNumber == 1){
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
