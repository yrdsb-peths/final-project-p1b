import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends Enemy
{
    private int hp = 1;
    private int cd;
    private int maxCd;
    
    public Skeleton (){
        maxCd = 60;
        cd = maxCd;
        
        image = drawSkeleton();
        setImage(image);
    }
    
    public void addedToWorld (World w){
        
        player = w.getObjects(Player.class).get(0);
    }
    
    public void act()
    {
        //if (cd > 0){
            //cd--;
        //} else {
            // shoot 
            //getWorld().addObject(new Arrow(), getX(), getY());
            //cd = maxCd;
        //}
        
        int random = Greenfoot.getRandomNumber(2);
        if(random == 1){
            turnTowards(player.getX(), player.getY());
            move(1);
        }
        
        Player p = (Player)getOneIntersectingObject(Player.class);
        if(p != null){
            p.hitMe(2);
            getWorld().removeObject(this);

        }
    }
    
    private GreenfootImage drawSkeleton(){
        
        image = new GreenfootImage("Skeleton.png");
        return image;
        
    
    }
}
