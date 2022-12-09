package aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

// https://adventofcode.com/2022/day/1
public class Day1 {

  private final List<String> inputData;

  Day1(InputStream input) throws IOException {
    inputData = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
      reader.lines().forEach(inputData::add);
    }
  }

  public int execute(int countToReturn) {

    TreeSet<Integer> calories = new TreeSet<>(Comparator.reverseOrder());

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
    InputStream in = Day1.class.getClassLoader().getResourceAsStream("day1/input.txt");
    Day1 d = new Day1(in);
    System.out.println(d.execute(1));
    System.out.println(d.execute(3));
  }
}


