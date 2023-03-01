/**
 * @version 2/28/2023
 * @author Mary Lisicki
 */

public class FloweringPlant extends Plant 
{
     private String flowerColors;
     private String features;

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

        if (features.isEmpty() || features == null)
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
    public String printDescription()
    {
        return features + " plant with " + flowerColors + " colors";
    }
}
