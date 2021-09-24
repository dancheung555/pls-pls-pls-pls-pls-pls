import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;



public class BingoPanel extends JPanel implements KeyListener, MouseListener, ActionListener  {
	
	
	private Graphics g = null;
	private static long seed = BingoCardTextFrame.seedUpdate();
	private static long numberOfCards = BingoCardTextFrame.numberOfCardsUpdate();
	private static long days = BingoCardTextFrame.daysUpdate();
	private static long numberOfWinners = BingoCardTextFrame.numberOfWinnersUpdate();
	private BallGenerator gen = new BallGenerator();
	private int[][] bingoArr = new int[5][5];
	private ArrayList<BingoCard> allBingoArr = new ArrayList<>();
	private static int index = 0;
	private int winnersCount = 0;
	private static BufferedImage template;
	private static ArrayList<Integer> numbersDrawn = new ArrayList<>();
	private static boolean[] winners = new boolean[(int) numberOfCards];
	private int[] sequenceIDOfWinners = new int[(int) numberOfWinners];
	private int smthToKeepTrackOf = 0;
	
	public BingoPanel() {
		super();
		addMouseListener(this);
		for(int i = 0; i < numberOfCards; i++) {
			allBingoArr.add(new BingoCard(i));
			winners[i] = false;
			getTemplate();
			
			
			setSize(1100, 900);
			
		}
		for(int i = 0; i < numberOfCards; i++) {
			if(winnersCount != numberOfWinners) {
				int[][] tempArr = allBingoArr.get(i).getArr();
				boolean didWin = allBingoArr.get(i).getWon();
				if(didWin && !winners[i]) {
					winners[i] = true;
					sequenceIDOfWinners[winnersCount] = i;
				}
				System.out.println("Number of Winners: " + winnersCount);
			}
		}
		
		System.out.println(winnersCount);
		int[] tempArrForTheLastTime = gen.getAllNumbersGenerated();
		for(int i = 0; i < tempArrForTheLastTime.length; i++) {
			System.out.print(tempArrForTheLastTime[i] + " ");
		}
		
	}
	
	public void getTemplate() {
		try {
            template = ImageIO.read(BingoPanel.class.getResource("/BingoTemplate.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void checkAll(int generatedNum) {
		for(int i = 0; i < allBingoArr.size(); i++) {
			BingoCard tempBC = allBingoArr.get(i);
			int[][] temparr = tempBC.getArr();
			for(int row = 0; row < 5; row++) {
				for(int col = 0; col < 5; col++) {
					if(temparr[row][col] == generatedNum) {
						(allBingoArr.get(i)).setCrossedOff(row, col);
					}
				}
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int xcoord = e.getX();
		int ycoord = e.getY();
		int num = 0;
		int[][] temparr;
//		780, 170, 290, 80
		if(xcoord >= 780 && xcoord < 780+290 && ycoord >= 170 && ycoord <= 170+80 && gen.getNumberOfRolls() < 75 && winnersCount != numberOfWinners) {
			
			num = gen.getNextRandomNumber();
			numbersDrawn.add(num);
			System.out.println(gen.getNumberOfRolls());
			System.out.println("Random num is " + num);
			checkAll(num);
			for(int i = 0; i < allBingoArr.size(); i++) {
				if(allBingoArr.get(i).fiveInARow() && !winners[i]) {
					System.out.println("Bingo Card " + i + " just won!");
					System.out.println(winnersCount);
					sequenceIDOfWinners[winnersCount] = i;
					winnersCount++;
					winners[i] = true;
				}
			}
		}
		
		
		//780-910, 300-340
		if(xcoord >= 780 && xcoord <= 910 && ycoord >= 300 && ycoord <= 340 && index>0) {
			index = index-1;
		}
		
		//940-1070, 300-340
		if(xcoord >= 940 && xcoord <= 1070 && ycoord >= 300 && ycoord <= 340 && index<numberOfCards-1) {
			index = index+1;
		}
		
		
		
		repaint();
	}
	

	@Override
	public void paint(Graphics graphics) {
//		graphics.setColor(new Color(123, 234, 123));
		graphics.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		
		
		
		if(winnersCount >= numberOfWinners) {
			graphics.drawString("Here are the numbers used in the Bingo!", 20, 50);
			int[] arrJustForHere = gen.getAllNumbersGenerated();
			for(int i = 0; i < 15; i++) {
				if(arrJustForHere[i] < 10) {
					graphics.drawString("0"+arrJustForHere[i]+", ", 20+40*i, 100);
				} else {
					graphics.drawString(arrJustForHere[i]+", ", 20+40*i, 100);
				}
			}
			for(int i = 15; i < 30; i++) {
				if(arrJustForHere[i] < 10) {
					graphics.drawString("0"+arrJustForHere[i]+", ", 20+40*(i-15), 140);
				} else {
					graphics.drawString(arrJustForHere[i]+", ", 20+40*(i-15), 140);
				}
			}
			for(int i = 30; i < 45; i++) {
				if(arrJustForHere[i] < 10) {
					graphics.drawString("0"+arrJustForHere[i]+", ", 20+40*(i-30), 180);
				} else {
					graphics.drawString(arrJustForHere[i]+", ", 20+40*(i-30), 180);
				}
			}
			for(int i = 45; i < 60; i++) {
				if(arrJustForHere[i] < 10) {
					graphics.drawString("0"+arrJustForHere[i]+", ", 20+40*(i-45), 220);
				} else {
					graphics.drawString(arrJustForHere[i]+", ", 20+40*(i-45), 220);	
				}
			}
			for(int i = 60; i < 75; i++) {
				if(arrJustForHere[i] < 10) {
					graphics.drawString("0"+arrJustForHere[i]+", ", 20+40*(i-60), 260);
				} else {
					graphics.drawString(arrJustForHere[i]+", ", 20+40*(i-60), 260);
				}
			}
			
			graphics.drawString("Here is the order of winners: ", 20, 350);
			for(int i = 0; i < numberOfWinners; i++) {
				graphics.drawString("Bingo Card " + sequenceIDOfWinners[i], 20, 390+30*i);
			}
			return;
		}
		
		
		
		
		
		//drawing the image
		graphics.setColor(new Color(255, 255, 255));
		graphics.fillRect(0, 0, 1100, 900);
		graphics.drawImage(template, 0, 0, null);
		//drawing the bingo ID
		Font font = new Font("Comic Sans", Font.PLAIN, 40);
		graphics.setFont(font);
		graphics.setColor(new Color(200, 0, 0));
		graphics.drawString("Bingo ID: " +(index+1), 650, 50);
		drawText(graphics, index);
		
		//drawing next and previous buttons
		
		graphics.setColor(new Color(68, 96, 221));
		graphics.fillRect(780, 300, 130, 40);				//780-910, 300-340
		graphics.fillRect(940, 300, 130, 40);				//940-1070, 300-340
		graphics.setColor(new Color(123, 234, 123));
		font = new Font("Comics Sans", Font.PLAIN, 20);
		graphics.setFont(font);
		graphics.drawString("Previous", 805, 325);
		graphics.drawString("Next", 980, 325);
		
		int[][] temparr = allBingoArr.get(index).getArr();
		
		graphics.setColor(new Color(0, 0, 255));
		font = new Font("Comic Sans", Font.PLAIN, 40);
		graphics.setFont(font);
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 5; col++) {
				if(allBingoArr.get(index).isCrossedOff(row, col) && !(row == 2 && col == 2)) {
//					System.out.println("GOT!");
					graphics.setColor(new Color(255, 0, 0));
					graphics.drawString(temparr[col][row]+"", row * 126 + 89, col * 129 + 227);
					graphics.setColor(new Color(0, 0, 255));
				} else {
					if(!(row == 2 && col == 2)) graphics.drawString(temparr[col][row]+"", row * 126 + 89, col * 129 + 227);
				}
			}
		}
		if(allBingoArr.get(index).fiveInARow()) {
			System.out.println((index+1) + " NICE");
		}
		
	}
	
	
	
	private void drawText(Graphics numbers, int index) {
		//rectangle for button to roll ball
		numbers.setColor(new Color(68, 96, 221));
		numbers.fillRect(780, 170, 290, 80);
		//text on button
		numbers.setColor(new Color(123, 234, 123));
		Font font = new Font("Comic Sans", Font.PLAIN, 30);
		numbers.setFont(font);
		numbers.drawString("Click me to get", 800, 200);
		numbers.drawString("a Bingo Ball!", 800, 230);
		
		//getting the numbers to print
		font = new Font("Comic Sans", Font.PLAIN, 40);
		numbers.setFont(font);
		numbers.setColor(new Color(0, 0, 255));
		int[][] temparr = allBingoArr.get(index).getArr();
		
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if(!(row == 2 && col == 2)) numbers.drawString(temparr[col][row]+"", row * 126 + 89, col * 129 + 227);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}