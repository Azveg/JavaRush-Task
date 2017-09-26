package com.javarush.task.task19.task1924;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Замена чисел
*/
public class Solution {
    public static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(name));
        ArrayList<String> file = new ArrayList<>();
        while (fileReader.ready()) {
            file.add(fileReader.readLine());
        }
        fileReader.close();
        Pattern pattern = Pattern.compile("\\b[0-9]\\b|\\b[1][0-2]\\b");
        for (int i = 0; i < file.size(); i++) {
            String text = file.get(i);
            Matcher matcher = pattern.matcher(file.get(i));
            while (matcher.find()) {
                String num = file.get(i).substring(matcher.start(), matcher.end());
                int number = Integer.parseInt(num);
                if (number <= map.entrySet().size()) {
                    text = text.replaceFirst("\\b[0-9]\\b|\\b[1][0-2]\\b", map.get(number));
                }
            }
            file.set(i, text);
        }
        for (int i = 0; i < file.size(); i++) {
            System.out.println(file.get(i));
        }
    }
}