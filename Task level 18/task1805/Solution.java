package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());


        HashMap<Integer, Integer> map = new HashMap<>();

        while (inputStream.available() > 0)
        {
            int data  = inputStream.read();

            if (map.containsKey(data))
            {
                for (HashMap.Entry<Integer, Integer> me : map.entrySet())
                {
                    if (me.getKey().equals(data))
                    {
                        me.setValue(me.getValue() + 1);
                    }
                }
            }
            else {
                map.put(data,1);
            }
        }

        int count = map.size();
        ArrayList<Integer> list = new ArrayList<>();


        for (HashMap.Entry<Integer, Integer> me : map.entrySet())
        {
                list.add(me.getKey());
        }
        Collections.sort(list);

        for (Integer aList : list)
        {
            System.out.print(aList + " ");
        }

        inputStream.close();
    }
}
