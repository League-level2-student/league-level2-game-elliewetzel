import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font enter;
	Font instruction;
	Font over;
	Font over2;
	Font over3;
	Font over4;
	Font over5;
	Timer frameDraw;	
	Ball ball = new Ball(250, 500, 20, 20);
	Paddle1 paddle1 = new Paddle1(5, 320, 10, 100);
	Paddle2 paddle2 = new Paddle2(788, 320, 10, 100);
	ObjectManager manager = new ObjectManager(paddle1, paddle2);
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
		enter = new Font("Arial", Font.PLAIN, 24);
		over = new Font("Arial", Font.BOLD, 48);
		over2 = new Font("Arial", Font.BOLD, 24);
		over3 = new Font("Arial", Font.PLAIN, 24);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		over5 = new Font("Arial", Font.BOLD, 24);
	}
	void updateMenuState() {	}
	void updateGameState() {
		manager.update();
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
		g.drawString("Reach 16 points by returning the ball each time using the paddles.", 70, 500);
		g.setFont(enter);
		g.setColor(Color.white);
		g.drawString("Press Enter to play.", 300, 320);
	}
	
	void drawGameState(Graphics g) {  
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		ball.draw(g);
		manager.draw(g);
		manager.draw(g);
	}
	void drawEndState(Graphics g)  { 
		g.setColor(Color.black);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		g.setFont(over);
		g.setColor(Color.GREEN);
		g.drawString("GAME OVER", 305, 144);
		g.setFont(over2);
		g.setColor(Color.GREEN);
		g.drawString("Player 1's score is " + manager.score1, 290, 230);
		g.setFont(over5);
		g.setColor(Color.GREEN);
		g.drawString("Player 2's score is " + manager.score2, 290, 290);
		g.setFont(over3);
		g.setColor(Color.GREEN);
		g.drawString("Press ENTER to restart", 300, 390);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else {
		    drawEndState(g);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		repaint();
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
			else if(currentState == GAME) {
				currentState = END;
			}
			else if(currentState == END) {
				currentState = MENU;
				//make new objects
				/*paddle1 = new Paddle1(5, 320, 10, 100);
				paddle2 = new Paddle2(788, 320, 10, 100);
				ball = new Ball(250, 500, 20, 20);
*/
			}
		}
		else if (e.getKeyCode() ==KeyEvent.VK_UP) {
			System.out.println("UP");
			paddle1.up();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			paddle1.down();
		}
		/*else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			paddle1.right();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			paddle1.left();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			paddle2.left();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			paddle2.right();
		}*/
		else if(e.getKeyCode() == KeyEvent.VK_W) {
			System.out.println("UP");
			paddle2.up();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("DOWN");
			paddle2.down();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	

}
