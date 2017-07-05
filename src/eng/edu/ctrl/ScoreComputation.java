/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

import eng.edu.utilities.Utilities;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 *
 * @author Gayatri
 */
public class ScoreComputation {
    
    public static int calculateScore(int numberOfIncorrectResponses, int numberOfResponses, String scoreEvaluationType, int quesNo) {
        ArrayList<Integer> scoreWeightage = readScoreFile(quesNo);
        int score=0;
        int positiveScore;
        int negativeScore;
        if(scoreEvaluationType.equals("assumption")){
            positiveScore = scoreWeightage.get(0);
            negativeScore = scoreWeightage.get(1);
        }
        else{
            positiveScore = scoreWeightage.get(2);
            negativeScore = scoreWeightage.get(3);
        }
        score = positiveScore*(numberOfResponses-numberOfIncorrectResponses) + (negativeScore*numberOfIncorrectResponses);
        return score;
     
    }
    
    
    /*
    * read the scores text file and get the weightage
    */
    public static ArrayList<Integer> readScoreFile(int quesNo){
        ArrayList<Integer> scoreWeightage = new ArrayList<>();
        try{
            String fileName = "score";
            BufferedReader bufferedReader = Utilities.getFileReader(fileName, quesNo);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                 String scoreAssignment[] = currentLine.split(":");
                 String scores[] = scoreAssignment[1].split(",");
                 for(int i=0; i<scores.length; i++){
                     scoreWeightage.add(Integer.parseInt(scores[i]));
                 }
            }
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        return scoreWeightage;
    }
}
