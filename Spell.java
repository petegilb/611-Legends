//Peter Gilbert
//CS611 Legends
//March 2021
//spell classes for each kind of spell
public class Spell extends RPGItem{
    private int dmg;
    private int manaCost;
    private Spells spellType;
    public Spell(){
        super();
    }

    //Name/cost/required level/damage/mana cost
    //Lightning_Dagger      400        1       500     150
    public void setAttributes(String input, Spells spellType){
        //split by any amount of whitespace using regex sourced from: https://javarevisited.blogspot.com/2016/10/how-to-split-string-in-java-by-whitespace-or-tabs.html
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.cost = Integer.parseInt(characterAttr[1]);
        this.rqLvl = Integer.parseInt(characterAttr[2]);
        this.dmg = Integer.parseInt(characterAttr[3]);
        this.manaCost = Integer.parseInt(characterAttr[4]);
        this.spellType = spellType;

    }

    //print weapon and info
    @Override
    public String toString(){
        String str = "";
        String spaces = "  ";
        str+=this.name+spaces;
        str+="Cost: "+ this.cost+spaces;
        str+="rqLVL: " + this.rqLvl+spaces;
        str+="DMG: " + this.dmg+spaces;
        str+="ManaCost: " + this.manaCost+spaces;
        return str;
    }

	public int getDmg() {
		return dmg;
	}

	public int getManaCost() {
		return manaCost;
	}

	public Spells getSpellType() {
		return spellType;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public void setSpellType(Spells spellType) {
		this.spellType = spellType;
	}

}
