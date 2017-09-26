package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat simpleDateFormat;
    static {
        //u id name sex bd
        simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);

        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, IOException {

        switch (args[0]){
            case "-c": Create.creating(args[1],args[2],simpleDateFormat.parse(args[3]));
            break;
            //-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
            case "-u": Create.edit(Integer.parseInt(args[1]),args[2],args[3], simpleDateFormat.parse(args[4]));
            break;
            //-u — обновляет данные человека с данным id
            case "-d": Create.delete(Integer.parseInt(args[1]));  ;
            break;
            //-d — производит логическое удаление человека с id, заменяет все его данные на null
            case "-i": Create.info(Integer.parseInt(args[1]));
            break;
            //-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
        }

    }
}
