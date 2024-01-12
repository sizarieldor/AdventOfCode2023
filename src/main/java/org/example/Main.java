package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
//            File input = new File("src\\Inputs\\Day1.txt");
//            Day1.solveDay1(input);

//            File input = new File("src\\Inputs\\Day2.txt");
//            Day2.solveDay2(input);

            File input = new File("src\\Inputs\\Day3.txt");
            Day3.solveDay3(input);



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}