package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(
                new InputStreamReader(new FileInputStream(name), StandardCharsets.UTF_8));
        String line;
        String f = args[0];
        while ( reader1.readLine()!= null){
            line = reader1.readLine();
            if (line.startsWith(f))
                System.out.println(line);
        }
        reader1.close();
    }
}
