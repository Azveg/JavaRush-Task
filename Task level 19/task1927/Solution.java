package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream stream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();
        System.setOut(stream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(outputStream.toString().getBytes())));

        int a = 1;

        while (reader.ready()){
            String line = reader.readLine();
            System.out.println(line);

            if (a % 2 == 0){
                System.out.println("JavaRush - курсы Java онлайн");
            }
            a++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
