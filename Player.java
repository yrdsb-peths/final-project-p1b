import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private GreenfootImage image;
    private int maxHP;
    private int currentHP;
    private int speed;
    
    public Player()
    {
        speed = 4;
        
        maxHP = Dungeon.PLAYER_MAX_HP;
        currentHP = maxHP;
        
        image = drawPlayer();
        setImage(image);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            getWorld().addObject(new Projectiles(getRotation()), getX(), getY());
            
        }
    }
    
    
    
    public void hitMe(int damage){
        currentHP = Math.max(currentHP - damage, 0);
        if(currentHP == 0){
            Greenfoot.stop();
        }
    }
    
    private GreenfootImage drawPlayer() {
        image = new GreenfootImage(24,24);
        image.setColor(Color.BLUE);
        image.fillOval(0,0,image.getWidth(), image.getHeight());
        return image;
        
    }
}