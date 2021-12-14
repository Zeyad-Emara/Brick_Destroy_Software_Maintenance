# Software Maintenance Coursework

Done by Zeyad Hesham Emara 20215171
Original game [Brick Destroy game by FilippoRanza](https://github.com/FilippoRanza/Brick_Destroy).

Welcome to Brick_Destroy a very famous arcade video game.

Your goal is to destroy a wall of bricks by deflecting a ball.
The game's controls are:

SPACE start/pause the game
A move left the player
D move right the player
ESC enter/exit pause menu
ALT+SHIFT+F1 open console

#Game Maintenance

-Separate the classes into 6 meaningful packages depending on each class's function and its relation with other classes.
-Extracted the Crack subclass from the Brick class and made it an independant class to fulfill single responsibility principle.
-Extracted the methods necessary for level generation from the Wall class and have created a new class called LevelGenerator to handle level generation so it adheres to SOLID design.
-Encapsulated the public variables in all classes thus preventing unauthorized classes from having direct access to them, and incorporated getters and setter methods for the attributes to allow control over their values.
-Removed unused and unnecessary attributes and methods such as name variable in Brick class, crack sections and jump probability variables and their associated methods from Crack class, 
random inbounds in middle jumps methods were also removed from Crack class as they were useless and several other editions. 
-Added Javadocs documentation.
-Made Class Diagram.

#Extension and Additions 

-Increased menu font size and main menu background color.
-Increased ball speed and made it constant (not random) to make the game more action packed and fast paced.
-Increased player movement speed to be in line with ball's increased speed.
-Added Diamond brick stronger than steel.
-Added Obsidian brick stronger than diamond.
-Added 4 more levels with increasing difficulty incorporating the new diamond and obsidian bricks.
-Added score system and score display when round ends and saves score in txt file.

