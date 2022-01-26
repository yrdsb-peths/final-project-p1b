import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    // Pretty much the same as bullet but different image.
    private boolean remove;
    private GreenfootImage image;
    
    public Arrow () {
        remove = false;
        // Draw the image and set it up
        image = drawArrow();
        setImage(image);        
    }
    
    public void addedToWorld (World w){
        // When it goes to the world it will turn towards the player
        Player p = (Player)w.getObjects(Player.class).get(0);
        turnTowards (p.getX(), p.getY());
    }
    
    public void act()
    {
        // So 60 times a second, it will move 2 
        // So arrow moves 120 a second
        move (2);
        // Check if player got hut by the arrow
        //If so, deal 1 damage to player and remove itself.
        Player p = (Player)getOneIntersectingObject(Player.class);
        if (p != null){
            p.hitMe(1);
            remove = true;
        }
        // Also deletes itself if it goes outside of the world.

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
