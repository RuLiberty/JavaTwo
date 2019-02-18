package lesson3.Homework;

import java.util.ArrayList;
import java.util.List;

public class Facebook {
    private static List<String> name = new ArrayList<String>();
    private static List<String> number = new ArrayList<String>();

    public void add(String yourName, String yourNumber){
        name.add(yourName);
        number.add(yourNumber);
    }

    public void get(String yourName){
        if (getNumber(yourName).isEmpty()) {
            System.out.println("Указанная фамилия в телефоном справочнике отсутствует!");
            return;
        }
        System.out.println("Для фамилии " + yourName + " нашлись следующие соответствия телефонных номеров:");
        for (String s:getNumber(yourName)) {
            System.out.println("Номер телефона: " + s);
        }
    }

    private List<String> getNumber(String yourName){
        List<String> result = new ArrayList<String>();
        String[] names = name.toArray(new String[name.size()]);
        String[] numbers = number.toArray(new String[number.size()]);
        for (int i = 0; i < name.size(); i++) {
            if (names[i].equalsIgnoreCase(yourName)) {result.add(numbers[i]);}
        }
        return result;
    }
}
