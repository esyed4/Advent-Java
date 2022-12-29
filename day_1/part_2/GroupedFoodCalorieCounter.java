package day_1.part_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GroupedFoodCalorieCounter {
  public static void main(String[] args) {
    Integer currentCount = 0;
    Integer totalSum = 0;
    ArrayList<Integer> groupedMax = new ArrayList<>(Arrays.asList(0,0,0));
    String line = "";
    File inputFile = new File("input.txt");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      while ((line = reader.readLine()) != null) {
        if (line.equals("")) {
          Collections.sort(groupedMax);
          groupedMax = checkCurrentMaxes(groupedMax, currentCount);
          currentCount = 0;
          continue;
        }
        currentCount += Integer.parseInt(line);
      }
      for (int i = 0; i < groupedMax.size(); i++) {
        totalSum += groupedMax.get(i);
      }
      System.out.println(totalSum);
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static ArrayList<Integer> checkCurrentMaxes(ArrayList<Integer> groupedMax,
  Integer currentCount) {
    for (int i = 0; i < groupedMax.size(); i++) {
      if (groupedMax.get(i) < currentCount) {
        groupedMax.set(i, currentCount);
        break;
      }
    }
    return groupedMax;
    //acknowledge that this current logic might not replace the smallest number

  }
}
