package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        double sumCh = 0;
        double sumSp = 0;

        while (inputStream.available() > 0){
            int data = inputStream.read();
            sumCh++;
            if (data==32)
                sumSp++;
        }
        inputStream.close();
        double res = (sumSp/sumCh)*100;

        System.out.println(String.format("%.2f", res));

    }
}
