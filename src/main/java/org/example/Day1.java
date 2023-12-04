package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Day1 {

    public static void solveDay1(File input) throws IOException {
/*        URL aURL = new URL("https://adventofcode.com/2023/day/1/input");
        InputStreamReader isr = new InputStreamReader(aURL.openStream());
        BufferedReader br = new BufferedReader(isr);

        String dataLine;
        while((dataLine = br.readLine()) != null){
            System.out.println(dataLine);
        }
        br.close();*/

        BufferedReader br = new BufferedReader(new FileReader(input));
        System.out.println(br.readLine());


    }
}