import java.awt.Image;
import oop.ex2.*;

/**
 * @author nirwiener
 * spaceShip class is the the most super class,that from her 
 * all the other spaceShip classes are inherit from it
 */
public abstract class SpaceShip{
	
	// set all the constant number
	private final int SHIP_INITIAL_HEALTH = 20;
	private final int SHIP_REDUCE_HELTH = 1;
	private final int SHIP_REDUCE_ENERGY = 10;
	private final int SHIP_EMPTY_HEALTH = 0;
	private final int SHIP_INITIAL_MAX_ENERGY = 200;
	private final int COLLIDE_ENERGY_ADD = 20;
	private final int TURN_ENERGY_ADD = 1;
	private final int FIRE_ENERGY_REDUCE = 20;
	private final int TELEPORT_ENERGY_REDUCE = 150;
	private final int SHIELD_ENERGY_REDUCE = 3;
	private final int SHIP_EMPTY_ENERGY = 0;
	private final int STRAT_FIRE_PAUSE = 0;
	private final int SHOTS_NUM_OF_TURNS_PAUSE = 8;
	protected final int SHIP_TURN_RIGHT = -1;
	protected final int SHIP_TURN_LEFT = 1;

	
	private int shipCanFire;
	private int shipHelth;
	private int shipMaxEnergy;
	protected int shipEnergy;
	protected boolean shipShieldOn;
	protected SpaceShipPhysics shipGameStatus;
   
	
	/**
	 * constructs a spaceship. That will be implemented in the son classes
	 */
	public SpaceShip(){
		
		this.shipGameStatus = new SpaceShipPhysics();
		this.shipHelth = SHIP_INITIAL_HEALTH ;
		this.shipEnergy = SHIP_INITIAL_MAX_ENERGY;
		this.shipMaxEnergy = SHIP_INITIAL_MAX_ENERGY;
		this.shipCanFire =  SHOTS_NUM_OF_TURNS_PAUSE;
	}
   

	/**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
    public abstract void doAction(SpaceWars game);
    	
    
    /*
     * This method is called every time a collision with this ship occurs 
     * and the ship shiled is off
     */
    private void reduceEnergyAndHelth(){
  		
    	this.shipHelth = Math.max((this.shipHelth - SHIP_REDUCE_HELTH),SHIP_EMPTY_HEALTH);
    	this.shipMaxEnergy = Math.max((this.shipMaxEnergy - SHIP_REDUCE_ENERGY),SHIP_EMPTY_ENERGY);
    	this.shipEnergy = Math.max((this.shipEnergy - SHIP_REDUCE_ENERGY),SHIP_EMPTY_ENERGY);
    }
    
    
    /**
     * This method is called every time a collision with this ship occurs 
     */
    public void collidedWithAnotherShip(){
    	
    	if (this.shipShieldOn == true){
    		this.shipMaxEnergy += COLLIDE_ENERGY_ADD;
    		this.shipEnergy = Math.min((this.shipEnergy+COLLIDE_ENERGY_ADD),this.shipMaxEnergy);
    	}else{
    		reduceEnergyAndHelth();
    	}

    }

    
    /** 
     * This method is called whenever a ship has died. It resets the ship's 
     * attributes, and starts it at a new random position.
     */
    public void reset(){
		// create a new ship with the initial data
    	// when the current ship is dead
    	this.shipGameStatus = new SpaceShipPhysics();
    	this.shipHelth = SHIP_INITIAL_HEALTH ;
    	this.shipEnergy = SHIP_INITIAL_MAX_ENERGY;
    	this.shipMaxEnergy = SHIP_INITIAL_MAX_ENERGY;
    	this.shipCanFire =  SHOTS_NUM_OF_TURNS_PAUSE;
    }

    
    /**
     * Checks if this ship is dead.
     * 
     * @return true if the ship is dead. false otherwise.
     */
    public boolean isDead() {
       
    	if (this.shipHelth == SHIP_EMPTY_HEALTH){
    		return true;
    	}else{
    	
    		return false;
    	}
    }

    
    /**
     * Gets the physics object that controls this ship.
     * 
     * @return the physics object that controls the ship.
     */
    public SpaceShipPhysics getPhysics() {
        
    	return this.shipGameStatus;
    }

    
    /**
     * This method is called by the SpaceWars game object when ever this ship
     * gets hit by a shot.
     */
    public void gotHit() {
    	
    	if (this.shipShieldOn == true){
    		return;
    	}else{
    		
    		reduceEnergyAndHelth();
     	}
    	
    }

    /**
     * Gets the image of this ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     * 
     * @return the image of this ship.
     */
    public abstract Image getImage();
     
    
    /**
     * Attempts to fire a shot.
     * 
     * @param game the game object.
     */
    public void fire(SpaceWars game) {
    	
    	if ((this.shipEnergy >= FIRE_ENERGY_REDUCE) && (this.shipCanFire >= SHOTS_NUM_OF_TURNS_PAUSE)){
    		
    		game.addShot(this.shipGameStatus);
    		this.shipEnergy -= FIRE_ENERGY_REDUCE;
    		this.shipCanFire  = STRAT_FIRE_PAUSE;
    	}
    }

    
    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {
    	
    	if (this.shipEnergy >= SHIELD_ENERGY_REDUCE){
    		this.shipEnergy -= SHIELD_ENERGY_REDUCE;
    		this.shipShieldOn = true;
    	}
        
    }
    

    /**
     * Attempts to teleport to a random place.
     */
    public void teleport() {
    	
    	if (this.shipEnergy >= TELEPORT_ENERGY_REDUCE){
    		this.shipEnergy -= TELEPORT_ENERGY_REDUCE;
    		this.shipGameStatus = new SpaceShipPhysics();
    	}
       
    }
   
    /**
     *initializing the variables according to the game rules  
     */
    protected void updateShipStatus(){
  
    	this.shipShieldOn = false;
    	if (this.shipCanFire <= SHOTS_NUM_OF_TURNS_PAUSE){
    		this.shipCanFire  ++;
    	}
    }
    
    /**
     * add energy to the ship total energy at the end of the turn
     */
    protected void updateShipEnergy(){
    	this.shipEnergy = Math.min((this.shipEnergy + TURN_ENERGY_ADD), this.shipMaxEnergy);
    }
    
}
