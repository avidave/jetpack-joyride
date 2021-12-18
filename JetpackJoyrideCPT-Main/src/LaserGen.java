import java.awt.geom.*;
import java.util.Random;
import javax.swing.ImageIcon;

//For generating lasers
public class LaserGen {
	
	// Random object for random values
	private Random rand;
	// Rectangle2D mask for laser
	private Rectangle2D lsrMask;
	// ImageIcon for laser
	private ImageIcon Laser;
	// Integer values for x and y position, and direction
	private int xLaser, yLaser, dir;
	
	// LaserGen constructor
	public LaserGen() {
		
		// Initializing x and y positions of the laser and direction
		xLaser = 2000;
		yLaser = 600;
		dir = 1;
		
		// Initializing Random object
		rand = new Random();
		
		// Initializing laser mask and laser ImageIcon
		lsrMask = new Rectangle2D.Double();
		Laser = new ImageIcon("");
	}
	
	// Method for setting a random laser
	public void setLaser() {
		
		// Random direction and setting the xLaser to off the screen to the right
		dir = rand.nextInt(4) + 1;
		xLaser = 2000;
		
		// Setting the ImageIcon, mask based on the random direction chosen, and setting a random y position for the laser to spawn on
		// They each have different ranges for the random y-value because the diagonals, horizontal, and verticals all have different heights
		// Also the diagonal lasers do not have rectangle masks because they need a line instead. The coordinates on the image are in the lines arrays
		
		// Horizontal
		if (dir == 1) 
		{
			
			Laser = new ImageIcon("images//laser//laser.png");
			//Rectangle mask because it is horizontal
			lsrMask = new Rectangle2D.Double(xLaser, yLaser, Laser.getIconWidth(), Laser.getIconHeight());
			
			yLaser = rand.nextInt(560) + 120;
			
			// Diagonal quad 1
		} else if (dir == 2) 
		{
			
			Laser = new ImageIcon("images//laser//laser2.png");
			
			yLaser = rand.nextInt(353) + 20;
			
			// Vertical
		} else if (dir == 3)
		{
			
			Laser = new ImageIcon("images//laser//laser3.png");
			//Rectangle mask because it is vertical
			lsrMask = new Rectangle2D.Double(xLaser, yLaser, Laser.getIconWidth(), Laser.getIconHeight());
			
			yLaser = rand.nextInt(220) + 50;
			
			// Diagonal quad 2
		} else if (dir == 4) 
		{
			
			Laser = new ImageIcon("images//laser//laser4.png");
			
			yLaser = rand.nextInt(353) + 20;
		}
	}
	
	// Methods for getting certain variables from the LaserGen class (getters)
	public ImageIcon getLaser() {
		
		return Laser;
	}
	
	public int getXLaser() {
		return xLaser;
	}
	
	public int getYLaser() {
		return yLaser;
	}
	
	public Rectangle2D getMask() {
		
		return lsrMask;
	}
	
	public int getDir() {
		return dir;
	}
}
