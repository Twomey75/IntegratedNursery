/**
 * 
 * This class is supposed to represent all types of trees
 * 
 * @version 2/20/2023
 * @author Sean Twomey
 */

public class Tree extends Plant 
{
    private GrowingSpeed growingSpeed;

    /**
     * Constructor for tree
     * @param commonName the commonName of the plant
     * @param genusSpecies the genus species of the plant
     * @param plantGroupChoice the plant group chosen for the plant being added to the nursery
     * @param localDateInput the date of entry chosen for the plant being added to the nursery
     * @param lowestZoneTemp lowest temp the plant can survive in
     * @param highestZoneTemp highest temp the plant can survive in
     * @param growingSpeedChoice the growing speed of the tree instance
     */
    public Tree(String commonName, String genusSpecies, String plantGroupChoice, String localDateInput, int lowestZoneTemp, int highestZoneTemp, String growingSpeedChoice)
    {
        // Run constructor of super class plant
        super(commonName, genusSpecies, plantGroupChoice, localDateInput, lowestZoneTemp, highestZoneTemp);

        if(growingSpeedChoice != null) {
            // Case where the user puts in that growing speed is fast
            if(growingSpeedChoice.equalsIgnoreCase("fast")) {
                this.growingSpeed = GrowingSpeed.FAST;
            }
            // Case where the user puts in that growing speed is slow 
            else if(growingSpeedChoice.equalsIgnoreCase("slow")) {
                this.growingSpeed = GrowingSpeed.SLOW;
            }
            // Case where no valid speed is put in so growing speed assumes a default value of null
            else {
                this.growingSpeed = null;
            }
        }
    }

    /**
     * @return the growing speed of the tree
     */
    public GrowingSpeed getGrowingSpeed() 
    {
        return growingSpeed;
    }

    /**
     * @return the growing speed of the tree as a string
     */
    public String getGrowingSpeedAsString() 
    {
        // Case where the growing speed is known
        if(growingSpeed != null) {
            return growingSpeed.toString().toLowerCase();
        }
        // Case where the growing speed is not known
        else {
            return getDefaultName();
        }
    }
}
