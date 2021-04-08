//Peter Gilbert
//CS611 Legends
//March 2021
//this class is meant to be used as a group of heroes for an RPG
public class RPGParty{
    private final int defaultPartyLocX = 0;
    private final int defaultPartyLocY = 0;
    private Hero[] playerParty;
    //current location of the party
    private int xLoc;
    private int yLoc;
    //constructor to specify number of players
    public RPGParty(int num){
        playerParty = new Hero[num];
        xLoc = defaultPartyLocX;
        yLoc = defaultPartyLocY;
    }
    //method to get a Hero at an index
    public Hero getIndex(int index){
        return playerParty[index];
    }
    //set a hero at an index
    public void setIndex(int index, Hero hero){
        playerParty[index] = hero;
    }
    //print everyone's inventory
    public void printTeamInv(){
        for(int x=0;x<playerParty.length; x++){
            playerParty[x].printInv();
        }

    }

    //revive the dead members after the battle
    public void reviveTeam(){
        for(int x=0;x<playerParty.length; x++){
            if(playerParty[x].isDead()){ //revive if dead
                playerParty[x].setHp(playerParty[x].getLvl()*100/2);
            }
        }
    }

    //award the heroes for winning
    public void winBattle(){
        for(int x=0;x<playerParty.length; x++){
            //if a hero is not dead it gains money and xp and hp and mana
            if(!(playerParty[x].isDead())){
                playerParty[x].setExp(playerParty[x].getExp()+2); //add 2 xp
                int prevMoney = playerParty[x].getMoney();
                playerParty[x].setMoney(prevMoney + (getHighestLvl() * 100));
                //add 10 percent hp back
                playerParty[x].setHp(playerParty[x].getHp() + (playerParty[x].getHp()/10));
                //add 10 percent mana back
                playerParty[x].setMana(playerParty[x].getMana() + (playerParty[x].getMana()/10));
            }
        }
    }

    //go through each character and check for level up
    public void chkLevelUp(){
        for(int x=0;x<playerParty.length; x++){
            //if the player is eligible to lvlup, do that
            if(playerParty[x].chkLvlUp()){
                playerParty[x].LvlUp();
            }
        }
    }

    //override the toString method for when we print
    @Override
    public String toString(){
        String toPrint = "";
        toPrint+="\n";
        toPrint+="Your current party: \n";
        for(int x=0; x<playerParty.length; x++){
            toPrint+= playerParty[x] + "\n";
            toPrint+="\n";
        }
        return toPrint;
    }

    //return true if every hero is dead
    public boolean allDead(){
        int count = 0;
        for(int x=0;x<playerParty.length; x++){
            if(playerParty[x].isDead()){
                count++;
            }
        }
        if(count == playerParty.length){
            return true;
        }
        return false;
    }

    //get the number of heros that are still alive
    public int numAlive(){
        int count =0;
        for(int x=0; x<playerParty.length; x++){
            if(!(playerParty[x].isDead())){
                count++;
            }
        }
        return count;
    }

    //return an array filled with the indexes of the living creatures
    public int[] aliveIndexes(){
        int[] alive = new int[numAlive()];
        int count = 0;
        for(int x=0; x<playerParty.length; x++){
            if(!(playerParty[x].isDead())){
                alive[count] = x;
                count++;
            }
        }
        return alive;
    }

    //set the party's new position
    public void setPos(int x, int y){
        xLoc = x;
        yLoc = y;
    }

    //get length of the party
    public int getLength(){
        return playerParty.length;
    }
    //get the highest level in the party
    public int getHighestLvl(){
        int highestLvl = 0;
        for(int x=0; x<playerParty.length; x++){
            if(playerParty[x].getLvl() > highestLvl){
                highestLvl = playerParty[x].getLvl();
            }
        }
        return highestLvl;
    }

    //getters and setters
    public int getXLoc(){
        return xLoc;
    }
    public int getYLoc(){
        return yLoc;
    }
    public void setXLoc(int xLoc){
        this.xLoc = xLoc;
    }
    public void setYLoc(int yLoc){
        this.yLoc = yLoc;
    }


}
