//Peter Gilbert
//CS611 Legends
//March 2021
//a hero but is favored on strength and agility
public class Warrior extends Hero implements HeroCreator{
    public Warrior(){
        super();
    }
    public Warrior(int lvl, int hp, String name, int strength, int dex, int agl, int mana, int exp, int money){
        super(lvl, hp, name, strength, dex, agl, mana, exp, money);
    }

    public Warrior createHero(String charInfo){
        Warrior newHero = new Warrior();
        setAttributes(charInfo);
        return newHero;
    }

    //same as hero but add 5 percent more to favored stats
    public void LvlUp(){
        lvl++;
        hp = lvl*100;
        mana = (int)(mana*1.1);
        //all skills go up 5 percent and 5 more to favored stats
        strength = (int)(strength*1.10);
        agility = (int)(agility*1.10);
        dexterity = (int)(dexterity*1.05);
    }
}
