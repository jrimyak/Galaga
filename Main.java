import javax.swing.*;
import java.awt.*;

public class Main extends JApplet
{
	public static void main(String [] args)
	{
		JFrame galaFrame = new JFrame("Space Shooter");
		GalagaPanel gPanel = new GalagaPanel();
		galaFrame.getContentPane().add(gPanel);
		galaFrame.setSize(602,602);
		galaFrame.setVisible(true);
	}
}