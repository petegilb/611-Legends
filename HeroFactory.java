//Peter Gilbert
//CS611 Legends
//March 2021
//factory for making heroes
public class HeroFactory{
    //default constructor
    public HeroFactory(){

    }
    //a method to create a hero, input must be either 1,2,or 3 (aka warrior, sorcerer, or paladin)
    public Hero createHero(int type){
        Hero newHero;
        switch(type){
            case 1:
                newHero = new Warrior();
                break;
            case 2:
                newHero = new Sorcerer();
                break;
            case 3:
                newHero = new Paladin();
                break;
            default: //default to a warrior
                newHero = new Warrior();
                break;
        }
        return newHero;
    }
}
