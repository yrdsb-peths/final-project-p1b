import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Enemy
{
    public Zombie() {
        super();
        
        maxHP = Dungeon.ENEMY_HP;
        currentHP = maxHP;
        
        image = drawZombie();
        setImage(image);
        
        
    }
    
    public void addedToWorld (World w){
        
        player = w.getObjects(Player.class).get(0);
    }
    
    public void act()
    {
        int random = Greenfoot.getRandomNumber(2);
        if(random == 1){
            turnTowards(player.getX(), player.getY());
            move(1);
        }
        
        Player p = (Player)getOneIntersectingObject(Player.class);
        if(p != null){
            p.hitMe(2);
            
            getWorld().removeObject(this);
            
        }
        
        
    }
    
    private GreenfootImage drawZombie(){
        
        image = new GreenfootImage(24,24);
        image.setColor(Color.RED);
        image.fillOval(0,0,image.getWidth(), image.getHeight());
        return image;
        
    
    }
    }
        
    
    
    
