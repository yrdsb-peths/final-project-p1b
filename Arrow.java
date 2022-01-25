import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    private boolean remove;
    private GreenfootImage image;
    
    public Arrow () {
        remove = false;
        
        image = drawArrow();
        setImage(image);        
    }
    
    public void addedToWorld (World w){
        Player p = (Player)w.getObjects(Player.class).get(0);
        turnTowards (p.getX(), p.getY());
    }
    
    public void act()
    {
        move (2);
        
        Player p = (Player)getOneIntersectingObject(Player.class);
        if (p != null){
            p.hitMe(1);
            remove = true;
        }

        if (isAtEdge()){
            remove = true;
        }

        if (remove){
            getWorld().removeObject(this);   
        }
    }
    
    private GreenfootImage drawArrow() {
        image = new GreenfootImage("Arrow.png");
        
        return image;
        
    }
}
