package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        long sum = 0;

        while (inputStream.available()>0){
           int data = inputStream.read();
           if ((data >= 65 && data <= 90) || (data >= 97 && data <= 122))
               sum++;
        }
        inputStream.close();
        System.out.println(sum);
    }
}
