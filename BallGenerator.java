import java.util.*;
import java.io.*;

public class BallGenerator {
	private static ArrayList<Integer> allBalls;
	private static Random random;
	private static int numberOfRolls = 0;
	private static int[] orderOfRandomNumbers = new int[75];
	public BallGenerator() {
		allBalls = new ArrayList<>();
		for(int i = 1; i <= 75; i++) allBalls.add(i);
		int r = (int) BingoCardTextFrame.seedUpdate();
		random = new Random(r);
		for(int i = 0; i < 75; i++) {
			int place = random.nextInt(allBalls.size());
			int number = allBalls.get(place);
			allBalls.remove(place);
			orderOfRandomNumbers[i] = number;
		}
		
		
	}
	
	public int getNextRandomNumber() {
		numberOfRolls++;
		return orderOfRandomNumbers[numberOfRolls-1];
	}
	
	public int getNumberOfRolls() {
		numberOfRolls++;
		return numberOfRolls;
	}
	
	public int[] getAllNumbersGenerated() {
		return orderOfRandomNumbers;
	}
	
}


/*
75 balls
*/