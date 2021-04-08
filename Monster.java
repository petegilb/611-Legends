//Peter Gilbert
//CS611 Legends
//March 2021
//base class for a monster that contains their stats
//and some helper methods
public class Monster extends Creature{
    protected int baseDMG;
    protected int defense;
    protected int dodgeChance;

    //default constructor
    public Monster(){

    }
    //create a monster with all new attributes
    public Monster(int baseDMG, int defense, int dodgeChance) {
		super();
		this.baseDMG = baseDMG;
		this.defense = defense;
		this.dodgeChance = dodgeChance;
	}
    //create a monster and set all its stats
    public Monster(int lvl, int hp, String name, int baseDMG, int defense, int dodgeChance) {
		super(lvl, hp, name);
		this.baseDMG = baseDMG;
		this.defense = defense;
		this.dodgeChance = dodgeChance;
	}

    //override toString
    @Override
    public String toString(){
        String toPrint = "";
        String spaces = "  ";
        toPrint+= getClass().getName() + spaces;
        toPrint+= name + spaces;
        toPrint+= "LVL: " + lvl + spaces;;
        toPrint+= "HP: " + hp + spaces;
        toPrint+= "DMG: " + baseDMG + spaces;
        toPrint+= "DEF: " + defense + spaces;
        toPrint+= "DODGE: " + dodgeChance + spaces;
        return toPrint;
    }

    //helper methods

    //set each attribute based on the inputted string from the file
    //ex: Name/level/damage/defense/dodge chance
    //Desghidorrah	 3       300       400     35
    public void setAttributes(String input){
        //split off of any white space
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.lvl = Integer.parseInt(characterAttr[1]);
        this.baseDMG = Integer.parseInt(characterAttr[2]);
        this.defense = Integer.parseInt(characterAttr[3]);
        this.dodgeChance = Integer.parseInt(characterAttr[4]);
        //set hp
        this.hp = lvl*100;
    }

    //make it so the monster is on the same level as the highest level hero in the party
    //ex: Name/level/damage/defense/dodge chance
    //Desghidorrah	 3       300       400     35
    public void matchLevel(int newLvl){
        //balance creature to its new level
        int oldLvl = this.lvl;
        this.lvl = newLvl;
        this.hp = lvl*100;
        this.baseDMG = baseDMG/oldLvl * newLvl;
        this.defense = defense/oldLvl * newLvl;
    }

    //method to do the debuff from a spell
    public void spellDebuff(Spell spell){
        switch(spell.getSpellType()){
            case ICE: //do 10 percent dmg debuff
                this.baseDMG = this.baseDMG - (int)(this.baseDMG*.1);
                break;
            case FIRE: //do 10 percent defense debuff
                this.defense = this.defense - (int)(this.defense*.1);
                break;
            case LIGHTNING: //do 10 percent dodge chance debuff
                this.dodgeChance = this.dodgeChance - (int)(this.dodgeChance*.1);
                break;
        }

    }

    //method to calculate the amount of damage
    public int calcDmg(){
        return (int)(this.baseDMG *.15);
    }
    //method to calculate the dodge chance of the hero
    public int calcDodge(){
        return (int)(dodgeChance*.01);
    }
    //take damage and subtract defense
    public void takeDamage(int dmg){
        this.hp = this.hp - (dmg-(defense/100));
    }

    //setters / getters
	public int getBaseDMG() {
		return baseDMG;
	}

	public int getDefense() {
		return defense;
	}

	public int getDodgeChance() {
		return dodgeChance;
	}

	public void setBaseDMG(int baseDMG) {
		this.baseDMG = baseDMG;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setDodgeChance(int dodgeChance) {
		this.dodgeChance = dodgeChance;
	}

}
