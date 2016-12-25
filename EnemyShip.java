
public abstract class EnemyShip {

	private String name;
	ESWeapon weapon;
	ESEngine engine;
	
	
	abstract void makeShip();

	public void displayEnemyShip() {
		// TODO Auto-generated method stub
		
	}

	public void followHeroShip() {
		// TODO Auto-generated method stub
		
	}

	public void enemyShipShoots() {
		// TODO Auto-generated method stub
		
	}
	public String toString()
	{
		return "The "+name+" has a top speed of "+engine+" and an attack power of "+weapon;
	}
	
	public void setName(String string) {
		// TODO Auto-generated method stub
		this.name=string;
	}
	public String getName()
	{
		return name;
	}

}
