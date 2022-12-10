package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import aoc.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Day2Test {
  @Test
  @DisplayName("Test Day 2")
  public void testCalories() throws IOException {
    Day2 d = new Day2(Util.readFileToList("day2/example.txt"));
    assertEquals(15,d.getScore(true));
  }
}
