package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        Map<Character, Integer> map = new TreeMap<>();

        while (inputStream.available() > 0) {
            map.merge((char)inputStream.read(), 1, (k, v) -> k + v);
        }
        inputStream.close();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s %d%n", entry.getKey(), entry.getValue());
        }

    }
}
