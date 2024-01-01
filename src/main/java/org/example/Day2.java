package org.example;

import java.io.*;
// line = "Game1:13green,3red;4red,9green,4blue;9green,10red,2blue"
// lineData = "13green,3red;4red,9green,4blue;9green,10red,2blue"
// arrAllDrawsInLine = {"13green,3red" , "4red,9green,4blue" , "9green,10red,2blue"}
// singleDraw = "13green,3red"

public class Day2 {
    public static void solveDay2(File input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line = "";
        int lineNum = 1;
        int totalSum = 0;
        int totalPower = 0;

        while ((line = br.readLine()) != null) {
            line = line.replaceAll(" ", "");
            String[] arrLineSplit = line.split(":");
            String lineData = arrLineSplit[1];
            String[] arrAllDrawsInLine = lineData.split(";");

            boolean allDrawsAreValid = true;
            for (int i = 0; i < arrAllDrawsInLine.length; i++) {
                String singleDraw = arrAllDrawsInLine[i];
                if (!checkIfDrawValid(singleDraw)) {
                    allDrawsAreValid = false;
                }
            }
            if (allDrawsAreValid) {
                totalSum += lineNum;
            }
            lineNum++;

// line = "Game1:13green,3red;4red,9green,4blue;9green,10red,2blue"
// lineData = "13green,3red;4red,9green,4blue;9green,10red,2blue"
// arrAllDrawsInLine = {"13green,3red" , "4red,9green,4blue" , "9green,10red,2blue"}
// singleDraw = "13green,3red"

            //Part 2 logic
            int linePower = 0;
            int minRedNeed = Integer.MIN_VALUE;
            int minGreenNeed = Integer.MIN_VALUE;
            int minBlueNeed = Integer.MIN_VALUE;
            int[] maxColors = new int[3];
            maxColors[0] = minRedNeed;
            maxColors[1] = minGreenNeed;
            maxColors[2] = minBlueNeed;

            for (int i = 0; i < arrAllDrawsInLine.length; i++) {
                String singleDraw = arrAllDrawsInLine[i];
                maxColors = findMinRequired(singleDraw, maxColors);

            }

            int power = maxColors[0] * maxColors[1] * maxColors[2];
            totalPower += power;

        } //go to next line

        System.out.println(totalSum);
        System.out.println(totalPower);
    }

    /*
    Game 1: 13 green, 3 red; 4 red, 9 green, 4 blue; 9 green, 10 red, 2 blue
    Game 2: 3 red, 8 green, 1 blue; 4 green, 11 blue, 2 red; 3 blue, 2 red, 6 green; 5 green, 15 blue, 1 red; 2 blue, 2 red, 5 green; 12 blue, 7 green, 2 red
    Game 3: 1 red, 9 green, 3 blue; 8 green, 4 red, 11 blue; 6 red, 10 blue; 6 green, 6 red, 12 blue; 2 blue, 11 green, 7 red; 12 blue, 9 green, 8 red
    Game 4: 7 red, 2 green, 1 blue; 12 green; 12 green
     */

// line = "Game1:13green,3red;4red,9green,4blue;9green,10red,2blue"
// lineData = "13green,3red;4red,9green,4blue;9green,10red,2blue"
// arrAllDrawsInLine = {"13green,3red" , "4red,9green,4blue" , "9green,10red,2blue"}
// singleDraw = "13green,3red"

    private static int[] findMinRequired(String singleDraw, int[] singleDrawMaxes) {
        int maxRed = singleDrawMaxes[0];
        int maxGreen = singleDrawMaxes[1];
        int maxBlue = singleDrawMaxes[2];

        String[] tokens = singleDraw.split(",");
        for (int i = 0; i < tokens.length; i++) {
            String[] splitToken = splitToken(tokens[i]);
            int cubeCount = Integer.parseInt(splitToken[0]);
            String cubeColor = splitToken[1];

            if ("red".equals(cubeColor)) {
                if (cubeCount > maxRed) {
                    maxRed = cubeCount;
                }
            } else if ("green".equals(cubeColor)) {
                if (cubeCount > maxGreen) {
                    maxGreen = cubeCount;
                }
            } else if ("blue".equals(cubeColor)) {
                if (cubeCount > maxBlue) {
                    maxBlue = cubeCount;
                }
            }
        }

        singleDrawMaxes[0] = maxRed;
        singleDrawMaxes[1] = maxGreen;
        singleDrawMaxes[2] = maxBlue;

        return singleDrawMaxes;
    }

    private static boolean checkIfDrawValid(String singleDraw) {
        //only 12 red cubes, 13 green cubes, and 14 blue cubes
        final int MAX_RED = 12;
        final int MAX_GREEN = 13;
        final int MAX_BLUE = 14;
        boolean isValidDraw = true;

        String[] tokens = singleDraw.split(",");
        for (int i = 0; i < tokens.length; i++) {
            String[] splitToken = splitToken(tokens[i]);
            int cubeCount = Integer.parseInt(splitToken[0]);
            String cubeColor = splitToken[1];

            if (("red".equals(cubeColor) && MAX_RED < cubeCount)
                    || ("green".equals(cubeColor) && MAX_GREEN < cubeCount)
                    || ("blue".equals(cubeColor) && MAX_BLUE < cubeCount)) {
                isValidDraw = false;
            }
        }

        return isValidDraw;
    }

    private static String[] splitToken(String token) {
        String[] splitToken = new String[2];
        String digitsPart = null;
        String wordsPart = null;
        char cFirst = token.charAt(0);
        char cSecond = token.charAt(1);
        boolean cFirstIsDigit = ((int) cFirst >= 48 && (int) cFirst <= 57);
        boolean cSecondIsDigit = ((int) cSecond >= 48 && (int) cSecond <= 57);
        if (cFirstIsDigit && cSecondIsDigit) {
            digitsPart = "" + cFirst + cSecond;
            wordsPart = token.substring(2);
        } else if (cFirstIsDigit) {
            digitsPart = "" + cFirst;
            wordsPart = token.substring(1);
        }
        splitToken[0] = digitsPart;
        splitToken[1] = wordsPart;

        return splitToken;
    }
}