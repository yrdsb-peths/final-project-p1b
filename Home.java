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
    private static GreenfootSound music;
    private String songName;
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
        
        songName = "Menu.mp3";
        music = new GreenfootSound (songName);
  
        
        
        music.setVolume(40);
        music.playLoop();
    }
    
    private void stop(){
        music.stop();
    }
    
    public void onClick()
    {
        Greenfoot.setWorld(new Dungeon());
        stop();
    }
    
    public void started (){ // this only triggers when the "Run" button is pressed while 
        music.playLoop();     // this World is active, which might happen if paused, but not as a start state.
    }
    
    public void act(){
        
    }
    
    //private void checkMouse(){
        //if (Greenfoot.mouseCLicked(next)){
            //Greenfoot.setWorld(new Dungeon());
       //}
    //}
}
