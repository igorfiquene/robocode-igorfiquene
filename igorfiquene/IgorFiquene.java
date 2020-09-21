package igorfiquene;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * IgorFiquene - a robot by (your name here)
 */
public class IgorFiquene extends Robot
{
	/**
	 * run: IgorFiquene's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.black,Color.white,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			turnRight(90);
			back(100);
			turnGunRight(360);
			turnRight(45);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e){
	    double distance = e.getDistance(); 
	    if(distance > 800) 
	        fire(5);
	    else if(distance > 600 && distance <= 800)
	        fire(4);
	    else if(distance > 400 && distance <= 600)
	        fire(3);
	    else if(distance > 200 && distance <= 400)
	        fire(2);
	    else if(distance < 200)
	        fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e){
		turnLeft(35);
		back(50);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e){
	    double bearing = e.getBearing(); 
	    turnRight(-bearing);
	    ahead(100);
	}
}
