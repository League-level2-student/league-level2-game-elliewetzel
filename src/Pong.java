import javax.swing.JFrame;

public class Pong {
	JFrame frame;
	final static int WIDTH = 800;
	final static int HEIGHT = 650;
	GamePanel panel;
	public Pong() {
		// TODO Auto-generated constructor stub
		frame = new JFrame();
		frame.setSize(800, 650);
		panel = new GamePanel();
		frame.addKeyListener(panel);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pong pong = new Pong();
		pong.setup();
	}
	
	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
	}
	
}







