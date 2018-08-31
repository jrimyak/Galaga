public class Seeker extends Alien
{
	double theata;
	GameObject ship;
	
	
	/**
	 * Constructor method for the seeker class
	 */
	public Seeker()
	{
		x = random.nextInt(400);
		y = random.nextInt(200);
		changeAttribute("Seeker");

	}
	
	/**
	 * getter method for the prey 
	 * @param ship - the object that will be the prey 
	 */
	public void setPrey(GameObject ship)
	{
		this.ship = ship;
	}
	
	/**
	 * updates where the bullet and the seeker will move on the screen
	 */
	public void update()
	{		
		if(getCounter() % 2 == 0)
		{
			x += velocity;
			y = 119+ (int) (150 *Math.cos(theata));
			theata+= .2;
			if(x > 500)
				changeCounter(1);
		}
		else
		{
			x -= velocity;
			y = 119+ (int) (150 *Math.cos(theata));
			theata += .2;
			if(x < 0)
				changeCounter(1);
		}	
		
		rand = random.nextInt(2);
		
		if(getIsAlive() == true)
		{
			if(rand == 0 && !getHasShot())
			{
				bullet.x = getLocation().x + getSize().width/2;
				bullet.y = getLocation().y + 5;
				changeHasShot(true);
			}
			
			if(getHasShot() == true)
			{
				bullet.y += 5;
				if(ship.getLocation().x < bullet.getLocation().x)
				{
					bullet.x -= 4;
				}
				if(ship.x > bullet.getLocation().x)
				{
					bullet.x += 4;
				}
				if(bullet.y >= 500)
				{
					bullet.getLocation().y = -5;
					changeHasShot(false);
				}
			}
		}
		else
		{
			bullet.y = -15;
		}
	}
}
