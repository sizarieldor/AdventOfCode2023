package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Day1 {

    public static void solveDay1(File input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;
        int result = 0;
        int inputLineCounter = 0;
        while ((line = br.readLine()) != null) {
            inputLineCounter++;
            String lineDigits = replaceStrDigits(line, inputLineCounter);
            int lineVal = getLineSum(lineDigits);
            result += lineVal;
        }

        br.close();
        System.out.println(result);
    }

    private static String replaceStrDigits(String line, int inputLineCounter) {
        String firstStr = "";
        Map<String, String> dict = new HashMap<>();

        try {
            dict.put("one", "1");
            dict.put("two", "2");
            dict.put("three", "3");
            dict.put("four", "4");
            dict.put("five", "5");
            dict.put("six", "6");
            dict.put("seven", "7");
            dict.put("eight", "8");
            dict.put("nine", "9");

            //replace first instance of substring
            int startIndex = Integer.MAX_VALUE;

            for (String key : dict.keySet()) {
                int keyPos = line.indexOf(key);
                if (keyPos != -1 && keyPos < startIndex) {
                    startIndex = keyPos;
                    firstStr = key;
                }
            }
            if ("" != firstStr) {
                line = line.replaceFirst(firstStr, dict.get(firstStr));
            }

            //replace last substring
            startIndex = Integer.MAX_VALUE;
            String lastStrRev = "";
            //reverse the input line
            String lineRev = reverseStr(line);
            String keyRev = "";
            for (String key : dict.keySet()) {
                //reverse the key
                keyRev = reverseStr(key);

                int keyRevPos = lineRev.indexOf(keyRev);
                if (keyRevPos != -1 && keyRevPos < startIndex) {
                    startIndex = keyRevPos;
                    lastStrRev = keyRev;
                }
            } //the string value of the last number has been found

            //find the digit value of the last number
            if ("" != lastStrRev) {
                String valueOfRev = reverseStr(lastStrRev);
                lineRev = lineRev.replaceFirst(lastStrRev, dict.get(valueOfRev));
            }


            line = reverseStr(lineRev);
        } catch (NullPointerException ne) {
            System.out.println("firstStr is " + firstStr + " on line " + inputLineCounter);
        } finally {
            return line;
        }

    }

    private static int getLineSum(String line) {
        Map<String, String> dict = new HashMap<>();
        dict.put("one", "1");
        dict.put("two", "2");
        dict.put("three", "3");
        dict.put("four", "4");
        dict.put("five", "5");
        dict.put("six", "6");
        dict.put("seven", "7");
        dict.put("eight", "8");
        dict.put("nine", "9");

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

        lineSum = 10 * Character.getNumericValue(firstC) + Character.getNumericValue(lastC);
        return lineSum;
    }

    private static String reverseStr(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
}