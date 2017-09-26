package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        //2. BufferedReader для считывания данных с консоли должен быть закрыт.
        reader.close();

        //3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
        FileReader fileReader = new FileReader(f1);

        // 5. Программа должна записывать во второй файл все байты из первого файла с четным индексом (используй FileWriter).
        FileWriter writer = new FileWriter(f2);
        int i = 0;

        while (fileReader.ready()){
            i++;
            int a = fileReader.read();
            if (i%2==0){
                writer.write(a);
            }
        }

        //4. Поток чтения из файла (FileReader) должен быть закрыт.
        fileReader.close();
        //6. Поток записи в файл (FileWriter) должен быть закрыт.
        writer.close();



    }
}
