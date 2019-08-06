import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.Timer;

public class ObjectManager implements ActionListener{
	Paddle1 pad1;
	Paddle2 pad2;
	Ball b;
	int score1 = 0;
	int score2 = 0;
	Timer cube;
	public int getScore1() {
		return score1;
	}
	public int getScore2() {
		return score2;
	}
	public ObjectManager() {
		this.pad1 = new Paddle1(6, 320, 11, 100);
		this.pad2 = new Paddle2(780, 320, 11, 100);
		this.b = new Ball(250, 500, 20, 20);
		cube = new Timer(1000, b);
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
			if(score1 == 4 || score2 == 4) {
				b.speed = 3;
			}
			else if(score1 == 8 || score2 == 8) {
				b.speed = 4;
				pad1.speed = 27;
			}
			else if(score1 == 12 || score2 == 12) {
				b.speed = 5;
				pad1.speed = 29;
			}
		}
		else if(b.collisionBox.intersects(pad2.collisionBox)) {
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
			if(score1 == 4 || score2 == 4) {
				b.speed = 3;
			}
			else if(score1 == 8 || score2 == 8) {
				b.speed = 4;
				pad2.speed = 30;
			}
			else if(score1 == 12 || score2 == 12) {
				b.speed = 5;
				pad2.speed = 32;
			}
		}
		else if(b.getX() <= 0) {
			score2++;
			if(score2 == 16) {
				GamePanel.setEndState();
			}
			b.x = 400;
			b.y = 325;
			b.paused = true;
			cube.start();
			b.speed = -b.speed;
		}
		else if(b.getX() >= 800) {
			score1++;
			if(score1 == 16) {
				GamePanel.setEndState();
			}
			b.x = 400;
			b.y = 325;
			b.paused = true;
			cube.start();
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