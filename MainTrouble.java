import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainTrouble extends JFrame{
	String searchWord="";
	String[][] simpleWords= {
			{
				"Internet",
				"Cant connect",
				"Cant authenticate",
				"No internet access"
			},{
				"Ipad",
				"Lost",
				"Wont turn on",
				"Screen Froze"
			},{
				"Miscellaneous",
				"Ipad broken",
				"Previous issues",
				"Other"
			}
	};
	String wordFor;
	JButton button[]=new JButton[11];
	JPanel panel=new JPanel();
	public MainTrouble() {
		add(panel);
		setVisible(true);
		setSize(700,500);
		setTitle("Trouble Shooting");
		setLocation(WIDTH/3, HEIGHT/3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		for(int x=0,j=0,y=0;x<11;x++) {
			button[x]=new JButton();
			button[x].setEnabled(true);
			button[x].setVisible(true);
			button[x].setSize(300,200);
			button[x].setText(simpleWords[y][j]);
			button[x].setName(simpleWords[y][j]);
			System.out.println(simpleWords[y][j]);
			button[x].addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								wordFor=((JButton) e.getSource()).getText();
							}
						}
					);
			if((x+1)%4==0) {
				y++;
				j=0;
			}
			if(j<3){
				j++;
			}
		}
		start();
	}
	private void start() {
		while(true) {
			mainMenu();
		}
	}
	private void mainMenu() {
			if(wordFor!=null) {
				menuFor(wordFor);
			}else {
				for(int x=0;x<=11;x++) {
					panel.add(button[x]);
					button[x].setEnabled(true);
					button[x].setVisible(true);
					x=+4;
				}
			}
	}
	private void menuFor(String word) {
		setTitle(word+" Problems");
		int wordCol;
		for(int x=0;x<simpleWords.length;x++) {
			if(word.equals(simpleWords[x][0])) {
				wordCol=x;
			}
		}
		
	}
}