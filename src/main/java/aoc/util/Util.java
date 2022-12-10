package aoc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Util {
  public static List<String> readFileToList(String input) throws IOException {
    List<String> inputData = new ArrayList<>();
    InputStream in = Util.class.getClassLoader().getResourceAsStream(input);

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
      reader.lines().forEach(inputData::add);
    }
    return inputData;
  }
}
