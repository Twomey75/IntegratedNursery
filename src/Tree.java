/**
 * 
 * This class is supposed to represent all types of trees
 * 
 * @version 2/20/2023
 * @author Sean Twomey
 */

public class Tree extends Plant {
    
    public Tree()
    {
        if(latestId != 0) {
            latestId = latestId + 1;
            id = latestId;
        }
        else {
            latestId = 4902;
            id = latestId;
        }
    }
}
