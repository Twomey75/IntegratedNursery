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
    static private long id;
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
        id = 4902;
    }
}
