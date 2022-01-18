import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon extends World
{

    public static final int TIME_PER_WAVE = 30;
    
    public static final int PLAYER_MAX_HP = 10;
    private Player player;
    public static final int PLAYER_BASE_SPEED = 3;
    
    public static final int ENEMY_HP = 2;
    
    
    
    
    
    private int timeMax;
    private int timeLeft;
    

    private int playerDirection;
    private int playerDirection2;
    private int playerSpeed;
    
    
    
    
    

    Label title;
    /**
     * Constructor for objects of class Dungeon.
     * 
     */

    public Dungeon()
    {    
        super(800, 600, 1); 
        setBackground(drawSpace(800,600,40));
        
        timeMax = TIME_PER_WAVE*60;
        timeLeft = timeMax;
        
        player = new Player();
        addObject(player, 400,300);
        
        playerSpeed = PLAYER_BASE_SPEED;

        
        

        
    }
    
    public void act(){
        timeLeft = timeLeft-1;
        checkKeys();
        spawn();
        
    }
    
    private void spawn(){
        int randomSpawn = Greenfoot.getRandomNumber(20);
        int randX = Greenfoot.getRandomNumber(800);
        int randY = Greenfoot.getRandomNumber(600);
        if(randomSpawn == 1)
        {
            addObject(new Zombie(), randX, randY);
        }
        
    }
    
    private void checkKeys(){
        // Check for movement and adjusts.
        playerDirection = 0;
        playerDirection2 = 0;
        int cooldown = 30;
        String key = Greenfoot.getKey();
        
        if (Greenfoot.isKeyDown("left")){
            playerDirection = -1;
        } 
        if (Greenfoot.isKeyDown("right")){
            playerDirection = 1;
        } 
        if(Greenfoot.isKeyDown("up")){
            playerDirection2 = -1;
            
        }
        if(Greenfoot.isKeyDown("down")){
            playerDirection2 = 1;
        }
        player.setLocation (player.getX() + playerSpeed * playerDirection, player.getY() + playerSpeed * playerDirection2);
        
        
        if(Greenfoot.isKeyDown("space")){
            addObject(new Projectiles(), player.getX(), player.getY());
            cooldown = 30;
        }
        
        
    }
    
    public static GreenfootImage drawSpace (int width, int height, int density){
        // Draws the background as gray.
        GreenfootImage world = new GreenfootImage (width, height);
        world.setColor (Color.GREEN);
        world.fill();
        
        return world;
    }
    
    
}
