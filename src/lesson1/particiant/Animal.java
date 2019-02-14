package lesson1.particiant;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 11/02/2019
 */
public abstract class Animal implements Jumping
{
  protected final static double COEF_FOR_DOG = 1.2;
  protected final static double COEF_FOR_CAT = 0.7;
  protected final static double COEF_FOR_HUMAN = 1;

  private int age;
  private String name;


  public Animal(int age, String name)
  {
    this.age = age;
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "Animal{" + "age=" + age + ", name='" + name + '\'' + '}';
  }

  public int getAge()
  {
    return age;
  }

  public String getName()
  {
    return name;
  }
}
