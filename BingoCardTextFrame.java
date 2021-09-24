import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class BingoCardTextFrame extends JFrame implements ActionListener {
	
	private JLabel label1, label2, label3, label4, label5, instructions1, instructions2, instructions3, instructions4, instructions5;
	private JButton button;
	private JTextField textField1, textField2, textField3, textField4, textField5;
	private Container win;
	private static int seed, numberOfCards, days, numberOfWinners;
	private static String fileplace;
	
	public BingoCardTextFrame(String framename) {
		super(framename);
		win = getContentPane();
		win.setLayout(null);
		
		
		label1 = new JLabel("Submit Seed:");
		label1.setSize(150, 30);
		label1.setLocation(20, 20);
		win.add(label1);
		
		label2 = new JLabel("Number of bingo cards:");
		label2.setSize(150, 30);
		label2.setLocation(20, 60);
		win.add(label2);
		
		label3 = new JLabel("Number of days:");
		label3.setSize(150, 30);
		label3.setLocation(20, 100);
		win.add(label3);
		
		label4 = new JLabel("Number of winners:");
		label4.setSize(150, 30);
		label4.setLocation(20, 140);
		win.add(label4);
		
		label5 = new JLabel("Enter place to put the Bingo files");
		label5.setSize(300, 30);
		label5.setLocation(20, 180);
		win.add(label5);
		
		
		instructions1 = new JLabel("Instructions:");
		instructions1.setSize(1000, 100);
		instructions1.setLocation(20, 240);
		win.add(instructions1);
		
		instructions2 = new JLabel("First three textboxes ");
		instructions2.setSize(1000, 100);
		instructions2.setLocation(20, 260);
		win.add(instructions2);
		
		instructions3 = new JLabel("Be sure to have positive integers in the first four text boxes, ");
		instructions3.setSize(1000, 100);
		instructions3.setLocation(20, 280);
		win.add(instructions3);
		
//		and a location to find your files after it runs
		
		instructions4 = new JLabel("and a location to find your files after it runs");
		instructions4.setSize(1000, 100);
		instructions4.setLocation(20, 300);
		win.add(instructions4);
		
		instructions5 = new JLabel("Depending on how many cards, wait a little until it progresses to next screen. Have fun!");
		instructions5.setSize(1000, 100);
		instructions5.setLocation(20, 320);
		win.add(instructions5);
		
		
		textField1 = new JTextField("", 30);
		textField1.setSize(150, 20);
		textField1.setLocation(20, 40);
		win.add(textField1);
		
		textField2 = new JTextField("", 30);
		textField2.setSize(150, 20);
		textField2.setLocation(20, 80);
		win.add(textField2);
		
		textField3 = new JTextField("", 30);
		textField3.setSize(150, 20);
		textField3.setLocation(20, 120);
		win.add(textField3);
		
		textField4 = new JTextField("", 30);
		textField4.setSize(150, 20);
		textField4.setLocation(20, 160);
		win.add(textField4);
		
		textField5 = new JTextField("", 30);
		textField5.setSize(150, 20);
		textField5.setLocation(20, 200);
		win.add(textField5);
		
		
		button = new JButton("Print Seed");
		button.setSize(150, 20);
		button.setLocation(240, 200);
		button.addActionListener(this);
		win.add(button);
		
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public static long seedUpdate() {
		return seed*BingoCard.getID();
	}
	public static long numberOfCardsUpdate() {
		return numberOfCards;
	}
	public static long daysUpdate() {
		return days;
	}
	public static long numberOfWinnersUpdate() {
		return numberOfWinners;
	}
	
	public int getSeed() {
		return seed*BingoCard.getID();
	}
	
	public static String getFilePlace() {
		return fileplace;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		String w = textField1.getText();
		String x = textField2.getText();
		String y = textField3.getText();
		String z = textField4.getText();
		String fp = textField5.getText();
		
//		GenerateJPG.generateJPG();
		
		try {
			seed = Integer.parseInt(w);
			numberOfCards = Integer.parseInt(x);
			days = Integer.parseInt(y);
			numberOfWinners = Integer.parseInt(z);
			fileplace = fp;
			BingoCardPanelFrame output = new BingoCardPanelFrame("Bingo Table");
			dispose();
			
		} catch (NumberFormatException ee) {
			System.out.println("Input is not string");
		}
		
//		System.out.println(w + " " + x + " " + y + " " + z);
	}
	
	
	
}