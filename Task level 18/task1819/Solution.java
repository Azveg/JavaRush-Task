package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //Программа должна два раза считать имена файлов с консоли.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine(); //считываем имя первого файла
        String fileName2 = br.readLine(); //считываем имя второго файла
        br.close(); //закрываем поток чтения с консоли, он больше не нужен

            FileInputStream inFile1 = new FileInputStream(fileName1); //открываем для чтения первый файл
            ArrayList<Integer> buffer = new ArrayList<>(); //сюда мы пока запишем первый файл
            while (inFile1.available() > 0)
            {
                buffer.add(inFile1.read()); //записываем первый файл
            }
            inFile1.close(); //закрываем первый файл
            FileInputStream inFile2 = new FileInputStream(fileName2); //открываем для чтения второй файл
            FileOutputStream outFile1 = new FileOutputStream(fileName1); //открываем для записи первый файл
            while (inFile2.available() > 0)
            {
                int data = inFile2.read(); //читаем второй файл
                outFile1.write(data); //записываем первый файл
            }
            inFile2.close(); //закрываем второй файл
            for (int i = 0; i < buffer.size(); i++)
            {
                outFile1.write(buffer.get(i)); //записываем первый файл после второго
            }
            outFile1.close(); //закрываем первый файл

    }
}
