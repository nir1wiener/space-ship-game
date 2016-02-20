import java.awt.Image;
import oop.ex2.*;

/**
 * @author nirwiener
 *this class is the father of all computer controlled ships 
 */
public abstract class ComputerTypeShips extends SpaceShip{
	
	protected final double SHIP_CLOSE = 0.2;
	protected final int NO_ANGLE = 0;
	protected final boolean ACCEL = true;
	
	public ComputerTypeShips(){}
	/**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
	public abstract void doAction(SpaceWars game);
	
	
	/**
	 * @return Image this method returns the current image of the spaceship.
	 */
	public Image getImage(){
		if(shipShieldOn)
			return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
		else
			return GameGUI.ENEMY_SPACESHIP_IMAGE;
	}


	protected int nextDiraction(SpaceShip enemyship){
		int turn = 0; 
		if(this.shipGameStatus.angleTo(enemyship.shipGameStatus) > NO_ANGLE){
			turn = SHIP_TURN_LEFT ;
		}else{
			turn = SHIP_TURN_RIGHT;
		}
		return turn;
			
	}
}
