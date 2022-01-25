import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor
{
    public static int score = 0;
    
    Color trans = new Color(0, 0, 0, 0);
    public Score(){
        setImage(new GreenfootImage("Score : " + score, 80, Color.BLACK, trans));
    }
    
    public void addScore(int amount){   
        score += amount;
        setImage(new GreenfootImage("Score : " + score, 80, Color.BLACK, trans));   
    }
}
