/**
 * @version 2/28/2023
 * @author Mary Lisicki
 */

public class FloweringPlant extends Plant 
{
     private String flowerColors;
     private String features;

     /**
     * Constructor for FloweringPlant
     * @param genusSpecies the genus species of the plant
     * @param commonName the commonName of the plant
     * @param plantGroupChoice the plant group chosen for the plant being added to the nursery
     * @param localDateInput the date of entry chosen for the plant being added to the nursery
     * @param lowestZoneTemp the lowest temperature the plant can survive in
     * @param highestZoneTemp the highest temperature the plant can survive in
     * @param flowerColors the colors the plant can be
     * @param features the features of the plant
     */
    public FloweringPlant(String genusSpecies, String commonName, String plantGroupChoice, String localDateInput, int lowestZoneTemp, int highestZoneTemp, String flowerColors, String features)
    {
        super(genusSpecies, commonName, plantGroupChoice, localDateInput, lowestZoneTemp, highestZoneTemp);
        if (flowerColors == null || flowerColors.isEmpty())
        {
            flowerColors = getDefaultName();
        }
        else
        {
            this.flowerColors = flowerColors;
        }

        if (features == null || features.isEmpty())
        {
            features = getDefaultName();
        }
        else{
            this.features = features; 
        }
    }

    /**
     * @return the flower colors
     */
    public String getFlowerColors()
    {
        return flowerColors;
    }

    /**
     * @return the flower features
     */
    public String getFeatures()
    {
        return features;
    }
    
    /**
     * @return description of the plant
     */
    public String getDescription()
    {
        return features + " plant with " + flowerColors + " colors";
    }
}
