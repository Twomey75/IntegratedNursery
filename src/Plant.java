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
    private long id;
    private static long latestId;
    private String genusSpecies;
    private String commonName;
    private PlantGroup plantGroup;
    private LocalDate dateIntroduced;
    private HashMap<Integer, Zone> zones;
    private HashMap<String, Predicate<Plant>> plantTest;

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
}
