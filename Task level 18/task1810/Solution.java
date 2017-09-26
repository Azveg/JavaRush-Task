package com.javarush.task.task18.task1810;

/* 
DownloadException
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                while (true) {
                    String s = reader.readLine();
                    if (s.isEmpty())break;
                    FileInputStream inputStream = new FileInputStream(s);
                    if (inputStream.available() < 1000) {
                        reader.close();
                        inputStream.close();
                        throw new DownloadException();
                    }
                }
    }
    public static class DownloadException extends Exception {

    }
}
