/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.utilities;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
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

    public Utilities() {

        max = getNumberOfQuestions();
        number = getRandomQuestion(max);
    }

    public static int getNumberOfQuestions() {

        File file = new File(basePath + baseDirectory);
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        System.out.println("@@@@@@@@@@@@@@" + Arrays.toString(directories));

        System.out.println("getNumberOfQuestions :: " + directories.length);
        return directories.length;
    }

    public static int getRandomQuestion(int n) {

        Random rand = new Random();
        int quesNo = rand.nextInt(n) + min;

        System.out.println("getRandomQuestion :: " + quesNo);
        return quesNo;
    }

    public String getPath(String imageType, String fileType) {

        File file = new File(basePath + baseDirectory + "q" + number + "/" + imageType + number + fileType);
        return file.toURI().toString();
    }
}
