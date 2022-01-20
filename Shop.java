import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World implements Clickable
{
    
    /**
     * Constructor for objects of class Shop.
     * 
     */
    Button healthPot;
    Button grenade;
    Button speedPot;
    Button damagePot;
    Button attackSpeedPot;
    Label shop;
    public Shop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        shop = new Label("Shop", 50);
        int labelWidth = (int) (getWidth() * 0.5);
        int labelHeight = (int) (getHeight() *0.05);
        addObject(shop, labelWidth, labelHeight);
        
    }
    public void onClick()
    {
       
    }
}
