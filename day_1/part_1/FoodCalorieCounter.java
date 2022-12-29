package day_1.part_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class FoodCalorieCounter {
  public static void main(String[] args) {
    Integer currentMax = 0;
    Integer currentCount = 0;
    String line = "";
    File inputFile = new File("input.txt");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      while ((line = reader.readLine()) != null) {
        if (line.equals("")) {
          currentCount = 0;
          continue;
        }
        currentCount += Integer.parseInt(line);
        if (currentCount > currentMax) {
          currentMax = currentCount;
        }
      }
      System.out.println(currentMax);
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

//answer: 66819
