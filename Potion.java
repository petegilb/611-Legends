//Peter Gilbert
//CS611 Legends
//March 2021
//potion class for potions in an rpg game
public class Potion extends RPGItem{
    private int attInc; //attribute increase
    private String attrAff; //attribute affected
    public Potion(){
        super();
    }

    //Name/cost/required level/attribute increase/attribute affected
    //Healing_Potion  250     1   100		Health
    public void setAttributes(String input){
        //split by any amount of whitespace using regex sourced from: https://javarevisited.blogspot.com/2016/10/how-to-split-string-in-java-by-whitespace-or-tabs.html
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.cost = Integer.parseInt(characterAttr[1]);
        this.rqLvl = Integer.parseInt(characterAttr[2]);
        this.attInc = Integer.parseInt(characterAttr[3]);
        this.attrAff = characterAttr[4];

    }

    //print weapon and info
    @Override
    public String toString(){
        String str = "";
        String spaces = "  ";
        str+=this.name+spaces;
        str+="Cost: "+ this.cost+spaces;
        str+="rqLVL: " + this.rqLvl+spaces;
        str+="Potency: " + this.attInc+spaces;
        str+="Affinities: "+this.attrAff+spaces;
        return str;
    }

    //use a potion on the hero
    public void usePotion(Hero hero){
        String[] affs = attrAff.split("/");
        for(int x=0;x<affs.length;x++){
            switch(affs[x]){
                case "Health":
                    hero.setHp(hero.getHp()+attInc);
                    break;
                case "Mana":
                    hero.setMana(hero.getMana()+attInc);
                    break;
                case "Strength":
                    hero.setStrength(hero.getStrength()+attInc);
                    break;
                case "Dexterity":
                    hero.setDexterity(hero.getDexterity()+attInc);
                    break;
                case "Agility":
                    hero.setAgility(hero.getAgility()+attInc);
                    break;
                case "All":
                    hero.setHp(hero.getHp()+attInc);
                    hero.setMana(hero.getMana()+attInc);
                    hero.setStrength(hero.getStrength()+attInc);
                    hero.setDexterity(hero.getDexterity()+attInc);
                    hero.setAgility(hero.getAgility()+attInc);
                    break;
            }
        }

    }


	public int getAttInc() {
		return attInc;
	}

	public String getAttrAff() {
		return attrAff;
	}

	public void setAttInc(int attInc) {
		this.attInc = attInc;
	}

	public void setAttrAff(String attrAff) {
		this.attrAff = attrAff;
	}
}
