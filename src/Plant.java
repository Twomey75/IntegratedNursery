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
     * Constructor for plant
     * @param genusSpecies the genus species of the plant
     */
    public Plant(String genusSpecies, String commonName, String plantGroupChoice, String localDateInput)
    {
        // Construction scenario where plants have previously been added
        if(latestId != 0) {
            latestId = latestId + 1;
            this.id = latestId;
        }
        // Construction scenario where no plants have previously been added
        else {
            latestId = 4902;
            this.id = latestId;
        }
        this.commonName = commonName;
    }

    /**
     * @return the plants id
     */
    public long getPlantId()
    {
        return id;
    }
    
    /**
     * @return the plants genus species
     */
    public String getGenusSpecies()
    {
        return genusSpecies;
    }

    /**
     * @return the plants common name
     */
    public String getCommonName()
    {
        return commonName;
    }

    /**
     * @return the group the plant belongs to
     */
    public PlantGroup getPlantGroup()
    {
        return plantGroup;
    }

}
