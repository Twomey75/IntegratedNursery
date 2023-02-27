/**
 * This class allows the user to start and use the program
 *
 * @author Sean Twomey
 * @author Mary Lisicki
 * @version 2/20/2023
 */

public class NurseryDriver 
{
    private static Plant plant = new Plant("helloMaya", "se", "Gymnosperms", null, 0, 0);
    private static Tree tree = new Tree("helloMayo", "bruh", null, 0, 0, null);
    public static void main(String[] args)  {
        System.out.println(plant.getPlantId());
        System.out.println(tree.getPlantId());
        System.out.println(tree.getGrowingSpeedAsString());
        System.out.println(tree.getDateIntroduced());
        System.out.println(plant.getDateIntroduced());
        System.out.println(tree.toString());
        System.out.println(tree.growsInZone("6"));
        System.out.println(plant.growsInZone("5"));
        System.out.println(plant.getPlantGroupAsString());
        System.out.println(tree.getPlantGroupAsString());;
        System.out.println(plant.getGenusSpecies());
        System.out.println(plant.getCommonName());
        System.out.println(tree.getCommonName());
        System.out.println(tree.getGenusSpecies());
    }
}
