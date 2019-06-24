

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currectState = MENU;
	
	@Override
	public void paintComponent(Graphics g){
		for(int i = 0; i < 2; i ++) {
		g.fillRect(10, 10, 20, 100);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
