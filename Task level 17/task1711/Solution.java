package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static SimpleDateFormat simpleDateFormat;

    static {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        switch (args[0]){

            case "-c": synchronized (allPeople){
                for (int i = 1; i < args.length ; i+=3) {
                    Create.creating(args[i], args[i+1], simpleDateFormat.parse(args[i+2]));
                }
            }
                 break;
            //-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
            case "-u":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i+=4) {
                        Create.edit(Integer.parseInt(args[i]),args[i+1],args[i+2], simpleDateFormat.parse(args[i+3]));
                    }
                }
                break;
            //-u — обновляет данные человека с данным id
            case "-d":
                synchronized (allPeople){
                    for (int i = 1; i < args.length ; i++) {
                        Create.delete(Integer.parseInt(args[i]));
                    }
                }
                break;
            //-d — производит логическое удаление человека с id, заменяет все его данные на null
            case "-i":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        Create.info(Integer.parseInt(args[i]));
                    }
                }
                break;
            //-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
        }
    }
}
