//Peter Gilbert
//CS611 Legends
//March 2021
//a monster but with increased defense
public class Exoskeleton extends Monster implements MonsterCreator{
    public Exoskeleton(){
        super();
    }
    //create a Exoskeleton with all set attributes
    public Exoskeleton(int lvl, int hp, String name, int baseDMG, int defense, int dodgeChance){
        super(lvl, hp, name, baseDMG, defense, dodgeChance);
    }

    //create a new Exoskeleton and match it to the correct level
    public Exoskeleton createMonster(String charInfo, int matchLvl){
        Exoskeleton exoskeleton = new Exoskeleton();
        exoskeleton.setAttributes(charInfo);
        exoskeleton.matchLevel(matchLvl);
        return exoskeleton;
    }

}
