import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends World
{

    /**
     * Constructor for objects of class Home.
     * 
     */
    public Home()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
    }
    
    public void act(){
        checkMouse();
    }
    
    //private void checkMouse(){
        //if (Greenfoot.mouseCLicked(next)){
            //Greenfoot.setWorld(new Dungeon());
       //}
    //}
}
