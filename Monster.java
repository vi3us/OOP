public class Monster extends Character
{
    private String monsterType;
    private int strengthConstant = 0;
    
    public Monster(int hp, int maxHp, int speed, int money, String monsterType)
    {
        super(hp, maxHp, speed, money);
        this.monsterType = monsterType;
    }
    ///getters
    public String getMonsterType()
    {
        return monsterType; 
    }
    public String getCharacterDescription(){
        return getMonsterType() + " || HP: " + getHp() + " || Speed: " + getSpeed();
    }
    public String getCharacterDescriptionToHeal(){
        return getMonsterType() + " || HP: " + getHp() + "\\" + getMaxHp() +" || Speed: " + getSpeed();
    }
    public int getStrengthConstant(){
        return strengthConstant;
    }
    
    ///setters
    public void setStrengthConstant(int strengthConstant){
        this.strengthConstant = strengthConstant;
    }
    
    ///fight
    public String fight(Monster wildMonster, Player player1){return null;}
    public void special(){};
    public void special(Player player1){};
    
    
    ///escape
    public Boolean escape(Monster wildMonster){
        int yourMonsterHp = this.getHp();
        int wildMonsterHp = wildMonster.getHp();
        
        int yourMonsterSpeed = this.getSpeed();
        int wildMonsterSpeed = wildMonster.getSpeed(); 
        ///decided to escape
        int i = (int) ((Math.random()) * (10)) * yourMonsterSpeed;
        int j = (int) ((Math.random()) * (10)) * wildMonsterSpeed;
        if (i >= j){
            ///could not escape
            return false;
        }else{
            ///could escape
            return true;
        }
    }
    
    public String yourMonsterEscape(Monster wildMonster){
        String tempString = "";
        
        Boolean escapeBoolean =  escape(wildMonster);
        if(escapeBoolean == true){
            tempString += "You escaped successfully\n";
        }else{
            tempString += "Not successfull\n";
            
            int yourMonsterSpeed = this.getSpeed();
            int wildMonsterSpeed = wildMonster.getSpeed(); 
            
            int yourMonsterHp = this.getHp();
            int wildMonsterHp = wildMonster.getHp();

            int i = (int)(wildMonsterSpeed*0.5 + this.getStrengthConstant());
            if(( i == 0)){
                yourMonsterHp -=1;
                tempString += "Your monster lost  Hp: -1\n";
                this.setHp(yourMonsterHp);
            }else{
                if (i < 0){
                    i = i*i;
                    i = i/2;
                    tempString += "Your monster lost  Hp: -" + i;
                    yourMonsterHp -=i;
                    this.setHp(yourMonsterHp);
                }else{
                    yourMonsterHp -= i; ///if im stronger damage recived is - 2, if im weaker recived given is +2
                    tempString += "Your monster lost  Hp: -" + i + "\n";
                    this.setHp(yourMonsterHp);
                }
            }
            if(this.getHp() <= 0){
                this.setHp(0);
                tempString += "Your monster died";
            } 
        }
        return tempString;
    }
}