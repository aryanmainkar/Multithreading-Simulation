/*
 * Aryan Mainkar 1001844964
 */
package code5_1001844964;

/**
 *
 * @author Aryan
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class TrickOrTreater implements Runnable
{
    public static int ImDone;
    private String name;
    private String path = ".";
    private ArrayList<House>ListOfHouses = new ArrayList<>();
    private HashMap<String, Integer>Bucket = new HashMap<>();
    
    public TrickOrTreater(String name,ArrayList<House>ListOfHouses)
    {
        this.name = name;
        this.ListOfHouses = ListOfHouses;  
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public void addToPath(String name)
    {
        path += name;     
    }
    
    private void Walk(int Speed)
    {
        for(int i = 0 ; i < 10 ; i++)
        {
            path += ".";        
            try
            {
                Thread.sleep(Speed);
            }
            catch (InterruptedException e)
            {
                    Thread.currentThread().interrupt();
            }       
        }   
    }
    
    public String printBucket()
    {
        String Candy = "";
        String BucketContents ="";
        BucketContents = String.format("%-10s - ", name);
        int CandyCount = 0;
        
        for(HashMap.Entry mapElement : Bucket.entrySet())
        {
            Candy = (String)mapElement.getKey();
            CandyCount = (int)mapElement.getValue();
            BucketContents += String.format("%15s %d ", Candy, CandyCount);               
        }      
        BucketContents += "\n";
        return BucketContents; 
    }
    
    @Override
    
    public void run() 
    {
        int speed,count = 0;
        String Candy = "";
        
        for(House it:ListOfHouses)
        {
            speed = (int) (Math.random() * 1501);
            Walk(speed);
            Candy = it.ringDoorbell(this);
            
            if(Bucket.containsKey(Candy))
            {
                count = Bucket.get(Candy); 
                Bucket.put(Candy,++count);              
            }
            else
            {
               Bucket.put(Candy,1);
            }      
        }
        
        synchronized (this)
        {
            ImDone++;    
        }  
    }   
}
