/**
 * This class allows the user to start and use the program
 *
 * @author Sean Twomey
 * @version 2/20/2023
 */

public class PlantDriver {
    private static Plant plant = new Plant();
    private static Plant plant2 = new Plant();
    private static Plant plant3 = new Plant();
    public static void main(String[] args)  {
        System.out.println(plant.getPlantId());
        System.out.println(plant2.getPlantId());
        System.out.println(plant3.getPlantId());
    }
}
