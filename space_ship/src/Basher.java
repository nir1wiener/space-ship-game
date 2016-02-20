/**
 * 
 * @author nirwiener
 * the Basher space ship try to collide at the closest spaceship
 */
public class Basher extends ComputerTypeShips{
	
	public Basher(){}
	
	
	/**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
	public void doAction(SpaceWars game){
		
		updateShipStatus();
		int turn;
		SpaceShip shipToBash = game.getClosestShipTo(this);
		
		if(Math.abs(shipToBash.getPhysics().distanceFrom(this.shipGameStatus)) <= SHIP_CLOSE){
			shieldOn();	
		}
		turn = nextDiraction(shipToBash);
		this.shipGameStatus.move(ACCEL, turn);
		updateShipEnergy();
	}
}
