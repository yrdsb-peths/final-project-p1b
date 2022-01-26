import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int hp;
    private int speed;
    private StatBar statBar;
    private GreenfootImage image;
    
    public Player()
    {
        speed = 4;
        
        hp = 20;
        
        
        statBar = new StatBar(10, 10, this, 36, 6, 24,  Color.GREEN,Color.RED, false);
        
        image = drawPlayer();
        setImage(image);
    }
    
    public void addToWorld (World w){
        w.addObject(statBar, 0, 0);
        statBar.update();
    }
    
    public void act(){
        checkKeys();
        statBar.moveMe();
    }
    
    private void checkKeys(){
        // Check for movement and adjusts.
        int moveX = 0;
        int moveY = 0;
        int direction = 0;
        
        
        if (Greenfoot.isKeyDown("a")){
            moveX -= speed;
            setRotation(180);
            
        } 
        if (Greenfoot.isKeyDown("d")){
            moveX += speed;
            setRotation(0);
            
        } 
        if(Greenfoot.isKeyDown("w")){
            moveY -= speed; 
            setRotation(270);
            
        }
        if(Greenfoot.isKeyDown("s")){
            moveY += speed;
            setRotation(90);
            
        }
      
        
        setLocation (getX() + moveX, getY() + moveY);
        
    }
    
    public void shoot() {
        Projectile bullet = new Projectile();
        getWorld().addObject(bullet,getX(), getY());
        bullet.setRotation(getRotation());        
    }
    

    public void hitMe(int damage){
        hp = Math.max(hp -= damage, 0);
        statBar.update(new int[]{hp});
        ((Dungeon)getWorld()).getHealthCounter().addHealthScore(hp);
        
        if(hp == 0){
            Greenfoot.stop();
        }
    }
    
    private GreenfootImage drawPlayer() {
        image = new GreenfootImage("Character.png");        
        return image;
        
    }
}
