
public class UFOEnemyShip extends EnemyShip {

	private String idCode="100";
	
	private String getPrivate()
	{
		return "How did you get this";
	}
	
	private String getOtherPrivate(int thisInt, String thatString)
	{
		return "How did you get here "+thisInt+" "+thatString;
	}
	
	public UFOEnemyShip(int number,String randString)
	{
		System.out.println("You sent: "+number+" "+randString);
	}
	
	EnemyShipFactory enemyShipFactory;
	
	public UFOEnemyShip(EnemyShipFactory shipPartsFactory) {
		// TODO Auto-generated constructor stub
		enemyShipFactory=shipPartsFactory;
	}

	@Override
	void makeShip() {
		// TODO Auto-generated method stub
		setName("UFO");
		System.out.println("Making enemy ship "+getName());
		weapon=enemyShipFactory.addESGun();
		engine=enemyShipFactory.addESEngine();
		
	}
	

}
