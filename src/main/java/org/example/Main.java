package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Person, Integer> countHowMany(File file) throws FileNotFoundException {
        Map<Person, Integer> count = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] names = line.split(" ");
                if (names.length == 2) {
                    String[] words = line.split(" ");
                    Person person = new Person(names[0].toLowerCase(), names[1].toLowerCase());
                    if (count.containsKey(person)) {
                        count.put(person, count.get(person) + 1);
                    } else {
                        count.put(person, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void printIfGreater3(Map<Person, Integer> count) {
        for (Person person: count.keySet()){
            if(count.get(person) >= 3){
                System.out.println(person + " " + count.get(person));
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("D:\\Paradigme de Programare\\Paradigme\\Laborator6Part2\\src\\fisier.txt");

        try {
            printIfGreater3(countHowMany(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

