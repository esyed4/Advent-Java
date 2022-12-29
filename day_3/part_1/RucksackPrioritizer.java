package day_3.part_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RucksackPrioritizer {
  public static void main(String[] args) {
    String rucksack = "";
    String item1 = "";
    String item2 = "";
    int prioritizationTotal = 0;

    Integer gameScore = 0;
    File inputFile = new File("input.txt");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      while ((rucksack = reader.readLine()) != null) {
        prioritizationTotal += checkPrioritizationValue(rucksack);
      }
      System.out.println(prioritizationTotal);
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static int checkPrioritizationValue(String rucksack) {
    int compartmentLength = rucksack.length() / 2;
    for (int i = 0; i < compartmentLength; i++) {
       if (rucksack.substring(compartmentLength, rucksack.length()).contains(
        rucksack.substring(i, i+1))) {
          return getPrioritizationValue(rucksack.substring(i, i+1).charAt(0));
        }
      }
    System.out.println("Invalid rucksack parsed");
    return -1;
  }

  private static int getPrioritizationValue(char item) {
    if (Character.isLowerCase(item)) {
      return item - 'a' + 1;
    } else if (Character.isUpperCase(item)) {
      return item - 38;
    } else {
      System.out.println("Invalid item passed through!");
      return -1;
    }
  }

}
