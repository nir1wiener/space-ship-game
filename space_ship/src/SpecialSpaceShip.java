import oop.ex2.Physics;
import oop.ex2.SpaceShipPhysics;

/**
 * @author nirwiener
 * this is a special spaceship, aims towards the closest ship, 
 * shoots at it, and teleport in case the distance is greater than
 * 3 spaceships
 */

public class SpecialSpaceShip extends ComputerTypeShips{
	
	//define the distance from the closest spaceship to be teleported from	
	double teleportDistance = 3 * SpaceShipPhysics.RADIUS;
	private final int SPECIAL_ENERGY = 250;

	
	public SpecialSpaceShip() {}
			
	
	/**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
	public void doAction(SpaceWars game){
		updateShipStatus();
		//makes sure there's enough energy to shoot and to teleport
		this.shipEnergy = SPECIAL_ENERGY;
		
		//aims at the closest spaceship
		int turn;
		SpaceShip enemy = game.getClosestShipTo(this);
		Physics spacielShip = this.getPhysics();
		double distance = enemy.getPhysics().distanceFrom(spacielShip);
		double angle = this.shipGameStatus.angleTo(enemy.shipGameStatus);
		
		if(enemy.getPhysics().distanceFrom(this.shipGameStatus) <= SHIP_CLOSE){
			shieldOn();	
		}
		
		if(angle > NO_ANGLE){
			turn = SHIP_TURN_LEFT;
		
		}else{
			turn = SHIP_TURN_RIGHT;
		}
		
		this.shipGameStatus.move((!ACCEL), turn);
		
		if(distance > teleportDistance){
			teleport();
		}
		fire(game);
		
	}

}