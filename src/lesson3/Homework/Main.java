package lesson3.Homework;

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.

//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи,
// а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.
// Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
// взаимодействие с пользователем через консоль и т.д).
// Консоль использовать только для вывода результатов проверки телефонного справочника.


import java.util.*;

public class Main {
    public static void main(String[] args) {

//        Задание №1
        System.out.println("Задание №1");
        List<String> word = new ArrayList<String>();
        word.add("word");
        for (int i = 0; i < 19; i++) {word.add(randGenerationWord());}
        word.add("word");
        countUniqObj(word);
        System.out.println();
        System.out.println();
//        Задание №1

//        Задание №2
        System.out.println("Задание №2");
        Facebook facebook = new Facebook();

        facebook.add("Dmitrylovky","89774235258");
        facebook.add("Markov","89772547854");
        facebook.add("Dmitrylovky","89745243526");
        facebook.add("Maximus","89774235257");
        facebook.add("Loreonov","89014587652");
        facebook.add("Gershik","89774235252");
        facebook.add("Sofiarkovich","89774235244");

        facebook.get("Dmitrylovky");
//        Задание №2

    }

//Количество уникальных объектов в list
private static void countUniqObj(List<String> list) {
    Map map = new HashMap<String, Integer>();
    for (int i = 0; i < list.size(); i++) {
        if (!map.containsKey(list.get(i))) {
            map.put(list.get(i),1);
        } else {
            map.replace(list.get(i),(int)(map.get(list.get(i)))+1);
        }
    }
    for (int i = 0; i < map.size(); i++)
    {
        System.out.println("Слово:");
    }

//        Set<String> set = new HashSet<>();
//        for (String s:list) {
//            set.add(s);
//        }
//    System.out.println("Уникальные слова с количеством повторений: ");
//        String[] setArray = set.toArray(new String[set.size()]);
//        String[] listArray = list.toArray(new String[list.size()]);
//        for (int k = 0; k < set.size(); k++) {
//            int count = 0;
//            for (int i = 0; i < list.size(); i++) {
//                if (setArray[k].equalsIgnoreCase(listArray[i])) {count++;}
//            }
//            System.out.println(setArray[k] + ": встречается " + count + " раз");
//        }
//    System.out.println("Количество уникальных слов: " + set.size());
}

//  Генерация случайных слов максимальной длины 2
private static String randGenerationWord() {
    String result = "";
    String arrayWord = "abcdefghijklmnopqrstuvwxyz";
    char sym = ' ';
    for (int i = 0; i < 2 * Math.random(); i++) {
        sym = arrayWord.charAt((int) (Math.random() * arrayWord.length()));
        result += sym;
    }
    return result;
    }

}

