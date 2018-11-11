package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "С#";
    langs[2] = "Python";
    langs[3] = "PHP";

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("С#");
    languages.add("Python");
    languages.add("PHP");
    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
