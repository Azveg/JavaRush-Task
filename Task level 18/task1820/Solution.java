package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
    //Программа должна два раза считать имена файлов с консоли.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();

        FileInputStream input = new FileInputStream(s1);
        FileWriter writer = new FileWriter(s2);

        //Заполнение объекта StringBuilder
        StringBuilder builder = new StringBuilder();
        while (input.available() > 0) builder.append((char) input.read());
        String[] totalLine = builder.toString().split(" ");

        //Записываем во второй файл округленные числа через пробел
        String forOut;
        for (int i = 0; i < totalLine.length; i++) {
            forOut = Long.toString(Math.round(Double.parseDouble(totalLine[i])));
            writer.write(forOut+" ");
        }

        //Закрытие потоков
        input.close();
        writer.close();
    }
}
