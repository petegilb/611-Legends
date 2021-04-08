//Peter Gilbert
//CS611 Legends
//March 2021
//a factory to create monsters
public class MonsterFactory{
    public MonsterFactory(){

    }
    //a method to create a dragon, input must be either 1,2,or 3 (aka dragon, exoskeleton, spirit)
    public Monster createMonster(int type, String info, int targetLvl){
        Monster newMonster;
        switch(type){
            case 1:
                newMonster = new Dragon();
                break;
            case 2:
                newMonster = new Exoskeleton();
                break;
            case 3:
                newMonster = new Spirit();
                break;
            default: //default to a dragon
                newMonster = new Dragon();
                break;
        }
        //set attributes
        newMonster.setAttributes(info);
        //match target level
        newMonster.matchLevel(targetLvl);
        return newMonster;
    }
}
