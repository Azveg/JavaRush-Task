package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            String [] s = fileScanner.next().split(" ");
            String sd = s[3] + " " + s[4] + " " + s[5];
            try {
                return new Person(s[1],s[2],s[0], format.parse(sd));
            } catch (ParseException e) {
                return  null;
            }
            //public Person(String firstName, String middleName, String lastName, Date birthDate)
            //lastName, firstName, middleName, birthDate.toString()
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
