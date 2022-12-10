package aoc;

import aoc.util.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {

  private static final int  WIN  = 6;
  private static final int  DRAW  = 3;
  private static final int LOSE = 0;
  private enum SHAPE {
    ROCK,
    PAPER,
    SCISSOR
  }

  private final Map<String, SHAPE> codeLookup = Map.of(
      "A", SHAPE.ROCK,
      "B", SHAPE.PAPER,
      "C", SHAPE.SCISSOR,
      "X", SHAPE.ROCK,
      "Y", SHAPE.PAPER,
      "Z", SHAPE.SCISSOR
  );

  private final Map<String,String> codePairs = Map.of(
      "X","A",
      "Y","B",
      "Z","C"
  );

  private final Map<String,Integer> intentionMap = Map.of(
      "X",LOSE,
      "Y",DRAW,
      "Z",WIN
  );

  private final Map<SHAPE, SHAPE> winMap = Map.of(
      SHAPE.ROCK, SHAPE.SCISSOR,
      SHAPE.SCISSOR, SHAPE.PAPER,
      SHAPE.PAPER, SHAPE.ROCK
  );

  private final Map<SHAPE,Integer> pointsMap = Map.of(
      SHAPE.ROCK,1,
      SHAPE.PAPER,2,
      SHAPE.SCISSOR,3
  );
  private List<String> input;
  Day2(List<String> input){
    this.input = input;
  }

  public int getScore(boolean useIntention){
    int score = 0;
    for(String line:input){
      if (line.length()>=3){
        String[] strategy = line.substring(0,3).split(" ");
        if(strategy.length==2){
          if(useIntention){
            String myShape = "";
            switch (intentionMap.get(strategy[1])) {
              case WIN -> {
                Map<SHAPE,SHAPE> loseMap = new HashMap<>();
                for(SHAPE key:winMap.keySet()){
                  loseMap.put(winMap.get(key),key);
                }
                switch (loseMap.get(codeLookup.get(strategy[0]))) {
                  case ROCK -> myShape="X";
                  case PAPER-> myShape="Y";
                  case SCISSOR-> myShape="Z";
                }
              }
              case DRAW -> myShape=strategy[0];
              case LOSE -> {
                switch (winMap.get(codeLookup.get(strategy[0]))){
                  case ROCK -> myShape="X";
                  case PAPER-> myShape="Y";
                  case SCISSOR-> myShape="Z";
                }
              }
            }
            score = score+calculateScore(strategy[0],myShape);
          }else{
            score = score+calculateScore(strategy[0],strategy[1]);
          }
        }
      }
    }
    return score;
  }

  private int calculateScore(String oShape, String mShape){
    int score = 0;
    if (!codeLookup.containsKey(oShape) || !codeLookup.containsKey(mShape)) {
      return score;
    }
    SHAPE opponentSelection = codeLookup.get(oShape);
    SHAPE mySelection = codeLookup.get(mShape);

    score = pointsMap.get(mySelection);

    if (mySelection.equals(opponentSelection)) {
      return score+DRAW;
    }

    if (winMap.get(mySelection).equals(opponentSelection)){
      return score+WIN;
    }

    return score;
  }

  public static void main(String[] args) throws IOException {
    Day2 day2 = new Day2(Util.readFileToList("day2/input.txt"));
    System.out.println(day2.getScore(false));
    System.out.println(day2.getScore(true));
  }
}
