//Peter Gilbert
//CS611 Legends
//March 2021
//RPGItem class for RPG games and their items
public class RPGItem{
    protected String name;
    protected int cost;
    protected int rqLvl; //required level
    //default constructor
    public RPGItem(){
        name = "";
    }

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getRqLvl() {
		return rqLvl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setRqLvl(int rqLvl) {
		this.rqLvl = rqLvl;
	}

}
