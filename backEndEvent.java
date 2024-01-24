import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class backEndEvent{
    private int playerInWorld;
    private ArrayList<Controls> controls;
    private ArrayList<world> wholeWorld = new ArrayList();
    
    private world currentWorld;
    private Player player1;
    
    public backEndEvent(){
        playerInWorld = 0;
        controls = new ArrayList<>();
        player1 = new Player(12, 10, 0, 0, 5, "p1",8);
    }
    public String start(){
        createWorld();
        return wholeWorld.get(playerInWorld).getWorldDescription();
    }
    public void createWorld(){
        
        wholeWorld.add(createHome(0, 0, 0, false, true)); ///int numberOfMonstersInWorld, int numberOfCoins, Boolean canMoveWest , Boolean canMoveEast


        for(int i=0;i<3;i++){
            if (i != 2){
                ///int numberOfMonstersInWorld, int numberOfCoins, Boolean canMoveWest , Boolean canMoveEast
                wholeWorld.add(createWildWorld(1, randomNumberMonsters(), randomNumberCoins(), true, true));
            }else{
                wholeWorld.add(createWildWorld(1, randomNumberMonsters(), randomNumberCoins(), true, false));
            }
        }
    }
    
    ///getters
    public String getCoins(){
        player1.setMoney(currentWorld.getNumberOfCoins());
        currentWorld.setNumberOfCoins(0);
        return currentWorld.getWorldDescription();
    }
    public Monster getWildMonster(int i){
        wildWorld WW = (wildWorld) currentWorld;
        return WW.getMonsterArray().get(i);
    }
    public String itemsOnBackPack(){
        String temp = "";
        temp += "Space: " + player1.getSpaceOnBackpack() + "\n" + "\n";
        for (int i=0;i<player1.getNumberOfItemsOnbackpack();i++){
            temp += player1.getItemOfBackpack(i).getTypeOfItem() + "\n";
        }
        return temp;
    }
    public String getPlayerMonsters(){
        String temp = "";
        ArrayList<Monster> monsters = player1.getMonsterArray();
        for(int i=0;i<monsters.size();i++){
            temp += monsters.get(i).getCharacterDescription() + "\n";
        }
        return temp;
    }
    public world getCurrentWorld(){
        return currentWorld;
    }
    public ArrayList<Monster> firstMonsterArray(){
        ArrayList<Monster> tempMonsterStore = new ArrayList<Monster>(4);
        Monster monster1 = new Monster1(10,10,4,0); tempMonsterStore.add(monster1);///int hp, int maxHp, int speed, int money
        Monster monster2 = new Monster2(8,8,5,0); tempMonsterStore.add(monster2);
        Monster monster3 = new Monster3(5,8,8,0); tempMonsterStore.add(monster3);
        Monster monster4 = new Monster4(4,4,10,0); tempMonsterStore.add(monster4);
        
        return tempMonsterStore;
    }
    public int getPlayerInWorld(){
        return playerInWorld;
    }
    public Player getPlayer(){
        return player1;
    }
    
    ///action
    public String goWest(){
        playerInWorld -= 1;
        currentWorld = wholeWorld.get(playerInWorld);
        controls = getMovementAndInfo(currentWorld);
        
        ///if current world is empty then when player leaves generate new one
        if(fillEmptyWorld(controls) == true){
            if (playerInWorld < 3){
                wholeWorld.set(playerInWorld, createWildWorld((currentWorld.getWorldLevel()+1), randomNumberMonsters(), randomNumberCoins(), true, true));
            }else{
                wholeWorld.set(playerInWorld, createWildWorld((currentWorld.getWorldLevel()+1), randomNumberMonsters(), randomNumberCoins(), true, false));
            }
        }

        
        player1.setHp(player1.getHp()-1);
        if (currentWorld.getNumberOfCoins()==0){
            return currentWorld.getWorldDescription();
        }else{
            return currentWorld.getWorldDescription() + "\nCoins: " + currentWorld.getNumberOfCoins() + "\n";
        }
        
    }
    public String goEast(){
        playerInWorld += 1;
        currentWorld = wholeWorld.get(playerInWorld);
        controls = getMovementAndInfo(currentWorld);
        
        ///if current world is empty then when player leaves generate new one
        if(fillEmptyWorld(controls) == true){
            if (playerInWorld < 3){
                wholeWorld.set(playerInWorld, createWildWorld((currentWorld.getWorldLevel()+1), randomNumberMonsters(), randomNumberCoins(), true, true));
            }else{
                wholeWorld.set(playerInWorld, createWildWorld((currentWorld.getWorldLevel()+1), randomNumberMonsters(), randomNumberCoins(), true, false));
            }
        }

        
        player1.setHp(player1.getHp()-1);
        if (currentWorld.getNumberOfCoins()==0){
            return currentWorld.getWorldDescription();
        }else{
            return currentWorld.getWorldDescription() + "\nCoins: " + currentWorld.getNumberOfCoins() + "\n";
        }
    }
    public ArrayList<String> fight(Monster myMonster, Monster wildMonster, int myMonsterNumber, int wildMonsterNumber){
        wildWorld WW = (wildWorld) currentWorld;
        ArrayList<String> tempArraylistString = new ArrayList<>();
        String monsterDescription ="";
        String deadMonster = "";
                
        monsterDescription = myMonster.fight(wildMonster, player1);

        ///if hp reaches 0 remove monster from player or from world
        if (myMonster.getHp() <= 0){
            player1.removeDeadMonster(myMonsterNumber);
            deadMonster = "myMonster";
        }else if(wildMonster.getHp() <= 0){
            WW.removeDeadMonster(wildMonsterNumber);
            deadMonster = "wildMonster";
        }
        tempArraylistString.add(deadMonster);
        tempArraylistString.add(monsterDescription);
        
        return tempArraylistString;
    }
    public String escape(Monster myMonster, Monster wildMonster, int myMonsterNumber){
        String temp = myMonster.yourMonsterEscape(wildMonster);
        if (myMonster.getHp() <= 0){
            player1.removeDeadMonster(myMonsterNumber);
        }
        return temp;
    }
    public String catchMonster(int wildMonsterNumber, Monster wildMonster){
        wildWorld WW = (wildWorld) currentWorld;
        Boolean playerHasMagicMushrooms = false;
        Boolean endFight = false;
        String tempString = "";
        
        int placeInBag = 0;
        for(int i=0;i<player1.getNumberOfItemsOnbackpack();i++){
            if(player1.getItemOfBackpack(i).getTypeOfItem().equals("Magic Mushroom")){
                playerHasMagicMushrooms = true;
                placeInBag = i;
                break;
            }
        }
        if(playerHasMagicMushrooms == true){
            tempString += "Trying to catch monster\n";
            endFight = player1.tryToCaptureWildMonster(wildMonster);
            player1.removeItem(placeInBag);
            if(endFight == true){
                tempString += "You catched the monster";
                WW.removeDeadMonster(wildMonsterNumber);
            }else{
                tempString += "Could not catch\n";
            }
        }else{
            tempString += "You dont have item to catch monster";
        }
        
        return tempString;
    }
    
    public String buy(int i){     
        String temp = "";
        home h = (home) currentWorld;

        if (player1.getMoney() < h.getStore().get(i).getPrice()){
            temp += "You dont have enough";
            ///check if backpack is full
        }else if (player1.getSpaceOnBackpack() == 0){
            temp += "Backpack full";
            ///else item can be purchased
        }else{
            int spend;
            ///save selected item
            Items boughtItem = h.itemBought(i);
            ///check if there is enough space on backpack
            if (player1.getSpaceOnBackpack() < boughtItem.getSpace()) {
                temp += "Space on backpack for that item is insufficient";
                ///add item to backpack
            }else{
                temp += "Item purched: " + boughtItem.getTypeOfItem();
                h.removeItemFromStore((int) i);
                player1.setMoneyPurchase(boughtItem.getPrice());
                h.addItem();
                player1.collectItems(boughtItem);
            }
        }
        return temp;
    }
    public String useMagicMushrooms(){
        String tempString = "";
        return tempString += "You cant use that right now";
    }
    public String useBurger(int choiceObject){
        String tempString = "";
        tempString += "Eating Burger\n";
        int playerHp = player1.getHp();
        int playerMaxHp = player1.getMaxHp();
        
        if (playerHp >= playerMaxHp){
            tempString += "player Hp was max\n";
            player1.setHp(playerMaxHp);
        }else if((playerHp+2) > playerMaxHp){
            player1.setHp(playerMaxHp);
            tempString += "Player Hp: " + player1.getHp();
        }else{
            playerHp += (player1.getItemOfBackpack(choiceObject)).getHpRegen();
            player1.setHp(playerHp);
            tempString += "Player Hp:  " + player1.getHp();
        }
        player1.removeItem(choiceObject);
        
        return tempString;
    }
    public String usePotion(int choiceObject){
        String tempString = "";        
        
        if(player1.getMonsters(choiceObject).getHp() ==  player1.getMonsters(choiceObject).getMaxHp()){
            tempString += "Monster at max Hp potion used\n";
            tempString += (player1.getMonsters(choiceObject).getMonsterType() + "  HP: " + 
                                player1.getMonsters(choiceObject).getHp() + "\\" +  player1.getMonsters(choiceObject).getMaxHp());
        }else if ((player1.getMonsters(choiceObject).getHp() + (player1.getItemOfBackpack(choiceObject)).getHpRegen()) > player1.getMonsters(choiceObject).getMaxHp()){
            player1.getMonsters(choiceObject).setHp(player1.getMonsters(choiceObject).getMaxHp());
            tempString += (player1.getMonsters(choiceObject).getMonsterType() + "  HP: " + 
                                player1.getMonsters(choiceObject).getHp() + "\\" +  player1.getMonsters(choiceObject).getMaxHp());
        }else{
            player1.getMonsters(choiceObject).setHp(player1.getMonsters(choiceObject).getHp() + (player1.getItemOfBackpack(choiceObject)).getHpRegen());
            tempString += (player1.getMonsters(choiceObject).getMonsterType() + "  HP: " + 
                                player1.getMonsters(choiceObject).getHp() + "\\" +  player1.getMonsters(choiceObject).getMaxHp());
        }
        player1.removeItem(choiceObject);
        
        return tempString;
    }
    
    ///methods to create worlds and player
    public  world createWildWorld(int worldLevel, int numberOfMonstersInWorld, int numberOfCoins, Boolean canMoveWest , Boolean canMoveEast)
    {
        wildWorld wildWorldInstance = new wildWorld(worldLevel, numberOfMonstersInWorld, numberOfCoins, canMoveWest, canMoveEast);
        return wildWorldInstance;
    }
    public  world createHome(int worldLevel, int numberOfMonstersInWorld, int numberOfCoins, Boolean canMoveWest , Boolean canMoveEast)
    {
        return new home(worldLevel, numberOfMonstersInWorld, numberOfCoins, canMoveWest, canMoveEast);
    }
    public  int randomNumberMonsters(){
        int x = (int) (Math.random() * (5));
        return x;
    }
    public  int randomNumberCoins(){
        int x = (int) (Math.random() * (5));
        if(x == 1 || x == 0){
            return 1;
        }else if (x == 2){
            return 2;
        }else{
            return 0;
        }
    }
    public  Monster getFirstMonster(int choiceObject, Boolean validObject){
        Scanner input = new Scanner(System.in);      
        
        ArrayList<Monster> tempMonsterStore = new ArrayList<Monster>(4);
        Monster monster1 = new Monster1(10,10,4,0); tempMonsterStore.add(monster1);///int hp, int speed, int money
        Monster monster2 = new Monster2(8,8,5,0); tempMonsterStore.add(monster2);
        Monster monster3 = new Monster3(5,8,8,0); tempMonsterStore.add(monster3);
        Monster monster4 = new Monster4(4,4,10,0); tempMonsterStore.add(monster4);

        return tempMonsterStore.get(choiceObject);
    }
    public Boolean fillEmptyWorld(ArrayList<Controls> controls){
        Boolean temp = true;
        for(int i=0;i<controls.size(); i++){
            if (controls.get(i).verb.equals("f") || controls.get(i).verb.equals("c") || controls.get(i).verb.equals("b")){
                temp = false;
                break;
            }
        }
        return temp;
    }
    
    ///methods to get data from world
    public ArrayList<Controls> getMovementAndInfo(world currentWorld){
        ArrayList<Controls> controls = currentWorld.getWorldControls();
        return controls;
    }
    
    //validating user input
    public  int choiceValidation(String choice, ArrayList<Controls> controls){
        int valid = -1;
        for (int i=0;i<controls.size();i++){
            if (controls.get(i).verb.equals(choice)){
                return valid = i;
            }
        }
        if (choice.equals("exit")){
            return valid = 1;
        }
        if (choice.equals("bk")){
            return valid = 1;
        }if (choice.equals("i")){
            return valid = 1;
        }if (choice.equals("use")){
            return valid = 1;
        }
        
        return valid;
    }
    public  Boolean inputObjectMonsterCheck(int input, ArrayList<Monster> monsterArray){
        if(input> monsterArray.size()){
            return false;
        }else{
            return true;
        }
    }
}