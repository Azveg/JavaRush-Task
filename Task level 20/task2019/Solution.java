package com.javarush.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация
1. В классе Solution не должно быть метода void Solution без параметров.


*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name"); //path
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput); //stream

        Solution solution = new Solution(); //new object
        outputStream.writeObject(solution); //paste object in stream

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
    }



//    public void Solution() {
//        m.put("Mickey", "Mouse");
//        m.put("Mickey", "Mantle");
//    }

    public int size() {
        return m.size();
    }
}
