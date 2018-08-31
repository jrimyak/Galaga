import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class GalagaPanel extends JPanel implements KeyListener
{

	//images
	ImageIcon spaceBackground; 
	ImageIcon shippicture; 
	ImageIcon idiotAlien;
	ImageIcon predator;
	ImageIcon seeker;

	ArrayList<Alien> listOfAliens;

	Ship ship;
	Bullet bullet;
	
	int deathOfAlien;
	int lengthOfList;
	
	
	/**
	 * constructor to create the panel using JPanel
	 */
	public GalagaPanel()
	{
		spaceBackground = new ImageIcon("data/space.GIF");
		shippicture = new ImageIcon("data/shipp.png");
		idiotAlien = new ImageIcon("data/Alien1.PNG");
		predator = new ImageIcon("data/Alien2.PNG");
		listOfAliens = new ArrayList<Alien>();
		for(int i=0; i<4; i++)
		{
			Alien alien = new Alien();
			alien.changePicture(idiotAlien);
			listOfAliens.add(alien);
		}
		CircleAlien ca = new CircleAlien();
		ca.changePicture(idiotAlien);
		listOfAliens.add(ca);
		ship = new Ship();
		ship.changePicture(shippicture);
		ship.x = 200;
		ship.y = 400;
		Predator p1 = new Predator();
		p1.changePicture(predator);
		p1.changePrey(ship);
		listOfAliens.add(p1);
		Seeker seek = new Seeker();
		seeker = new ImageIcon("data/Alien4.PNG");
		seek.changePicture(seeker);
		seek.setPrey(ship);
		listOfAliens.add(seek);
		Predator p2 = new Predator();
		p2.changePicture(predator);
		p2.changePrey(ship);
		listOfAliens.add(p2);
		bullet = new Bullet();
		UpdateThread ut = new UpdateThread(this);
		ut.start();
		addKeyListener(this);
		setFocusable(true);
	}


	public void paintComponent(Graphics g)
	{
		//clear screen
		g.drawImage(spaceBackground.getImage(),0,0,600,600,this);

		//draw all objects in game
		for(int i =0; i < listOfAliens.size();i++ )
		{
			listOfAliens.get(i).draw(g,this);
			lengthOfList++;
			listOfAliens.get(i).bullet.draw(g, this);
			if(!listOfAliens.get(i).getIsAlive())
				deathOfAlien++;
		}
		ship.draw(g, this);
		bullet.draw(g, this);
		if(deathOfAlien == lengthOfList)
		{
			g.setFont(new Font("Georgia", Font.BOLD, 35));
			g.drawString("CHAMPION", 150, 300);
		}
		else
		{
			lengthOfList = 0;
			deathOfAlien = 0;
		}
		if(ship.getIsAlive() == false)
		{
			g.setFont(new Font("Georgia", Font.BOLD, 35));
			g.drawString("YOU LOST THE GAME", 100, 300);
		}
	}

	/**
	 * updates all the the objects in the game
	 */
	public void update()
	{
		for(int i = 0;i < listOfAliens.size(); i++)
		{
			listOfAliens.get(i).update();
			if(listOfAliens.get(i).intersects(ship) == true && listOfAliens.get(i).getAttribute().equalsIgnoreCase("ship") == false)
			{
				ship.kill();
				System.out.println(listOfAliens.get(i).getAttribute() + " killed you");
			}
			
			if(bullet.intersects(listOfAliens.get(i)) == true)
			{
				listOfAliens.get(i).kill();
			}
			

			if(listOfAliens.get(i).bullet.intersects(ship) == true )
			{
				ship.kill();
				System.out.println("Shot by " + listOfAliens.get(i).getAttribute());
			}
			
		}
			
		ship.update();
		bullet.update();
		
		repaint();
	}

	/**
	 * method from the KeyListener class
	 * @param k - the key that is pressed
	 */
	public void keyPressed(KeyEvent k)
	{
		char c = k.getKeyChar();
		
		if( k.getKeyCode() == KeyEvent.VK_RIGHT )
			ship.velocity = 6;
		if( k.getKeyCode() == KeyEvent.VK_LEFT )
			ship.velocity = -6;
		if(c == ' ')
		{
			bullet.x = ship.x;
			bullet.y = ship.y - 28;
		}
	}
	/**
	 * method from the KeyListener class
	 * @param k - the key that is pressed
	 */
	public void keyReleased(KeyEvent k)
	{
		if( k.getKeyCode() == KeyEvent.VK_LEFT ||  k.getKeyCode() == KeyEvent.VK_RIGHT )
			ship.velocity = 0;
	}
	/**
	 * method from the KeyListener class
	 * @param k - the key that is pressed
	 */
	public void keyTyped(KeyEvent k)
	{
	}

}