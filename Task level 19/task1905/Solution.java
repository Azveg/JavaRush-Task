package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    //Класс Solution должен содержать public static поле countries типа Map
    public static Map<String,String> countries = new HashMap<String,String>();
//В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
}

    public static void main(String[] args) {
    }
//Класс DataAdapter должен реализовывать интерфейс RowItem.
    public static class DataAdapter implements RowItem {
        //Класс DataAdapter должен содержать два приватных поля: customer типа Customer и contact Contact.
        private Customer customer;
        private Contact contact;
    //Класс DataAdapter должен содержать конструктор с параметрами
    // (Customer customer, Contact contact), который инициализирует поля contact и customer.
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

    @Override
    public String getCountryCode() {
        String countryCode = "";
        for (Map.Entry entry : countries.entrySet())
        {
            if (customer.getCountryName().equals(entry.getValue()))
                countryCode = (String) entry.getKey();
            break;
        }
        return countryCode;
    }

    @Override
    public String getCompany() {
        return customer.getCompanyName();
    }

    @Override
    public String getContactFirstName() {
        return contact.getName().split(", ")[1];
    }

    @Override
    public String getContactLastName() {
        return contact.getName().split(", ")[0];
    }

    @Override
    public String getDialString() {
        return "callto://+" + contact.getPhoneNumber().replaceAll("[^0-9]","");
    }
}

//Класс Solution должен содержать интерфейс RowItem
    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }
//Класс Solution должен содержать интерфейс Customer
    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }
//Класс Solution должен содержать интерфейс Contact.
    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}