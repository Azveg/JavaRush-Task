package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException {
        //Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (!"exit".equals(name = reader.readLine())){
            ReadThread rd = new ReadThread(name);
            rd.start();
        }

    }
    //Для каждого файла создай нить ReadThread и запусти ее.
    public static class ReadThread extends Thread {
        String name;
        FileInputStream file;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            file = new FileInputStream(fileName);
            this.name = fileName;
        }

        @Override
        public void run() {
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            try {
                while (file.available()>0){
                    list.add(file.read());
                }
                file.close();
                int count= 0;
                for (int ch : list) {
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch) + 1);
                    } else {
                        map.put(ch, 1);
                    }
                }
                int max = 0;
                int  bytes = 0;

                for(Map.Entry<Integer, Integer> paitr: map.entrySet() ){
                    if (paitr.getValue()>max){
                        max =paitr.getValue();
                        bytes = paitr.getKey();
                    }
                }
                resultMap.put(name,bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    // implement file reading here - реализуйте чтение из файла тут

}
