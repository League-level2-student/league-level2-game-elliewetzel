

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font instruction;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
    	    gotImage = true;
            } catch (Exception e) {
                
            }
            needImage = false;
        }
    }
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.BOLD, 48);
		instruction = new Font("Arial", Font.PLAIN, 24);
	}
	
	void updateMenuState() {	}
	void updateGameState() {
		
	}
	void updateEndState() {		}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("Pong",340, 144);
		g.setFont(instruction);
		g.setColor(Color.white);
		g.drawString("Move the paddles to keep the ball from going through the goals.", 70, 500);
	}
	
	void drawGameState(Graphics g) {  
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		
	}
	void drawEndState(Graphics g)  { 
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == MENU) {
				currentState = GAME;
			}
			if(currentState == END) {
				currentState = MENU;
				//make new objects
			}
			if(currentState == GAME) {
				currentState = END;
			}
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
