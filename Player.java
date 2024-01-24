import java.util.*;

public class Player extends Character
{
    private int numberOfMonsters;
    private int numberOfItems;
    private int spaceOnBackpack = 9;
    private String name;
    private Boolean gameOver = false;
    
    private ArrayList<Items> backpack = new ArrayList(9);
    private ArrayList<Monster> myMonsters = new ArrayList(2);
    
    ///constructor
    public Player(int hp, int maxHp, int numberOfMonsters, int numberOfItems, int speed, String name, int money)
    {
        super(hp, maxHp, speed, money);
        this.numberOfMonsters = numberOfMonsters;
        this.numberOfItems = numberOfItems;
        this.name = name;
    }
    
    ///capture monster
    public void captureMonster(Monster monster){

        myMonsters.add(monster);
        numberOfMonsters += 1;
    }
    public Boolean tryToCaptureWildMonster(Monster monster){
        double monsterHp = monster.getHp();
        double monsterSpeed = monster.getSpeed();
        double x = Math.random();
        
        if((monsterHp + monsterSpeed)*x < monsterHp*2){
            ///captureMonster(monster);
            return true;
        }else{
            return false;
        }
    }
    ///add items to backpack
    public void collectItems(Items item){
        backpack.add(item);
        spaceOnBackpack -= item.getSpace();
    }
    
    ///remove dead monster
    public void removeDeadMonster(int i){
        myMonsters.remove(i);
    }
    
    ///remove item when used
    public void removeItem(int i){
        spaceOnBackpack += backpack.get(i).getSpace();
        backpack.remove(i);
    }
    
    ///check if game is over
    public Boolean gameOverModifier(){
        if (getHp() == 0 || myMonsters.size() == 0){
            gameOver = true;
        }else{
            gameOver = false;
        }
        return gameOver;
    }
    
    ///setters
    public void setNumberOfMonsters(int numberOfMoster)
    {
        this.numberOfMonsters =  numberOfMoster;   
    }
    public void setNumberOfItems(int numberOfItems)
    {
        this.numberOfItems =  numberOfItems;   
    }
    public void setGameOver(){
        gameOver = true;
    }
    public void setMonsterHp(int i, int hp){
        myMonsters.get(i).setHp(hp);
    }
    
    ///getters
    public int getNumberOfMonsters(){
        return myMonsters.size();
    }
    public int getNumberOfItems(){
        return numberOfItems;
    }
    public String getCharacterDescription(){
        return "Energy:     " + getHp() + "  \n" + 
                "Coins:     " + getMoney() + "\n";
    }
    public int getSpaceOnBackpack(){
        return spaceOnBackpack;
    }
    public Items getItemOfBackpack(int place){
        return (backpack.get(place));
    }
    public int getNumberOfItemsOnbackpack(){
        return backpack.size();
    }
    public ArrayList<Monster> getMonsterArray(){
        return myMonsters;
    }
    public Monster getMonsters(int i){
        return myMonsters.get(i);
    }
    public static int forceIntInput(){
        Scanner userInput = new Scanner(System.in);        
        String i = userInput.nextLine();
        Boolean valid = false;
        while(valid == false){
            if (i.equals("1") || i.equals("2")){
                valid = true;
            }else{
                i = userInput.nextLine();
            }
        }
        return Integer.parseInt(i);
    }
}