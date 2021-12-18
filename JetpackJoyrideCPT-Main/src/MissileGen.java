import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;

// For generating missiles
public class MissileGen {
	
	// Random object for random values
	private Random rand;
	// Rectangle2D mask for missile
	private Rectangle2D misMask;
	// ImageIcon for missiles
	private ImageIcon missile;
	// Integers for x and y position, and speed
	private int xMis, yMis, speed;
	
	// MissileGen constructor
	public MissileGen() {
		
		// Initializing ImageIcon and mask for missiles
		missile = new ImageIcon("images//missile.png");
		misMask = new Rectangle2D.Double();
		
		// Initializing Random object, x and y positions, and speed
		rand = new Random();
		xMis = 1800;
		yMis = 75;
		speed= 1;
	}
	
	// Method for setting random missiles
	public void setMissiles() {
		
		// Setting x position to off the screen to the right, and randomizing the y position
		xMis = 1800;
		yMis = rand.nextInt(600) + 100;
		
		// Setting the missile mask and randomizing the increase of speed from 0 to 2
		misMask = new Rectangle2D.Double(xMis, yMis, missile.getIconWidth(), missile.getIconWidth());
		speed = rand.nextInt(3);
		
	}
	
	// Methods for getting certain variables from the MissileGen class
	public int getXMis() {
		
		return xMis;
	}
	
	public int getYMis() {
		
		return yMis;
	}
	
	public int getSpeedX(){
		return speed;
	}
	
	public Rectangle2D getMisMask() {
		return misMask;
	}
	
	public ImageIcon getMissiles() {
		
		return missile;
	}
	
	// Sets a random y position for the missile 
	public void setYMis() {
		
		yMis = rand.nextInt(600) + 100;
	}
}