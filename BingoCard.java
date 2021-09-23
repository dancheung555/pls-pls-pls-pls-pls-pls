import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;

public class BingoCard {
	
	private int[][] arr = new int[5][5];
	private boolean[][] crossedOff = new boolean[5][5];
	
	private boolean won = false;
	
	private List<Integer> banks0 = new ArrayList<>(15);		//1-15
	private List<Integer> banks1 = new ArrayList<>(15);		//16-30
	private List<Integer> banks2 = new ArrayList<>(15);		//31-45
	private List<Integer> banks3 = new ArrayList<>(15);		//46-60
	private List<Integer> banks4 = new ArrayList<>(15);		//61-75
	private static int ID = 1;
	
	private Random random;
	
	public BingoCard(int numBingo) {
		ID++;
		createRandom(BingoCardTextFrame.seedUpdate()+numBingo);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				crossedOff[i][j] = false;
				if(i == 2 && j == 2) crossedOff[i][j] = true;
			}
		}
		generateBanks();
		generateTiles();
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public void createRandom(long seed) {
		random = new Random(seed);
	}
	
	public Random getRandom() {
		return random;
	}
	
	public int[][] getArr() {
		return arr;
	}
	
	public void setID(int i) {
		ID = i;
	}
	
	public static int getID() {
		return ID;
	}
	
	public int[][] getBingoNumbers() {
		return arr;
	}
	
	public boolean isCrossedOff(int i, int j) {
		return crossedOff[i][j];
	}
	
	public void setCrossedOff(int i, int j) {
		if(!won) crossedOff[i][j] = true;
	}
	
	public boolean getWon() {
		return won;
	}
	
	public boolean fiveInARow() {
		if(!won) {
			for(int i = 0; i < 5; i++) {
				if(isCrossedOff(i, 0) && isCrossedOff(i, 1) && isCrossedOff(i, 2) &&  isCrossedOff(i, 3) && isCrossedOff(i, 3) && isCrossedOff(i, 4)) return won = true;
			}
			for(int i = 0; i < 5; i++) {
				if(isCrossedOff(0, i) && isCrossedOff(1, i) && isCrossedOff(2, i) &&  isCrossedOff(3, i) && isCrossedOff(3, i) && isCrossedOff(4, i)) return won = true;
			}
			
			//diagonal 1
			if(crossedOff[0][0] && crossedOff[1][1] && crossedOff[2][2] && crossedOff[3][3] && crossedOff[4][4]) return won = true;
			
			//diagonal 2
			if(crossedOff[4][0] && crossedOff[3][1] && crossedOff[2][2] && crossedOff[1][3] && crossedOff[0][4]) return won = true;
			
			return false;
		} else {
			ArrayList<Integer> arr0 = new ArrayList<>();
			for(int i = 1; i <= 15; i++) arr0.add(i);
			setBanks0(arr0);
			
			ArrayList<Integer> arr1 = new ArrayList<>();
			for(int i = 16; i <= 30; i++) arr1.add(i);
			setBanks1(arr1);
			
			ArrayList<Integer> arr2 = new ArrayList<>();
			for(int i = 31; i <= 45; i++) arr2.add(i);
			setBanks2(arr2);
			
			ArrayList<Integer> arr3 = new ArrayList<>();
			for(int i = 46; i <= 60; i++) arr3.add(i);
			setBanks3(arr3);
			
			ArrayList<Integer> arr4 = new ArrayList<>();
			for(int i = 61; i <= 75; i++) arr4.add(i);
			setBanks4(arr4);
			return true;
		}
	}
	
	
	
	private void setBanks0(ArrayList<Integer> arr) {
		banks0 = arr;
	}
	private void setBanks1(ArrayList<Integer> arr) {
		banks1 = arr;
	}
	private void setBanks2(ArrayList<Integer> arr) {
		banks2 = arr;
	}
	private void setBanks3(ArrayList<Integer> arr) {
		banks3 = arr;
	}
	private void setBanks4(ArrayList<Integer> arr) {
		banks4 = arr;
	}
	
	private void generateBanks() {
		for(int i = 1; i <= 15; i++) {
			banks0.add(i);
			banks1.add(i+15);
			banks2.add(i+15*2);
			banks3.add(i+15*3);
			banks4.add(i+15*4);
		}
	}
	private void generateTiles() {
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks0.size());
			int number = banks0.get(place);
			banks0.remove(place);
			arr[i][0] = number;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks1.size());
			int number = banks1.get(place);
			banks1.remove(place);
			arr[i][1] = number;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks2.size());
			int number = banks2.get(place);
			banks2.remove(place);
			arr[i][2] = number;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks3.size());
			int number = banks3.get(place);
			banks3.remove(place);
			arr[i][3] = number;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks4.size());
			int number = banks4.get(place);
			banks4.remove(place);
			arr[i][4] = number;
		}
		
	}
	
	
}