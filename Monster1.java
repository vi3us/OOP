import java.util.*;

public class Monster1 extends Monster
{
    private Monster wildMonster;
    private Boolean escape;
    private Player player1;
    private int fightConstant;
    
    private String tempString = "";
    
    public Monster1(int hp, int maxHp, int speed, int money)
    {
        super(hp, maxHp, speed, money, "Minotaur");
    }
    public String fight(Monster wildMonster, Player player1){
        tempString = "";
        fightConstant = 0;
        this.wildMonster = wildMonster;
        
        int yourMonsterHp = this.getHp();
        int wildMonsterHp = wildMonster.getHp();
        
        int yourMonsterSpeed = this.getSpeed();
        int wildMonsterSpeed = wildMonster.getSpeed();
        try{
            wildMonster.special();
        }catch(Exception e){
            wildMonster.special(player1);
        }
        
        if(wildMonster.getMonsterType().equals("Cerberus")){
            tempString += ("your monster is naturally stronger than Cerberus" + "\n");
            setStrengthConstant(2);
            fightConstant = 3;
            calculateFightOutcome();
        }else if(wildMonster.getMonsterType().equals("Fenix")){
            Monster4 m4 = (Monster4)wildMonster;
            tempString += "your monster is naturally weaker than Fenix\n";
            setStrengthConstant(-2);
            fightConstant = 1;
            tempString += m4.getTempString();
            calculateFightOutcome();
        }else{
            calculateFightOutcome();
        }
        return tempString;
    }
    public String getTempString(){
        return tempString;
    }
    
    ///true = fight, false = escaped
    public void special(){
        if(((int) ((Math.random()) * (10))) > 0){ 
            tempString += "Wild Monster Decided to escape\n";
            escape();
        }else{
            escape = true;
        }
    }
    public void escape(){        
        ///decided to escape
        int i = (int) ((Math.random()) * (10));
        int j = (int) ((Math.random()) * (10));
        if (i >= j){
            ///could not escape
            tempString += "Could not escape\n";
            escape =  true;
        }else{
            ///could escape
            tempString += "Could escape\n";
            escape = false;
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
    
    public Boolean getEscape(){
        return escape;
    }
}