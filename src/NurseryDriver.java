/**
 * This class allows the user to start and use the program
 *
 * @author Sean Twomey
 * @version 2/20/2023
 */

public class NurseryDriver 
{
    private static Plant plant = new Plant("The one from Wall-E", "A leaf idk", "Gymnosperm", "1984-01-20");
    private static Tree tree = new Tree("aaaa", "aa", "Bryophytes", "2003-10-03", "sLoW");
    public static void main(String[] args)  {
        System.out.println(plant.getPlantId());
        System.out.println(tree.getPlantId());
        System.out.println(tree.getGrowingSpeed());
        System.out.println(tree.getDateIntroduced());
        System.out.println(plant.getDateIntroduced());
        System.out.println(tree.toString());
    }
}
