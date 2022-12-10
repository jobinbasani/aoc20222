package aoc;

import aoc.util.Util;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// https://adventofcode.com/2022/day/1
public class Day1 {

  private final List<String> inputData;

  Day1(List<String> input) {
    this.inputData = input;
  }

  public int execute(int countToReturn) {

    Set<Integer> calories = new TreeSet<>(Comparator.reverseOrder());

    int total = 0;
    for (String line : inputData) {
      if (line.length() == 0) {
        calories.add(total);
        total = 0;
      } else {
        total = total + Integer.parseInt(line);
      }
    }

    return calories.stream()
        .limit(countToReturn)
        .reduce(0, Integer::sum);
  }

  public static void main(String[] args) throws IOException {
    Day1 d = new Day1(Util.readFileToList("day1/input.txt"));
    System.out.println(d.execute(1));
    System.out.println(d.execute(3));
  }
}


