/**
 * @author nirwiener
 * the SpaceShipFactory  creates space ships in the game according to a list of strings it receives 
 * in the arguments
 */
public class SpaceShipFactory {
    
	/**
	 * create an arrys of the space ship in the game  
	 * @param args from the user
	 * @return the arrys of ship that in the game 
	 */
	public static SpaceShip[] createSpaceShips(String[] args) {
        	SpaceShip[] spaceShip = new SpaceShip[args.length];
        	//runs on all the array of strings and creates instances accordingly
        	// to the receive argument
        	for(int index = 0; index < args.length; index++){
        		switch(args[index]){
        		
        		case ("s"):
        			
        			spaceShip[index] = new SpecialSpaceShip();
        			break;  
        		
        		case ("h"):
        			
        			spaceShip[index] = new Human();
        			break;
        			
        		case ("r"):
        			
        			spaceShip[index] = new Runner();
        			break;
        			
        		case ("b"):
        			
        			spaceShip[index] = new Basher();
        			break;
        			
        		case ("a"):
        			
        			spaceShip[index] = new Aggressive();
        			break;
        			
        		case ("d"):
        			
        			spaceShip[index] = new Drunkard();
        			break;
            
  		
        		}
        	}
        return spaceShip;
    }
}