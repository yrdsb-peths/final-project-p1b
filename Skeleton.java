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
    
    private static GreenfootSound[] deathSounds2;
    private int deathSoundIndex2;
    
    public Skeleton (){
        // So the cooldown between arrow shots is 2.5 seconds
        maxCd = 150;
        cd = maxCd;
        
        image = drawSkeleton();
        setImage(image);
        // Setting up the music objects
        deathSoundIndex2 = 0;
        
        deathSounds2 = new GreenfootSound [20];
        for (int i = 0; i < deathSounds2.length; i++){
            deathSounds2[i] = new GreenfootSound("Enemy Death.wav");
            deathSounds2[i].setVolume(85);
        }
    }
    
    public void addedToWorld (World w){
        
        player = w.getObjects(Player.class).get(0);
    }
    
    public void act()
    {
        // If cooldown is still there, minus 1 from cooldown
        // Otherwise shoot the arrow
        if (cd > 0){
            cd--;
        } else {
            getWorld().addObject(new Arrow(), getX(), getY());
            cd = maxCd;
        }
        // So 1/2 of the skeleton turning towards player, so looks more realistic
        // When skeleton facing one way and arrow goes another way
        int random = Greenfoot.getRandomNumber(2);
        if(random == 1){
            turnTowards(player.getX(), player.getY());
            
        }
        // If player hits the skeleton, it counts as a hit, and takes 2 damage
        Player p = (Player)getOneIntersectingObject(Player.class);
        if(p != null){
            p.hitMe(2);
            getWorld().removeObject(this);
            // Plays the death sound when enemy dies.
            deathSounds2[deathSoundIndex2].play();
            deathSoundIndex2++;
            if (deathSoundIndex2 >= deathSounds2.length){
                deathSoundIndex2 = 0;
            }

        }
    }
    
    private GreenfootImage drawSkeleton(){
        
        image = new GreenfootImage("Skeleton.png");
        return image;
        
    
    }
    
    public void hitMe(int damage){
        // If took damage from bullet, minus health and when go to 0, it dies
        currentHP = Math.max(currentHP - damage, 0);
        if(currentHP == 0){
            getWorld().removeObject(this);
            // Plays death sounds when enemy dies.
            deathSounds2[deathSoundIndex2].play();
            deathSoundIndex2++;
            if (deathSoundIndex2 >= deathSounds2.length){
                deathSoundIndex2 = 0;
            }
        }
    }
}
