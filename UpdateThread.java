import javax.swing.*;

public class UpdateThread extends Thread
{

	GalagaPanel panel;

	public UpdateThread(GalagaPanel panel)
	{
		this.panel = panel;
	}
	//https://www.journaldev.com/1016/java-thread-example help for making this method
	public void run()
	{
		while(true)
		{
			panel.update();

		//	//wait awhile
			try{
				Thread.sleep(60);
			}
			catch(Exception error)
			{
				
			}
		}
	}


}