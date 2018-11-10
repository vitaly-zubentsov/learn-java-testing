package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistanceTests {

  @Test
  public void testPointDistance() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals( p1.distance(p2),0.0);
    p1.x = 0;
    p1.y = 0;
    p2.x = 4;
    p2.y = 0;
    Assert.assertEquals( p1.distance(p2),4.0);
    p1.x = -10;
    p1.y = 0;
    p2.x = 0;
    p2.y = 0;
    Assert.assertEquals( p1.distance(p2),10.0);

  }
}
