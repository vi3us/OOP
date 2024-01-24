Student name: Jordan Steve Andino Rivera
Student number: 200348760

Please complete this README file for your level 3 mini-project submission.

If your level 1/2 submission did not get full marks you MUST complete the second part of this template describing how and where your have improved your code so that it now meets the level 1 and 2 requirements. If your code still does not meet level 1 and 2 requirements then you will get 0 for level 3.

LEVEL THREE

The main method is on the class guiGameRun
Disclaimer: I coded this on linux so it might look different in another Os.

GUI

The button is crated and a ActionListener is assinged to it, so when this button is pressed the method actionListener will run and depending on the ID of the button a certain action will take place.

Exceptions

Class: Monster1
Line: 26

The monsters have each a special technique and one requires to access the data of the user so thats why if wildMonster.special(); does not work it will run  wildMonster.special(player1);

Class: guiGameRun
Line: 817

Just check is the file that contains the usernames and passwords is found.

Collections

Class: home
Line: 5

Here the items that are going to be sold are saved in this ArrayList of superClass Type Items meaning any subclass of item can be stored making it easier to hold all the data.

File I/O

[Explain in no more than four sentences how your code implements file I/O in order to save its complete state.]

'Something impressive'

[Explain in no more than six sentences how and where your code implements OOP/Java principles beyond those taught on the course.]


LEVELS 1 AND 2

(ONLY complete this if you did not get full marks for your level 1/2 submission.)

LEVEL ONE

Made the monsters more diverse so the user or inheritance is a more sensible approach
Re-writen all the code in OOP so is easier to interact with the buttons.



My code demonstrates inheritance in the following way...

I have a superclass called world

This superclass is extended into at least two subclasses called home, wildWorld

For each of the named subclasses complete the following...

Subclass 1.

Subclass home extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are:
    public Items itemBought(int choiceObject)
    public void addItem()
    public Items foodOrHpPotion(int x)
    private ArrayList<Items> store = new ArrayList(6)


These/this new properties/property are used by the subclass in the following way: 

public Items itemBought(int choiceObject)
itemBought removes the item that the user selected.
Class: backEndEvent
Line: 200

public void addItem()
addItem puts items on the store useful when an item is bougBought and need to be replaced
Class: backEndEvent
Line: 209

private ArrayList<Items> store = new ArrayList(6)
store is an ArrayList that stores all teh subclasses of Items 
Class: home
Line: 25

public Items foodOrHpPotion(int x)
foodOrHpPotion decided randomly what item is added
Class: home
Line: 25

Subclass home extends the superclass by overriding the following methods (there must be at least one): public ArrayList<Controls> getWorldControls() Line: 57

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]
Class: backEndEvent
Line: 309


Subclass 2.

Subclass wildWorld extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are:
    private ArrayList<Monster> monsterArray = new ArrayList()
    public Monster monsterType(int x)
    public void removeDeadMonster(int i)
    public int monsterHealth(int type)
    public int monsterSpeed(int type)
    public int monsterMoney()

These/this new properties/property are used by the subclass in the following way: 

private ArrayList<Monster> monsterArray = new ArrayList() is used to save subclasses of type Monster in a single place, this way is easier to access these objects.
Class: wildWorld
Line: 13

public Monster monsterType(int x)
decides randomly what monster should be generated and stored on the array
Class : wildWorld
Line : 13


public int monsterHealth(int type)
public int monsterSpeed(int type)
public int monsterMoney()
randomly generate the variables of each monster so it more diverse, this depends on the world level
Class: wildWorld
Line: 75



Subclass wildWorld extends the superclass by overriding the following methods (there must be at least one): 
    public String getWorldDescription()
    Line: 53 
    
    public ArrayList<Controls> getWorldControls()
    Line: 34

These overridden methods are used in the working code in the following places:
Class: guiGameRun
Line: 307, 318 

Class backEndEvent
Line: 309



LEVEL TWO

Added made it easier and intresting way to see where polymorphism happens


Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in 
Class: guiGameRun
Line: 33
The variable wildMonster is of the type superClass Monster meaning a subclass needs to be saved either Monster1, Monster2, Monster3, Monster4. this happends on:
Class: guiGameRun
Line: 677
where game.getWildMonster(i) returns a monster of any of the subclasses mentioned before.

The name of the superclass used this example is Monster and the subclasses used are Monster1, Monster2, Monster3, Monster4.

Late dynamic binding can be seen in
Class: Monster1
Line: 27, 29
depending on the wildMonster the user choose to fight a different special() method will run and its only known once the user decides what monster to fight.

First the user can pick any between 4 monster to have a fight so having a variable that can "take" all of the monsters was a must, also is easier to have only one variable to refer to the wildMonster and finally this variable is private meaning there is less chance of "exposing the REF" meaning the obj cant be tweaked from another class.

Example 2.

The substitution principle can be seen in use in 
Class: guiGameRun
Line: 33
The variable fightingMonster is of the type superClass Monster meaning a subclass needs to be saved either Monster1, Monster2, Monster3, Monster4. this happends on:
Class: guiGameRun
Line: 697
where game.getPlayer().getMonsterArray().get(i) returns a monster of any of the subclasses mentioned before.


The name of the superclass used this example is Monster and the subclasses used are Monster1, Monster2, Monster3, Monster4.

Late dynamic binding can be seen in
Class: backEndEvent
Line: 134

Where myMonster.fight(wildMonster, player1); fightMonster is renamed as myMonster and this method is called when the user selects what monster to fight. Because each monster fights different this means that the fight method called is not known until myMonster is known and that only happends on runtime.


Need to access this variable in 2 classes so is easier to have one varible that can refer to any monster subClass because having 1 vaiable to refer to each monster it will get very messy, also this has to be pribate beacuse is used in more than one class and safer to only have one variable to hold this kind of data.


