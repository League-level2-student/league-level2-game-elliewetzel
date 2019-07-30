import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;

public class ObjectManager implements ActionListener{
	Paddle1 pad1;
	Paddle2 pad2;
	Ball b;
	int score1 = 0;
	int score2 = 0;
	
	public int getScore1() {
		return score1;
	}
	public int getScore2() {
		return score2;
	}
	
	public ObjectManager() {
		this.pad1 = new Paddle1(6, 320, 10, 100);
		this.pad2 = new Paddle2(784, 320, 10, 100);
		this.b = new Ball(250, 500, 20, 20);;
		
	}

	public void update() {
		b.update();
		
		checkCollision();
	}

	void draw(Graphics g) {
		pad1.draw(g);
		pad2.draw(g);
		b.draw(g);
	}

	public void paddle1UP() {
		pad1.up();
	}
	public void paddle1DOWN() {
		pad1.down();
	}
	public void paddle2UP() {
		pad2.up();
	}
	public void paddle2DOWN() {
		pad2.down();
	}
	
	
	void checkCollision() {
		
		if(b.collisionBox.intersects(pad1.collisionBox)) {
			//System.out.println("test");
			b.speed = Math.abs(b.speed);
			playSound("PongBlip.wav");
			
			System.out.println(b.getY()-pad1.getY());
			System.out.println(pad1.getY());
			
			if(b.getY() - pad1.getY() <= 33) {
				b.speedy = -3;
				System.out.println(b.speed);
			}
			else if(b.getY() - pad1.getY() > 33 && b.getY()-pad1.getY() <= 66) {
				b.speedy = 0;
				System.out.println(b.speed);
			}
			else {
				b.speedy = 3;
				System.out.println(b.speed);
			}
			if(score1 == 4 ) {
				b.speed = 4;
			}
			else if(score2 == 4) {
				b.speed = 4;
			}
			else if(score1 == 8) {
				b.speed = 5;
				pad1.speed = 24;
			}
			else if(score2 == 8) {
				b.speed = 5;
				pad1.speed = 24;
			}
			else if(score1 == 12) {
				b.speed = 6;
				pad1.speed = 26;
			}
			else if(score2 == 12) {
				b.speed = 6;
				pad1.speed = 26;
			}
		}
		else if(b.collisionBox.intersects(pad2.collisionBox)) {
			//System.out.println("test2");
			b.speed = -(Math.abs(b.speed));
			playSound("PongBlip.wav");
			
			if(b.getY() - pad2.getY() <= 33) {
				b.speedy = -3;
				System.out.println(b.speed);
			}
			else if(b.getY() - pad2.getY() > 33 && b.getY()-pad2.getY() <= 66) {
				b.speedy = 0;
				System.out.println(b.speed);
			}
			else {
				b.speedy = 3;
				System.out.println(b.speed);
			}
			if(score1 == 4 ) {
				b.speed = 4;
			}
			else if(score2 == 4) {
				b.speed = 4;
			}
			else if(score1 == 8) {
				b.speed = 5;
				pad2.speed = 27;
			}
			else if(score2 == 8) {
				b.speed = 5;
				pad2.speed = 27;
			}
			else if(score1 == 12) {
				b.speed = 6;
				pad2.speed = 29;
			}
			else if(score2 == 12) {
				b.speed = 6;
				pad2.speed = 29;
			}
		}
		else if(b.getX() <= 0) {
			score2++;
			if(score2 == 16) {
				GamePanel.setEndState();
			}
			b.x = 400;
			b.y = 325;
			b.speed = -b.speed;
		}
		else if(b.getX() >= 800) {
			score1++;
			if(score1 == 16) {
				GamePanel.setEndState();
			}
			b.x = 400;
			b.y = 325;
			b.speed = -b.speed;
		}
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
