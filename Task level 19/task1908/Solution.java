package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//        1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();

//        2. BufferedReader для считывания данных с консоли должен быть закрыт.
        reader.close();

//        3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f1));
//        5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        String s = "! ";
        //считываю все в одну строку
        while (bufferedReader.ready()){
                s+= (char) bufferedReader.read();
        }
        //объявляю паттерн и применяю его к строке
        Pattern pattern = Pattern.compile("\\b[0-9]+\\b");
        Matcher matcher = pattern.matcher(s);
        //делаю поиск совпадений паттерна
        while (matcher.find()){
            //пишу совпадающую группу
            writer.write(matcher.group());
            writer.write(32);
        }

        bufferedReader.close();
        writer.close();

//        4. Поток чтения из файла (BufferedReader) должен быть закрыт.

//        6. Поток записи в файл (BufferedWriter) должен быть закрыт.
    }
}
