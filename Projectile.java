import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)




public class Projectile extends Actor
{
    private boolean remove;
    private GreenfootImage image;
    // Similar to arrow since they both projectiles, just one use by player and arrow use by skeletons
    public Projectile () {
        remove = false;
        // Draw image
        image = drawProjectile();
        setImage(image);
    }

    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // So it moves 300 a second
        move (5);
        // Constantly checks if bullet hits player. If so, deal 1 damage and remove arrow from world.

        Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
        if (e != null){
            e.hitMe(1);
            remove = true;
            // If you kill the unit, you gain one point
            ((Dungeon)getWorld()).getScoreCounter().addScore(1);
        }

        if (isAtEdge()){
            // Removes bullet if bullet goes outside of world.
            remove = true;
        }

        if (remove){
            getWorld().removeObject(this);   
        }
    }    
    
    public void addedToWorld (World w){
        Player p = (Player)w.getObjects(Player.class).get(0);
        turnTowards (p.getX(), p.getY());
    }
    private GreenfootImage drawProjectile() {
        image = new GreenfootImage("Bullet.png");
        // Adds image of bullet.
        return image;
        
    }
}