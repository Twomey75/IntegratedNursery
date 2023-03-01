import java.util.Scanner;

/**
 * This class allows the user to start and use the program
 *
 * @author Sean Twomey
 * @author Mary Lisicki
 * @version 2/20/2023
 */

public class NurseryDriver 
{
    static Scanner scan = new Scanner(System.in);
    private static String zoneNumberInput;
    private static String wayToEvaluate;
    private static String commonNameInput;
    private static String scientificNameInput;
    private static String dateIntroducedInput;


    private static Tree bloodJapanMaple = new Tree("Bloodgood Japanese Maple", "Acer palmatum", "Gymnosperm", "2016-01-02", -10, 20, "fast");
    public static void main(String[] args)  {
        // 5 questions to the user
        System.out.println("What zone are you currently in?");
        zoneNumberInput = scan.nextLine();
        System.out.println("How should we evaluate nursery experience with plant?  [Enter 'least' or 'most']");
        wayToEvaluate = scan.nextLine();
        System.out.println("Enter the common name of the plant");
        commonNameInput = scan.nextLine();
        System.out.println("Enter the scientific name of the plant (make one up!)");
        scientificNameInput = scan.nextLine();
        System.out.println("Enter when the plant was first introduced to the nursery [YYYY-MM-DD]");
        dateIntroducedInput = scan.nextLine().replaceAll("\\s", "");;

        Plant userPlant = new Plant(commonNameInput, scientificNameInput, null, dateIntroducedInput, 0, 0);
        // Printing the results of the user's input
        System.out.println("\n--------------- Results -------------\n");
        printInfoOnPlant(bloodJapanMaple);
        printInfoOnPlant(userPlant);
    }

    private static void printInfoOnPlant(Plant plant)
    {
        System.out.println(plant.toString());
        System.out.println(plant.getClass().getSimpleName());
        System.out.println("Introduced on " + plant.getDateIntroducedAString());
        if(plant instanceof Tree)
        {
            System.out.println("a " + ((Tree)plant).getGrowingSpeedAsString() + " growing tree");
        }
        if(wayToEvaluate.equalsIgnoreCase("least"))
        {
            System.out.println("least experienced: ");
        }
        if(wayToEvaluate.equalsIgnoreCase("most"))
        {
            System.out.println("most experienced: ");
        }
        System.out.println("good for your zone: " + plant.growsInZone(zoneNumberInput) + "\n");
    }
}
