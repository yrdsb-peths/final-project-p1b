import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class HighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScore extends Actor
{
    protected void addedToWorld(World world)
    {
        UserInfo myInfo = UserInfo.getMyInfo();
        ArrayList<Integer> score = new ArrayList<Integer>();
        
        if(myInfo != null)
        {
            score.add(myInfo.getScore());
        }
    }
    
    private void insertionSort(ArrayList<Integer> arr){
        int N = arr.size();
        for(int i = 0; i < N; i++)
        {
            for(int j = 1; j < N; j++)
            {
                if(arr.get(j) < arr.get(j-1))
                {
                    swap(arr, j, j-1);
                    
                }
            }
        }
    }
    
    private void swap(ArrayList<Integer> arr, int i, int j)
    {
        int temp = arr.get(i);
        arr.get(i) = arr.get(j);
        arr.get(i) = temp;
    }

}
