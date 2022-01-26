import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class ScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreScreen extends World
{
    Label display;
    private static GreenfootSound music;
    private String songName;
    // This is the arraylist where we put current score along with our previous scores to sort.
    public static ArrayList<Integer> high = new ArrayList<Integer>();
    
    Label display2;
    Label display3;
    Label display4;
    Label display5;
    Label display6;
    Label display7;
    
    private int temp;
    private int temp2;
    private int temp3;
    
    public ScoreScreen()
    {    
        super(800, 600, 1);
        // Added the label and display it
        display = new Label("Thanks for playing!", 100);
        display2 = new Label(Score.score, 50);
        display3 = new Label ("Your Score: ", 50);
        
        addObject(display, 400, 200);
        addObject(display3, 400, 300);
        addObject(display2, 400, 350);
        
        // Play the ending music
        songName = "Ending.mp3";
        music = new GreenfootSound (songName);
        // These numbers are scores we got based on 7 rounds of playing.
  
        high.add(71);
        high.add(101);
        high.add(52);
        high.add(25);
        high.add(112);
        high.add(17);
        high.add(42);
        // Temp numbers to get highest, second and third highest in arraylist.
        temp = high.size()-1;
        temp2 = high.size()-2;
        temp3 = high.size()-3;
        
        high.add(Score.score);
        // Adding your own score and sorting.
        sort();
        
        // Scores in arraylist.
        display4 = new Label ("High Scores: ", 50);
        display5 = new Label(high.get(temp), 24);
        display6 = new Label(high.get(temp2), 24);
        display7 = new Label(high.get(temp3), 24);
        // Adding labels onto world
        addObject(display4, 400, 400);
        addObject(display5, 400, 450);
        addObject(display6, 400, 475);
        addObject(display7, 400, 500);
        
        music.setVolume(40);
        music.playLoop();
    }
    
    
    // Recursive Quick sort using arraylist.
    private void shuffle(ArrayList<Integer> arr)
    {
        for(int i = 0; i < arr.size(); i++){
            int indexes = Greenfoot.getRandomNumber(arr.size() - i) + i;
            swap(arr, i, indexes);
        }
    }
    
    private void swap(ArrayList<Integer> arr, int i, int j)
    {
        int temp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i, temp);
    }
    
    public int partition(ArrayList<Integer> a, int lo, int hi) {
        int i = lo; 
        int j = hi + 1;
        while (true) {
            while (a.get(++i) < a.get(lo)){ // Find item on left to swap 
                if (i == hi){
                    break;
                }
            }
            while (a.get(--j) > a.get(lo)){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;  // Check if pointers cross 
            }
            swap(a, i, j);  // Swap
        }
        // Swap partitioning element
        swap(a, lo, j);
        return j;  // Return index of item now know to be in place
    }
    
     public void quicksort(ArrayList<Integer> a) {
        shuffle(a);
        quicksort(a, 0, a.size()- 1);
    }
    
     private void quicksort(ArrayList<Integer> a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); 
        quicksort(a, lo, j-1); 
        quicksort(a, j+1, hi);
    }
    
    private void sort()
    {
        quicksort(high);
        
    }
}
