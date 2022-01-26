import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    // Constructors of objects
    private int hp;
    private int speed;
    private StatBar statBar;
    private GreenfootImage image;
    
    private static GreenfootSound[] gunSounds;
    private int gunSoundIndex;
    
    private int shotCooldown, cooldownCounter;
    
    public Player()
    {
        // Declaring sounds and hp
        speed = 4;
        
        hp = 20;
        
        
        statBar = new StatBar(10, 10, this, 36, 6, 24,  Color.GREEN,Color.RED, false);
        
        image = drawPlayer();
        setImage(image);
        // Declaring the sounds so when player shoots makes a gun shot
        gunSoundIndex = 0;
        
        gunSounds = new GreenfootSound [20];
        for (int i = 0; i < gunSounds.length; i++){
            gunSounds[i] = new GreenfootSound("Gun Sound.mp3");
            gunSounds[i].setVolume(70);
        }
        
        cooldownCounter = shotCooldown;
    }
    // We tried to add a nicer health bar but ran out of time.
    public void addToWorld (World w){
        w.addObject(statBar, 0, 0);
        statBar.update();
    }
    
    public void act(){
        // 60 times a second, check if you press your WASD keys.
        checkKeys();
        statBar.moveMe();
        
        if (cooldownCounter > 0)
        {
            cooldownCounter--;
        }
    }
    
    private void checkKeys(){
        // Check for movement and adjusts.
        int moveX = 0;
        int moveY = 0;
        int direction = 0;
        // Depending on which key you press, you will rotate towards that direction
        // and move accordingly depending on your speed.
        
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
      
        // Set location of player to coordinates based on previous location and
        // which way player wants to move.
        setLocation (getX() + moveX, getY() + moveY);       
    }
    
    public void shoot() {
            
        // If you shoot your gun, sounds will play and projectile will be added to world.
        if (cooldownCounter == 0){
            gunSounds[gunSoundIndex].play();
            gunSoundIndex++;
            if (gunSoundIndex >= gunSounds.length){
                gunSoundIndex = 0;
            }
            
            Projectile bullet = new Projectile();
            getWorld().addObject(bullet,getX(), getY());
            bullet.setRotation(getRotation());  
        
            cooldownCounter = shotCooldown;
        }
    }
    

    public void hitMe(int damage){
        // If you get hit, you take damage and send that information to Dungeon world so health bar can be updated.
        hp = Math.max(hp -= damage, 0);
        statBar.update(new int[]{hp});
        ((Dungeon)getWorld()).getHealthCounter().addHealthScore(hp);
        // If you get 0 hp, you get moved to the ScoreScreen world.
        if(hp == 0){
            Greenfoot.setWorld(new ScoreScreen());
            ((Dungeon)getWorld()).stopped();
        }
    }
    // Draws the player based on image we have in image folder.
    private GreenfootImage drawPlayer() {
        image = new GreenfootImage("Character.png");        
        return image;
        
    }
}
