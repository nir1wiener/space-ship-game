import java.util.Random;

/**
 * 
 * @author nirwiener
 *this is a drunk spaceship, that acts according to 3 random cases:
 *1) teleports to a random place and activate the shield
 *2) fire 3 times to somewhere
 *3) do nothing
 */
public class Drunkard extends ComputerTypeShips{


	Random randomMove;

	/**
	 * constructs a  drunkard spaceship.
	 */
	public Drunkard() {
		
		randomMove = new Random();
		
	}
	
	
	/**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
	public void doAction(SpaceWars game){
		//get a random number and act according
		int randomTurn = randomMove.nextInt((3*SHIP_TURN_LEFT)) + (SHIP_TURN_RIGHT);
		
		updateShipStatus();
		switch (randomTurn){
			case (NO_ANGLE):
				
				teleport();
			    this.shipGameStatus.move(ACCEL,SHIP_TURN_LEFT);
				shieldOn();
				break;
			
			case (SHIP_TURN_RIGHT):
				 
				this.shipGameStatus.move((!ACCEL),NO_ANGLE);
				fire(game);
				break;
				
			case (SHIP_TURN_LEFT):
				
				this.shipGameStatus.move(ACCEL,SHIP_TURN_RIGHT);
				break;
		}
		updateShipEnergy();	
	}
}
