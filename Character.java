public class Character
{
    private int hp;
    private int maxHp;
    private int speed;
    private int money;
    public Character(int hp, int maxHp,int speed,int money)
    {
        this.hp=hp;
        this.speed = speed;
        this.money = money;
        this.maxHp = maxHp;
    }
    
    ///setters
    public void setHp(int hp)
    {
        this.hp = hp;    
    }
    public void setMoneyPurchase(int spend)
    {
        money -= spend;    
    }
    public void setSpeed(int speed)
    {
        this.speed =  speed;   
    }
    public void setMoney(int money){
        this.money += money;
    }
    
    ///getters
    public int getHp(){
        return hp;
    }
    public int getSpeed(){
        return speed;
    }
    public int getMoney(){
        return money;
    }
    public String getCharacterDescription(){
        return "";
    }
    public int getMaxHp(){
        return maxHp;
    }
}