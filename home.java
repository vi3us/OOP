import java.util.*;

public class home extends world
{
    private ArrayList<Items> store = new ArrayList(6);
    
    public home(int worldLevel, int numberOfMonstersInWorld, int numberOfCoins, Boolean canMoveWest , Boolean canMoveEast)
    {
        super(worldLevel, numberOfMonstersInWorld, numberOfCoins, canMoveWest , canMoveEast);
        for(int i=0;i<6;i++)
        {
            addItem();
        }
    }  
    
    ///store interaction
    public void removeItemFromStore(int choiceObject){
        store.remove(choiceObject);
    }
    public Items itemBought(int choiceObject){
        return store.get(choiceObject);
    }
    public void addItem(){
        int x = (int) (Math.random() * 98);
        store.add(foodOrHpPotion(x));
    }
    public Items foodOrHpPotion(int x)
    {
        if (x<=32){
            Items item = new Food(3,1,2);///int price, int space, int playerHpRegen
            return item;
        }else if(x<=65){
            Items item = new  HpPotion(4,2,3);///int price, int space, int playerHpRegen
            return item;
        }else{
            Items item = new  MagicMushrooms(1,1,0);///int price, int space, int playerHpRegen
            return item;
        }
    }
    
    ///creating world controls
    public Controls createWorldControls(String verb){
        Controls thisControl = new Controls();
        thisControl.verb = (verb);
        return thisControl;
    }
    public Controls createWorldControls(String verb,ArrayList<Items> store){
        Controls thisControl = new Controls();
        thisControl.verb = (verb);
        for (int i=0;i<store.size(); i++){
            thisControl.itemsInControls.add(store.get(i));
        }
        return thisControl;
    }
    
    ///getters
    public ArrayList<Controls> getWorldControls(){
        ArrayList<Controls> temp = new  ArrayList<Controls>();
        if(getCanMoveEast().equals(true)){
            temp.add(createWorldControls("e"));
        }
        if(getCanMoveWest().equals(true)){
            temp.add(createWorldControls("w"));
        }
        temp.add(createWorldControls("b", store));
        return temp;
    }
    public ArrayList<Items> getStore(){
        return store;
    }
    public String getWorldDescription()
    {
        String temp = "\nStore:\n";
        
        for(int i=0;i<store.size();i++){
            temp += "(" + (i+1) + ") "  + store.get(i).itemDescription() + "\n";
        }
        return temp;
    }
}