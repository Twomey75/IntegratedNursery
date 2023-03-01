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
    private static LocalDate oldestPlantDate;
    private static LocalDate youngestPlantDate;
    private static final String defaultName = "No-Info";

    public static HashMap<String, Predicate<Plant>> plantTest;
        static {
            plantTest = new HashMap<>();
            plantTest.put("most_experienced", Plant -> Plant.getDateIntroduced().equals(oldestPlantDate));
            plantTest.put("least_experienced", Plant -> Plant.getDateIntroduced().equals(youngestPlantDate));
        }

    /**
     * Constructor for plant
     * @param genusSpecies the genus species of the plant
     * @param commonName the commonName of the plant
     * @param plantGroupChoice the plant group chosen for the plant being added to the nursery
     * @param dateInput the date of entry chosen for the plant being added to the nursery
     * @param lowestTemp lowest temp the plant can survive in
     * @param highestTemp highest temp the plant can survive in
     */
    public Plant(String commonName, String genusSpecies, String plantGroupChoice, String dateInput, int lowestTemp, int highestTemp)
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
        // Assign a common name if meets proper requirements
        this.commonName = determineCommonName(commonName);
        // Assign a genusSpecies name if it meets the proper requirements
        this.genusSpecies = checkGenusNameValidity(genusSpecies);
        // Assign a plant group if input is valid and matches a plant group listed in PlantGroups
        this.plantGroup = checkPlantGroupValidity(plantGroupChoice);
        // Implementation of setting the year introduced, a method could be made to make the assignment of dateIntroduced more clean
        if(validDateInput(dateInput)) {
            dateIntroduced = LocalDate.of(Integer.parseInt(dateInput.substring(0,4)), Integer.parseInt(dateInput.substring(5,7)), Integer.parseInt(dateInput.substring(8,10)));
        }
        else {
            dateIntroduced = LocalDate.of(9999,12,31);
        }
        // Assign Zones to the plant based off of the highest and lowest temps it can survive in provided by the user
        populateZones(lowestTemp, highestTemp);
        // Check the new plants date against oldest and youngest plant date and do assignments accordingly
        comparePlantDates();
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
     * @return the default value that gets assigned to a name field
     */
    public String getDefaultName()
    {
        return defaultName;
    }

    /**
     * @return the oldest plant date
     */
    public LocalDate getOldestDate()
    {
        return oldestPlantDate;
    }

    /**
     * @return the oldest plant date
     */
    public LocalDate getYoungestDate()
    {
        return youngestPlantDate;
    }

    /**
     * @return the group the plant belongs to
     */
    public String getPlantGroupAsString()
    {
        // Case where the plant group is known
        if(plantGroup != null) {
            return plantGroup.toString().toLowerCase();
        }
        // Case where the plant group is not known
        else {
            return defaultName;
        }
    }

    /**
     * @return the date the plant was introduced to the Nursery
     */
    public LocalDate getDateIntroduced()
    {
        return dateIntroduced;
    }

    /**
     * @return the date the plant was introduced to the Nursery as a string
     */
    public String getDateIntroducedAsString()
    {
        if(!dateIntroduced.toString().equals("9999-12-31")) {
            return dateIntroduced.toString();
        }
        else {
            return defaultName;
        }
    }

    /**
     * @return that the date added was a valid or invalid int
     * @param number the string with a number that is being tested to see if the string is a number
     */
    private boolean determineIfInt(String number)
    {
        try {
            int testInt = Integer.parseInt(number);
            testInt = testInt + 1;
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
     * @param dateInput the year string the user initially puts in that gets checked
     */
    private boolean validDateInput(String dateInput)
    {
        if(dateInput != null && dateInput.length() == 10 && determineIfInt(dateInput.substring(0,4)) && determineIfInt(dateInput.substring(5,7)) && determineIfInt(dateInput.substring(8,10))) {
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
     * @return the Genus Name input if it meets the rules of a name for a genus species
     */
    private static String checkGenusNameValidity(String genusName)
    {
        if(genusName != null && genusName.length() >= 7 && genusName.length() <= 39) {
            return genusName.substring(0, 1).toUpperCase() + genusName.substring(1, genusName.length()).toLowerCase();
        }
        else {
            return defaultName;
        }
    }

    /**
     * @param plantGroupChoice
     * @return the PlantGroup option the plant belongs to or a null value if the plant does not belong to anything
     */
    private PlantGroup checkPlantGroupValidity(String plantGroupChoice)
    {
            // Assign a plant group to the plant
            if(plantGroupChoice == null) {
                return null;
            }
            else if(plantGroupChoice.equalsIgnoreCase("ANGIOSPERM")) {
                return PlantGroup.ANGIOSPERM;
            }
            else if(plantGroupChoice.equalsIgnoreCase("GYMNOSPERM")) {
                return PlantGroup.GYMNOSPERM;
            }
            else if(plantGroupChoice.equalsIgnoreCase("PTERIDOPHYTE")) {
                return PlantGroup.PTERIDOPHYTE;
            }
            else if(plantGroupChoice.equalsIgnoreCase("BRYOPHYTE")) {
                return PlantGroup.BRYOPHYTE;
            }
            // Make plantgroup null if the inputed plantgroup doesn't match anything on record
            else {
                return null;
            }
    }

    /**
     * @return the common Name input if it meets the rules of a name for a common name
     */
    private static String determineCommonName(String commonName)
    {
        if(commonName != null && !commonName.isEmpty()) {
            return commonName.substring(0, 1).toUpperCase() + commonName.substring(1, commonName.length());
        }
        else {
            return defaultName;
        }
    }

    /**
     * @return whether or not the plant can grow in the zone
     * @param zoneNumberInput the number of the zone being checked for suitability of a plant
     */
    public boolean growsInZone(String zoneNumberInput) 
    {
        // Check if a user actually put in a valid intger
        if(!(determineIfInt(zoneNumberInput))) {
            return false;
        }
        int zoneNum = Integer.parseInt(zoneNumberInput);
        // Check to see if the zone is null
        if(zones.get(zoneNum) == null)
        {
            return false;
        }
        // Check to make sure the int represents a valid zone
        if(zoneNum > 11 && zoneNum < 1) {
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
     * @param lowestPlantTemp the lowest temperature the plant can survive in
     * @param highestPlantTemp the highest temperature the plant can survive in
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

    /**
     * compares the dateIntroduced of the current plant with the youngest plant date and oldest plant date to see if it was introduced after or 
     * before them respectively. It also assigns the oldest and youngest plant dates to the current plants dateIntroduced if the current plant is
     * the first instance of a plant being created.
     */
    public void comparePlantDates()
    {
        // Case where no oldest or youngest date exists yet
        if(oldestPlantDate == null && youngestPlantDate == null)
        {
            oldestPlantDate = dateIntroduced;
            youngestPlantDate = dateIntroduced;
        }
        // Check if the new plant date is older than the current oldest plant date
        if(dateIntroduced.isBefore(oldestPlantDate))
        {
            oldestPlantDate = dateIntroduced;
        }
        // Check if the new plant date is younger than the current youngest plant date
        if(dateIntroduced.isAfter(youngestPlantDate))
        {
            youngestPlantDate = dateIntroduced;
        }
    }
}
