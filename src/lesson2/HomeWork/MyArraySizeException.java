package lesson2.HomeWork;

public class MyArraySizeException extends Exception{
    MyArraySizeException(){
        System.out.println("На вход метода поступил массив не правильного размера!");
    }
}
