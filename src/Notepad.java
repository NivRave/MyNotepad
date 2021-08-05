import Window.MyJFrame;

public class Notepad {
	MyJFrame window;
	
	public static void main(String[] args) {
		new Notepad();
	}

	//Default constructor
	public Notepad() {
		run();
	}
	
	//Runs the program
	public void run() {
		window = new MyJFrame("My Notepad");
		window.setVisible(true);
	}
		
}