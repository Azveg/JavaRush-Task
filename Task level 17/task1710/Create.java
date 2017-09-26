package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.javarush.task.task17.task1710.Solution.allPeople;

public class Create {

    public static void creating(String name, String sex,Date bd) throws ParseException {
        if (sex.equals("м")){
            allPeople.add(Person.createMale(name,bd));
        } else{
            allPeople.add(Person.createFemale(name,bd));
        }
        int a = 0;
        for (Person p : allPeople) {
            if (p.getName().equals(name)) //this print id person
            {
                 a = allPeople.indexOf(p);
            }
        }
        System.out.println(a);
    }

    public static void edit(int arg, String arg1, String arg2, Date parse) {
        allPeople.get(arg).setName(arg1);
        if (arg2.equals("м")){ allPeople.get(arg).setSex(Sex.MALE);
        }
        else {allPeople.get(arg).setSex(Sex.FEMALE);
        }
        allPeople.get(arg).setBirthDay(parse);
    }

    public static void delete(int arg){
        allPeople.get(arg).setName(null);
        allPeople.get(arg).setSex(null);
        allPeople.get(arg).setBirthDay(null);
    }

    public static void info (int arg){
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sex;
        if (allPeople.get(arg).getSex()==Sex.MALE)
            sex ="м";
        else sex = "ж";
        System.out.println(allPeople.get(arg).getName()+" "+ sex + " " + format.format(allPeople.get(arg).getBirthDay()));
    }
}

