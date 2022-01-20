import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    public int score = 0;
    
    public Counter() {
        updateImage();
        
    }
    
    public void updateImage() {
        setImage(new GreenfootImage("Score: " + score, 25, Color.WHITE, new Color(0,0,0,0)));
        
    }
    
    public void addScore() {
        score++;
        updateImage();
    }
    
}
