/**
 * This class allows the user to start and use the program
 *
 * @author Sean Twomey
 * @author Mary Lisicki
 * @version 2/20/2023
 */

public class NurseryDriver 
{
    private static Tree bloodJapanMaple = new Tree("Bloodgood Japanese Maple", "Acer palmatum", "Gymnosperm", "2016-01-02", -10, 20, "fast");
    public static void main(String[] args)  {
        System.out.println(bloodJapanMaple.getZones());
    }
}
