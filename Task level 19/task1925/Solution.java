package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        BufferedWriter output = new BufferedWriter(new FileWriter(args[1]));

        StringBuffer buffer = new StringBuffer();
        while (input.ready()) {
            String[] array = input.readLine().split(" ");
            for (int i = 0; i < array.length; i++) {
                if (array[i].length() > 6) {
                    buffer.append(array[i] + " ");
                }
            }
        }
        String finalLine;
        if (buffer.toString().length() > 0) {
            finalLine = buffer.toString().substring(0, buffer.toString().length() - 1);
            output.write(finalLine);
        }
        input.close();
        output.close();
    }
}
