public class Monster3 extends Monster
{
    private Monster wildMonster;
    private Player player1;
    private int fightConstant;
    
    String tempString = "";    
    public Monster3(int hp, int maxHp, int speed, int money)
    {
        super(hp, maxHp, speed, money, "Ghoul");
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
        
        if(wildMonster.getMonsterType().equals("Fenix")){
            Monster4 m4 = (Monster4)wildMonster;
            tempString += ("your monster is naturally stronger that Fenix" + "\n");
            setStrengthConstant(2);
            fightConstant = 3;
            tempString += m4.getTempString();
        }else if(wildMonster.getMonsterType().equals("Cerberus")){
            tempString += "your monster is naturally weaker that Cerberus\n";
            setStrengthConstant(-2);
            fightConstant = 1;
            calculateFightOutcome();
        }else{
            calculateFightOutcome();
        }
        return tempString;
    }
    public String getTempString(){
        return tempString;
    }
    
    
    public void special(){
        tempString = "";
        int i = (int) ((Math.random()) * (10));

        if(i > 3){
            regenHp();
            tempString += "Wild monster used special ability: +"+i +" Hp";
        }
    }
    public void regenHp(){
        int i = (int) ((Math.random()) * (10));
        
        if(this.getHp()+i > this.getMaxHp()){
            this.setHp(this.getMaxHp());
        }else{
            this.setHp(this.getHp()+i);
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