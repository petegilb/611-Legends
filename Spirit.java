//Peter Gilbert
//CS611 Legends
//March 2021
//a monster but higher dodge chance
public class Spirit extends Monster implements MonsterCreator{
    public Spirit(){
        super();
    }
    //create a Spirit with all set attributes
    public Spirit(int lvl, int hp, String name, int baseDMG, int defense, int dodgeChance){
        super(lvl, hp, name, baseDMG, defense, dodgeChance);
    }

    //create a new spirit and match it to the correct level
    public Spirit createMonster(String charInfo, int matchLvl){
        Spirit spirit = new Spirit();
        spirit.setAttributes(charInfo);
        spirit.matchLevel(matchLvl);
        return spirit;
    }

}
