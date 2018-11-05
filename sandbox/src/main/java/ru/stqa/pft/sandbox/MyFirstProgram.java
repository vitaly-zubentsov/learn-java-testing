package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Vitaly");

    Square s = new Square(5);
    System.out.println("Площидь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Площидь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

  }


  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }



}