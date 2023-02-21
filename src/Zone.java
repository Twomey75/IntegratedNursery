/**
 * 
 * This class represents the different zones a plant can belong to
 * 
 * @version 2/20/2023
 * @author Sean Twomey
 */

public class Zone 
{
    private int minTemperature;
    private int maxTemperature;

    public Zone(int zoneNumber)
    {
        switch(zoneNumber) {
            case 1:
                this.minTemperature = -100;
                this.maxTemperature = -51;
                break;
            case 2:

        }
    }
}
