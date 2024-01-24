import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class guiGameRun {
    public static void main(String args[]) {   
        Color mainBgColor = new Color(2 ,46,81);
        
        GUI guiDemo = new GUI("GAME");
        
        
        guiDemo.setLayout(new FlowLayout());
        guiDemo.setVisible(true);
        guiDemo.setBackground(mainBgColor);
        guiDemo.setSize(800,550);
        guiDemo.setLocation(100,2);
        ///guiDemo.setResizable(false);

    }
}
class GUI extends Frame implements ActionListener{
    
    private ArrayList<Monster> tempArray;
    private ArrayList<Button> choiceButtons = new ArrayList<>();
    private ArrayList<Button> itemButtons = new ArrayList<>();
    private int myMonsterNumber, wildMonsterNumber;
    private Monster fightingMonster, wildMonster;
    
    private JFrame tempWindow;
    private JLabel worldLevelWindow, userInfoWindow;
    private JPanel northPanel, southPanel, actionPanel, movePanel ,choicePanel, infoPanel, userInfoPanel, fightPanel, tempPanel;
    private Button bUse,bEast,bWest,bCoins,bFight,bEscape,bCatch,
            mCure1, mCure2,
            mSetFree1, mSetFree2,
            b1,b2,b3,b4,b5,b6,
            bItem1, bItem2, bItem3, bItem4, bItem5, bItem6, bItem7, bItem8, bItem9, 
            m1,m2,m3,m4,
            monster1, monster2;
    private TextArea dialogWindow, bagInfoWindow, monterInfoWindow;
    
    private backEndEvent game = new backEndEvent();

    
    public GUI(String title){ 
        super(title);
        
        Color  BGColor = new Color(2 ,46,81);
        Color  panelColor = new Color(23,140,164);
        
        bUse = new Button("Use");
        bEast = new Button("East");
        bWest = new Button("West");
        bCoins = new Button("Coins");
        bFight = new Button("Fight");
        bEscape  = new Button("Run Away");
        bCatch = new Button("Catch");
        
        b1 = new Button("1"); b2 = new Button("2"); b3 = new Button("3");
        b4 = new Button("4"); b5 = new Button("5"); b6 = new Button("6");
        
        bItem1 = new Button(""); bItem2 = new Button(""); bItem3 = new Button("");
        bItem4 = new Button(""); bItem5 = new Button(""); bItem6 = new Button("");
        bItem7 = new Button(""); bItem8 = new Button(""); bItem9 = new Button("");
        
        choiceButtons.add(b1); choiceButtons.add(b2); choiceButtons.add(b3);
        choiceButtons.add(b4); choiceButtons.add(b5); choiceButtons.add(b6);

        for(int i=0; i<choiceButtons.size();i++){
            choiceButtons.get(i).setForeground(Color.white);
        }

        
        itemButtons.add(bItem1); itemButtons.add(bItem2); itemButtons.add(bItem3);
        itemButtons.add(bItem4); itemButtons.add(bItem5); itemButtons.add(bItem6);
        itemButtons.add(bItem7); itemButtons.add(bItem8); itemButtons.add(bItem9);

        
        bUse.setVisible(true);
        bEast.setVisible(true);
        bWest.setVisible(false);
        bCoins.setVisible(false);
        
        b1.setVisible(true); b2.setVisible(true); b3.setVisible(true);
        b4.setVisible(true); b5.setVisible(true); b6.setVisible(true);        
        
        dialogWindow = new TextArea();
        dialogWindow.setPreferredSize(new Dimension(435, 370));
        dialogWindow.setEditable(false);
        
        userInfoWindow = new JLabel();
        userInfoWindow.setForeground(Color.white);
        userInfoWindow.setPreferredSize(new Dimension(245, 55));
        
        worldLevelWindow = new JLabel("Home");
        worldLevelWindow.setForeground(Color.white);
        worldLevelWindow.setPreferredSize(new Dimension(435, 50));
        
        bagInfoWindow = new TextArea();
        bagInfoWindow.setPreferredSize(new Dimension(245, 200));
        bagInfoWindow.setEditable(false);
        
        monterInfoWindow = new TextArea();
        monterInfoWindow.setPreferredSize(new Dimension(245, 70));
        monterInfoWindow.setEditable(false);
        
        choicePanel = new JPanel(new GridLayout(1,6));
        choicePanel.setBackground(BGColor);
        choicePanel.setPreferredSize(new Dimension(775, 85));
        choicePanel.add(b1); choicePanel.add(b2); choicePanel.add(b3);
        choicePanel.add(b4); choicePanel.add(b5); choicePanel.add(b6);
        
        
        fightPanel = new JPanel(new GridLayout(1,3));
        fightPanel.setBackground(panelColor);
        fightPanel.setPreferredSize(new Dimension(775, 85));
        fightPanel.add(bFight);
        fightPanel.add(bEscape);
        fightPanel.add(bCatch);
        
        movePanel = new JPanel(new GridLayout(1,2));
        movePanel.setBackground(panelColor);
        movePanel.add(bWest);
        movePanel.add(bEast);
        
        actionPanel = new JPanel(new GridLayout(3,0));
        actionPanel.setPreferredSize(new Dimension(70, 400));
        actionPanel.setBackground(panelColor);
        actionPanel.add(movePanel);
        actionPanel.add(bCoins);
        actionPanel.add(bUse);

        
        infoPanel = new JPanel(new FlowLayout());
        infoPanel.setPreferredSize(new Dimension(440, 400));
        infoPanel.setBackground(panelColor);
        infoPanel.add(worldLevelWindow);
        infoPanel.add(dialogWindow);
        
        userInfoPanel = new JPanel();
        userInfoPanel.setPreferredSize(new Dimension(250, 400));
        userInfoPanel.setBackground(panelColor);
        userInfoPanel.add(userInfoWindow);
        userInfoPanel.add(bagInfoWindow);
        userInfoPanel.add(monterInfoWindow);

        northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.setPreferredSize(new Dimension(800, 400));
        northPanel.setBackground(BGColor);
        northPanel.add(actionPanel);
        northPanel.add(infoPanel);
        northPanel.add(userInfoPanel);

 
        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(800, 100));
        southPanel.setBackground(BGColor);
        southPanel.add(choicePanel);
        
        ///this.add(northPanel);
        ///this.add(southPanel);
        
        bWest.addActionListener(this);
        bEast.addActionListener(this);
        bCoins.addActionListener(this);
        bFight.addActionListener(this);
        bEscape.addActionListener(this);
        bCatch.addActionListener(this);
        bUse.addActionListener(this);
        b1.addActionListener(this); b2.addActionListener(this); b3.addActionListener(this);
        b4.addActionListener(this); b5.addActionListener(this); b6.addActionListener(this);
        
        bItem1.addActionListener(this); bItem2.addActionListener(this); bItem3.addActionListener(this);
        bItem4.addActionListener(this); bItem5.addActionListener(this); bItem6.addActionListener(this);
        bItem7.addActionListener(this); bItem8.addActionListener(this); bItem9.addActionListener(this);
        
        logInScreen();
        ///firstMonster();
        
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        }); 
    }
    public void setMonsterFreeWindow(){
        displayInf("You already have 2 monsters, set one free");
        southPanel.remove(choicePanel);
        southPanel.add(fightPanel);
        actionPanel.setVisible(false);
        fightPanel.setVisible(false);
        bCoins.setVisible(false);
        
        tempWindow = new JFrame();
        tempPanel = new JPanel();
        tempPanel.setLayout(new GridLayout(2,1));
        tempWindow.setSize(100,70);
        
        if(game.getPlayer().getNumberOfMonsters() == 1){
            mSetFree1 = new Button(game.getPlayer().getMonsterArray().get(0).getCharacterDescription());
            mSetFree1.addActionListener(this);
            tempPanel.add(mSetFree1);
        }else{
            mSetFree1 = new Button(game.getPlayer().getMonsterArray().get(0).getCharacterDescription());
            mSetFree2 = new Button(game.getPlayer().getMonsterArray().get(1).getCharacterDescription());
            mSetFree1.addActionListener(this);
            mSetFree2.addActionListener(this);
            tempPanel.add(mSetFree1);
            tempPanel.add(mSetFree2);
        }
        
        tempWindow.add(tempPanel);
        tempWindow.pack();
        tempWindow.setVisible(true);
        tempWindow.setLocation(170,370);
    }
    public void monsterWindow(){
        southPanel.remove(choicePanel);
        southPanel.add(fightPanel);
        actionPanel.setVisible(false);
        fightPanel.setVisible(false);
        bCoins.setVisible(false);
        
        tempWindow = new JFrame();
        tempPanel = new JPanel();
        tempPanel.setLayout(new GridLayout(2,1));
        tempWindow.setSize(170,370);
        
        if(game.getPlayer().getNumberOfMonsters() == 1){
            monster1 = new Button(game.getPlayer().getMonsterArray().get(0).getCharacterDescription());
            monster1.addActionListener(this);
            tempPanel.add(monster1);
        }else{
            monster1 = new Button(game.getPlayer().getMonsterArray().get(0).getCharacterDescription());
            monster2 = new Button(game.getPlayer().getMonsterArray().get(1).getCharacterDescription());
            monster1.addActionListener(this);
            monster2.addActionListener(this);
            tempPanel.add(monster1);
            tempPanel.add(monster2);
        }
        
        tempWindow.add(tempPanel);
        tempWindow.pack();
        tempWindow.setVisible(true);
        tempWindow.setLocation(170,370);
    }
    public void monsterToCureWindow(){
        actionPanel.setVisible(false);
        choicePanel.setVisible(false);
        bCoins.setVisible(false);
        
        tempWindow = new JFrame();
        tempPanel = new JPanel();
        tempPanel.setLayout(new GridLayout(2,1));
        tempWindow.setSize(170,370);
        
        if(game.getPlayer().getNumberOfMonsters() == 1){
            mCure1 = new Button(game.getPlayer().getMonsterArray().get(0).getCharacterDescriptionToHeal());
            mCure1.addActionListener(this);
            tempPanel.add(mCure1);
        }else{
            mCure1 = new Button(game.getPlayer().getMonsterArray().get(0).getCharacterDescriptionToHeal());
            mCure2 = new Button(game.getPlayer().getMonsterArray().get(1).getCharacterDescriptionToHeal());
            mCure1.addActionListener(this);
            mCure2.addActionListener(this);
            tempPanel.add(mCure1);
            tempPanel.add(mCure2);
        }
        
        tempWindow.add(tempPanel);
        tempWindow.pack();
        tempWindow.setVisible(true);
        tempWindow.setLocation(170,370);
    }
    public void actionPerformed(ActionEvent ae){
        ///action
        if (ae.getSource() == bWest){
            displayInf(game.goWest());
            displayUserInfo();
            setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
        }
        if (ae.getSource() == bEast){
            displayInf(game.goEast());
            displayUserInfo();
            setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
        }
        if (ae.getSource() == bCoins){
            displayInf(game.getCoins());
            displayUserInfo();
            setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
        }
        if(ae.getSource() == bFight){
            ArrayList<String> fightOutput = game.fight(fightingMonster, wildMonster, myMonsterNumber, wildMonsterNumber);
            String temp = "";
            if (fightOutput.get(0).equals("myMonster") || fightOutput.get(0).equals("wildMonster")){
                if (fightOutput.get(0).equals("myMonster")){
                    temp += "Your monster died\n";
                    displayUserInfo();
                    displayInf(temp);
                    sleep(2);
                    displayInf(game.getCurrentWorld().getWorldDescription());
                    setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
                    actionPanel.setVisible(true);
                    southPanel.remove(fightPanel);
                    southPanel.add(choicePanel);
                    this.validate();
                }else{
                    temp += "Wild Monster died\n";
                    displayUserInfo();
                    displayInf(temp);
                    sleep(2);
                    displayInf(game.getCurrentWorld().getWorldDescription());
                    
                    actionPanel.setVisible(true);
                    southPanel.remove(fightPanel);
                    southPanel.add(choicePanel);
                    setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
                    this.validate();
                }
            }else{
                temp += fightOutput.get(1);
                int intIndex = temp.indexOf("Could escape");
                if(intIndex==-1){
                    displayUserInfo();
                    displayInf(temp);
                    sleep(2);
                    displayInf(fightingMonster.getCharacterDescription() + "\n" + wildMonster.getCharacterDescription());
                }else{
                    displayInf("Monster decided to escape \nescape succesfully");
                    sleep(2);
                    displayInf(game.getCurrentWorld().getWorldDescription());
                    actionPanel.setVisible(true);
                    southPanel.remove(fightPanel);
                    southPanel.add(choicePanel);
                    this.validate();
                }
            }
        }
        if(ae.getSource() == bEscape){
            String temp = game.escape(fightingMonster, wildMonster, myMonsterNumber);
            displayInf(temp);
            sleep(1);
            if(temp.indexOf("Not") == -1 || temp.indexOf("died") != -1){
                ///successful escape or monster died
                displayUserInfo();
                displayInf(game.getCurrentWorld().getWorldDescription());
                actionPanel.setVisible(true);
                southPanel.remove(fightPanel);
                southPanel.add(choicePanel);
                this.validate();
            }else{
                displayUserInfo();
                displayInf(fightingMonster.getCharacterDescription() + "\n" + wildMonster.getCharacterDescription());
            }
        }
        if(ae.getSource() == bCatch){
            String catchOutput = game.catchMonster(wildMonsterNumber, wildMonster);
            displayInf(catchOutput);
            sleep(1);
            if(catchOutput.indexOf("You catched the monster") != -1){
                if(game.getPlayer().getNumberOfMonsters() < 2){
                    game.getPlayer().captureMonster(wildMonster);
                    displayInf(game.getCurrentWorld().getWorldDescription());
                    setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
                    actionPanel.setVisible(true);
                    southPanel.remove(fightPanel);
                    southPanel.add(choicePanel);
                    this.validate();
                    
                }else{
                    setMonsterFreeWindow();
                }
            }else{
                displayInf(fightingMonster.getCharacterDescription() + "\n" + wildMonster.getCharacterDescription());
            }        
            
            displayUserInfo();
        }
        if (ae.getSource() == bUse){
            if(game.getPlayer().getNumberOfItemsOnbackpack() == 0){
                displayInf("Backpack Empty");
                sleep(1);
                displayInf(game.getCurrentWorld().getWorldDescription());
            }else{
                choicePanel.setVisible(false);
                backPackWindow();
            }
        }
        ///choice object (fight monster or buy item)
        if (ae.getSource() == b1){
            choiceObject(0);
        }
        if (ae.getSource() == b2){
            choiceObject(1);
        }
        if (ae.getSource() == b3){
            choiceObject(2);
        }
        if (ae.getSource() == b4){
            choiceObject(3);
        }
        if (ae.getSource() == b5){
            choiceObject(4);
        }
        if (ae.getSource() == b6){
            choiceObject(5);
        }
        
        if (ae.getSource() == bItem1){
            useItem(0, bItem1.getLabel());
        }
        if (ae.getSource() == bItem2){
            useItem(1, bItem2.getLabel());
        }
        if (ae.getSource() == bItem3){
            useItem(2, bItem3.getLabel());
        }
        if (ae.getSource() == bItem4){
            useItem(3, bItem4.getLabel());
        }
        if (ae.getSource() == bItem5){
            useItem(4, bItem5.getLabel());
        }
        if (ae.getSource() == bItem6){
            useItem(5, bItem6.getLabel());
        }
        if (ae.getSource() == bItem7){
            useItem(6, bItem7.getLabel());
        }
        if (ae.getSource() == bItem8){
            useItem(7, bItem8.getLabel());
        }
        if (ae.getSource() == bItem9){
            useItem(8, bItem9.getLabel());
        }
        
        ///get first monster
        if (ae.getSource() == m1){
            getFirstMonsterAction(0);
        }
        if (ae.getSource() == m2){
            getFirstMonsterAction(1);
        }
        if (ae.getSource() == m3){
            getFirstMonsterAction(2);
        }
        if (ae.getSource() == m4){
            getFirstMonsterAction(3);
        }
        
        ///choose what monster to fight with
        if (ae.getSource() == monster1){
            getYourMonster(0);
        }
        if (ae.getSource() == monster2){
            getYourMonster(1);
        }
        
        ///choose monsetr to cure
        if (ae.getSource() == mCure1){
            cureThisMonster(0);
            displayUserInfo();
        }
        if (ae.getSource() == mCure2){
            cureThisMonster(1);
            displayUserInfo();
        }
        
        
        if (ae.getSource() == mSetFree1){
            setFree(0);
        }
        if (ae.getSource() == mSetFree2){
            setFree(1);
        }
        
        
        if (ae.getSource() == bLogIn){
            logIn();
        }
        if (ae.getSource() == bLogIn2){
            ///-1 = username not found, 0 = username found pass does not match, 1 = all good to go
            String user = username.getText();
            String pass = password.getText();
            
            if (findUsername(user, pass)==-1){
                infoAboutLogIn.setText("User not found");
            }else if(findUsername(user, pass)==0){
                infoAboutLogIn.setText("pass does not match");
            }else{
                infoAboutLogIn.setText("Loggin Successfully");
                sleep(1);
                this.remove(inputsPanel);
                this.remove(buttonPanel);
                firstMonster();
                this.validate();
            }
        }
        if (ae.getSource() == bSignUp){
            signUp();
        }
        if (ae.getSource() == bSignUp2){
            String user = username.getText();
            String pass = password.getText();
            
            if (user.indexOf(" ") != -1 || pass.indexOf(" ") != -1){
                infoAboutLogIn.setText("Username or password" + "\n" + "cant contain a space");
            }else if (user.length() <=4 || pass.length() <=4){
                infoAboutLogIn.setText("Username and password\nneed to have > 4 characters");
            }else if (user.indexOf(",") != -1 || pass.indexOf(",") != -1){
                infoAboutLogIn.setText("Username or password" + "\n" + "cant contain a comma");
            }else if(approveLogIn(user)==0){
                infoAboutLogIn.setText("User already in use");
            }else{
                infoAboutLogIn.setText("User Created Successfully" + "\n" + "Auto Logging in");
                sleep(1);
                createUser(user, pass);
                
                this.remove(inputsPanel);
                this.remove(buttonPanel);
                firstMonster();
                this.validate();
            }
        }
    }
    public void firstMonster(){
        
        tempArray = game.firstMonsterArray();
        tempPanel = new JPanel();
        m1 = new Button(tempArray.get(0).getCharacterDescription());
        m2 = new Button(tempArray.get(1).getCharacterDescription());
        m3 = new Button(tempArray.get(2).getCharacterDescription());
        m4 = new Button(tempArray.get(3).getCharacterDescription());
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        
        tempPanel.setLayout(new GridLayout(4,0));
        tempPanel.add(m1); tempPanel.add(m2);
        tempPanel.add(m3); tempPanel.add(m4);
        
        this.add(tempPanel);
        
    }
    public void displayInf(String info){
        dialogWindow.setText(info);
        if(game.getPlayerInWorld() == 0){
            worldLevelWindow.setText("Home");
        }else{
            worldLevelWindow.setText("Level: " + String.valueOf(game.getCurrentWorld().getWorldLevel()));
        }
        this.validate();
    }
    public void setFree(int i){
        game.getPlayer().removeDeadMonster(i);
        tempWindow.dispose();
        game.getPlayer().captureMonster(wildMonster);
        displayInf(game.getCurrentWorld().getWorldDescription());
        displayUserInfo();
        actionPanel.setVisible(true);
        southPanel.remove(fightPanel);
        setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
        southPanel.add(choicePanel);
        this.validate();
    }
    public void displayUserInfo(){
        if(game.getPlayer().getHp() == 0 ){
            this.remove(southPanel);
            actionPanel.setVisible(false);
            dialogWindow.setText("You dont have enough energy to move\nGAME OVER");
            sleep(2);
            this.dispose();
        }
        if(game.getPlayer().getNumberOfMonsters() == 0){
            this.remove(southPanel);
            actionPanel.setVisible(false);
            dialogWindow.setText("You have no monster alive\nGAME OVER");
            sleep(3);
            this.dispose();
        }
        userInfoWindow.setText(game.getPlayer().getCharacterDescription());
        bagInfoWindow.setText(game.itemsOnBackPack());
        monterInfoWindow.setText(game.getPlayerMonsters());
    }
    public void setButtonVisibleTrue(int playerInWorld, world currentWorld){
        if(playerInWorld == 0){
            bWest.setVisible(false);
            b1.setVisible(true); b2.setVisible(true); b3.setVisible(true);
            b4.setVisible(true); b5.setVisible(true); b6.setVisible(true);
        }else{
            wildWorld WW = (wildWorld) currentWorld;
            bWest.setVisible(true);
            b1.setVisible(false); b2.setVisible(false); b3.setVisible(false);
            b4.setVisible(false); b5.setVisible(false); b6.setVisible(false);
            if(WW.getMonsterArray().size() > 0){
                for(int i=0;i<WW.getMonsterArray().size();i++){
                    choiceButtons.get(i).setVisible(true);
                }
            }
        }
        if(playerInWorld == 3){
            bEast.setVisible(false);
        }else{
            bEast.setVisible(true);
        }
        if(currentWorld.getNumberOfCoins() > 0){
            bCoins.setVisible(true);
        }else{
            bCoins.setVisible(false);
        }
    }
    public void useItem(int i, String label){
        if(label.equals("Burger")){
            displayInf(game.useBurger(i));
            displayUserInfo();
            ///close window
            tempWindow.dispose();
            ///display effect
            sleep(1);
            ///display game info
            displayInf(game.getCurrentWorld().getWorldDescription());
            ///re-evaluate what buttons should be visible
            setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
            ///set choice panel visible again
            choicePanel.setVisible(true);
            actionPanel.setVisible(true);
        }else if(label.equals("Potion")){
            displayInf("");
            ///close window
            tempWindow.dispose();
            monsterToCureWindow();
            
        }else{
            displayInf(game.useMagicMushrooms());
            displayUserInfo();
            ///close window
            tempWindow.dispose();
            ///display effect
            sleep(1);
            ///display game info
            displayInf(game.getCurrentWorld().getWorldDescription());
            ///re-evaluate what buttons should be visible
            setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
            ///set choice panel visible again
            choicePanel.setVisible(true);
            actionPanel.setVisible(true);
        }
    }
    public void cureThisMonster(int i){
        displayInf(game.usePotion(i));
        tempWindow.dispose();
        ///display effect
        sleep(1);
        ///display game info
        displayInf(game.getCurrentWorld().getWorldDescription());
        ///re-evaluate what buttons should be visible
        setButtonVisibleTrue(game.getPlayerInWorld(), game.getCurrentWorld());
        ///set choice panel visible again
        choicePanel.setVisible(true);
        actionPanel.setVisible(true);
    }
    public void choiceObject(int i){
        if (game.getPlayerInWorld() == 0){
            displayInf(game.buy(i));
            sleep(1);
            displayInf(game.getCurrentWorld().getWorldDescription());
            displayUserInfo();
        }else{
            wildMonster = game.getWildMonster(i);
            wildMonsterNumber = i;
            monsterWindow();
            this.validate();
        }
    }
    public void getFirstMonsterAction(int i){
        game.getPlayer().captureMonster(tempArray.get(i));
        
        dialogWindow.setText(game.start());
        
        this.remove(tempPanel);
        game.goEast();
        game.goWest();
        displayUserInfo();
        this.add(northPanel);
        this.add(southPanel);
        this.validate();
    }
    public void getYourMonster(int i){
        fightingMonster = game.getPlayer().getMonsterArray().get(i);
        String temp = game.getWildMonster(wildMonsterNumber).getCharacterDescription() + "\n" + 
                        "vs\n" + game.getPlayer().getMonsters(myMonsterNumber).getCharacterDescription();
        
        displayInf(temp);
        fightPanel.setVisible(true);
        ///myMonsterNumber = i;
        tempWindow.dispose();
    }
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    public void restoreButtons(){
        for(int i=0;i<6; i++){
            choiceButtons.get(i).setLabel(String.valueOf(i+1));
            choiceButtons.get(i).setVisible(false);
            choicePanel.add(choiceButtons.get(i));
        }
    }
    
    public void backPackWindow(){
        actionPanel.setVisible(false);
        choicePanel.setVisible(false);
        
        tempWindow = new JFrame();
        tempPanel = new JPanel();
        tempPanel.setLayout(new GridLayout(game.getPlayer().getNumberOfItemsOnbackpack(),1));
        tempWindow.setSize(100,70);
        
        for(int i=0;i<game.getPlayer().getNumberOfItemsOnbackpack(); i++){
            itemButtons.get(i).setVisible(true);
            itemButtons.get(i).setLabel(game.getPlayer().getItemOfBackpack(i).getTypeOfItem());
            tempPanel.add(itemButtons.get(i));
        }
        
        tempWindow.add(tempPanel);
        tempWindow.pack();
        tempWindow.setVisible(true);
        tempWindow.setLocation(170,370);
    }
    
    
    
    private String player;
    private Button bLogIn, bSignUp, bLogIn2, bSignUp2;
    private Panel logInPagePanel, 
            buttonPanel, inputsPanel,mainPanel;
    private JTextField username, password;
    private JLabel infoAboutLogIn = new JLabel(""), lUsername = new JLabel("username: "), lPassword = new JLabel("password: ");
    
    public void logInScreen(){
        
        bLogIn = new Button("Log In"); bLogIn.setForeground(Color.white);
        bLogIn.addActionListener(this);
        bSignUp = new Button("Sign Up"); bSignUp.setForeground(Color.white);
        bSignUp.addActionListener(this);
        
        mainPanel = new Panel(); mainPanel.setLayout(new FlowLayout());
        
        mainPanel.add(bLogIn);
        mainPanel.add(bSignUp);
        this.add(mainPanel);
        
        this.validate();
    }
    public void logIn(){
        mainPanel.setVisible(false);
        bLogIn2 = new Button("Log In"); bLogIn2.setForeground(Color.white);
        bLogIn2.addActionListener(this);
        
        username = new JTextField();
        password = new JTextField();
        
        inputsPanel = new Panel(new GridLayout(2,2));
        inputsPanel.add(lUsername); lUsername.setForeground(Color.white);
        inputsPanel.add(username);
        inputsPanel.add(lPassword); lPassword.setForeground(Color.white);
        inputsPanel.add(password);
        
        buttonPanel = new Panel();
        buttonPanel.add(bLogIn2);
        infoAboutLogIn.setForeground(Color.white);
        buttonPanel.add(infoAboutLogIn);
        
        this.add(inputsPanel);
        this.add(buttonPanel);
        this.validate();
    }
    public void signUp(){
        mainPanel.setVisible(false);
        bSignUp2 = new Button("Sign Up"); bSignUp2.setForeground(Color.white);
        bSignUp2.addActionListener(this);
        
        username = new JTextField();
        password = new JTextField();

        inputsPanel = new Panel(new GridLayout(2,2));
        inputsPanel.add(lUsername); lUsername.setForeground(Color.white);
        inputsPanel.add(username);
        inputsPanel.add(lPassword);lPassword.setForeground(Color.white);
        inputsPanel.add(password);
        
        buttonPanel = new Panel();
        buttonPanel.add(bSignUp2);
        infoAboutLogIn.setForeground(Color.white);
        buttonPanel.add(infoAboutLogIn);
        
        this.add(inputsPanel);
        this.add(buttonPanel);
        this.validate();
    }
    
    
    public int approveLogIn(String username){
        String data[] = new String[2];
        int position = -1;
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String dataOnLine = myReader.nextLine();
                data = dataOnLine.split(",");
                if(data[0].equals(username)){
                    position = 0;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return position;
    }
    public int findUsername(String username, String password){
        /// -1 = username not found, 0 = username found pass does not match, 1 = all good to go
        String data[] = new String[2];
        int validation = -1;
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String dataOnLine = myReader.nextLine();
                data = dataOnLine.split(",");
                if(data[0].equals(username)){
                    validation = 0;
                    if(data[1].equals(password)){
                        validation = 1;
                    }
                }
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        
        return validation;
    }
    public void createUser(String username, String password){
        String temp = "";
        try{
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            
            while(myReader.hasNextLine()){
                temp = temp.concat(myReader.nextLine() + "\n");
            }
            temp = temp.concat(username + "," + password);
            FileWriter writer = new FileWriter("data.txt");
            writer.write(temp);
            writer.close();
        }catch (java.io.IOException ioe){
            ioe.printStackTrace();
        }
    }
}