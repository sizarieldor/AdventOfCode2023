package org.example;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        try {
        Day1.solveDay1();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}