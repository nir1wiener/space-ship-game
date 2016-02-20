# space-ship-game
nir wiener


=============================
=  File description    =
=============================

SpaceShip.java - contain the main method of any kind of space ship that are in the game.
SpaceShipFactory.java - create the arry of ship that are playing the game.
Human.java - contain the sepcific method of an Human player and extend of SpaceShip.
ComputerTypeSpaceShip.java - this class is the father of all computer controlled ships extend the SpaceShip class.
Drunkard.java - implement the drunk class, extend of ComputerTypeSpaceShip.
Runner.java - implement the Runner class, extend of ComputerTypeSpaceShip.
Basher.java - implement the Basher class, extend of ComputerTypeSpaceShip.
Aggressive.java -  implement the Aggressive class, extend of ComputerTypeSpaceShip.


==================
=   Design     =
==================


I disgin my program in a way that all spaceships inherite from the abstract class SpaceShip,
that includes all the attributs a spaceship has, and methods that are mutual to all spaceships.
Than i  devided the spaceships to two groups: the ship that controlled by the computer controlled.when the computer controlled
spaceships inherit from an abstract subclass of SpaceShip called ComputertypeSpaceShips in order to prevent
code duplication because the image of a computer controlled spaceship is different than the human one.
and the Human space ship that inherit from the abstract class of SpaceShip


=============================
=  Implementation details =
=============================

SpaceWars game, for each diffrent spaceship there is a class represention. the 
spaceships  in the game fighting against each other.every time 
a spaceship gets hit with no shield the health and energy are being reduced
and when the space ship helth is reach 0 the ship is dead,and reset in a diff place.
the ship can fire a shot(cost 20 energy units), put shield on that prutect the ship from
coliiding and hiting by a shoot(cost 3 energy units),teleport to a random place(cost 150
energy units),and move.
evry space ship has a different game tactic:

Human:
    act according to the user chooice,in each turn can teleporte,move,fire,and put shiled on
    accordnig to her energy status.
        
Runner - try to avoide all the ship's that are in the game,don't do nothing else. 

Basher - try to bash the nearst space ship,when it comes close to a bash activiate the shild.

Aggressive - try to shot at the closest spaceship.

Drunken -  acts according to 3 random cases:
 1) teleports to a random place and activate the shield
 2) fire 3 times to somewhere
 3) do nothing
SpecialSpaceShip - this is a special spaceship, aims towards the closest ship, 
  shoots at it, and teleport in case the distance is greater than
  3 spaceships. 

