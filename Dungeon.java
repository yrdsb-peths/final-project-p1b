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
    
    private String songName;
    private static GreenfootSound music;



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
        // Adding player to the world
        player = new Player();
        addObject(player, 400,300);
        // Adding score info to world
        score = new Score();
        addObject(score, 260, 30);
        Score.score = 0;
        // Adding number of lives to top of screen
        health = new HealthScore();
        addObject(health, 600, 30);
        HealthScore.health = 20;
        // Automatically start music
        songName = "Battle 1.mp3";
        music = new GreenfootSound (songName);
  
        
        
        music.setVolume(40);
        music.playLoop();
        
        
    }
    
    public void started (){ // this only triggers when the "Run" button is pressed while 
        music.playLoop();     // this World is active, which might happen if paused, but not as a start state.
    }

    public void stopped (){
        music.stop();
    }
    
    public void act(){
        // So 60 times per second, it checks the following
        // Time, Check if you shot and potentionally spawn an enemy
        timeLeft = timeLeft-1;
        checkShoot();
        spawnZombie();
        spawnSkeleton();
    }
    
    
    private void spawnZombie(){
        number = 100;
        // So 60 times per second, randomly generates a number
        // Also randomly generates x and y coordinates 
        int randomSpawn = Greenfoot.getRandomNumber(number);
        int randX = Greenfoot.getRandomNumber(800);
        int randY = Greenfoot.getRandomNumber(600);
        // If randomSpawn is 1 so 1 in 100 chance, it will spawn at random x and y location
        
        Zombie zom = new Zombie();
        if(randomSpawn == 1)
        {
            addObject(zom, randX, randY);
            
        }
        
    }
    
    private void spawnSkeleton(){
        // The number here will determine which side of the world it spawn
        int side = Greenfoot.getRandomNumber (4);
        int xx, yy;
        // Same as zombie but 1 in 300 chance rather than 1 in 100
        int randomSpawn = Greenfoot.getRandomNumber(300);
        
        if (randomSpawn == 1){
            if (side == 0){
                // Since skeletons don't spawn randomly like zombies,
                //Depending on what side number you get, determines
                // What side of the world you are on.
                yy = 50;
                xx = Greenfoot.getRandomNumber (getWidth());
                // Spawn top side of world
            } else if (side == 1) {
                yy = getHeight() - 50;
                xx = Greenfoot.getRandomNumber (getWidth());
                // Spawn bottom side of world
            } else if (side == 2) {
                xx = 35;
                yy = Greenfoot.getRandomNumber (getHeight());
                // Spawn left side of world
            } else {
                xx = getWidth() - 35;
                yy = Greenfoot.getRandomNumber (getHeight());
                // Spawn right side of the world
            }
            addObject (new Skeleton(), xx, yy);
        }
    }
    
    
    private void checkShoot(){
         String key = Greenfoot.getKey();
        // Checks if space bar is clicked then player wil shoot
        if("space".equals(key)){
            player.shoot();
            
        }
    }
    
    
    // Returns our score and health so they can be updated to world.
    public Score getScoreCounter() {
        return score;
    }
    
    public HealthScore getHealthCounter() {
        return health;
    }
    
    
    
    
}
