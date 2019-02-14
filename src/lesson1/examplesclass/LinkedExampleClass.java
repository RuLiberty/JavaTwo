package lesson1.examplesclass;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 11/02/2019
 */
public class LinkedExampleClass
{
  private int field;

  @Override
  public String toString()
  {
    return "LinkedExampleClass{" + "field=" + field + '}';
  }

  public void setField(int field)
  {
    this.field = field;
  }
}
