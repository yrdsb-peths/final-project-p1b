import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends World
{
    Counter counter = new Counter();
    
    private Button shop;
    
    
    public Home()
    {    
        
        super(800, 600, 1); 
        setBackground(drawSpace2(800,600,40));
        
        
        
    }
    
    
    
    public static GreenfootImage drawSpace2 (int width, int height, int density){
        // Draws the background as gray.
        GreenfootImage world = new GreenfootImage (width, height);
        world.setColor (Color.GREEN);
        world.fill();
        
        return world;
    }
}
