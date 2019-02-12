package lesson1.examplesclass;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 11/02/2019
 */
public class MainClass
{

  public static void main(String[] args)
  {
    /*
    int a = 5;
    int b = 6;
    ExampleClass exampleClass = new ExampleClass();
    exampleClass.sum(a, b);

    System.out.println(" A in Main = " + a);
    System.out.println(" B in Main = " + b);
    */

    LinkedExampleClass exampleClass = new LinkedExampleClass();
    ExampleForMethodClass exampleForMethodClass = new ExampleForMethodClass();
    exampleForMethodClass.toDo(exampleClass);
    System.out.println(exampleClass.toString());
  }


}
