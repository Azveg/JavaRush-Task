package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
//        5. Программа должна записывать во второй файл все числа, через пробел,
// из первого файла (используй BufferedWriter с конструктором FileWriter).
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        //считываю все в одну строку
        while (bufferedReader.ready()){
            String [] strings = bufferedReader.readLine().split(" ");
            for (String s: strings) {
                Matcher matcher = Pattern.compile(".*\\d.").matcher(s);
                if (matcher.find()){
                    writer.write(s);
                    writer.write(32);
                }
            }

        }

        bufferedReader.close();
        writer.close();
    }
}
