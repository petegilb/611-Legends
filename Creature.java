//Peter Gilbert
//CS611 Legends
//March 2021
//class for creatures with HP, name, level
//to be extended by monsters and heroes
public class Creature{
    protected int lvl;
    protected int hp;
    protected String name;
    //protected boolean isDead;
    protected int target; //who they are targetting -> updated with each turn

    //default constructor
    public Creature(){
        name = "default";
        lvl = 1;
        hp = 100;
    }
    //constructor to set other attributes
    public Creature(int lvl, int hp, String name){
        this.lvl = lvl;
        this.hp = hp;
        this.name = name;
    }

    //make a creature take damage
    public void takeDamage(int dmg){
        hp -= dmg;
    }
    //make a creature gain health
    public void gainHealth(int health){
        hp+=health;
    }

    //return true if a creature is dead
    public boolean isDead(){
        if(this.hp <= 0){
            return true;
        }
        return false;
    }

    //make the creature go up a level
    public void lvlUp(){
        lvl++;
    }

    //getter/setters
    public int getTarget(){
        return target;
    }

    public void setTarget(int target){
        this.target = target;
    }

	public int getLvl() {
		return lvl;
	}

	public int getHp() {
		return hp;
	}

	public String getName() {
		return name;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setName(String name) {
		this.name = name;
	}
}
