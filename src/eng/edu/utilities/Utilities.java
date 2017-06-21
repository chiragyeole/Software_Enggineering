/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.utilities;

import eng.edu.ctrl.QuestionController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.Random;

/**
 *
 * @author deeptichavan
 */
public class Utilities {

    public static String basePath = System.getProperty("user.home");
    public static String baseDirectory = "/questions/";
    public static int min = 1;
    public static int max;
    public int number;
    public static String assumptionsTxt;

    public Utilities() {

        max = getNumberOfQuestions();
        number = getRandomQuestion(max);
        assumptionsTxt = getPath("assumptions", ".txt");
    }

    public static int getNumberOfQuestions() {

        File file = new File(basePath + baseDirectory);
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });

        return directories.length;
    }

    public static int getRandomQuestion(int n) {

        Random rand = new Random();
        int quesNo = rand.nextInt(n) + min;

        return quesNo;
    }

    public String getPath(String imageType, String fileType) {

        File file = new File(basePath + baseDirectory + "q" + number + "/" + imageType + number + fileType);
        return file.toURI().toString();
    }
    
    public static BufferedReader getFileReader(String fileName) {
        BufferedReader bufferedReader = null;
        try {

            int n1 = QuestionController.quesNo;
            System.out.println("n1: " + n1);
            File file = new File(basePath + baseDirectory + "q" + n1 + "/" + fileName + n1 + ".txt");
            String fileTxt = file.toURI().toString();
            String[] split = fileTxt.split("file:");
            fileTxt = split[1];

            bufferedReader = new BufferedReader(new FileReader(fileTxt));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return bufferedReader;
    }

}
