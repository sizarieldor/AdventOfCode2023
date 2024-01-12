package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Day3 {

    private static final char DOT = '.';
    private static final HashSet<Character> digits = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

    public static void solveDay3(File input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line = "";
        int totalSum = 0;

        while ((line = br.readLine()) != null) {
            totalSum += calculateLine(line);
        }

        System.out.println(totalSum);
    }

    private static int calculateLine(String line) {
        while (line.contains("..")) {
            line = line.replace("..", ".");
        }
        /*
        .487.599.411.574.679.136.30.255.432.
.*.*.*.&586.375.@.*./.835.610*./.582.
.833.304.&.862.203.922.125.819.@.563.722.775.
.+.994.#.*.244.457.*.867.829.469.#.*.
313.753.596.*.270./.*.38.836.850.914.942*215
.*.10.525.515.417$.976.*.878.613/.*247.*.+.
.725.*.848*.236.25.#605.602.352.+.505#.619.
741.872.899.596.824.*.542.#.893.299&.*.389.176.*.
.*.691.165.*./.@.#.973.%.207.435.296.269.&.*.$.112.
.707.311.@.522.561.470.152.524.964*853.*.+.541.578.871.
.*805.774.*.397*.$261.74.956.*.451.
*/
        char[] lineChars = line.toCharArray();
        StringBuilder sbNumber = new StringBuilder();
        List<Integer> numbersInLine = new ArrayList<>();

        boolean isRecording = false;

        for (int i = 0; i < lineChars.length; i++) {
            char currChar = lineChars[i];

            if (DOT == currChar) {
                isRecording = false;
                if (sbNumber.length() > 0) {
                    int currNumber = Integer.parseInt(sbNumber.toString());
                    numbersInLine.add(currNumber);
                    sbNumber.delete(0, sbNumber.length());
                }

            } else if (digits.contains(currChar)) {
                if (isRecording) {
                    //append the digit to the current number
                    sbNumber.append(currChar);
                }


            } else if (!digits.contains(currChar) || DOT != currChar) {
                //char at i is symbol
                isRecording = true;
            }
        } //end of loop - clear the stringbuilder

        isRecording = false;
        if (sbNumber.length() > 0) {
            int currNumber = Integer.parseInt(sbNumber.toString());
            numbersInLine.add(currNumber);
            sbNumber.delete(0, sbNumber.length());
        }

        for (int i = lineChars.length - 1; i >= 0; i--) {
            char currChar = lineChars[i];

            if (DOT == currChar) {
                isRecording = false;
                if (sbNumber.length() > 0) {
                    int number = Integer.parseInt(sbNumber.reverse().toString());
                    numbersInLine.add(number);
                    sbNumber.delete(0, sbNumber.length());
                }

            } else if (digits.contains(currChar)) {
                if (isRecording) {
                    sbNumber.append(currChar);
                }

            } else if (!digits.contains(currChar) && DOT != currChar) {
                //we have detected a symbol, the following chars need to be recorded
                isRecording = true;
            }
        } //end of reverse loop

        isRecording = false;
        if (sbNumber.length() > 0) {
            int number = Integer.parseInt(sbNumber.reverse().toString());
            numbersInLine.add(number);
            sbNumber.delete(0, sbNumber.length());
        }

        int sum = 0;
        for (Integer num : numbersInLine) {
            sum += num;
        }

        System.out.println("Sum of valid numbers in line is " + sum);
        return sum;
    }


}
