/**
 * This class allows the user to start and use the program
 *
 * @author Sean Twomey
 * @author Mary Lisicki
 * @version 2/20/2023
 */

public class NurseryDriver 
{
    private static Plant plant = new Plant("plant", "A leaf idk", "Gymnosperm", "1984-01-20", -10, 20);
    private static Tree tree = new Tree("aaaa", "aa", "2003-10-03", -100, 100, "sLoW");
    public static void main(String[] args)  {
        System.out.println(plant.getPlantId());
        System.out.println(tree.getPlantId());
        System.out.println(tree.getGrowingSpeed());
        System.out.println(tree.getDateIntroduced());
        System.out.println(plant.getDateIntroduced());
        System.out.println(tree.toString());
        System.out.println(tree.growsInZone("6"));
        System.out.println(plant.growsInZone("5"));
    }
}
