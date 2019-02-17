package lesson2.HomeWork;

public class MyArrayDataException extends Exception{
    MyArrayDataException(int l, int r){
        System.out.println("В ячейке Массива [" + l + "][" + r + "]" + " лежит строка которую невозможно преобразовать в число");
    }
}
