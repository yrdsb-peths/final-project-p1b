import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon extends World
{

    public static final int TIME_PER_LEVEL = 120;
    
    public static final int PLAYER_MAX_HP = 10;
    private Player player;
    public static final int PLAYER_BASE_SPEED = 3;
    
    
    

    

    Label title;
    /**
     * Constructor for objects of class Dungeon.
     * 
     */

    public Dungeon()
    {    
        super(800, 600, 1); 
        setBackground(drawSpace(800,600,40));
        
        
        


        
        title = new Label("William", 100);
        int labelWidth = (int) (getWidth() * 0.5);
        int labelHeight = (int) (getHeight() * 0.35);
        
        addObject(title, labelWidth, labelHeight);

        
    }
    
    public static GreenfootImage drawSpace (int width, int height, int density){
        // Draws the background as gray.
        GreenfootImage world = new GreenfootImage (width, height);
        world.setColor (Color.GREEN);
        world.fill();
        
        return world;
    }
    
    
}
