import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon extends World
{
    private MouseInfo mouse;
    public static final int TIME_PER_WAVE = 30;
    
    public static final int PLAYER_MAX_HP = 10;
    private Player player;
    public static final int PLAYER_BASE_SPEED = 2;
    
    public static final int ENEMY_HP = 2;
    
    private int number;
    
    private int timeMax;
    private int timeLeft;
    
    private Score score;
    private HealthScore health;


    /**
     * Constructor for objects of class Dungeon.
     * 
     */

    public Dungeon()
    {    
        super(800, 600, 1); 
        //setBackground(drawSpace(800,600,40));
        
        timeMax = TIME_PER_WAVE*60;
        timeLeft = timeMax;
        
        player = new Player();
        addObject(player, 400,300);
        
        score = new Score();
        addObject(score, 260, 30);
        Score.score = 0;
        
        health = new HealthScore();
        addObject(health, 600, 30);
        HealthScore.health = 20;
    }
    
    public void act(){
        timeLeft = timeLeft-1;
        checkShoot();
        spawn();
        
    }
    
    private void spawn(){
        number = 100;
        int randomSpawn = Greenfoot.getRandomNumber(number);
        int randX = Greenfoot.getRandomNumber(800);
        int randY = Greenfoot.getRandomNumber(600);
        if(randomSpawn == 1)
        {
            addObject(new Zombie(), randX, randY);
        }
        
    }
    
    private void checkShoot(){
         String key = Greenfoot.getKey();
        
        if("space".equals(key)){
            player.shoot();
        }
    }
    
    public Score getScoreCounter() {
        return score;
    }
    
    public HealthScore getHealthCounter() {
        return health;
    }
    
    
    
    
}
