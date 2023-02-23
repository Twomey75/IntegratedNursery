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
    private HashMap<Integer, Zone> zones;
    private HashMap<String, Predicate<Plant>> plantTest;

    /**
     * Constructor for plant
     * @param genusSpecies the genus species of the plant
     */
    public Plant(String genusSpecies, String commonName, String plantGroupChoice, String localDateInput, int lowestZoneTemp, int HighestZoneTemp)
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
        //Implementation of setting the year introduced I feel like I could make the body of the if statement more clean
        if(validYearInput(localDateInput)) {
            dateIntroduced = LocalDate.of(Integer.parseInt(localDateInput.substring(0,4)), Integer.parseInt(localDateInput.substring(5,7)), Integer.parseInt(localDateInput.substring(8,10)));
        }
        populateZones(lowestZoneTemp, HighestZoneTemp);
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

    /**
     * @return the zones that are valid for the plant
     */
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

    /**
     * @return whether or not the plant can grow in the zone
     * also I finally was able to use a nice technique to avoid if statement nesting woohoo!
     */
    public boolean growsInZone(String zoneNumberInput) 
    {
        // Check if a user actually put in a valid intger
        if(!(determineIfInt(zoneNumberInput))) {
            return false;
        }
        int zoneNum = Integer.parseInt(zoneNumberInput);
        // Check to make sure the int represents a valid zone
        if(zoneNum > 11 && zoneNum < 1) {
            return false;
        }
        // Check to see if the zone is null
        if(zones.get(zoneNum) == null)
        {
            return false;
        }
        // Case where the zone appears in the Map of zones the plant can grow in
        else
        {
            return true;
        }

    }

    /**
     * Populates a plant with the different valid zones from Zone class
     */
    private void populateZones(int lowestPlantTemp, int highestPlantTemp)
    {
        zones = new HashMap<Integer, Zone>();
        for (Integer key : Zone.zones.keySet()) {
            Zone currentZone = Zone.zones.get(key);
            // Check if the lowest temp and the highest temp this plant can survive in is in the range of the current zone
            if(lowestPlantTemp <= currentZone.getLowTemp() && highestPlantTemp >= currentZone.getHighTemp()) {
                zones.put(currentZone.getZoneNumber(), currentZone);
            }
        }
    }

}
