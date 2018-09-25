import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
	JButton button[]=new JButton[12];
	JPanel panel=new JPanel();
	public MainTrouble() {
		add(panel);
		setVisible(true);
		setSize(700,500);
		setTitle("Trouble Shooting");
		setLocation(WIDTH/3, HEIGHT/3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		for(int x=0,j=0,y=0;x<=11;x++) {
			button[x]=new JButton();
			button[x].setEnabled(false);
			button[x].setVisible(false);
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
			panel.add(button[x]);
			if(j<3){
				j++;
			}
			if((x+1)%4==0) {
				y++;
				j=0;
			}
		}
		start();
	}
	private void start() {
		while(true) {
			mainMenu();
			waitForIt();
			menuFor(wordFor);
		}
	}
	private void mainMenu() {
			for(int x=0;x<11;x++) {
				button[x].setEnabled(true);
				button[x].setVisible(true);
				x+=3;
			}
	}
	private void waitForIt() {
		while(wordFor==null) {}
	}
	private void menuFor(String word) {
		System.out.println(word);
		setTitle(word+" Problems");
		int wordCol;
		for(int x=0;x<simpleWords.length;x++) {
			if(word.equals(simpleWords[x][0])) {
				wordCol=x;
			}
		}
		
		
	}
}