//Peter Gilbert
//CS611 Legends
//March 2021
//Main class for Legends -> extends RPGGame
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
public class Legends extends RPGGame{
    //variables
    private LegBoard board;
    private RPGParty playerParty;
    private final int MAX_HEROES = 3;
    private Scanner myScanner;
    private int fileLength;
    private final int encounterChance = 3; //1 in 3 chance

    //file paths
    private final String warriorPath = "./Warriors.txt";
    private final String sorcererPath = "./Sorcerers.txt";
    private final String paladinPath = "./Paladins.txt";
    private final String dragonPath = "./Dragons.txt";
    private final String exoskeletonPath = "./Exoskeletons.txt";
    private final String spiritPath = "./Spirits.txt";
    private final String weaponPath = "./Weaponry.txt";
    private final String armorPath = "./Armory.txt";
    private final String potionPath = "./Potions.txt";
    private final String iceSpellPath = "./IceSpells.txt";
    private final String fireSpellPath = "./FireSpells.txt";
    private final String lightningSpellPath = "./LightningSpells.txt";

    //colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //background colors
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    //default constructor
    public Legends(){
        myScanner = new Scanner(System.in);
    }
    //method to call to play the game
    public void playGame(){
        //while the game is not over yet
        //some initial print statements
        printDragon();
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_GREEN + "Welcome to Legends: Monsters and Heroes!" + ANSI_RESET);
        System.out.println(ANSI_WHITE_BACKGROUND +ANSI_BLUE +  "Your legend awaits..."+ ANSI_RESET);
        //generate map
        //create a board with default value 8x8
        board = new LegBoard();
        //set up player and allow for hero choices
        chooseHeroes();
        System.out.println(playerParty);
        System.out.println(ANSI_GREEN + "Let the Adventure begin!!"+ANSI_RESET);
        System.out.println("");
        System.out.println(board);
        while(isOver == false){
            //player turn
            //can either move, quit, show info,
            playerTurn();
        }
        System.out.println("Game is Over!");
    }

    //method for a player's turn that shows them their current options
    public void playerTurn(){
        //check current tile and if it's a market then prompt if they wanna go inside
        Tile currTile = board.getTile(playerParty.getXLoc(), playerParty.getYLoc());
        if(currTile instanceof MarketTile){
            //market prompt
            marketSetup();
        }
        printMoveOptions();
        //get letter and do the corresponding action
        checkMoveOpt();
    }

    //check if the player can go there and if so then move the player
    public void checkMoveOpt(){
        String option = getCharInput();
        int currX = playerParty.getXLoc(); int currY = playerParty.getYLoc();
        //check if it is any of our input options
        //if it is, then we call the corresponding method
        switch(option){
            case moveUP:
                if(board.canGo(currX-1, currY)){
                    playerMove(currX-1, currY);
                }
                else{
                    checkMoveOpt();
                }
                break;
            case moveLEFT:
                if(board.canGo(currX, currY-1)){
                    playerMove(currX, currY-1);
                }
                else{
                    checkMoveOpt();
                }
                break;
            case moveDOWN:
                if(board.canGo(currX+1, currY)){
                    playerMove(currX+1, currY);
                }
                else{
                    checkMoveOpt();
                }
                break;
            case moveRIGHT:
                if(board.canGo(currX, currY+1)){
                    playerMove(currX, currY+1);
                }
                else{
                    checkMoveOpt();
                }
                break;
            case quitGame:
                //quit game
                isOver = true;
                break;
            case showInfo:
                System.out.println(playerParty);
                break;
            case showMap:
                System.out.println(board);
                break;
            case showInv:
                //allow the user to access their inventory
                manageInv();
                break;
        }

    }

    //print the current options for the player when they are allowed to move
    public void printMoveOptions(){
        System.out.println("-------------------------");
        System.out.println("Type " + moveUP + " to move up.");
        System.out.println("Type " + moveLEFT + " to move left.");
        System.out.println("Type " + moveDOWN + " to move down.");
        System.out.println("Type " + moveRIGHT + " to move right.");
        System.out.println("Type " + showInfo + " to show info.");
        System.out.println("Type " + quitGame + " to quit.");
        System.out.println("Type " + showInv + " to manage inventory.");
        System.out.println("Type " + showMap + " to show the Map");
        System.out.println("-------------------------");
    }

    //print some an ascii dragon
    public void printDragon(){
        System.out.println("   (  )   /\\   _                 (");
        System.out.println("    \\ |  (  \\ ( \\.(               )                      _____");
        System.out.println("  \\  \\ \\  `  `   ) \\             (  ___                 / _   \\");
        System.out.println(" (_`    \\+   . x  ( .\\            \\/   \\____-----------/ (o)   \\_");
        System.out.println("- .-      YOUR     \\+  ;          (  O                           \\____");
        System.out.println("         LEGEND          )        \\_____________  `              \\  /");
        System.out.println("(__      BEGINS    +- .( -'.- <. - _  VVVVVVV VV V\\                 \\/");
        System.out.println("(_____            ._._: <_ - <- _  (--  _AAAAAAA__A_/                  |");
        System.out.println("  .    /./.+-  . .- /  +--  - .     \\______________//_              \\_______");
        System.out.println("  (__ ' /x  / x _/ (                                  \\___'          \\     /");
        System.out.println(" , x / ( '  . / .  /                                      |           \\   /");
        System.out.println("    /  /  _/ /    +                                      /              \\/");
        System.out.println("   '  (__/                                             /                  \\");
        System.out.println("");

    }

    //logic for a player moving and updating the player's position
    public void playerMove(int x, int y){
        playerParty.setPos(x, y);
        board.updatePlayer(x, y);
        System.out.println(board); //show the updated board
        //check for battle if necessary
        if(board.getTile(x, y) instanceof WildTile){
            checkBattle(x, y);
        }
    }

    //allow the user to choose heroes at the beginning of the game
    public void chooseHeroes(){
        System.out.println("How many heroes would you like in your party?");
        System.out.println("Max is " + MAX_HEROES);
        int numHeroes = getIntInput(1, MAX_HEROES);
        playerParty = new RPGParty(numHeroes);
        //add a hero for the amount of times the player chose
        for(int x=0; x<numHeroes; x++){
            addHero(x);
        }
    }

    //method to add a hero to the party
    //index being where in the party array to add them
    public void addHero(int index){
        System.out.println("");
        System.out.println("What type of hero would you like?");
        System.out.println("Warrior = 1, Sorcerer = 2, Paladin = 3");
        //get an integer between 1 and 3 from the user
        int choice = getIntInput(1, 3);
        //list heroes depending on the choice
        //file names are declared in final variables at the top
        System.out.println("YOUR CHOICE IS " + choice);
        int input;
        String heroString = "";
        switch(choice) {
            case 1: //print the list of warriors from the file and then select them by getting the file lineNumber
                System.out.println("Please select a Warrior with the corresponding number");
                System.out.println("");
                printFile(warriorPath);
                input = getIntInput(1,fileLength);
                heroString = getFileLine(input, warriorPath);
                break;
            case 2:
                System.out.println("Please select a Sorcerer with the corresponding number");
                System.out.println("");
                printFile(sorcererPath);
                input = getIntInput(1,fileLength);
                heroString = getFileLine(input, sorcererPath);
                break;
            case 3:
                System.out.println("Please select a Paladin with the corresponding number");
                System.out.println("");
                printFile(paladinPath);
                input = getIntInput(1,fileLength);
                heroString = getFileLine(input, paladinPath);
                break;
        }
        System.out.println("You have chosen:");
        System.out.println(heroString);
        //now generate the object with the hero factory and add it to the party
        HeroFactory heroFac = new HeroFactory();
        Hero newHero = heroFac.createHero(choice);
        newHero.setAttributes(heroString);
        playerParty.setIndex(index, newHero);
    }

    //allow the player to use a hero's inventory
    public void manageInv(){
        System.out.println("");
        playerParty.printTeamInv();
        System.out.println("Which Hero's inventory would you like to manage?");
        System.out.println("Type -1 to exit");
        for(int x=0; x<playerParty.getLength(); x++){
            System.out.println("(" + x + ") " + playerParty.getIndex(x));
        }
        int choice = getIntInput(-1, playerParty.getLength()-1);
        if(choice == -1){ //if they chose to exit
            return;
        }
        Hero hero = playerParty.getIndex(choice);
        System.out.println("You have selected: " + hero.getName());
        hero.printInv();
        System.out.println("What would you like to do?");
        System.out.println("(0) Equip Items?");
        System.out.println("(1) Use a Potion?");
        choice = getIntInput(-1, 1);
        //get input and then do a method based on the choice
        if(choice == 0){
            equipItem(hero);
        }
        else if(choice == 1){
            usePotion(hero);
        }
        //otherwise we exit
    }

    //method for setting up the market
    public void marketSetup(){
        System.out.println("------------------");
        System.out.println("You've arrived at a shop!");
        System.out.println("What would you like to do?");
        System.out.println("(1) Enter the shop");
        System.out.println("(2) Move along");
        System.out.println("");
        int choice = getIntInput(1, 2);
        if(choice ==1){ //if they want to enter the shop
            System.out.println("Welcome to the shop!");
            System.out.println("");
            heroMarket();
            marketSetup();
        }
        else{
            return;
        }

    }

    //select the hero and choose whether they want to shop or sell
    public void heroMarket(){
        System.out.println("Please select a Hero to work with");
        //show all of the players and make a selection
        for(int x=0; x<playerParty.getLength(); x++){
            System.out.println("(" + (x+1) + ") " + playerParty.getIndex(x));
        }
        System.out.println("Or type -1 to leave");
        //get the player's choice and set the hero
        int choice = getIntInput(-1, playerParty.getLength());
        if(choice > 0){
            Hero hero = playerParty.getIndex(choice-1);
            hero.printInv();
            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("(1) Shop");
            System.out.println("(2) Sell");
            int choice2 = getIntInput(-1, 2);
            if(choice2 == 1){
                buyItem(hero);
            }
            else if(choice2 == 2){
                sellItem(hero);
            }
        }
    }

    //allow the hero to buy items
    //for simplicity allow them to buy any item in the files
    public void buyItem(Hero hero){
        System.out.println("What kind of item would you like?");
        System.out.println("(1) Weapons");
        System.out.println("(2) Armor");
        System.out.println("(3) Potions");
        System.out.println("(4) Spells");
        int choice = getIntInput(-1, 4);
        String filePath = "";
        if(choice == 1){ //weapons
            filePath = weaponPath;
        }
        else if(choice == 2){
            filePath = armorPath;;
        }
        else if(choice == 3){
            filePath = potionPath;
        }
        else if(choice == 4){ //spells
            System.out.println("What kind of spell would you like?");
            System.out.println("(1) Ice Spells");
            System.out.println("(2) Fire Spells");
            System.out.println("(3) Lightning Spells");
            int choice2 = getIntInput(1,3);
            if(choice2 == 1){
                filePath = iceSpellPath;
            }
            else if(choice2 == 2){
                filePath = fireSpellPath;
            }
            else{
                filePath = lightningSpellPath;
            }
        }
        else{ //if they typed 0 or -1, leave
            return;
        }
        printFile(filePath);
        int itemChoice = getIntInput(1, numLines(filePath)-1);
        String itemStr = getFileLine(itemChoice, filePath);
        //item that the hero is going to buy
        RPGItem toBuy;
        //make the item based on what kind of item it is
        switch(filePath){
            case weaponPath:
                toBuy = new Weapon();
                ((Weapon)toBuy).setAttributes(itemStr);
                break;
            case armorPath:
                toBuy = new Armor();
                ((Armor)toBuy).setAttributes(itemStr);
                break;
            case potionPath:
                toBuy = new Potion();
                ((Potion)toBuy).setAttributes(itemStr);
                break;
            case iceSpellPath:
                toBuy = new Spell();
                ((Spell)toBuy).setAttributes(itemStr, Spells.ICE);
                break;
            case fireSpellPath:
                toBuy = new Spell();
                ((Spell)toBuy).setAttributes(itemStr, Spells.FIRE);
                break;
            case lightningSpellPath:
                toBuy = new Spell();
                ((Spell)toBuy).setAttributes(itemStr, Spells.LIGHTNING);
                break;
            default:
                toBuy = new Weapon();
                break;
        }
        //if the hero has the rq lvl and enough money
        if(hero.getLvl() >= toBuy.getRqLvl() && hero.getMoney() >= toBuy.getCost()){
            if(toBuy instanceof Weapon){
                hero.getWeapons().add((Weapon)toBuy);
                hero.setMoney(hero.getMoney() - toBuy.getCost());
            }
            else if(toBuy instanceof Armor){
                hero.getArmor().add((Armor)toBuy);
                hero.setMoney(hero.getMoney() - toBuy.getCost());
            }
            else if(toBuy instanceof Potion){
                hero.getPotions().add((Potion)toBuy);
                hero.setMoney(hero.getMoney() - toBuy.getCost());
            }
            else if(toBuy instanceof Spell){
                hero.getSpells().add((Spell)toBuy);
                hero.setMoney(hero.getMoney() - toBuy.getCost());
            }
            System.out.println(ANSI_GREEN +"Successfully bought it!"+ANSI_RESET);
        }
        else{
            System.out.println(ANSI_RED + "Cannot buy that item!"+ANSI_RESET);
        }
    }

    //allow a hero to sell an item from their inventory
    public void sellItem(Hero hero){
        hero.printInv();
        System.out.println("What kind of item would you like to sell?");
        System.out.println("(1) Weapons");
        System.out.println("(2) Armor");
        System.out.println("(3) Potions");
        System.out.println("(4) Spells");
        int choice = getIntInput(1, 4);
        RPGItem toSell = new RPGItem();
        System.out.println("Which one would you like to sell?");
        System.out.println("-1 for none");
        if(choice == 1){ //weapons
            ArrayList<Weapon> items = hero.getWeapons();
            if(items.size() == 0){
                System.out.println("Hero doesn't have any to sell");
                return;
            }
            for(int x=0; x<items.size(); x++){
                System.out.println("(" + x + ") " + items.get(x));
            }
            int itemChoice = getIntInput(-1, items.size()-1);
            if(itemChoice == -1){ //if they've changed their mind
                return;
            }
            else{
                toSell = items.get(itemChoice);
            }
        }
        else if(choice == 2){ //armor
            ArrayList<Armor> items = hero.getArmor();
            if(items.size() == 0){
                System.out.println("Hero doesn't have any to sell");
                return;
            }
            for(int x=0; x<items.size(); x++){
                System.out.println("(" + x + ") " + items.get(x));
            }
            int itemChoice = getIntInput(-1, items.size()-1);
            if(itemChoice == -1){ //if they've changed their mind
                return;
            }
            else{
                toSell = items.get(itemChoice);
            }
        }
        else if(choice == 3){ //potions
            ArrayList<Potion> items = hero.getPotions();
            if(items.size() == 0){
                System.out.println("Hero doesn't have any to sell");
                return;
            }
            for(int x=0; x<items.size(); x++){
                System.out.println("(" + x + ") " + items.get(x));
            }
            int itemChoice = getIntInput(-1, items.size()-1);
            if(itemChoice == -1){ //if they've changed their mind
                return;
            }
            else{
                toSell = items.get(itemChoice);
            }
        }
        else if(choice == 4){ //spells
            ArrayList<Spell> items = hero.getSpells();
            if(items.size() == 0){
                System.out.println("Hero doesn't have any to sell");
                return;
            }
            for(int x=0; x<items.size(); x++){
                System.out.println("(" + x + ") " + items.get(x));
            }
            int itemChoice = getIntInput(-1, items.size()-1);
            if(itemChoice == -1){ //if they've changed their mind
                return;
            }
            else{
                toSell = items.get(itemChoice);
            }
        }
        //add money for half the cost of the item
        hero.setMoney(hero.getMoney() + (toSell.getCost()/2));
        System.out.println(ANSI_GREEN +"Successfully sold " + toSell.getName()+ANSI_RESET);
        //remove the item
        if(toSell instanceof Weapon){
            hero.getWeapons().remove(toSell);
        }
        else if(toSell instanceof Armor){
            hero.getArmor().remove(toSell);
        }
        else if(toSell instanceof Potion){
            hero.getPotions().remove(toSell);
        }
        else if(toSell instanceof Spell){
            hero.getSpells().remove(toSell);
        }
    }

    //check if there is going to be a battle
    public void checkBattle(int x, int y){
        //33 percent of the time there is going to be a battle
        Random rand = new Random();
        //encounter chance is a variable that can be changed and is defined above
        int tileNum = rand.nextInt(encounterChance);
        if(tileNum == 0){ //if it equals 0 -> start the battle
            startBattle();
        }
    }

    //method to start a battle sequence
    public void startBattle(){
        System.out.println("------------------");
        System.out.println(ANSI_CYAN +"THE BATTLE BEGINS..."+ANSI_RESET);
        System.out.println("------------------");
        System.out.println(playerParty);
        //first generate monsters corresponding to the size of the party and highest level of the party
        int highLvl = playerParty.getHighestLvl();
        MonsterParty monsters = new MonsterParty(playerParty.getLength());
        for(int x=0; x<monsters.getLength(); x++){
            //generate monster randomly 1-3 : dragon, exoskeleton, spirit
            Random rand = new Random();
            int type = rand.nextInt(3) + 1;
            //randomly get a string from the corresponding monster file
            String charInfo = "";
            String filePath = "";
            if(type ==1){//if we're making a dragon set the path accordingly
                filePath = dragonPath;
            }
            else if(type ==2){
                filePath = exoskeletonPath;
            }
            else{
                filePath = spiritPath;
            }
            int toGet = rand.nextInt(numLines(filePath)) + 1; //rand number from 1-length of file
            charInfo = getFileLine(toGet, filePath); //get a line from the file
            MonsterFactory monFac = new MonsterFactory();
            Monster newMon = monFac.createMonster(type, charInfo, highLvl);
            monsters.setIndex(x, newMon);
        }
        System.out.println(monsters);

        //while loop to keep fighting until a side is dead
        //add hp every round
        //while some monsters are alive and some heros are alive
        while(monsters.allDead() == false && playerParty.allDead() == false){
            //player turn
            battleTurn(monsters);

            //monster turn
            monsterTurn(monsters);

            //show the hp after all of that
            System.out.println(playerParty);
            System.out.println(monsters);
        }
        if(monsters.allDead()){
            System.out.println(ANSI_GREEN +"Heroes win!"+ANSI_RESET);
            //if the heroes have won -> distribute stats and money
            playerParty.winBattle();
            //if any of the players have died -> revive with 50% hp
            playerParty.reviveTeam();
        }
        //if the players are all dead then the game is over
        else if(playerParty.allDead()){
            System.out.println(ANSI_RED +"Heroes have perished!" +ANSI_RESET);
            isOver = true;
        }
        //check for lvlup
        playerParty.chkLevelUp();
    }

    //give each monster a turn
    public void monsterTurn(MonsterParty monsters){
        int[] aliveMon = monsters.aliveIndexes();
        //get the alive heroes and the alive monsters and set the targets accordingly
        for(int x=0; x<aliveMon.length; x++){
            int[] aliveHeroes = playerParty.aliveIndexes();
            int newTarget = 0;
            for(int y=0; y<aliveHeroes.length; y++){ //if the difference is less then choose that as a target
                if(Math.abs(aliveMon[x]-newTarget) >= Math.abs(aliveMon[x] - aliveHeroes[y])){
                    newTarget = aliveHeroes[y];
                }
            }
            Monster currentMonster = monsters.getIndex(aliveMon[x]);
            currentMonster.setTarget(newTarget);
            monsterAttack(currentMonster); //attack the target
        }
    }

    //allow the monster to attack its target
    public void monsterAttack(Monster monster){
        Random rand = new Random();
        //see if the monster dodges the attack
        Hero target = playerParty.getIndex(monster.getTarget());
        if(rand.nextInt(100)+1 <= target.calcDodge()){
            System.out.println(ANSI_YELLOW + "The Hero Dodged it!" + ANSI_RESET);
        }
        else{
            //calculate damage based on equipped weapon
            int dmg = monster.calcDmg();
            target.takeDamage(dmg);
            System.out.println(ANSI_RED +monster.getName() + " has done " + dmg + " to " + target.getName() +ANSI_RESET);
            System.out.println("");
        }

    }

    //the player's turn in battle
    public void battleTurn(MonsterParty monsters){
        //get the alive heroes and the alive monsters and set the targets accordingly
        int[] aliveHeroes = playerParty.aliveIndexes();
        for(int x=0; x<aliveHeroes.length; x++){
            int[] aliveMon = monsters.aliveIndexes();
            if(aliveMon.length == 0){ //if they're all dead
                break;
            }
            int newTarget = 0;
            for(int y=0; y<aliveMon.length; y++){ //if the difference is less then choose that as a target
                // System.out.println("********");
                // System.out.println("monsters alive are " + monsters.getIndex(aliveMon[y]));
                if(y==0){
                    newTarget = aliveMon[y];
                }
                else if(Math.abs(aliveHeroes[x]-newTarget) >= Math.abs(aliveHeroes[x]-aliveMon[y])){
                    newTarget = aliveMon[y];
                }
            }
            Hero currentHero = playerParty.getIndex(aliveHeroes[x]);
            currentHero.setTarget(newTarget);
            System.out.println("------------");
            System.out.println(ANSI_CYAN + currentHero.getName() + " is targeting -> " + monsters.getIndex(currentHero.getTarget()).getName() + ANSI_RESET);
            System.out.println("What would you like to do?");
            System.out.println("(1) Attack");
            System.out.println("(2) Use a Spell");
            System.out.println("(3) Change Equipment");
            System.out.println("(4) Use a Potion");
            int choice = getIntInput(1, 4);
            if(choice == 1){ //attack
                heroAttack(currentHero, monsters);
            }
            else if(choice ==2){ //use a spell
                useSpell(currentHero, monsters);
            }
            else if(choice ==3){ //change Equipment
                equipItem(currentHero);
            }
            else if(choice==4){ //use a potion
                usePotion(currentHero);
            }
        }
    }

    //let a hero use a potion that the player selects
    public void usePotion(Hero hero){
        System.out.println("What would you like to use?");
        ArrayList<Potion> potions = hero.getPotions();
        if(potions.size() > 0){
            for(int x=0; x<potions.size(); x++){
                System.out.println("(" + x + ") " + potions.get(x));
            }
            //get the potion they want
            int choice2 = getIntInput(-1, potions.size()-1);
            hero.usePotion(choice2); //equip it
        }
        else{ //if they don't have any
            System.out.println("No potions to use!");
        }
    }

    //equip a weapon or armor to a certain hero
    public void equipItem(Hero hero){
        System.out.println("What would you like to equip?");
        System.out.println("(0) Weapon");
        System.out.println("(1) Armor");
        System.out.println("(-1) Nothing");
        int choice = getIntInput(-1, 1);
        //if they want to equip a weapon
        if(choice == 0){
            System.out.println("Which weapon?");
            ArrayList<Weapon> weapons = hero.getWeapons();
            if(weapons.size() > 0){
                for(int x=0; x<weapons.size(); x++){
                    System.out.println("(" + x + ") " + weapons.get(x));
                }
                //get the weapon they want
                int choice2 = getIntInput(-1, weapons.size()-1);
                hero.equipWeapon(choice2); //equip it
            }
            else{ //if they don't have any
                System.out.println("No weapons to equip!");
            }
        }
        else if(choice == 1){
            System.out.println("Which armor?");
            ArrayList<Armor> armor = hero.getArmor();
            if(armor.size() > 0){
                for(int x=0; x<armor.size(); x++){
                    System.out.println("(" + x + ") " + armor.get(x));
                }
                //get the weapon they want
                int choice2 = getIntInput(-1, armor.size()-1);
                hero.equipArmor(choice2); //equip it
            }
            else{ //if they don't have any
                System.out.println("No armor to equip!");
            }
        }

    }

    //use a spell
    public void useSpell(Hero hero, MonsterParty monsters){
        Random rand = new Random();
        //see if the monster dodges the attack
        Monster target = monsters.getIndex(hero.getTarget());
        if(rand.nextInt(100)+1 <= target.calcDodge()){
            System.out.println(ANSI_YELLOW + "The Monster Dodged it!" + ANSI_RESET);
        }
        else{
            ArrayList<Spell> spells = hero.getSpells();
            if(spells.size() > 0){
                //choose which spell to use
                for(int x=0;x<spells.size();x++){
                    System.out.println("(" + x + ") " + spells.get(x));
                }
                int choice = getIntInput(0, spells.size()-1);
                Spell spell = spells.get(choice);
                if(hero.useSpell(choice)){
                    //do the damage on the monster
                    int dmg = spell.getDmg();
                    target.takeDamage(dmg);
                    System.out.println("");
                    System.out.println(ANSI_GREEN +hero.getName() + " has done " + dmg + " to " + target.getName() + ANSI_RESET);
                    System.out.println("");
                    //do the debuff on the monster
                    target.spellDebuff(spell);
                }
            }
            else{
                System.out.println("No spells to use!");
            }
        }
    }

    public void heroAttack(Hero hero, MonsterParty monsters){
        Random rand = new Random();
        //see if the monster dodges the attack
        Monster target = monsters.getIndex(hero.getTarget());
        if(rand.nextInt(100)+1 <= target.calcDodge()){
            System.out.println(ANSI_YELLOW + "The Monster Dodged it!" + ANSI_RESET);
        }
        else{
            //calculate damage based on equipped weapon
            int dmg = hero.calcWpDmg();
            target.takeDamage(dmg);
            System.out.println("");
            System.out.println(ANSI_GREEN + hero.getName() + " has done " + dmg + " to " + target.getName() + ANSI_RESET);
            System.out.println("");
        }
    }

    //adds file to string line by line to be printed
    //assume the files are formatted like the example
    public void printFile(String filePath){
        String toPrint = "";
        //maybe returns string with the whole input
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(System.in);
        try{
             fileScanner = new Scanner(file);
        }
        catch(Exception e){
            System.out.println("File not found.");
        }
        int count=0;
        while (fileScanner.hasNextLine()){
            if(count>0){
                toPrint+=" (" + count + ") ";
            }
            toPrint+= fileScanner.nextLine();
            toPrint+="\n";
            count++;
        }
        fileScanner.close();
        fileLength = count;
        System.out.println(toPrint);
    }

    //get a specific line
    public String getFileLine(int lineNumber, String filePath){
        String output = "";
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(System.in);
        try{
             fileScanner = new Scanner(file);
        }
        catch(Exception e){
            System.out.println("File not found.");
        }
        int count=0;
        while (fileScanner.hasNextLine()){
            output = fileScanner.nextLine();
            if(count == lineNumber){
                break;
            }
            count++;
        }
        fileScanner.close();
        return output;
    }

    //return number of lines in a file
    //looked at: https://www.programiz.com/java-programming/examples/count-lines-in-file
    public int numLines(String filePath){
        int count = 0;
        try{
          File file = new File(filePath);
          Scanner sc = new Scanner(file);
          // read each line and
          // count number of lines
          while(sc.hasNextLine()) {
            sc.nextLine();
            count++;
          }
          sc.close();
        }
        catch (Exception e) {
          System.out.println("error reading from file");
        }
        return count;
    }

    //get integer input with a min and max range
    //helper function
    //i looked here: https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
    public int getIntInput(int min, int max){
        int input = 0;
        do{
            while(!myScanner.hasNextInt()){
                System.out.println("Please enter an Integer");
                myScanner.next();
            }
            input = myScanner.nextInt();
            if(input > max || input < min){
                System.out.println("Incorrect input. Please try again.");
            }
        } while(input > max || input < min);
        return input;
    }

    //get single char input from scanner and return as a String
    //also check if it matches any of our inputs
    public String getCharInput(){
        String input;
        int count=0;
        do{
            if(count>0){
                System.out.println("Wrong input. Try again.");
            }
            input = "";
            input += myScanner.next().charAt(0);
            input = input.toUpperCase();
            count++;
        } while(!(input.equals(moveUP) || input.equals(moveLEFT) || input.equals(moveDOWN) || input.equals(moveRIGHT) || input.equals(showInfo) || input.equals(quitGame) || input.equals(showInv) || input.equals(showMap)));
        return input;
    }

}
