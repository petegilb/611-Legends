//Peter Gilbert
//CS611 Legends
//March 2021
//weapon class for weapons in an rpg
public class Weapon extends RPGItem{
    private int dmg;
    private int rqHands;
    public Weapon(){
        super();
        dmg = 0;
    }
    //ex: Name/cost/level/damage/required hands
    //Sword           500     1    800    1
    public void setAttributes(String input){
        //split by any amount of whitespace using regex sourced from: https://javarevisited.blogspot.com/2016/10/how-to-split-string-in-java-by-whitespace-or-tabs.html
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.cost = Integer.parseInt(characterAttr[1]);
        this.rqLvl = Integer.parseInt(characterAttr[2]);
        this.dmg = Integer.parseInt(characterAttr[3]);
        this.rqHands = Integer.parseInt(characterAttr[4]);

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
        str+="rqHANDS: " + this.rqHands+spaces;
        return str;
    }


	public int getDmg() {
		return dmg;
	}

	public int getRqHands() {
		return rqHands;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public void setRqHands(int rqHands) {
		this.rqHands = rqHands;
	}
}
