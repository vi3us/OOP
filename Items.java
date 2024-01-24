public class Items
{
    private int price;
    private int space;
    private String typeOfItem;
    
    public Items(int price, int space, String typeOfItem)
    {
        this.price = price;
        this.space = space;
        this.typeOfItem = typeOfItem;
    }
    public int getPrice(){
        return price;
    }
    public int getSpace(){
        return space;
    }
    public String getTypeOfItem(){
        return typeOfItem;
    }
    public String itemDescription()
    {
        if(getTypeOfItem().equals("Burger")){
            return (getTypeOfItem() + "                     ||  " + "Price: " + getPrice() + "  ||  " + "Space on bag: " + getSpace()); 
        }else if(getTypeOfItem().equals("Potion")){
            return (getTypeOfItem() + "                      ||  " + "Price: " + getPrice() + "  ||  " + "Space on bag: " + getSpace()); 
        }else{
            return (getTypeOfItem() + "  ||  " + "Price: " + getPrice() + "  ||  " + "Space on bag: " + getSpace());    
        }
    }
    public int getHpRegen(){
        return 0;
    }
}