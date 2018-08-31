import javax.swing.*;
import java.awt.*;

public class GameObject extends Rectangle
{

    ImageIcon picture;
    private boolean isAlive;
    private String attribute;
    int score;
    int points;
    /**
     * Constructor for that creates the basic game object
     * @param none
     * @return none 
     */
    public GameObject()
    {
        attribute = "nothing";
    		isAlive = true;
        y = 200;
        x = 200;
        height = 50;
        width = 50;

    }
    /**
     * getter method for the isAlive variable 
     * @return isAlive - status whether the alien is alive or not 
     */
    public boolean getIsAlive()
    {
    		return isAlive;
    }
    /**
     * setter method for the isAlive variable 
     * @param isAlive - boolean value changing the status whether the alien is alive or not 
     */
    public void changeAliveStatus(boolean isAlive)
    {
    		this.isAlive = isAlive;
    }
    /**
     * getter method for the attribute of the game object
     * @return attribute - what type is this 
     */
    public String getAttribute()
    {
    		return attribute;
    }
    /**
     * setter method for the attribute of the game object
     * @param attribute - what the type of the object it is
     */
    public void changeAttribute(String attribute)
    {
    		this.attribute = attribute;
    }
    
    /**
     * setter method for the picture 
     * @param p - an Image is passed through and is set to 
     */
    public void changePicture(ImageIcon picture)
    {
        this.picture = picture;
    }
    /**
     * draws the images 
     * @param g references the graphics object
     * @param c references the component object
     */
    public void draw(Graphics g, Component c)
    {
        if(isAlive == true)
        {
        		g.drawImage(picture.getImage(),x,y,width,height,c);
        }
    }
    /**
     * kills the object
     */
    public void kill()
    {
            height = 0;
            width = 0;
            x = 0;
            y = 0;
            updateScore(points);
            System.out.println(attribute + " killed");
            isAlive = false;
    
    }
    /**
     * updates the screen
     */
    public void update()
    {
        y += 1;
        x += 1;
    }
    /**
     * update the scores
     * @param x - increment that the score is increased by 
     */
    public void updateScore(int x)
    {
        score += x;
    }
    /**
     * getter for the score variable
     * @return returns the score of the game 
     */
    public int getScore()
    {
        return score;
    }
       
}