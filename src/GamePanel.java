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
	/*Ball ball = new Ball(250, 500, 20, 20);
	Paddle1 paddle1 = new Paddle1(6, 320, 10, 100);
	Paddle2 paddle2 = new Paddle2(787, 320, 10, 100);*/
	ObjectManager manager = new ObjectManager();
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
		over = new Font("Arial", Font.BOLD, 51);
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
		g.setColor(Color.WHITE);
		g.fillRect(400, 0, 5, Pong.HEIGHT-1);
		//System.out.println(ball.speed);
		manager.draw(g);
		
	}
	void drawEndState(Graphics g)  { 
		g.setColor(Color.black);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		g.setFont(over);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 285, 144);
		g.setFont(over2);
		g.setColor(Color.GREEN);
		g.drawString("Player 1's score is " + manager.getScore1(), 280, 300);
		g.setFont(over5);
		g.setColor(Color.GREEN);
		g.drawString("Player 2's score is " + manager.getScore2(), 280, 400);
		g.setFont(over3);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to restart", 270, 500);
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
			System.out.println(currentState);
			if(currentState == MENU) {
				currentState = GAME;
				
			}
			else if(currentState == GAME) {
				currentState = END;
			}
			else if(currentState == END) {
				currentState = MENU;
				//make new objects
				manager.pad1 = new Paddle1(5, 320, 10, 100);
				manager.pad2 = new Paddle2(788, 320, 10, 100);
				manager.b = new Ball(250, 500, 20, 20);
				manager.score1 = 0;
				manager.score2 = 0;
			}
		}
		else if (e.getKeyCode() ==KeyEvent.VK_UP) {
			System.out.println("UP");
			manager.paddle1UP();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			manager.paddle1DOWN();
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
			manager.paddle2UP();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("DOWN");
			manager.paddle2DOWN();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	

}
