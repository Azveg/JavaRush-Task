package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        //PEOPLE.add(new Person(String.format("%s %s %s", args[0],args[1],args[2]), new Date()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //dateFormat.parse("");
        String buffername = "";
        Date bufferdate;
        String [] line;
        while (reader.ready()){
            line = reader.readLine().split(" ");
            int size = line.length;
            String date = String.format("%s %s %s", line[size-3],line[size-2],line[size-1]);
            bufferdate = dateFormat.parse(date);

            for (int i = 0; i < size-3 ; i++) {
                buffername += line[i];
            }
            PEOPLE.add(new Person(buffername,bufferdate));
        }
        for (Person p: PEOPLE) {
            System.out.println(String.format("%s %s", p.getName(),p.getBirthday()));
        }

        reader.close();
    }
}
