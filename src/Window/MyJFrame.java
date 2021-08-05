package Window;
import javax.swing.JFrame;
import Menu.*;

public class MyJFrame extends JFrame{
	
	MyPanel panel;
	MyMenu menuBar;
	
	public MyJFrame(String name) {
		super(name);
		initWindow();
		initMenu();
	}

	private void initMenu() {
		menuBar=new MyMenu(this);
		this.setJMenuBar(menuBar);
	}

	//Init the window
	private void initWindow() {
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new MyPanel();
		this.add(panel);
	}
	
}
