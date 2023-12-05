package org.example;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            File input = new File("src\\Inputs\\Day1.txt");
            Day1.solveDay1(input);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}