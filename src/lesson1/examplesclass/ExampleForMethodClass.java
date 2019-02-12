package lesson1.examplesclass;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 11/02/2019
 */
public class ExampleForMethodClass
{

  public void sum(int a, int b)
  {
    a = 10;
    b = 11;
    int c = a + b;
    System.out.println(c);
  }

  public void toDo(LinkedExampleClass linkedExampleClass)
  {
    linkedExampleClass.setField(6);
    System.out.println(linkedExampleClass.toString());
  }
}
