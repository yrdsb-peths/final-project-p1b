import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    protected GreenfootImage image;
    protected Player player;
    
    protected boolean entering;
    protected boolean removeMe;
    
    protected int maxHP;
    protected int currentHP;
    
    
    
    protected int maxTime;
    protected int currentTime;
    
    public Enemy() {
        
        entering = true;
        removeMe = false;
        
        
    }
    
    public void hitMe(int damage){
        currentHP = Math.max(currentHP - damage, 0);
        if(currentHP == 0){
            getWorld().removeObject(this);
        }
    }
}
