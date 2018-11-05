package ru.stqa.pft.sandbox;

public class Distance {

  public static void main(String[] args) {

    Point p1 = new Point(-1, -1);
    Point p2 = new Point(2, 2);

    System.out.println("Растояние между двумя точками = " + p1.distance(p2));
  }

 
}
