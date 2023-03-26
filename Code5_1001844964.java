/*
 * Aryan Mainkar 1001844964
 */
package code5_1001844964;

/**
 *
 * @author Aryan
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class Code5_1001844964 
{

    /**
     * @param args the command line arguments
     */
    
    public static void CreateCandyList(String CandyFileName,HashMap<String,Integer>CandyListMap)throws FileNotFoundException
    {
        File fileIn = null;
        Scanner inFileRead = null;
        String FileLine = "";
        String FileLineArr[] = new String[2];   
        fileIn = new File(CandyFileName);

        try 
        {
            inFileRead = new Scanner(fileIn);
        } 
        catch (Exception e) 
        {
            System.out.printf("%s file name does not exist...exiting", CandyFileName);
            System.exit(0);
        }
        
        while (inFileRead.hasNextLine()) 
        {
            FileLine = inFileRead.nextLine();
            FileLineArr = FileLine.split("\\|");
            CandyListMap.put(FileLineArr[0],Integer.parseInt(FileLineArr[1]));
            
        }
       
        inFileRead.close();
           
    }
    
    public static String CreateHouses(String HouseFileName,ArrayList <House> Houses,HashMap<String,Integer>CandyList)throws FileNotFoundException
    {
        String HouseHeading = "           ";
        File fileIn = null;
        Scanner inFileRead = null;
        String houseName = "";
        String FileLineArr[] = new String[1]; 
        int randomno = 0;
        int upperbound;
        int int_random;
        fileIn = new File(HouseFileName);

        try 
        {
            inFileRead = new Scanner(fileIn);
        } 
        catch (Exception e) 
        {
            System.out.printf("%s file name does not exist...exiting", HouseFileName);
            System.exit(0);
        }

        while (inFileRead.hasNextLine()) 
        {
            houseName = inFileRead.nextLine();
            HouseHeading += houseName;
            for (int i = 0; i < 11-houseName.length(); i++)
            {
                HouseHeading += " ";
            }
            randomno = (int) (Math.random() * 2);
           
            if(randomno == 0)
            {
                 Houses.add(new CandyHouse(houseName,CandyList));               
            }
            else
            {
                 Houses.add(new ToothbrushHouse(houseName,CandyList));          
            }
           
        }
        inFileRead.close();
        HouseHeading += "\n\n";  
        return HouseHeading;
    }
    
    public static void CreateTOTs(String TOTFileName,ArrayList<TrickOrTreater>TOTList,ArrayList <House> Houses)throws FileNotFoundException
    {
        File fileIn = null;
        Scanner inFileRead = null;
        String FileLine = "";
        String FileLineArr[] = new String[1];   
        fileIn = new File(TOTFileName);

        try 
        {
            inFileRead = new Scanner(fileIn);
        } 
        catch (Exception e) 
        {
            System.out.printf("%s file name does not exist...exiting", TOTFileName);
            System.exit(0);
        }
        
        while (inFileRead.hasNextLine()) 
        {
            FileLine = inFileRead.nextLine();
            TOTList.add(new TrickOrTreater(FileLine,Houses));      
        }
        inFileRead.close();     
    }
       
    public static void main(String[] args) throws FileNotFoundException
    {
        String CandyFileName = "";
        String HouseFileName = "";
        String TOTFileName = "";
        String BucketContents = "";
        String HouseHeading = "";
        String ScreenOutput = ""; 
        ArrayList <House> Houses = new ArrayList<>();
        ArrayList<TrickOrTreater>TOTList = new ArrayList<>();
        HashMap <String,Integer> CandyListMap = new HashMap <>();
        
        CandyFileName = args[0];
        HouseFileName = args[1];
        TOTFileName = args[2];
       
        CreateCandyList(CandyFileName,CandyListMap); 
        HouseHeading = CreateHouses(HouseFileName,Houses,CandyListMap);
        CreateTOTs(TOTFileName,TOTList,Houses);       
        ExecutorService executorService = Executors.newCachedThreadPool();    
       
        for(TrickOrTreater it : TOTList)       
        {
            executorService.execute(it);
        }
        
        TextAreaFrame TAF = new TextAreaFrame();
        TAF.setVisible(true);
             
        while(TrickOrTreater.ImDone != TOTList.size())
        {
            ScreenOutput = String.format("%s", HouseHeading);
            for(TrickOrTreater it : TOTList)
            {
                ScreenOutput += String.format("%s%s\n", it.getPath(), it.getName());
            }
            TAF.textArea.setText(ScreenOutput); 
        }
       
        executorService.shutdown();        
        BucketContents = "Candy!!\n\n";

        for(TrickOrTreater it : TOTList)
            {
                BucketContents += it.printBucket();
            }
           
        TAF.textArea.setText(BucketContents);         
    }
}

  