import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends World implements Clickable
{

    Label display;
    Label display2;
    Label display3;
    Label display4;
    Button button;
    public Home()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        display = new Label("Survival Dungeon!", 100);
        button = new Button(this, "Start World", 200, 30);
        display2 = new Label("Use WASD to move", 24);
        display3 = new Label("Use the Space Bar to shoot", 24);
        display4 = new Label("Instructions:", 30);
        
        int labelWidth = (int) (getWidth() * 0.5);
        int labelHeight = (int) (getHeight() * 0.35);
        addObject(display, labelWidth, labelHeight);
        
        addObject(display2, 400, 550);
        addObject(display3, 400, 575);
        addObject(display4, 400, 520);
        
        int buttonWidth = (int) (getWidth() * 0.5);
        int buttonHeight = (int) (getHeight() * 0.7);
        addObject(button, buttonWidth, buttonHeight);
    }
    
    public void onClick()
    {
        Greenfoot.setWorld(new Dungeon());
    }
    
    public void act(){
        
    }
    
    //private void checkMouse(){
        //if (Greenfoot.mouseCLicked(next)){
            //Greenfoot.setWorld(new Dungeon());
       //}
    //}
}
