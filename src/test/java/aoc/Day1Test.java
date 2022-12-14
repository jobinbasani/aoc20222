package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import aoc.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Day1Test {
  @Test
  @DisplayName("Test Day 1 part 1&2")
  public void testCalories() throws IOException {
    Day1 d = new Day1(Util.readFileToList("day1/example.txt"));
    assertEquals(24000,d.execute(1));
    assertEquals(41000,d.execute(3));
  }
}
