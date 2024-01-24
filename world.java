import java.util.*;

public class world
{
    private int numberOfMonstersInWorld;
    private int numberOfCoins;
    private int worldLevel;
    private Boolean canMoveWest;
    private Boolean canMoveEast;
    
    public world(int worldLevel, int numberOfMonstersInWorld, int numberOfCoins, Boolean canMoveWest, Boolean canMoveEast)
    {
        this.worldLevel = worldLevel;
        this.numberOfMonstersInWorld = numberOfMonstersInWorld;
        this.numberOfCoins = numberOfCoins;
        this.canMoveWest = canMoveWest;
        this.canMoveEast = canMoveEast;
    }
    
    ///setters
    public void setNumberOfCoins(int coins){
        numberOfCoins = coins;
    }
    public void setWorldLevel(int level){
        worldLevel = level;
    }
    
    ///getters
    public int getWorldLevel()
    {
        return worldLevel;
    }
    public int getNumberOfMonstersInWorld()
    {
        return numberOfMonstersInWorld;
    }
    public int getNumberOfCoins(){
        return numberOfCoins;
    }
    public String getWorldDescription()
    {
        return ("Number of Monsters: " + getNumberOfMonstersInWorld());
    }
    public Boolean getCanMoveEast(){
        return canMoveEast;
    }
    public Boolean getCanMoveWest(){
        return canMoveWest;
    }
    
    ///create controls
    public String getPossibleMovement()
    {
        String temp = "";
        if(canMoveEast == true){
            temp += "Move East     (e)\n";
        }
        if(canMoveWest == true){
            temp += "Move West     (w)\n";
        }
        return (temp);
    }
    public ArrayList<Controls> getWorldControls(){
        ArrayList<Controls> temp = new  ArrayList<Controls>();
        return temp;
    }
}