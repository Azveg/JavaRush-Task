package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();

//        2. BufferedReader для считывания данных с консоли должен быть закрыт.
        reader.close();

//        3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f1));
//        5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        String s ;
        //считываю все в одну строку
        while (bufferedReader.ready()){
            s = bufferedReader.readLine().replaceAll("\\.","!");
            writer.write(s);
        }

        bufferedReader.close();
        writer.close();
    }
}
