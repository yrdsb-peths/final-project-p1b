import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)




public class Projectile extends Actor
{
    private boolean remove;
    private GreenfootImage image;
    
    public Projectile () {
        remove = false;
        
        image = drawProjectile();
        setImage(image);
    }

    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move (5);

        Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
        if (e != null){
            e.hitMe(1);
            remove = true;
            ((Dungeon)getWorld()).getScoreCounter().addScore(1);
        }

        if (isAtEdge()){
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
        
        return image;
        
    }
}