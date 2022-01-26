import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Enemy
{
    // Overall similar to skeleton code since they both enemies.
    private static GreenfootSound[] deathSounds;
    private int deathSoundIndex;

    
    public Zombie() {
        super();
        // The HP of the zombie is based on Dungeon constructor called ENEMY_HP.
        maxHP = Dungeon.ENEMY_HP;
        currentHP = maxHP;
        // Draws the zombie and sets up the music.
        image = drawZombie();
        setImage(image);
        
        deathSoundIndex = 0;
        
        deathSounds = new GreenfootSound [20];
        for (int i = 0; i < deathSounds.length; i++){
            deathSounds[i] = new GreenfootSound("Enemy Death.wav");
            deathSounds[i].setVolume(85);
        }

        

        
    }
    
    public void addedToWorld (World w){
        
        player = w.getObjects(Player.class).get(0);
    }
    
    public void act()
    {
        int random = Greenfoot.getRandomNumber(2);
        // 1/2 chance that zombie turns towards and move towards the player
        // That means zombie is slower and allows players time to kill them.
        if(random == 1){
            turnTowards(player.getX(), player.getY());
            move(1);
        }
        // If player hits the zombie, it is considered a hit and player take damage
        Player p = (Player)getOneIntersectingObject(Player.class);
        if(p != null){
            p.hitMe(2);
            // Zombies die after giving a hit so it dies and play death sound
            getWorld().removeObject(this);
            deathSounds[deathSoundIndex].play();
            deathSoundIndex++;
            if (deathSoundIndex >= deathSounds.length){
                deathSoundIndex = 0;
            }

        }

    }
    
    private GreenfootImage drawZombie(){
        
        image = new GreenfootImage("Zombie.png");
        return image;
        
    
    }
    
    public void hitMe(int damage){
        currentHP = Math.max(currentHP - damage, 0);
        // If zombie get hit by bullet, deal 1 damage. If at 0 hp, it dies
        // and play death sounds.
        if(currentHP == 0){
            getWorld().removeObject(this);
            deathSounds[deathSoundIndex].play();
            deathSoundIndex++;
            if (deathSoundIndex >= deathSounds.length){
                deathSoundIndex = 0;
            }
        }
    }
    
    
}
        
    
    
    
