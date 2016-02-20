/**
 * 
 * @author nirwiener
 * the Aggressive space ship shoots at the closest spaceship
 */

public class Aggressive extends ComputerTypeShips{
	
	
	public Aggressive(){}
	
	/**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
	public void doAction(SpaceWars game){
		
		updateShipStatus();
		int turn;
		
		SpaceShip shipToFireAt = game.getClosestShipTo(this);
		//aims to the closest spaceship
		turn = nextDiraction(shipToFireAt);
		shipGameStatus.move(ACCEL, turn);
		if(Math.abs(shipToFireAt.getPhysics().angleTo(this.shipGameStatus)) <= SHIP_CLOSE){
			fire(game);
		}
		updateShipEnergy();
	}
}
