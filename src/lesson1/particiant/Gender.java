package lesson1.particiant;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 11/02/2019
 */
public enum Gender
{
  MALE(0.7), FEMALE(0.6);

  private double coef;

  Gender(double coef)
  {
    this.coef = coef;
  }

  public double getCoef()
  {
    return coef;
  }
}
