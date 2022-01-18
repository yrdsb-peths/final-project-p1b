import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectiles extends Actor
{
    private GreenfootImage image;
    private Player player;
    
    private boolean removeMe;
    
    public Projectiles(){
        setImage(drawProjectiles());
        
    }
    
    
    
    public void act()
    {
        move(2);
        
        if (getY() >= getWorld().getHeight()-1){
            removeMe = true;
        }
        
        if (getX() >= getWorld().getHeight()-1){
            removeMe = true;
        }
        
        if(checkCollision() || removeMe){
            getWorld().removeObject(this);
        }
    }
    
    private boolean checkCollision(){
        Zombie p = (Zombie)getOneIntersectingObject(Zombie.class);
        
        if(p != null){
            p.hitMe(2);
            return true;
        }
        return false;
    }
    
    private GreenfootImage drawProjectiles() {
        image = new GreenfootImage(24,24);
        image.setColor(Color.YELLOW);
        image.fillOval(0,0,image.getWidth(), image.getHeight());
        return image;
        
    }
}
