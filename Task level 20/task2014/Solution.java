package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public Solution() {

    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Solution(4));
        FileOutputStream of = new FileOutputStream("data.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(of);
        FileInputStream inf = new FileInputStream("data.txt");
        ObjectInputStream infd = new ObjectInputStream(inf);

        Solution savedObject = new Solution(5);

        outputStream.writeObject(savedObject);

        Solution loadedObject = (Solution)infd.readObject();
        if(loadedObject.string == savedObject.string){
        savedObject = loadedObject;

        }

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
