package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

//5. В методе writeObject должен быть вызван метод defaultWriteObject на объекте полученном в качестве параметра.
//6. В методе writeObject должен быть вызван метод writeObject(name) на объекте полученном в качестве параметра.
//7. В методе readObject должен быть вызван метод defaultReadObject на объекте полученном в качестве параметра.
//8. Метод readObject должен корректно восстанавливать значение поля name.
    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream outputStream) throws IOException{
            outputStream.defaultWriteObject();
            outputStream.writeObject(name);
        }
        private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException{
            inputStream.defaultReadObject();
            name =(String) inputStream.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2");
        System.out.println(b.name);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject();
        System.out.println(b1.name);
    }
}
