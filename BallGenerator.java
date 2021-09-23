import java.util.*;
import java.io.*;

public class BallGenerator {
	private static ArrayList<Integer> allBalls;
	private static Random random;
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
		return number;
	}
	
	
	
}


/*
75 balls
*/