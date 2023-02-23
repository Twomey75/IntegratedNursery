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
     * @param genusSpecies the genus species of the tree instance
     * @param growingSpeedChoice the growing speed of the tree instance
     */
    public Tree(String genusSpecies, String commonName, String localDateInput, int lowestZoneTemp, int HighestZoneTemp, String growingSpeedChoice)
    {
        // Run constructor of super class plant
        super(genusSpecies, commonName, null, localDateInput, lowestZoneTemp, HighestZoneTemp);

        // Case where the user puts in that growing speed is fast
        if(growingSpeedChoice.equalsIgnoreCase("fast")) {
            growingSpeed = GrowingSpeed.FAST;
        }
        // Case where the user puts in that growing speed is slow 
        else if(growingSpeedChoice.equalsIgnoreCase("slow")) {
            growingSpeed = GrowingSpeed.SLOW;
        }
        // Case where no valid speed is put in so growing speed assumes a default value of null
        else {
            growingSpeed = null;
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
     * @Override the original toString() method in Plant
     * @return the formated string of the tree
     */
    public String toString() 
    {
        return getCommonName() + " (" + getGenusSpecies() + ")," + " a " + growingSpeed.toString().toLowerCase() + "-growing tree.";
    }
}
