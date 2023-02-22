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

public class Plant 
{
    private long id;
    private static long latestId;
    private String genusSpecies;
    private String commonName;
    private PlantGroup plantGroup;
    private LocalDate dateIntroduced;
    private static HashMap<Integer, Zone> zones;
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
        if(commonName != null) {
            this.commonName = commonName;
        }
        if(genusSpecies != null) {
            this.genusSpecies = genusSpecies;
        }
        Plant.zones = new HashMap<Integer, Zone>();

        //Implementation of setting the year introduced I feel like I could make the body of the if statement more clean
        if(validYearInput(localDateInput)) {
            dateIntroduced = LocalDate.of(Integer.parseInt(localDateInput.substring(0,4)), Integer.parseInt(localDateInput.substring(5,7)), Integer.parseInt(localDateInput.substring(8,10)));
        }
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

    /**
     * @return the date the plant was introduced to the Nursery
     */
    public LocalDate getDateIntroduced()
    {
        return dateIntroduced;
    }

    /**
     * @return that the date added was valid or invalid int
     * @param number the string with a number that is being tested to see if the string is a number
     */
    private boolean determineIfInt(String number)
    {
        try {
            int testInt = Integer.parseInt(number);
        }
        catch (NumberFormatException nfe) {
            //Case where the date number entered is invalid
            return false;
        }
        //Case where the date number entered is valid
        return true;
    }

    /**
     * @return that the date added was valid or invalid int
     * @param yearInput the year string the user initially puts in that gets checked
     */
    private boolean validYearInput(String yearInput)
    {
        if(yearInput.length() == 10 && determineIfInt(yearInput.substring(0,4)) && determineIfInt(yearInput.substring(5,7)) && determineIfInt(yearInput.substring(8,10))) {
            // return true if the year is valid
            return true;
        }
        //return false if the year is invalid
        return false;
    }

    public HashMap<Integer, Zone> getZones()
    {
        return zones;
    }

    /**
     * @return the common name and genus of the plant formated
     */
    public String toString() 
    {
        return getCommonName() + " (" + getGenusSpecies() + ")";
    }

}
