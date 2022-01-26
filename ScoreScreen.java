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
    private static GreenfootSound music;
    private String songName;
    
    public ScoreScreen()
    {    
        super(800, 600, 1);
        display = new Label("Thanks for playing!", 100);
        
        addObject(display, 400, 200);
        
        songName = "Ending.mp3";
        music = new GreenfootSound (songName);
  
        
        
        music.setVolume(40);
        music.playLoop();
    }
}
