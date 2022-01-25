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
        
        player = new Player();
        addObject(player, 400,300);
        
        score = new Score();
        addObject(score, 260, 30);
        Score.score = 0;
        
        health = new HealthScore();
        addObject(health, 600, 30);
        HealthScore.health = 20;
        
        songName = "Battle 1.mp3";
        music = new GreenfootSound (songName);
  
        
        
        music.setVolume(50);
        music.playLoop();
        
        
    }
    
    public void started (){ // this only triggers when the "Run" button is pressed while 
        music.playLoop();     // this World is active, which might happen if paused, but not as a start state.
    }

    public void stopped (){
        music.stop();
    }
    
    public void act(){
        timeLeft = timeLeft-1;
        checkShoot();
        spawnZombie();
        spawnSkeleton();
    }
    
    
    private void spawnZombie(){
        number = 100;
        int randomSpawn = Greenfoot.getRandomNumber(number);
        int randX = Greenfoot.getRandomNumber(800);
        int randY = Greenfoot.getRandomNumber(600);
        

        if(randomSpawn == 1)
        {
            addObject(new Zombie(), randX, randY);
        }
        
    }
    
    private void spawnSkeleton(){
        int side = Greenfoot.getRandomNumber (4);
        int xx, yy;
        int randomSpawn = Greenfoot.getRandomNumber(300);
        
        if (randomSpawn == 1){
            if (side == 0){
                yy = 50;
                xx = Greenfoot.getRandomNumber (getWidth());
            } else if (side == 1) {
                yy = getHeight() - 50;
                xx = Greenfoot.getRandomNumber (getWidth());
            } else if (side == 2) {
                xx = 35;
                yy = Greenfoot.getRandomNumber (getHeight());
            } else {
                xx = getWidth() - 35;
                yy = Greenfoot.getRandomNumber (getHeight());
            }
            addObject (new Skeleton(), xx, yy);
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
