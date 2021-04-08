//Peter Gilbert
//CS611 Legends
//March 2021
//interface to help facilitate a monster factory
public interface MonsterCreator{
    //create a monster using a string and a level they need to be matched to
    Monster createMonster(String charInfo, int matchLvl);
}
