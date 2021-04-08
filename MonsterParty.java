//Peter Gilbert
//CS611 Legends
//March 2021
//this class represents a group of monsters in an rpg
public class MonsterParty{
    //monster array to hold the monsters
    private Monster[] monsters;
    public MonsterParty(){

    }
    //generate a monster party of a specified size
    public MonsterParty(int num){
        monsters = new Monster[num];
    }

    //print out all of the monsters that have not yet fainted
    @Override
    public String toString(){
        String toPrint = "";
        toPrint+="\n";
        toPrint+="Alive Monsters: \n";
        for(int x=0; x<monsters.length; x++){
            if(monsters[x].getHp() > 0){ // if it's still alive
                toPrint+= monsters[x] + "\n";
                toPrint+="\n";
            }
        }
        return toPrint;
    }

    //return true if every monster is dead
    public boolean allDead(){
        int count = 0;
        for(int x=0;x<monsters.length; x++){
            if(monsters[x].isDead()){
                count++;
            }
        }
        if(count == monsters.length){
            return true;
        }
        return false;
    }

    //number of monster still alive
    public int numAlive(){
        int count =0;
        for(int x=0; x<monsters.length; x++){
            if(!(monsters[x].isDead())){
                count++;
            }
        }
        return count;
    }

    //return an array filled with the indexes of the living creatures
    public int[] aliveIndexes(){
        int[] alive = new int[numAlive()];
        int count = 0;
        for(int x=0; x<monsters.length; x++){
            if(!(monsters[x].isDead())){
                alive[count] = x;
                count++;
            }
        }
        return alive;
    }

    //get the length
    public int getLength(){
        return monsters.length;
    }

    //get a monster at an index
    public Monster getIndex(int index){
        return monsters[index];
    }
    //set a monster at an index
    public void setIndex(int index, Monster mon){
        monsters[index] = mon;
    }


}
