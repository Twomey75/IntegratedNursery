import java.time.LocalDate;
import java.util.HashMap;
import java.util.function.Predicate;

/**
 * 
 * This class is supposed to represent the basic concept of a plant
 * 
 * @version 2/20/2023
 * @author Sean Twomey
 * @author Mary Lisicki
 */

public class Plant {
    protected long id;
    private static long latestId;
    protected String genusSpecies;
    protected String commonName;
    protected PlantGroup plantGroup;
    protected LocalDate dateIntroduced;
    protected HashMap<Integer, Zone> zones;
    protected HashMap<String, Predicate<Plant>> plantTest;

    /**
     * Constructor for plant when there are no plants previously added
     */
    public Plant()
    {
        if(latestId != 0) {
            latestId = latestId + 1;
            id = latestId;
        }
        else {
            latestId = 4902;
            id = latestId;
        }
    }

    public long getPlantId()
    {
        return id;
    }

    public 

}
