package lesson1.tournament;

import java.util.ArrayList;
import java.util.List;

import lesson1.particiant.*;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 11/02/2019
 */
public class TournamentLauncher
{

  public static void main(String[] args)
  {
    List<Animal> members = new ArrayList<>();

    Animal member1 = new Cat(5, "BARSIK", Cat.TYPE_BRITYSH);
    Animal member2 = new Cat(10, "KISYA", Cat.TYPE_PERSIA);
    Animal member3 = new Dog(3, "MUHTAR", Dog.TYPE_BULDOG);
    Animal member4 = new Human(23, "Ivan ivanov", Gender.MALE);


    /********** YOU CAN NO CHAGE ****************/


    members.add(member1);
    members.add(member2);
    members.add(member3);
    members.add(member4);

    for (Animal animal : members)
    {
      System.out.println(animal.toString() + ":" + animal.jump(3));
    }

    Swiming swimingr3 = new Dog(3, "MUHTAR", Dog.TYPE_BULDOG);
    Swiming swiming4 = new Human(23, "Ivan ivanov", Gender.MALE);


    List<Swiming> swimings = new ArrayList<>();
    swimings.add(swimingr3);
    swimings.add(swiming4);

    for (Swiming swiming : swimings)
    {
      swiming.swim(5);
    }


  }
}
