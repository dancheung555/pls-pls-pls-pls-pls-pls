import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class BingoCardPanelFrame extends JFrame {
	private JLabel label1;
	private JTextField textField1;
	private Container win;
	private int[][] bingoArr = new int[5][5];
	
	private BallGenerator gen;
	
	public BingoCardPanelFrame(String framename) {
		super(framename);
		win = getContentPane();
		JPanel panel = new JPanel();
		win.setLayout(null);
		
		gen = new BallGenerator();
		
		BingoPanel screen2;
		
		for(int i = 0; i < BingoCardTextFrame.numberOfCardsUpdate(); i++) {
			screen2 = new BingoPanel();
			add(screen2);
			try {
				GenerateJPG.generateJPG(screen2, framename, BingoCardTextFrame.getFilePlace());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
//		pack();
		
		setSize(1100, 900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	

	
	
}