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
    
    
    

    
    public Dungeon()
    {    
        super(800, 600, 1); 
        setBackground(drawSpace(800,600,40));
        
        
        
        
    }
    
    public static GreenfootImage drawSpace (int width, int height, int density){
        // Draws the background as gray.
        GreenfootImage world = new GreenfootImage (width, height);
        world.setColor (Color.GREEN);
        world.fill();
        
        return world;
    }
    
    
}
