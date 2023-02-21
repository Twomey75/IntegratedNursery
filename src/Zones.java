import java.util.HashMap;

/**
 * 
 * This class represents the different zones a plant can belong to
 * 
 * @version 2/20/2023
 * @author Sean Twomey
 */

public class Zones 
{
    private static HashMap<Integer, Zone> zones;

    private Zones()
    {
        zones = new HashMap<Integer, Zone>();
        zones.put(1, Zone(1, -50));
        zones.put(2, Zone(2, -50, -40));
        
    }
}
