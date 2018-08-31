
public class CircleAlien extends Alien
{

	double theata;
	/**
	 * Constructor for the circle alien object 
	 * @param none
	 * @return none
	 */
	public CircleAlien()
	{
		
	}
	/**
	 * method for updating the screen and making the alien move around in a circle 
	 * @param none
	 * @return none 
	 */
	public void update()
	{
		x = 99+ (int) (100 * Math.sin(theata));
		y = 99+ (int) (100 *Math.cos(theata));
		theata += .3;
		
		if(getIsAlive())
		{
			if(getHasShot() == true)
			{
				bullet.y += 12;
				if(bullet.y >= 500)
				{
					bullet.y = -6;
					changeHasShot(false);
				}
			}
			if(rand == 0 && getHasShot() == false)
			{
				bullet.y = y + 6;
				bullet.x = x + 600/2;
				changeHasShot(true);
			}
			

		}
		else
		{
			bullet.y = -15;
		}
	}

}