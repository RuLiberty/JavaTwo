package lesson1.particiant;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 11/02/2019
 */
public class Dog extends Animal implements Swiming
{
  private String type;

  public final static String TYPE_BULDOG = "BULDOG_TYPE";
  public final static String TYPE_GERMAN = "GERMAN_TYPE";
  private final static double COEF_OF_JUMP_BULDOG = 0.4;
  private final static double COEF_OF_JUMP_GERMAN = 0.8;
  private final static double DEFAULT_JUMP_VALUE = 8.0;

  public Dog(int age, String name, String type)
  {
    super(age, name);
    this.type = type;
  }

  @Override
  public boolean jump(double distanceJump)
  {
    if (type.equalsIgnoreCase(TYPE_BULDOG))
    {
      return distanceJump <= DEFAULT_JUMP_VALUE * COEF_OF_JUMP_BULDOG * COEF_FOR_DOG;
    }
    else if (type.equalsIgnoreCase(TYPE_GERMAN))
    {
      return distanceJump <= DEFAULT_JUMP_VALUE * COEF_OF_JUMP_GERMAN * COEF_FOR_DOG;
    }
    else
    {
      return false;
    }
  }

  @Override
  public String toString()
  {
    return "Dog{" + "type='" + type + '\'' + "} " + super.toString();
  }

  @Override
  public boolean swim(double distanceToSwim)
  {
    return false;
  }
}
