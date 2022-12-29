package day_2.part_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ElfRPS {
  public static void main(String[] args) {
    String game = "";
    Integer gameScore = 0;
    File inputFile = new File("input.txt");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      while ((game = reader.readLine()) != null) {
        gameScore += checkGameOutcomePoints(game);
      }
      System.out.println(gameScore);
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static Integer checkGameOutcomePoints(String game) {
    switch (game) {
      case "A X":  return 3 + 1;
      case "A Y":  return 6 + 2;
      case "A Z":  return 0 + 3;
      case "B X":  return 0 + 1;
      case "B Y":  return 3 + 2;
      case "B Z":  return 6 + 3;
      case "C X":  return 6 + 1;
      case "C Y":  return 0 + 2;
      case "C Z":  return 3 + 3;
      default: System.out.println("Not a game");
        return 0;
    }
  }

}
