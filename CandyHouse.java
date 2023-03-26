
package code5_1001844964;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Aryan
 */

public class CandyHouse extends House
{
    public CandyHouse(String houseName,HashMap<String,Integer>CandyList)
    {       
        super(houseName,CandyList);
        this.CandyList = CandyList;   
    }
    
    public synchronized String ringDoorbell(TrickOrTreater TOT)
    {
        String Candy = "";
        int count ;
        int x;
        int upperbound;
        int int_random;
        
        TOT.addToPath("+");
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
           Thread.currentThread().interrupt();
        }
        
           count = (int) (Math.random() *  CandyList.size() +1);
            
        for (HashMap.Entry mapElement : CandyList.entrySet())
        {
            x = (int)mapElement.getValue();
            if(x == count)
            {
                Candy = (String)mapElement.getKey();
            }
        }      
       return Candy;
    }  
}
