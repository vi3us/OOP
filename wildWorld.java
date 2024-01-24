import java.util.*;

public class wildWorld extends world
{
    private ArrayList<Monster> monsterArray = new ArrayList();
    
    public wildWorld (int worldLevel, int numberOfMonstersInWorld, int numberOfCoins, Boolean canMoveWest , Boolean canMoveEast)
    {
        super(worldLevel, numberOfMonstersInWorld, numberOfCoins, canMoveWest , canMoveEast);
        for(int i=0;i<numberOfMonstersInWorld;i++)
        {    
            int x = (int) (Math.random() * 99);
            monsterArray.add(monsterType(x));
        }
    }
    
    ///create Wold controls
    public Controls createWorldControls(String verb, ArrayList<Monster> monsterArray){
        Controls thisControl = new Controls();
        thisControl.verb = (verb);
        for (int i=0;i<monsterArray.size(); i++){
            thisControl.monsterInControls.add(monsterArray.get(i));
        }
        return thisControl;
    } 
    public Controls createWorldControls(String verb){
        Controls thisControl = new Controls();
        thisControl.verb = (verb);
        return thisControl;
    }
    
    
    ///getters
    public ArrayList<Controls> getWorldControls(){
        ArrayList<Controls> temp = new  ArrayList<Controls>();
        if(monsterArray.size() > 0){
            temp.add(createWorldControls("f", monsterArray));
        }
        if(getCanMoveEast().equals(true)){
            temp.add(createWorldControls("e"));
        }
        if(getCanMoveWest().equals(true)){
            temp.add(createWorldControls("w"));
        }
        if (getNumberOfCoins() > 0){
            temp.add(createWorldControls("c"));
        }
        return temp;
    }
    public ArrayList<Monster> getMonsterArray(){
        return monsterArray;
    }    
    public String getWorldDescription(){
        String description="";
        super.getWorldDescription();
        if(monsterArray.size() == 0){
            description = "No monsters here\n";
        }else{
            for(int i=0;i<monsterArray.size();i++)
            {
                description += "(" + (i+1) + ") " + (monsterArray.get(i)).getCharacterDescription() + "\n";
            }
        }
        return description;
    }
    
    ///decide monster type
    public Monster monsterType(int x)
    {
        int type = (int)(Math.random()*3);
        int health = monsterHealth(type);
        
        if (x<= 24)
        {
            Monster monsterCharacter = new Monster1(health,health,monsterSpeed(type),monsterMoney());///int hp, int maxHp, int speed, int money
            return monsterCharacter;        
        }else if (x<= 49)
        {
            Monster monsterCharacter = new Monster2(health,health,monsterSpeed(type),monsterMoney());///int hp, int maxHp, int speed, int money
            return monsterCharacter;
        }else if (x<= 74)
        {
            Monster monsterCharacter = new Monster3(health,health,monsterSpeed(type),monsterMoney());////int hp, int maxHp, int speed, int money
            return monsterCharacter;       
        }else{
            Monster monsterCharacter = new Monster4(health,health,monsterSpeed(type),monsterMoney());///int hp, int maxHp, int speed, int money
            return monsterCharacter;            
        }
    }
    
    ///remove dead monster from world
    public void removeDeadMonster(int i){
        monsterArray.remove(i);
    }
    
    ///randombly regenate monster stats
    public int monsterHealth(int type){
        double i = Math.random();
        if(type == 0){
            return (int)(10*getWorldLevel()*i);
        }else if(type == 1){
            return (int)(8*getWorldLevel()*i);
        }else if(type == 2){
            return (int)(5*getWorldLevel()*i);
        }else{
            return (int)(4*getWorldLevel()*i);
        }
    }
    public int monsterSpeed(int type){
        double i = Math.random();
        if(type == 0){
            return (int)(4*getWorldLevel()*i);
        }else if(type == 1){
            return (int)(5*getWorldLevel()*i);
        }else if(type == 2){
            return (int)(8*getWorldLevel()*i);
        }else{
            return (int)(10*getWorldLevel()*i);
        }
    }
    public int monsterMoney(){
        double i = Math.random();
        double money = 6*i;
        return (int)(money);
    }
}