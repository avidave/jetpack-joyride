# Welcome to Jetpack Joyride

This program is based off a popular mobile game called Jetpack Joyride, and jointly developed with Samir Harrinanan. 

# Goal: The goal of the game is to travel the greatest distance possible
 
##  Controls: 
   The only control to play the game is the up arrow-key (Key_Event.VK_UP) used to control the jetpack on the player.
   When pressed, the player will launch up, and when released, the player will fall back down to the ground.
  
##  Obstacles: 
   The game will have two different types of obstacles the player will have to avoid: Lasers and Missiles
   - Lasers: There are 4 different types of lasers; vertical, horizontal, and two diagonal. If the player collides with them, it is game over.
    The lasers will only generate one at a time. The lasers will spawn at a random y-positions.
   - Missiles: There will be 3 missiles that spawn every ten seconds at random y-positions in the game. 
    They are much smaller than lasers, however they can also be harder to avoid.
  
##  Gameplay: 
   When the user opens up the game, the user will have to enter their age and chosen name. Then the user will be greeted by the main menu, with three
   options: "Play", "Skin Locker", "Change Name", and "Exit". "Skin Locker" will allow the user to choose any of three different skins for the player, as
   well as a random skin option. "Change Name" will allow the user to change their name, or randomly generate a new name. "Exit" will allow the user to exit 
   the game, ending the program. "Play" will begin the game.
  
   When "Play" is clicked, the user will be able to control the character after a countdown leading up to the start of the game. As the user plays the game, the
   speed of the lasers, missiles, and background will slowly increase every ten seconds, increasing the difficulty overall. After the player eventually dies, the
   user is greeted by a death screen (courtesy of Dark Souls), which will display the total distance travelled by the player. Their will be four buttons the user 
   can click to return to the main menu. Each button will change the colour of the main menu settings menu different colour.
  
# Program Details: 
 
  When the program runs the main method, it calls on the constructor which makes the poster visible for 2s and then initializes all the other variables. The constructor
  then calls on the Menu method which, on the first time it is run, asks the user for their age and name. Then if the user enters valid answers they will be brought to the
  main menu. Otherwise, if they do not put valid entries, they will have to try again, or they can choose to close the program. In the main menu, there are five buttons
  that the user can press including, Play, Skin Locker, Change Name, Exit, and the close (X) button. The Skin Locker and Change Name buttons have similar decision making
  structures because they both ask the user for input, then if the input is valid they will proceed back to the main menu, otherwise, they will have to try again or they can
  press cancel or close to go back to the main menu with their previous skin choice or name. The Exit button is a more aesthetic way to close the program although the close
  (X) button essentially does the same thing, they both prompt the user with a confirmation that they still want to exit the game. Next, the Play button takes the user to a
  JFrame to play the game. The game uses timers and key events to move the player and the objects around it like the background, distance, lasers, and missiles. The x and y 
  positions of each moving object that were calculated are then used to draw them in the paint method on to the JFrame. In the object timer, the collision with the player and 
  obstacles are checked. If a collision is detected, it will start a timer that stops the movement of objects and changes the player's skin into a blood splat for about a second 
  and then calls on the Collision method. This method hides the JFrame, resets the player's skin and the variables that were used to play, and sets up and opens a JOptionPane. 
  This screen tells the user that the player has died and shows the distance they travelled in that run. The buttons do nothing but change the background colour according to 
  which button was clicked and no matter what, it will call on the Menu method. The second time the player is brought to the menu, they will not need to enter their age nor a
  name, however, they can choose to change their name and skin, play the game again, or they can choose to exit the game.
  
## Jetpack (Main Class): 
   This is the main class of the program. This class handles the structure of the program. It uses both the LaserGen and MissileGen classes in order to construct the Jetpack
   game.
 
   Methods:
   
    Main Method & Jetpack Constructor: Only used to call the constructor (which starts the program, and sets up the default values).
   
    KeyTyped: This is an unused method.
    KeyPressed: This method sets up the jetpack code for when the up-arrow key is pressed.
    KeyReleased: This causes the player to fall back down to the ground due to gravity.
   
 
    actionPerformed: This is the method that holds the code for the timers.
    objTimer: Handles collisions, the in-game physics for the jetpack, and the movement of the jetpack, obstacles, and background.
    incrTimer: Slowly increases the speed of the obstacles and background and sets and resets the missiles.
    distTimer: Measures the distance the player "travels".
    countTimer: Is used to display the countdown before the gameplay begins.
    bldTimer: Displays the blood splatter as a result of collision with an obstacle.
    
    paint: This method draws and updates the images, masks etc. throughout the game. It paints the lasers, missiles, player, background, ceiling border, distance,
     countdown, and blood splatter.
    
    Menu: This method holds the code for the menu. The menu and its various parts are in while loops and contain try-catch statements for handling input and setting 
     the various options available to the player. That code runs if showMenu is true. If showMenu is false, various code runs to begin the actual game.
    
    Collision: This code runs when the a collision occurs, after the bldTimer has stopped. It resets the variables in case the user wants to continue running and using
     the program. It also displays the "You Died" game over screen, and shows the distance travelled, along with the options to change the colour of the menus.
    
## LaserGen: 
   This class sets up and generates the random lasers that spawn in front of the player. It controls the mask of the vertical and horizontal lasers, the 
   images of all the lasers, and the random y position of the spawned laser. It includes methods to retreive those variables to paint them in the Jetpack class.
  
   Methods:
   
    Constructor LaserGen: Initializes variables.
    setLaser: This method sets up the laser by randomizing the y position and the direction of the laser.
    getLaser: Returns laser image.
    getXLaser: Returns x position of the laser.
    getYLaser: Returns y positions of the laser.
    getMask: Returns the lasers mask.
    getDir: Returns the direction of the laser.
 
## MissileGen: 
   This class contains code to set up and generate missiles as an obstacle in the game. It is mostly used to get the various values of the private variables 
   in the class.
 
   Methods: 
   
    Constructor MissileGen: Initializes variables.
    setMissiles: Randomizes the start y position of the missiles, the speed of the missile and resets the x position to the right side of the screen.
    getXMis: Returns x position of missile.
    getYMis Returns y position of missile.
    getSpeedX: Returns the randomized speed value for the x-position of the missile.
    getMisMask: Returns the missile mask.
    getMissiles: Returns missile image.
    setYMis: Allows reset of the y position of the missile.
   
  UIManager: UIManager.put() is used to make the menus look better. It sets the specified colour as the default in the
   Panel and JOptionPanes. This method is used multiple times in the code.
 
  BorderLayout: BorderLayout is used to make more structured and organized use of multiple JLabels inside a JPanel in a few of the JOptionPane prompts. This
   makes the menus look more professional, and in the case of the "Skin Lock" dialog, allows the user to see the various skins available.
  
  JLabel: The JLabel is used to add the ImageIcons and text to the JPanel.

# What you see in-game

## Welcome Screen
This window pops up for a couple seconds before any of the game prompts.

<img alt="Welcome Screen" src="https://github.com/avidave/jetpack-joyride/blob/master/JetpackJoyrideCPT-Main/images/screenshots/Welcome_screen.png">

## Age Screen
This window prompts the user for their age (any age above or below a certain range will barr access to the rest of the game, or ask the user to renenter their age).

<img alt="Age Screen" src="https://github.com/avidave/jetpack-joyride/blob/master/JetpackJoyrideCPT-Main/images/screenshots/Age_screen.png">

## Name Screen

This window asks the user for a username - this username will be used during a **Game Over** prompt to display the player's high score.

<img alt="Username" src="https://github.com/avidave/jetpack-joyride/blob/master/JetpackJoyrideCPT-Main/images/screenshots/Username.png">

## Main Menu

This is the **Main Menu** of the game. You can immediately play the game, change the player costume (to something other than the default costume), change your name, or exit the game.

<img alt="Main Menu" src="https://github.com/avidave/jetpack-joyride/blob/master/JetpackJoyrideCPT-Main/images/screenshots/Main_menu.png">

## Skin Locker

This is the aforementioned prompt that allows the user to change the player costume.

<img alt="Skin Locker" src="https://github.com/avidave/jetpack-joyride/blob/master/JetpackJoyrideCPT-Main/images/screenshots/Skin_locker.png">

## Gameplay

<img alt="Gameplay" src="https://github.com/avidave/jetpack-joyride/blob/master/JetpackJoyrideCPT-Main/images/screenshots/Gameplay.png">

## Game Over

The **Game Over** window displays the user's high score (through distance travelled) and allows the user to exit the window and return to the main menu by clicking one of the four options. Each options will change the background colour of the **Main Menu**.

<img alt="Game Over" src="https://github.com/avidave/jetpack-joyride/blob/master/JetpackJoyrideCPT-Main/images/screenshots/Game_over.png">
