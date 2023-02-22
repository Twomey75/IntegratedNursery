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
    public Tree(String genusSpecies, String commonName, String plantGroupChoice, String localDateInput, String growingSpeedChoice)
    {
        // Run constructor of super class plant
        super(genusSpecies, commonName, plantGroupChoice, localDateInput);

        //Case where the user puts in that growing speed is fast
        if(growingSpeedChoice.equalsIgnoreCase("fast")) {
            growingSpeed = GrowingSpeed.FAST;
        }
        //Case where the user puts in that growing speed is slow 
        else if(growingSpeedChoice.equalsIgnoreCase("slow")) {
            growingSpeed = GrowingSpeed.SLOW;
        }
        //Case where no valid speed is put in so it is assumed slow
        else {
            growingSpeed = GrowingSpeed.SLOW;
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
