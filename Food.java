public class Food extends Items
{
    private int playerHpRegen; 
    
    public Food(int price, int space, int playerHpRegen)
    {
        super(price, space, "Burger");
        this.playerHpRegen = playerHpRegen;
    }
    public int getHpRegen(){
        return playerHpRegen + (int)(Math.random()*2);
    }
}
