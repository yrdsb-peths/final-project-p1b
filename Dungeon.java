import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon extends World
{
    Label title;
    /**
     * Constructor for objects of class Dungeon.
     * 
     */
    public Dungeon()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        title = new Label("Andrew", 100);
        int labelWidth = (int) (getWidth() * 0.5);
        int labelHeight = (int) (getHeight() * 0.35);
        
        addObject(title, labelWidth, labelHeight);
        
    }
}
