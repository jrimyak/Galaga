import java.awt.*;
import javax.swing.*;


public class Bullet extends GameObject 
{
	Color color;
	public Bullet()
	{
		color = Color.WHITE;
		width = 9;
		height = 9;
		x = 0;
		y = 0;
		changeAttribute("bullet");

	}
	
	/**
	 * updates where the bullet will travel on the screen
	 */
	public void update()
	{
		y -= 11;
	}
	
	/**
	 * changes the color of the seeker's bullet 
	 */
	public void makeSeekerColor()
	{
		color = Color.GREEN;
	}
	/**
	 * changes the color for the alien's bullet
	 */
	public void makeAlienColor()
	{
		color = Color.RED;
	}
	/**
	 * draws the bullet on the screen
	 * @param g - passes through a graphics object
	 * @param c - passes through a component object
	 */
	public void draw(Graphics g, Component c)
	{
		g.setColor(color);
		g.fillRect(getLocation().x, getLocation().y, getSize().width, getSize().height);
	}
}
