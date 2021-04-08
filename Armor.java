//Peter Gilbert
//CS611 Legends
//March 2021
//armor class for armor in an rpg
public class Armor extends RPGItem{
    private int dmgRed;
    public Armor(){
        super();
        dmgRed = 0;
    }

    //ex: Name/cost/required level/damage reduction
    //Platinum_Shield       150   1   200
    public void setAttributes(String input){
        //split by any amount of whitespace using regex sourced from: https://javarevisited.blogspot.com/2016/10/how-to-split-string-in-java-by-whitespace-or-tabs.html
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.cost = Integer.parseInt(characterAttr[1]);
        this.rqLvl = Integer.parseInt(characterAttr[2]);
        this.dmgRed = Integer.parseInt(characterAttr[3]);
    }

    //print weapon and info
    @Override
    public String toString(){
        String str = "";
        String spaces = "  ";
        str+=this.name+spaces;
        str+="Cost: "+ this.cost+spaces;
        str+="rqLVL: " + this.rqLvl+spaces;
        str+="dmgRed: " + this.dmgRed+spaces;
        return str;
    }

	public int getDmgRed() {
		return dmgRed;
	}

	public void setDmgRed(int dmgRed) {
		this.dmgRed = dmgRed;
	}
}
