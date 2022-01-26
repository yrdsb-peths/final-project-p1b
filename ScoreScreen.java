import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreScreen extends World
{
    Label display;
    
    public ScoreScreen()
    {    
        super(800, 600, 1);
        display = new Label("Thanks for playing!", 100);
        
        addObject(display, 400, 200);
    }
}
