import java.util.*;

public class Alien extends GameObject
{
	Random random;
	int counter = 1;
	int velocity;
	int rand = 0;
	private boolean hasShot;
	
	Bullet bullet;
	
	public Alien()
	{
		random = new Random();
		x = random.nextInt(400);
		y = random.nextInt(250);
		velocity = random.nextInt(20) + 10;
		changeAttribute("alien");
		bullet = new Bullet();
		bullet.y = -10;
		hasShot = false;
		points = 2;
		bullet.makeAlienColor();
	}
	
	public boolean getHasShot()
	{
		return hasShot;
	}
	
	public void changeHasShot(boolean shooter)
	{
		hasShot = shooter;
	}

	public int getCounter()
	{
		return counter;
	}
	
	public void changeCounter(int x)
	{
		counter = counter + x;
		if(counter > 1000)
		{
			counter = 0;
		}
		
	}
	public void update()
	{		
		if(counter%2 != 1)
		{
			x += velocity;
			if(x > 500)
				changeCounter(1);
		}
		else
		{
			x -= velocity;
			if(x < 0)
				changeCounter(1);
		}	
		
		rand = random.nextInt(2);
		
		if(getIsAlive())
		{
			if(rand == 0 && !getHasShot())
			{
				
				bullet.x = getLocation().x + getSize().width/2;
				bullet.y = getLocation().y + 5;
				hasShot = true;
			}
			
			if(getHasShot())
			{
				bullet.y += 10;
				if(bullet.y >= 500)
				{
					bullet.y = -5;
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