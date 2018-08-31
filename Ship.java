
public class Ship extends GameObject
{

	//ship velocity
	int velocity;
	
	public Ship()
	{
		changeAttribute("ship");
	}
	/**
	 * moves the x position of the the up by the velocity 
	 * @param none
	 * @return none 
	 */
	public void update()
	{
		x = x + velocity;
	}
	
	public int getVelocity()
	{
		return velocity;
	}
	
	public void changeVelocity(int velocity)
	{
		this.velocity = velocity;
	}

}