import javax.swing.JFrame;

public class MyJFrame extends JFrame{

	public MyJFrame(String name) {
		super(name);
		initWindow();
	}

	//Init the window
	private void initWindow() {
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	
}
