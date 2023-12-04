package org.example;

import java.io.*;

public class Day1 {

    public static void solveDay1(File input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;
        int result = 0;
        while ((line = br.readLine()) != null) {
            int lineVal = getLineSum(line);
            result += lineVal;
        }
        br.close();
        System.out.println(result);
    }

    private static int getLineSum(String line) {
        int lineSum = 0;
        char[] lineChars = line.toCharArray();

        //get first char
        char firstC = 0;
        for (int i = 0; i < lineChars.length; i++) {
            char c = lineChars[i];
            if (Character.isDigit(c)) {
                firstC = c;
                break;
            }
        }

        //get last char
        char lastC = 0;
        for (int i = lineChars.length - 1; i >= 0; i--) {
            char c = lineChars[i];
            if (Character.isDigit(c)) {
                lastC = c;
                break;
            }
        }

        lineSum = 10*firstC + lastC;
/*        for (int i = 0; i < line.length(); i++) {
            if(Character.isDigit(line.charAt(i))){
                int cVal = (int)line.charAt(i);
                lineSum += cVal;
            }
        }*/

        return lineSum;
    }
}