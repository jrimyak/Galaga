
public class Predator extends Alien
{
	private GameObject preyShip;
	
	/**
	 * Constructor for the Predator class
	 */
	public Predator()
	{
		changeAttribute("Predator");
		y = random.nextInt(198);
		x = random.nextInt(403);
	}
	/**
	 * setter method for the prey which in this case is the ship
	 * @param preyObject - the ship that the bullet will try to hit 
	 */
	public void changePrey(GameObject preyObject)
	{
		preyShip = preyObject;
	}
	
	/**
	 * getter method to retrieve what the prey the bullet is try to hit is 
	 * @return preyShip - the ship that the bullet is trying to hit
	 */
	public GameObject getPrey()
	{
		return preyShip;
	}
	
	/**
	 * updates the location of where the bullet moves 
	 */
	public void update()
	{
		if(preyShip.getLocation().x < getLocation().x)
		{
			x -= 5;
		}
		if(preyShip.getLocation().x > getLocation().x)
		{
			
			x += 5;
		}
		if(preyShip.getLocation().y > getLocation().y)
		{
			y += 3;
		}
		if(preyShip.getLocation().y < getLocation().y)
		{
			y -= 3;
		}
			
		if(getIsAlive() == true)
		{
			if(rand == 0 && getHasShot() == false)
			{
				bullet.y = getLocation().y + 6;
				bullet.x = getLocation().x + 300;
				changeHasShot(true);
			}
				
			if(getHasShot() == true)
			{
				bullet.y = bullet.getLocation().y + 4;
				if(bullet.y > 504)
				{
					changeHasShot(false);
					bullet.y = -4;
				}
			}
		}
		else
			
		{
			bullet.y = -13;
		}
	}
}
