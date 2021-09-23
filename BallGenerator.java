import java.util.*;
import java.io.*;

public class BallGenerator {
	private static ArrayList<Integer> allBalls;
	private static Random random;
	private static int numberOfRolls = 0;
	private static boolean drawn = false;
	public BallGenerator() {
		allBalls = new ArrayList<>();
		for(int i = 1; i <= 75; i++) allBalls.add(i);
		int r = (int) BingoCardTextFrame.seedUpdate();
		random = new Random(r);
		
	}
	
	public static int getNextRandomNumber() {
		int place = random.nextInt(allBalls.size());
		int number = allBalls.get(place);
		allBalls.remove(place);
		numberOfRolls++;
		drawn = true;
		return number;
	}
	
	public static int getNumberOfRolls() {
		return numberOfRolls;
	}
	
	public static boolean hasDrawn() {
		return drawn;
	}
	public static boolean nextDraw() {
		if(drawn == false) {
			drawn = true;
			return true;
		} else {
			return false;
		}
		
	}
}


/*
75 balls
*/