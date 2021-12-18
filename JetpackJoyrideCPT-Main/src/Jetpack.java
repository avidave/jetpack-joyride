/* ICS3U1 CPT: Jetpack Joyride
 * January 28, 2021
 * By Samir Harrinanan & Avi Dave
 * Mr. Conway
 * 
 * PROGRAM DESCRIPTION: The program is based off a game called Jetpack Joyride by Halfbrick Studios.
 * 
 *  Goal: The goal of the game is to travel the greatest distance possible
 * 
 *  Controls: The only control to play the game is the up arrow-key (Key_Event.VK_UP) used to control the jetpack on the player.
 *   When pressed, the player will launch up, and when released, the player will fall back down to the ground.
 *  
 *  Obstacles: The game will have two different types of obstacles the player will have to avoid: Lasers and Missiles
 *   Lasers: There are 4 different types of lasers; vertical, horizontal, and two diagonal. If the player collides with them, it is game over.
 *    The lasers will only generate one at a time. The lasers will spawn at random y-positions.
 *   
 *   Missiles: There will be 3 missiles that spawn every ten seconds at random y-positions in the game. 
 *    They are much smaller than lasers, however, they can also be harder to avoid.
 *  
 *  Gameplay: When the user opens up the game, the user will have to enter their age and chosen name. Then the user will be greeted by the main menu, with three
 *   options: "Play", "Skin Locker", "Change Name", and "Exit". "Skin Locker" will allow the user to choose any of three different skins for the player, as
 *   well as a random skin option. "Change Name" will allow the user to change their name, or randomly generate a new name. "Exit" will allow the user to exit 
 *   the game, ending the program. "Play" will begin the game.
 *  
 *  When "Play" is clicked, the user will be able to control the character after a countdown leading up to the start of the game. As the user plays the game, the
 *   speed of the lasers, missiles, and background will slowly increase every ten seconds, increasing the difficulty overall. After the player eventually dies, the
 *   user is greeted by a death screen (courtesy of Dark Souls), which will display the total distance travelled by the player. There will be four buttons the user 
 *   can click to return to the main menu. Each button will change the colour of the main menu settings menu different colour.
 *  
 * PROGRAM DETAILS: 
 * 
 *  When the program runs the main method, it calls on the constructor which makes the poster visible for 2s and then initializes all the other variables. The constructor
 *   then calls on the Menu method which, on the first time it is run, asks the user for their age and name. Then if the user enters valid answers they will be brought to the
 *   main menu. Otherwise, if they do not put valid entries, they will have to try again, or they can choose to close the program. In the main menu, there are five buttons
 *   that the user can press including, Play, Skin Locker, Change Name, Exit, and the close (X) button. The Skin Locker and Change Name buttons have similar decision making
 *   structures because they both ask the user for input, then if the input is valid they will proceed back to the main menu, otherwise, they will have to try again or they can
 *   press cancels or close to go back to the main menu with their previous skin choice or name. The Exit button is a more aesthetic way to close the program although the close
 *   (X) button essentially does the same thing, they both prompt the user with a confirmation that they still want to exit the game. Next, the Play button takes the user to a
 *   JFrame to play the game. The game uses timers and key events to move the player and the objects around it like the background, distance, lasers, and missiles. The x and y 
 *   positions of each moving object that were calculated are then used to draw them in the paint method on to the JFrame. In the object timer, the collision with the player and 
 *   obstacles are checked. If a collision is detected, it will start a timer that stops the movement of objects and changes the player's skin into a blood splat for about a second 
 *   and then calls on the Collision method. This method hides the JFrame, resets the player's skin and the variables that were used to play, and sets up and opens a JOptionPane. 
 *   This screen tells the user that the player has died and shows the distance they travelled in that run. The buttons do nothing but change the background colour according to 
 *   which button was clicked and no matter what, it will call on the Menu method. The second time the player is brought to the menu, they will not need to enter their age nor a name, 
 *   however, they can choose to change their name and skin, play the game again, or they can choose to exit the game.
 *  
 *  IF STATEMENTS: There are many if-statements in the game. They make sure that certain code only runs when certain conditions are met. For example, in the ActionPerformed method (lines 526 - 539) in 
 *   the Jetpack class, there is a condition that runs at intervals set by the incrTimer. This means that the condition will only run once every ten seconds, as specified by the Timer. Inside 
 *   of the statement, a part of the code increments the xLaserSpeed by the constant value XINCR, thereby increasing the speed of the obstacles in the game by a constant amount every ten seconds. This is 
 *   important, since it increases the difficulty of the game over time.
 *  
 *  WHILE LOOPS: These are used throughout the program to repeat pieces of code until the condition is false. An example of a while loop in the program is in the Menu
 *   method (lines 690-730), the condition of the while loop is !valid and !ageAsked. These two variables are important because it tells the program to move on to the next set of code when the user
 *   inputs valid entries. For example, when the program asks the user for their age, the user will not be able to move on to the next question until they enter an age from 11 to 117,
 *   which then makes the valid condition true. Then after the while loop is over, ageAsked will be set to true so that the user only has to type their age once. After when the Menu 
 *   method is called again it skips those questions.
 *  
 *  DO-WHILE LOOP: This loop is used once in the program for the main menu. The do-while loop is guaranteed to run at least once, no matter the condition. It is used for the main menu, 
 *   since it should run at least once during the program. it uses the showMenu variable to activate the menu. The menu needs to repeat since the user will come back to it often from 
 *   playing the game, changing the settings, etc.
 *  
 *  FOR LOOPS: These loops are used a couple of times in the program, mostly to deal with arrays. For loops allow you to set a fixed number of iterations of specific code. As a result,
 *   it is often used in the program to get rid of needless repetition of code. In one case in ActionPerformed in incrTimer (lines 526 - 539), it is used to set up the three missile objects
 *   from the missiles array (an array that holds MissileGen objects). This allows for the values of the missiles to be set without having to repeat the code three times. They are important
 *   because they help compact repetitive code in the program.
 *  
 *  TRY-CATCH STATEMENTS: These are used throughout the program for pausing the game for a certain number of milliseconds and for confirming that the user's input is valid. For example in
 *   in the Menu method (lines 703-713), we ask the user for their age, it is stored as a string initially but we need to parse it to an integer to check if their age is between 11 and 117. 
 *   Therefore, we parse the integer in a try-catch statement and if there is an error when parsing the integer, this means that the age the user entered was not valid to be an age. 
 *   When it catches the error we can then output an error message telling the user that their entry was not valid, and they need to try again. This is important because we need to verify
 *   their age to play the game because of the moderate gore.
 *  
 *  
 *  STRING METHODS: These are used in the program when it is taking input from the user. They help manipulate Strings to match valid input, which can help personalize the settings of the 
 *   game to the user's preferences. As a result, most of the String methods are used in the Menu method. In the Skin Locker dialogue, skinChoice takes a String value. The String method matches()
 *   is uses regular expressions to check whether the input fits the criteria in the matches method argument. In this case, it makes sure that the user entered 1, 2, or 3 so that it can set the
 *   Skin (line 823).
 *  
 *  JOptionPane DIALOGS: These are used throughout the program to inform the user of something with dialogue and images, and to receive input from either an inputDialog (text box) or buttons.
 *   An example of this being used is in the Collision method (line 990) where it informs of the distance they travelled before they died. The dialogue will change based on the user's name and the 
 *   distance they travelled. The button the user presses determines the background colour. Each button gives a different number value to the variable the JOptionPane was stored in. This 
 *   is important because it allows the program to make each button correlate with a colour. We also customized these with the UIManager, BorderLayout, and JLabel.
 *  
 * Jetpack (Main Class): This is the main class of the program. This class handles the structure of the program. It uses both the LaserGen and MissileGen classes to 
 * construct the Jetpack game.
 * 
 *   METHODS:
 *   
 *    Main Method & Jetpack Constructor: Only used to call the constructor (which starts the program, and sets up the default values).
 *   
 *    KeyTyped: This is an unused method.
 *    KeyPressed: This method sets up the jetpack code for when the up-arrow key is pressed.
 *    KeyReleased: This causes the player to fall back down to the ground due to gravity.
 *   
 *    actionPerformed: This is the method that holds the code for the timers.
 *    objTimer: Handles collisions, the in-game physics for the jetpack, and the movement of the jetpack, obstacles, and background.
 *    incrTimer: Slowly increases the speed of the obstacles and background and sets and resets the missiles.
 *    distTimer: Measures the distance the player "travels".
 *    countTimer: This is used to display the countdown before the gameplay begins.
 *    bldTimer: Displays the blood splatter as a result of a collision with an obstacle.
 *    
 *    paint: This method draws and updates the images, masks etc. throughout the game. It paints the lasers, missiles, player, background, ceiling border, distance,
 *     countdown, and blood splatter.
 *    
 *    Menu: This method holds the code for the menu. The menu and its various parts are in while loops and contain try-catch statements for handling input and setting 
 *     the various options available to the player. That code runs if showMenu is true. If showMenu is false, various code runs to begin the actual game.
 *    
 *    Collision: This code runs when a collision occurs after the bldTimer has stopped. It resets the variables in case the user wants to continue running and using
 *     the program. It also displays the "You Died" game over screen and shows the distance travelled, along with the options to change the colour of the menus.
 *    
 * LaserGen: This class sets up and generates the random lasers that spawn in front of the player. It controls the mask of the vertical and horizontal lasers, the 
 * images of all the lasers, and the random y position of the spawned laser. It includes methods to retrieve those variables to paint them in the Jetpack class.
 *  
 *   Methods:
 *   
 *    Constructor LaserGen: Initializes variables.
 *    setLaser: This method sets up the laser by randomizing the y position and the direction of the laser.
 *    getLaser: Returns laser image.
 *    getXLaser: Returns x position of the laser.
 *    getYLaser: Returns y positions of the laser.
 *    getMask: Returns the lasers mask.
 *    getDir: Returns the direction of the laser.
 * 
 *  MissileGen: This class contains code to set up and generate missiles as an obstacle in the game. It is mostly used to get the various values of the private variables 
 *   in the class.
 * 
 *   Methods: 
 *   
 *    Constructor MissileGen: Initializes variables.
 *    setMissiles: Randomizes the start y position of the missiles, the speed of the missile and resets the x position to the right side of the screen.
 *    getXMis: Returns x position of missile.
 *    getYMis Returns y position of missile.
 *    getSpeedX: Returns the randomized speed value for the x-position of the missile.
 *    getMisMask: Returns the missile mask.
 *    getMissiles: Returns missile image.
 *    setYMis: Allows reset of the y position of the missile.
 *    
 *    <EXTRA CONCEPTS>
 *  UIManager: UIManager.put() is used to make the menus look better. It sets the specified colour as the default in the
 *   Panel and JOptionPanes. This method is used multiple times in the code.
 * 
 *  BorderLayout: BorderLayout is used to make more structured and organized use of multiple JLabels inside a JPanel in a few of the JOptionPane prompts. This
 *   makes the menus look more professional, and in the case of the "Skin Lock" dialogue, allows the user to see the various skins available.
 *  
 *  JLabel: The JLabel is used to add the ImageIcons and text to the JPanel.
 * 
 */

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Jetpack extends JPanel implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	// Declaring global variables
	
	// Integers that store x and y positions of objects, number of metres, choices, counts, etc. (choice = the option they choose in the menu), (xBack1/xBack2 = x-position of background images),
	//  (rndChoice = random skin choice)
	private int yPosRound, move, xPos, xLaserSpeed, xLaser, xMis, choice, metres, xBack1, xBack2, rndChoice, age, sec, countSec;
	// Decimals that store exact y positions of objects, exact distance, and gravity
	private double grav, ySpeed, yPos, distance;
	// Integers that remain the same for the whole game
	private final int WIDTH = 1600, HEIGHT = 800, XINCR = 2;
	// JFrame object
	private JFrame frame;
	// Timers for the game
	private Timer objTimer, incrTimer, distTimer, countTimer, bldTimer;
	// ImageIcons for objects and background
	private ImageIcon imgPlayer, imgPlayerNB, imgPoster, imgBack, imgBlood, imgMis;
	// LaserGen object
	private LaserGen lg;
	// Booleans to check if a statement is true or false (passed = if the laser passed the left side of the screen)
	private boolean passed, showMenu, showPoster, nameAsked, ageAsked, countdown;
	// Rectangles for the laser and player masks
	private Rectangle2D lsrMask, plrMask;
	// Player skins ImageIcon array - with and without jetpack boost (no boost)
	private final ImageIcon[] skins = {new ImageIcon("images//player//1boost.png"), new ImageIcon("images//player//2boost.png"), new ImageIcon("images//player//3boost.png")};
	private final ImageIcon[] skinsNB = {new ImageIcon("images//player//1noboost.png"), new ImageIcon("images//player//2noboost.png"), new ImageIcon("images//player//3noboost.png")};
	// Strings to save user input for name and skin choice
	private String name, skinChoice, prevName, prevSkin;
	// Font variables
	private Font f;
	private FontMetrics fm;
	// MissileGen object and missile mask arrays
	private final MissileGen[] missiles = new MissileGen[] {new MissileGen(), new MissileGen(), new MissileGen()};
	private final Rectangle2D[] misMasks = new Rectangle2D[] {missiles[0].getMisMask(), missiles[1].getMisMask(), missiles[2].getMisMask()};
	
	// The main method
	public static void main(String[] args) {
		// Running the constructor
		new Jetpack();
	}

	public Jetpack() {
		
		// Show the poster at the beginning of the game
		
		showPoster = true;
		showMenu = false;
		
		// New JFrame
		frame = new JFrame();
		
		// Default name
		name = "Bob";
		
		// Poster ImageIcon
		imgPoster = new ImageIcon("images//Jetpack_Joyride_Logo.png");
		
		// Setting up the JFrame for the poster
		frame.setSize(500, 630);
		frame.setContentPane(this);
		frame.setTitle("Jetpack Joyride!");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// Pause to display the poster for 2s
		try
		{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		
		// Setting the JFrame to invisible and initializing booleans
		frame.setVisible(false);
		showPoster = false;
		showMenu = true;
		nameAsked = false;
		ageAsked = false;
		passed = true;
		countdown = false;
		
		// Initializes timers
		objTimer = new Timer(16, this);
		incrTimer = new Timer(10000, this);
		distTimer = new Timer(100, this);
		countTimer = new Timer(800, this);
		bldTimer = new Timer(10, this);
		
		// Initializing laser generator object
		lg = new LaserGen();
		
		// Initializing the font
		f = new Font("Helvetica", Font.BOLD, 45);
		fm = getFontMetrics(f);
		
		// Initial variable values in the constructor
		lsrMask = new Rectangle2D.Double(0, 0, 0, 0);
		plrMask = new Rectangle2D.Double(0, 0, 0, 0);
		yPos = 500;
		xPos = 200;
		yPosRound = 500;
		grav = 0.6;
		ySpeed = 0;
		xLaserSpeed = 10;
		metres = 0;
		distance = 0;
		move = -1;
		xLaser = 0;
		xMis = -100;
		xBack1 = 0;
		xBack2 = 0;
		skinChoice = "1";
		age = 0;
		sec = 100;
		countSec = 4;
		
		// Initializing ImageIcons
		imgPlayer = new ImageIcon("images//player//1boost.png");
		imgPlayerNB = new ImageIcon("images//player//1noboost.png");
		imgBack = new ImageIcon("images//background.jpg");
		imgBlood = new ImageIcon("images//blood splat.png");
		imgMis = new ImageIcon("images//missile.png");
		
		// Setting up key-listeners
		setLayout(null);
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		
		// Setting the default OptionPane and Panel background colors as orange
		UIManager.put("OptionPane.background", Color.ORANGE);
		UIManager.put("Panel.background", Color.ORANGE);
		
		// Calls the code for the menu
		Menu();
	}

	// We don't use the keyTyped() in this program
	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		
		// If condition that checks if the up arrow button is pressed set move to 1 (up)
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			move = 1;
		}
	}

	public void keyReleased(KeyEvent e) {
		
		// If a key is released move is set to -1 (down -> gravity)
		move = -1;
	}

	public void actionPerformed(ActionEvent e) {
		
		// Timer that works with objects and collision code
		if(e.getSource() == objTimer)
		{
			
			// Code that controls gravity and the players movements
			/*
			 * move =-1 >Player is falling
			 *      = 0 >Player is on the ground
			 *      = 1 >Player is using the jetpack
			 *      = 2 >Player is using the jetpack on the ceiling
			 */
			
			// If player is at ground level
			if(yPosRound >= 721 - imgPlayer.getIconHeight())
			{
				move = 0;
			}
						
			// If player is passing the boundaries of the ceiling
			if(yPosRound <= 50 && move != -1)
			{
				move = 2;
			}
			
			// If move = -1 and they are within the boundries of the room then gravity will be in effect
			if(move == -1 && yPosRound < 720 - imgPlayer.getIconHeight() && yPosRound > 49)
			{
				// Gravity strength
				grav = 0.6;
				
				// If the player is using the jetpack and they are within the boundries of the room then the jetpack will be in effect
			} else if (move == 1 && yPosRound < 721 - imgPlayer.getIconHeight() && yPosRound > 50)
			{
				// Jetpack strength against gravity
				grav = -0.6;
				
				// If the player hits the ground they will be kept above it
			} else if (move == 0)
			{
				// Stopping gravity and the player's ySpeed, and setting their position above the ground
				yPos = 720 - imgPlayer.getIconHeight();
				grav = 0;
				ySpeed = 0;
				
				// 'move' has to equal 2 here, which means the player is at the ceiling
			} else if(yPosRound < 49)
			{
				// Again, stopping the player
				yPos = 50;
				grav = 0;
				ySpeed = 0;
			}
			// To have acceleration when falling and using the jetpack
			ySpeed += grav;
			yPos += ySpeed;
			
			yPosRound = (int)Math.round(yPos);
			
			// Code that checks for collision with lasers
			
			/*
			 * lg.getDir = 1> __
			 *           = 2> /
			 *           = 3> |
			 *           = 4> \
			 *           
			 */
			
			// If the laser is horizontal or vertical,
			if (lg.getDir() == 1 || lg.getDir() == 3) 
			{
				
				// If the laser passed the boundaries on the left side, reset laser
				if (passed == true) 
				{
					// Calls on the setLaser method which randomly sets the laser and gets the mask according to the random one it chose
					xLaser = 1500; 
					lg.setLaser();
					lsrMask = lg.getMask();
					passed = false;
				}
				
				// When the player mask intersects with the laser mask, then start bldTimer
				if (plrMask.intersects(lsrMask)) 
				{
					bldTimer.start();
				}
				
				// If the laser goes off the screen to the left it will set passed to true
				if (xLaser + lsrMask.getWidth() <= 0) 
				{
					passed = true;
				}
				
			// If the laser is diagonal in quad-1 (if you map out the laser on a cartesian plane)
			} else if (lg.getDir() == 2) 
			{
				// If the laser has passed the boundary on the left side, reset the laser
				if (passed == true) 
				{
					// Randomly sets the laser and gets the mask
					xLaser = 1500;
					// setLaser() sets the xPos, yPos, speed etc.
					lg.setLaser();
					passed = false;
				}
				
				// If the mask intersects with a line corresponding to the position of the laser, start bldTimer
				if (plrMask.intersectsLine(23 + xLaser, 320 + lg.getYLaser(), 318 + xLaser, 25 + lg.getYLaser()))
				{
					bldTimer.start();
				}
				
				// If the laser has passed the boundary on the left side, reset the laser
				if (xLaser + 400 <= 0) 
				{// resets the laser
					passed = true;
				}
				
			// If the laser is diagonal in quad-1 (if you map out the laser on a cartesian plane)	
			} else if (lg.getDir() == 4)
			{
				
				if (passed == true) 
				{// Randomly sets the laser and gets the mask
					xLaser = 1500;
					lg.setLaser();
					passed = false;
				}
				
				// If the mask intersects with a line corresponding to the position of the laser, start bldTimer
				if (plrMask.intersectsLine(28 + xLaser, 24 + lg.getYLaser(), 321 + xLaser, 317 + lg.getYLaser()))
				{
					bldTimer.start();
				}
				
				// Sets passed to true if it passes the left side of the screen
				if (xLaser + lg.getLaser().getIconWidth() <= 0) 
				{
					passed = true;
				}
			}
			
			// Decreases laser's x-position by the speed
			xLaser -= xLaserSpeed;
			
			// Code for the background, it is basically looping the background at the same speed of the lasers so that there are no gaps between imgBack 1 and 2
			
			if (xBack1 + imgBack.getIconWidth() <= 0)
			{
				xBack1 +=  imgBack.getIconWidth();
			}
			if (xBack2 + imgBack.getIconWidth() <= 0)
			{
				xBack2 +=  imgBack.getIconWidth();
			}
			
			// Setting the background speed the same as the laser speed 
			xBack1 -= xLaserSpeed;
			xBack2 -= xLaserSpeed;
			
			
			// Code that makes sure missiles don't overlap
			
			// For loop to run same code for the 3 missiles
			for (int i = 0; i <= 2; i++)
			{
				// Missile x-position decreases by the the speed and a factor of the laser speed
				
				xMis -=(int)(missiles[i].getSpeedX() + 0.5*xLaserSpeed);
				
				// If the player collides with a missile, start the bldTimer
				if (misMasks[i].intersects(plrMask))
				{	
					bldTimer.start();
				}
			}
			
			// Code for if the missiles overlap, in which case the y-position should be changed randomly
			
			if (misMasks[0].intersects(misMasks[1])) 
			{
				missiles[0].setYMis();

			} else if (misMasks[1].intersects(misMasks[2]))
			{
				missiles[1].setYMis();
				
			} else if (misMasks[2].intersects(misMasks[0]))
			{
				missiles[2].setYMis();
			}

		}
		
		
		// Increasing speed every 10s
		if (e.getSource() == incrTimer)
		{
			// Increasing laser speed by XINCR every 10s
			xLaserSpeed += XINCR;
			
			
			// Missile set-up (x value, random y values and speed, etc.)
			xMis = 1800;
			for (int i = 0; i <= 2; i++) 
			{
				missiles[i].setMissiles();
			}
		}
		
		//Calculates distance every 0.1s
		if(e.getSource() == distTimer)
		{
			// Calculates distance in meters to be displayed at the end of the play-through
			distance += 0.1 * xLaserSpeed;
			//Casts to an integer variable because we need to paint it
			metres = (int)Math.round(distance);			
		}
		
		// Called when collision happens
		if(e.getSource() == bldTimer)
		{
			// Code for when collision occurs to change player into blood splatter
			
			// Stops the other timers to stop gameplay, and decreases 'sec' by one from 100, until 1 second has passed
			sec--;
			objTimer.stop();
			incrTimer.stop();
			distTimer.stop();
			
			// Sets the player images to blood splatter
			imgPlayer = imgBlood;
			imgPlayerNB = imgBlood;
			
			// Stops the timer when one second has passed, and runs the collision method
			if (sec == 0)
			{
				bldTimer.stop();
				Collision();
			}
		}
		
		
		// Countdown before play-through starts (similar to bldTimer, except it runs at the start fo a playthrough instead)
		if(e.getSource() == countTimer) 
		{
			//Countsec represents the total amount of seconds; it decreases by one every time the timer runs
			countSec--;
			countdown = true;
			
			//If the countSec is -1, end the timer, set countdown to false from true, and start the other timers
			if (countSec == -1)
			{
				countdown = false;
				countTimer.stop();
				objTimer.start();
				incrTimer.start(); 
				distTimer.start();
			}
		}
		
		// Makes sure that the paint object updates to the changes made in actionPerformed
		repaint();
	}
	
	// The method that paints the graphics of the game
	public void paint(Graphics g) {
		
		// Setting up the paint method variables
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// Code for to display the poster
		if(showPoster) 
		{
			g2.drawImage(imgPoster.getImage(), 0, 0, this);
		
		// Code to display the game
		} else if(!showMenu)
		{
			// Draws the background images
			g2.drawImage(imgBack.getImage(), xBack1 + imgBack.getIconWidth(), 0, this);
			g2.drawImage(imgBack.getImage(), xBack2, 0, this);
			
			// Draws the line for the ceiling boundary
			g2.setStroke(new BasicStroke(5));
			g2.drawLine(0, 50, 1600, 50);
			
			// Draws the player with jetpack boosted if up key is pressed, else with no boost
			if (move >= 1) 
			{
				g2.drawImage(imgPlayer.getImage(), xPos, yPosRound, this);
			} else
			{
				g2.drawImage(imgPlayerNB.getImage(), xPos, yPosRound, this);
			}
			
			// Sets the font colour to white to display the distance being traveled on the upper-right corner of the screen
			g2.setColor(Color.WHITE);
			g2.setFont(f);
			g2.drawString(metres + "m",  1550 - fm.stringWidth(metres + "m"), 50);
			
			// Draws the laser
			g2.drawImage(lg.getLaser().getImage(), lg.getXLaser(), lg.getYLaser(), this);
			g2.drawImage(lg.getLaser().getImage(), xLaser, lg.getYLaser(), this);
			
			// Updates the player mask to match the location of the player image
			plrMask = new Rectangle2D.Double(xPos + 25, yPosRound, imgPlayer.getIconWidth() - 45, imgPlayer.getIconHeight());
			
			// Updates the laser mask to match the position of the laser image if it is horizontal or vertical (uses Rectangle2D)
			if (lg.getDir() == 1 || lg.getDir() == 3) {

				lsrMask = new Rectangle2D.Double(xLaser, lg.getYLaser(), lg.getLaser().getIconWidth(), lg.getLaser().getIconHeight());
			}
			
			// Updates each of the missile masks to match the location of the missile images, and draws the images
			for (int i = 0; i <= 2; i++)
			{
				misMasks[i] = new Rectangle2D.Double(xMis, missiles[i].getYMis(), missiles[i].getMissiles().getIconWidth(), missiles[i].getMissiles().getIconHeight());
				g2.drawImage(imgMis.getImage(), xMis, missiles[i].getYMis(), this);
			}
			
			// Draws the letters and numbers to display the countdown in the middle of the screen
			if(countdown) 
			{
				// Draws GO! is countSec is 0
				if (countSec == 0)
				{
					g2.drawString("GO!", getWidth() / 2 -fm.stringWidth("GO!") / 2, getHeight() / 2 + fm.getAscent() / 2);
					
					// Draws 3, 2, 1 (i) otherwise
				} else 
				{
					g2.drawString(Integer.toString(countSec), getWidth() / 2 -fm.stringWidth(Integer.toString(countSec)) / 2, getHeight() / 2 + fm.getAscent() / 2);
				}
			}
		}
	}
	
	// The method that displays the menu
	public void Menu() {
		
		// Local variables are declared and initialized
		Random rand = new Random();

		final String buttons[] = {"Play", "Skin Locker", "Change Name", "Exit"};
		final String prefix[] = {"Tropical", "King", "Flying", "Wild", "Majestic", "Wonder", "Crazy", "Winged", "Red", "Sturdy", "Magic", "Captain", "Snowy", 
				"Groovy", "Excited", "Lively", "Mighty", "Expert", "Gentle", "Tropical", "Wise", "Rockstar", "Honest", "Reggae"};
		final String suffix[] = {"Fish", "Lemming", "Cat", "Wolf", "Tiger", "Condor", "Lark", "Leopard", "Seal", "Oryx", "Lobster", "Dolphin", "Sable", "Newt", 
				"Penguin", "Egret", "Emu", "Lobster", "Squid", "Zebra", "Snail", "Horse", "Bimbo"};
		
		boolean valid = false;
		
		// If showMenu is true, show the menu
		if(showMenu)
		{
			showPoster = false;
			
			// ageAsked makes sure the loop only runs at the beginning of the game, and valid is true if the input is valid
			while(!valid && !ageAsked) 
			{
				// Ask for user to input age
				String ageStr = (String) JOptionPane.showInputDialog(null, "Welcome to Jetpack Joyride!\n \nPlease enter your age:", "Jetpack Joyride!", 
						JOptionPane.WARNING_MESSAGE, null, null, age);

				// If user tries to exit the prompt or press cancel, end the game
				if(ageStr == null)
				{					
					System.exit(0);
				}
				
				// Tries to parse the String to an int in a try-catch statement
				try 
				{
					age = Integer.parseInt(ageStr);
					
				}catch(Exception e)
				{
					
					// If input is not parsable, displays a message and reruns the iteration of the loop
					JOptionPane.showMessageDialog(null, "Invalid input entered! Please enter a number for your age!", "Error", JOptionPane.ERROR_MESSAGE, null);
					continue;
				}
				
				// Checks for the age requirement (after all, blood splatter is not for kids), to break out of loop
				if (age < 118 && age > 10)
				{
					valid = true;
					
					// Checks for an impossible age to display the corresponding message
				} else if(age > 117) 
				{
					JOptionPane.showMessageDialog(null, "Invalid age entered! You are not entering your true age...", "Too old!", JOptionPane.ERROR_MESSAGE, null);
					
					// Checks for an age too young to play
				} else
				{
					JOptionPane.showMessageDialog(null, "Invalid age entered! You are too young to play this game...", "Too young!", JOptionPane.ERROR_MESSAGE, null);
				}
			}
			ageAsked = true;
			valid = false;
			// Sets the values so the loop cannot run again
			
			// Valid checks for input validity, and nameAsked makes sure the loop runs only once
			while(!valid && !nameAsked) 
			{
				// Prompts the user for their name
				name = (String) JOptionPane.showInputDialog(null, "Please enter your name:\n(a-z, A-Z, 0-9, or underscores; no spaces allowed)",
						"Jetpack Joyride!", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images\\glowingJP.png"), null, name);
				
				if(name == null)// If user tries to exit the window or presses cancel, the program ends
				{
					System.exit(0);
				} else if(name.matches("\\w+")) // Checks if input is a number, letter, or underscore to break out of loop
				{
					valid = true;
				} else
				{
					valid = false;
				}
			}
			
			// Sets values so loop cannot run again
			nameAsked = true;
			
			do { // While true
				
				// Sets up the menu title icon and JPanel for menu prompt
				JLabel icon = new JLabel(new ImageIcon("images//Jetpack_Joyride.png"));

				JPanel panel = new JPanel();
				
				// Centers the icon in the JPanel, before adding it to a JOptionPane for the main menu
				// BorderLayout makes sure that the icon is perfectly centered so that the title screen looks better
				panel.setLayout(new BorderLayout());
				panel.add(icon, BorderLayout.CENTER);
				
				// Choice takes a value depending on which button in buttons the user clicks
				choice = JOptionPane.showOptionDialog(null, panel, "Main Menu", 1, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
				
				// If the user chooses to play the game, set the game frame to visible and break out of the menu loop
				if(choice == 0)
				{
					frame.setVisible(true);
					
					// showMenu is set to false, before Menu is rerun to run the code in the else condition
					showMenu = false;
					
				// If the user chooses to decide on a skin for the player, ...
				} else if(choice == 1)
				{
					// The different skins to be displayed in the JPanel
					JLabel icon1 = new JLabel(new ImageIcon("images//player//1boost.png"));
					JLabel icon2 = new JLabel(new ImageIcon("images//player//2boost.png"));
					JLabel icon3 = new JLabel(new ImageIcon("images//player//3boost.png"));
					
					// We are just using JLabel to hold the icons and text to put into the JPanel
					JLabel text = new JLabel("Please choose a skin (1 - 3; 4 for random skin): ");
					
					// The JPanel that holds the skins
					JPanel skinPanel = new JPanel();
					
					// BorderLayout allows for multiple images and text to be displayed in the image prompt, and we can decide which image goes where
					skinPanel.setLayout(new BorderLayout());
					skinPanel.add(icon1, BorderLayout.WEST);
					skinPanel.add(icon2, BorderLayout.CENTER);
					skinPanel.add(icon3, BorderLayout.EAST);
					skinPanel.add(text, BorderLayout.NORTH);
					
					// Saves the previous skin setting for user's convenience if they press cancel
					prevSkin = skinChoice;
					
					// A while loop that asks for the user's skin choice
					while(true)
					{
						
						// The actual prompt with the JPanel
						skinChoice = (String) JOptionPane.showInputDialog(null, skinPanel , "Skin Locker", JOptionPane.PLAIN_MESSAGE, null, null, skinChoice);
						
						// If the user tries to exit the window or press cancel, reset the skinChoice to the previous skin, and return to menu
						if (skinChoice == null)
						{
							skinChoice = prevSkin;
							break;
						
						// If skinChoice is 4, return to menu (random skin code is called when the user starts the game)
						} else if(skinChoice.equals("4"))
						{
							break;
							
						// If skin choice is 1, 2, or 3, and the user input has a length of one, set the ImageIcon to the corresponding skin, and return to menu
						} else if(skinChoice.matches("[1-3]") && skinChoice.length() == 1)
						{
							imgPlayer = skins[Integer.parseInt(skinChoice) - 1];
							imgPlayerNB = skinsNB[Integer.parseInt(skinChoice) - 1];
							break;
							
							// If the input is invalid or the user presses okay with no input, keep repeating the loop
						} else
						{
							continue;
						}
					}
				
				// For if the user wants to change their name
				} else if(choice == 2)
				{			
					valid = false;
					
					// Prompts the user to ask whether they want a randomly generated name or make a new name
					int nameChoice = JOptionPane.showConfirmDialog(null, "Do you want to randomly generate a name?", 
							"Change Name", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
					
					// If they click yes, the name is generated from the prefix and suffix arrays, and displayed in a message dialog
					if(nameChoice == JOptionPane.YES_OPTION)
					{
						name = prefix[rand.nextInt(prefix.length - 1)].concat("_" + suffix[rand.nextInt(prefix.length - 1)]);
						
						JOptionPane.showMessageDialog(null, "Your randomly generated name is: \n \n" + name, "Random Name", JOptionPane.PLAIN_MESSAGE, 
								new ImageIcon("images\\glowingJP.png"));
					
					// If they click no, an input dialog shows up, which asks them to input the new name, after saving the previous name
					} else if (nameChoice == JOptionPane.NO_OPTION)
					{
						prevName = name;
						
						while(!valid) 
						{
							
							name = (String) JOptionPane.showInputDialog(null, "Enter your new name:\n(a-z, A-Z, 0-9, or underscores; no spaces allowed)", 
									"Change Name", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images\\glowingJP.png"), null, name);
							
							// If the user presses cancel or tries to exit the window, it saves the name as the previous name, and returns to menu
							if(name == null)
							{
								name = prevName;
								break;
								
							// Checks if the input only contains numbers, letters, and underscore, in which case it returns to menu
							} else if(name.matches("\\w+")) 
							{
								valid = true;
								
							// If the input is not valid, it will continue to prompt the user for valid input
							} else
							{
								valid = false;
							}
						}
						
					// User cannot exit the confirm dialog until a button has been pressed
					} else if (nameChoice == -1)
					{
						continue;
					}
					
				
				// If the user presses the exit button or tries to close the window, ...	
				} else if(choice == 3 || choice == -1)
				{
					// The user is asked whether or not they want to leave
					int quit = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					// If yes, the game ends
					if (quit == JOptionPane.YES_OPTION)
					{
						System.exit(0);
						
					// If not, they return to menu
					} else
					{
						continue;
					}
				}
				
			} while (showMenu);
			Menu();
			
		} else // else show menu
		{
			
			// Sets the frame up for the game play
			frame.setSize(WIDTH, HEIGHT);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		
			// If the skinChoice is 4, the player ImageIcon are randomly generated and set each time the play button is hit
			if(skinChoice.equals("4"))
			{
				rndChoice = rand.nextInt(3);
				imgPlayer = skins[rndChoice];
				imgPlayerNB = skinsNB[rndChoice];
			}
			
			// The count down is activated
			countTimer.start();
		}
	}
	
	
	// This method runs the code to set the variables and prompts running after the player dies in a play-through
	public void Collision() {
		
		// Declaring and initializing the buttons for the game over screen
		String[] nothingButtons = new String[] {"Welp", "Noice", "Whoops", "Sadness"};
		
		// Makes the game frame invisible
		frame.setVisible(false);
		
		// Changing the skin back to their choice from being blood if it was not 4 because it will be randomized the next time they press start
		if (!skinChoice.equals("4"))
		{
			imgPlayer = skins[Integer.parseInt(skinChoice) - 1];
			imgPlayerNB = skinsNB[Integer.parseInt(skinChoice) - 1];
		}
		
		// Resetting the crucial variables for the game to work for the next time the user presses play
		xLaser = 0;
		grav = 0.6;
		xLaserSpeed = 10;
		ySpeed = 0;
		yPos = 500;
		xPos = 200;
		yPosRound = 500;
		move = -1;
		xMis = -100;
		sec = 100;
		countSec = 4;
		lg = new LaserGen();
		
		// Setting up a JLabel to be used in the JOptionPane
		// Sets the image that says you died
		JLabel icon = new JLabel(new ImageIcon("images//dead"));
		// Sets the text that will be printed on the panel
		JLabel text = new JLabel("\n"+ name.toUpperCase() + " travelled: " + metres + "m");

		// Initializes JPanel object
		JPanel panel = new JPanel();
		
		// Sets the OptionPane background which is the border along the edges of the window, and the Panel background which is the background excluding the border
		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		
		// Sets the colour behind the text box to black
		text.setBackground(Color.BLACK);
		// Makes the black from the previous line visible
		text.setOpaque(true);
		// Sets the text to white
		text.setForeground(Color.WHITE);
		
		// Initializing the panel with a BorderLayout
		panel.setLayout(new BorderLayout());
		
		//Sets up the panel with an icon and text at certain locations
		panel.add(icon, BorderLayout.CENTER);
		panel.add(text, BorderLayout.SOUTH);
		
		//JOptionPane that uses the panel we created and the buttons
		int choice = JOptionPane.showOptionDialog(null, panel, "Game Over!", 1, JOptionPane.PLAIN_MESSAGE, null, nothingButtons, null);
		
		//Depending on which button the user presses, they are met with a different background in the menu, just a fun, colourful addition to the game
		if (choice == -1) {
			UIManager.put("OptionPane.background", Color.ORANGE);
			UIManager.put("Panel.background", Color.ORANGE);
		} else if (choice == 0) {
			
			UIManager.put("OptionPane.background", Color.GREEN);
			UIManager.put("Panel.background", Color.GREEN);
		
		} else if (choice == 1) {
			UIManager.put("OptionPane.background", Color.ORANGE);
			UIManager.put("Panel.background", Color.ORANGE);
			
		} else if (choice == 2) {
			UIManager.put("OptionPane.background", Color.MAGENTA);
			UIManager.put("Panel.background", Color.MAGENTA);
			
		} else if (choice == 3) {
			UIManager.put("OptionPane.background", Color.CYAN);
			UIManager.put("Panel.background", Color.CYAN);
		}
		
		// Resets the distance and metres now because the values were needed for the game recap message
		distance = 0;
		metres = 0;
		
		// Sets showMenu boolean and calls on the menu method which opens the menu
		showMenu = true;
		Menu();
	}
}