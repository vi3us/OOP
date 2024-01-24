public class Monster4 extends Monster
{
    private Monster wildMonster;
    private Player player1;
    private int fightConstant;
    
    String tempString = "";
    public Monster4(int hp, int maxHp, int speed, int money)
    {
        super(hp, maxHp, speed, money, "Fenix");
    }
    public String fight(Monster wildMonster, Player player1){
        tempString = "";
        this.player1=player1;
        this.wildMonster = wildMonster;

        int fightConstant = 0;
        
        int yourMonsterHp = this.getHp();
        int wildMonsterHp = wildMonster.getHp();
        
        int yourMonsterSpeed = this.getSpeed();
        int wildMonsterSpeed = wildMonster.getSpeed();
        
        try{
            wildMonster.special();
        }catch(Exception e){
            wildMonster.special(player1);
        }
        
        if(wildMonster.getMonsterType().equals("Minotaur")){
            Monster1 m1 = (Monster1)wildMonster;
            tempString += ("your monster is naturally stronger that Minotaur" + "\n");
            setStrengthConstant(2);
            fightConstant = 3;
            if (m1.getEscape()==false){
            }else{
                calculateFightOutcome();
            }
        }else if(wildMonster.getMonsterType().equals("Ghoul")){
            Monster3 m3 = (Monster3)wildMonster;
            tempString += ("your monster is naturally stronger that Ghoul" + "\n");
            setStrengthConstant(2);
            fightConstant = 3;
            calculateFightOutcome();
            tempString += m3.getTempString();
        }else{
            calculateFightOutcome();
        }
        return tempString;
    }
    public String getTempString(){
        return tempString;
    }
    
    
    public void special(Player player1){
        int i = (int) ((Math.random()) * (10));
        if(i>0){
            tempString += "Monster 4 decided to attack the player";
            attackPlayer();
        }
    }
    public void attackPlayer(){
        int i = (int) ((Math.random()) * (2));
        if(player1.getHp()-i <0){
            player1.setHp(0);
        }else{
            player1.setHp(player1.getHp()-i);
        }
    }
    public void calculateFightOutcome(){
        
        int yourMonsterHp = this.getHp();
        int wildMonsterHp = wildMonster.getHp();
        
        int yourMonsterSpeed = this.getSpeed();
        int wildMonsterSpeed = wildMonster.getSpeed();
    
        int i = (int) ((Math.random()) * (10));
        int j = (int) ((Math.random()) * (10));
        int temp = 0;
        
        if(yourMonsterHp*yourMonsterSpeed*i < wildMonsterHp*wildMonsterSpeed*j){
            i = (int)(wildMonsterSpeed*0.5 - wildMonster.getStrengthConstant());
            if(( i == 0)){
                yourMonsterHp -=1;
                tempString += "your monster lost  Hp: -1\n";
            }else{
                if (i < 0){
                    i = i*i;
                    i = i/2;
                    yourMonsterHp -= i;
                }else{
                    yourMonsterHp -= i; ///if im stronger damage recived is - 2, if im weaker recived given is +2
                    tempString += "your monster lost  Hp: -" + i + "\n";
                }
            }
        }else if(yourMonsterHp*yourMonsterSpeed*i > wildMonsterHp*wildMonsterSpeed*j){
            i = (int)(yourMonsterSpeed*0.5 + this.getStrengthConstant());
            if(( i == 0)){
                wildMonsterHp -=1;
                tempString += "Wild monster lost  Hp: -1\n";
            }else{
                if (i < 0){
                    i = i*i;
                    i = i/2;
                    wildMonsterHp -= i;
                }else{
                    wildMonsterHp -= i; ///if im stronger damage recived is - 2, if im weaker recived given is +2
                    tempString += "wild monster lost  Hp: -" + i + "\n";
                }
            }
        }else{
            tempString += "Draw\n";
        }
        wildMonster.setHp(wildMonsterHp);
        this.setHp(yourMonsterHp);
    }
}