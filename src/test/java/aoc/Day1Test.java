package aoc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

class Day1Test {
  @Test
  @DisplayName("Test day 1 part 1&2")
  void testCalories() throws IOException {
    InputStream in = Day1.class.getClassLoader().getResourceAsStream("day1/example.txt");
    Day1 d = new Day1(in);
    assertEquals(24000,d.execute(1));
    assertEquals(41000,d.execute(3));
  }
}
