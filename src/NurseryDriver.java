import java.util.ArrayList;
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
    private static ArrayList<Plant> plants;

    public static void main(String[] args)  {
        // Initialize plants arraylist
        plants = new ArrayList<Plant>();
        // Add the hard coded plants
        createTree("Bloodgood Japanese Maple", "Acer palmatum", "Gymnosperm", "2008-02-26", -10, 20, "fast");
        createTree("Hemlock Tree", "Tsuga canadensis", "Gymnosperm", "2017-05-14", -40, 10, "slow");
        createFloweringPlant("Orange Jasmine", "Murraya paniculata", "Angiosperm", "2015-01-23", 20, 30, "white", "orange-scented");
        createFloweringPlant("Lily-of-the-Valley", "Convallaria majalis", "Angiosperm", "2014-09-17", -20, 20, "white, pink, or red", "delicate, fragrant");

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
        dateIntroducedInput = scan.nextLine();

        // Create the users plant
        createPlant(commonNameInput, scientificNameInput, null, dateIntroducedInput, 0, 0);
        
        // Printing the results of the user's input
        System.out.println("\n--------------- Results -------------\n");
        for(Plant plant : plants)
        {
            printInfoOnPlant(plant);
        }
    }

    private static void printInfoOnPlant(Plant plant)
    {
        System.out.println(plant.getPlantId());
        System.out.println(plant.toString());
        System.out.println(plant.getClass().getSimpleName());
        System.out.println("Introduced on " + plant.getDateIntroducedAString());
        if(plant instanceof Tree)
        {
            System.out.println("a " + ((Tree)plant).getGrowingSpeedAsString() + " growing tree");
        }
        if(plant instanceof FloweringPlant)
        {
            System.out.println(((FloweringPlant)plant).printDescription());
        }
        if(wayToEvaluate.equalsIgnoreCase("least"))
        {
            System.out.println("least experienced: " + plant.plantTest.get("least_experienced").test(plant));
        }
        if(wayToEvaluate.equalsIgnoreCase("most"))
        {
            System.out.println("most experienced: " + plant.plantTest.get("most_experienced").test(plant));
        }
        System.out.println("good for your zone: " + plant.growsInZone(zoneNumberInput) + "\n");
    }

    private static void createPlant(String commonName, String genusSpecies, String plantGroupChoice, String dateInput, int lowestTemp, int highestTemp)
    {
        plants.add(new Plant(commonName, genusSpecies, plantGroupChoice, dateInput, lowestTemp, highestTemp));
    }
    private static void createTree(String commonName, String genusSpecies, String plantGroupChoice, String dateInput, int lowestTemp, int highestTemp, String growingSpeedChoice)
    {
        plants.add(new Tree(commonName, genusSpecies, plantGroupChoice, dateInput, lowestTemp, highestTemp, growingSpeedChoice));
    }
    private static void createFloweringPlant(String commonName, String genusSpecies, String plantGroupChoice, String dateInput, int lowestTemp, int highestTemp, String flowerColors, String features)
    {
        plants.add(new FloweringPlant(commonName, genusSpecies, plantGroupChoice, dateInput, lowestTemp, highestTemp, flowerColors, features));
    }
}
