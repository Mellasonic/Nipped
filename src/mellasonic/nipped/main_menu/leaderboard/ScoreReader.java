/* ICS Final Project Nipped
 2022/06/03
 Time spent: 40 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - June 3, 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.0
 2022/06/03
 Time spent: 10 mins
 New features/processing: Added template
*/
/*
 Modification Authors: James Huynh
 Version 1.1
 2022/06/03
 Time spent: 30 mins
 New features/processing: Added functionality
*/
package mellasonic.nipped.main_menu.leaderboard;

import java.util.*;
import java.io.*;

/**
* This class has utilites to read scores from the text file.
*/
public class ScoreReader {
    final static int readAmt = 15;
    /**
    * This method returns a sorted arraylist of scores for every score in the folder
    * @return A sorted arraylist of scores
    */
    public static ArrayList<Score> getScores(){
        ArrayList<Score> out = new ArrayList<Score>();
        try{
            BufferedReader in = new BufferedReader(new FileReader("scores.txt"));
            for(int i = 0; i < readAmt;i++){
               String line = in.readLine();
               if(line == null) break;
               String[] arr = line.split(" ");
               out.add(new Score(arr[0], Integer.parseInt(arr[1])));
            }
        }
        catch(Exception e){ e.printStackTrace();}
        for(int i = 0 ; i < out.size();i++){
            int swapInd = i;
            for(int j = i+1;j < out.size(); j++){
               if(out.get(j).score < out.get(swapInd).score){
                  swapInd = j;
               }
            }
            Score store = out.get(swapInd);
            out.set(swapInd, out.get(i));
            out.set(i, store);
        }
        return out;
    }
}
