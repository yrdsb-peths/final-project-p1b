import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthScore extends Actor
{
    // Declaring that players have 20 health
    public static int health = 20;
    
    Color trans = new Color(0, 0, 0, 0);
    // Updates the image to show current lives at top of screen
    public HealthScore(){
        setImage(new GreenfootImage("Lives : " + health, 80, Color.BLACK, trans));
    }
    
    public void addHealthScore(int amount){   
        health = amount;
        setImage(new GreenfootImage("Lives : " + health, 80, Color.BLACK, trans));   
    }
}
