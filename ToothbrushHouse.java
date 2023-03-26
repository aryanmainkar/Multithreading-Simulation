
package code5_1001844964;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Aryan
 */
public class ToothbrushHouse extends House
{
    public ToothbrushHouse(String houseName,HashMap<String,Integer>CandyList)
    {       
        super(houseName,CandyList);
        this.CandyList = CandyList;     
    }
    public synchronized String ringDoorbell(TrickOrTreater TOT)
    {       
        TOT.addToPath("-"); 
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
           Thread.currentThread().interrupt();
        }              
       return "ToothBrush";
    }
   
}
