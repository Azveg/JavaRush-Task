package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        int a = 0;

        while (inputStream.available() > 0){
            int data = inputStream.read();
            if (data == 44) a++;
        }
        System.out.println(a);
        inputStream.close();
    }
}
