//Peter Gilbert
//CS611 Legends
//March 2021
//a monster but with higher damage
public class Dragon extends Monster implements MonsterCreator{
    public Dragon(){
        super();
    }
    //create a dragon with all set attributes
    public Dragon(int lvl, int hp, String name, int baseDMG, int defense, int dodgeChance){
        super(lvl, hp, name, baseDMG, defense, dodgeChance);
    }
    
    //create a new dragon and match it to the correct level
    public Dragon createMonster(String charInfo, int matchLvl){
        Dragon dragon = new Dragon();
        dragon.setAttributes(charInfo);
        dragon.matchLevel(matchLvl);
        return dragon;
    }

}
