public class HpPotion extends Items
{
    private int hpRegen;
    
    public HpPotion(int price, int space, int hpRegen)
    {
        super(price, space, "Potion");
        this.hpRegen = hpRegen;
    }
    public int getHpRegen(){
        return hpRegen + (int)Math.random();
    }
}