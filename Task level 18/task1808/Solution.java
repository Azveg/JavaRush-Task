package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream file1 = new FileInputStream(file);
        FileOutputStream outputStream1 = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);

        byte[] buffer = new byte[file1.available()];
        int count = file1.read(buffer);

        if (count % 2 == 0 ){
            outputStream1.write(buffer, 0,count/2);
            outputStream2.write(buffer, count/2,count/2);
        } else {
            outputStream1.write(buffer, 0,count/2+1);
            outputStream2.write(buffer, count/2+count%2,count/2);
        }

        file1.close();
        outputStream1.close();
        outputStream2.close();
    }
}
