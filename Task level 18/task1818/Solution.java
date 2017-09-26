package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();

        FileOutputStream outputStream = new FileOutputStream(f1);
        FileInputStream inputStream1 = new FileInputStream(f2);
        FileInputStream inputStream2 = new FileInputStream(f3);

        while (inputStream1.available() > 0){
            int data1 = inputStream1.read();
            outputStream.write(data1);
        }
        inputStream1.close();

        while (inputStream2.available() > 0){
            int data2 = inputStream2.read();
            outputStream.write(data2);
        }
        inputStream2.close();
        outputStream.close();
    }
}
