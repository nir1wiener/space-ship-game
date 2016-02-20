import java.awt.Image;
import oop.ex2.*;

/**
 * @author nirwiene
 * the Human space ship performs all the actions 
 * according to the user choice
 */
public class Human extends SpaceShip{

	public Human(){}
	
	
	/**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
	public void doAction(SpaceWars game){
		
		updateShipStatus();
		int shipTurn = 0;
		boolean shipAccel = false;
		
		if (game.getGUI().isTeleportPressed()){
			teleport();
		}
		if (game.getGUI().isLeftPressed()){
			shipTurn  = SHIP_TURN_LEFT;
		}
		if (game.getGUI().isRightPressed()){
			shipTurn  = SHIP_TURN_RIGHT;
		}
		if (game.getGUI().isUpPressed()){
			shipAccel = true;
		}
		// update the ship move in the game
		this.shipGameStatus.move(shipAccel,shipTurn);
		if(game.getGUI().isShieldsPressed()){
			shieldOn();
		}
		if(game.getGUI().isShotPressed()){
			fire(game);
		}
		updateShipEnergy();

	}
	
	/**
	 * @return Image the image of the spaceship at a given moment 
	 */
	public Image getImage(){
		if(this.shipShieldOn){
			return GameGUI.SPACESHIP_IMAGE_SHIELD;
		}
		return GameGUI.SPACESHIP_IMAGE;
	}
}
