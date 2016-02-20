/**
 * @author nirwiener
 * the Runner spaceship tries to avoid
 * contact with all other spaceships by turning against their 
 * direction and teleporting when they're close.
 */
public class Runner extends ComputerTypeShips{

	
	
	public Runner(){}
	
	
	/**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
	public void doAction(SpaceWars game){
		

		SpaceShip shipToRunFrom = game.getClosestShipTo(this);
		if ((Math.abs(shipToRunFrom.getPhysics().distanceFrom(this.shipGameStatus)) <= SHIP_CLOSE) &&
						(Math.abs(shipToRunFrom.getPhysics().angleTo(this.shipGameStatus)) <= SHIP_CLOSE)){
			teleport();
			shipToRunFrom = game.getClosestShipTo(this);
		}
		
		if (shipToRunFrom.getPhysics().angleTo(this.shipGameStatus) <= NO_ANGLE ) {
			this.shipGameStatus.move(ACCEL,SHIP_TURN_LEFT);
		
		}else{
			this.shipGameStatus.move(ACCEL,SHIP_TURN_RIGHT );
		}

		updateShipEnergy();
	}
	
}
