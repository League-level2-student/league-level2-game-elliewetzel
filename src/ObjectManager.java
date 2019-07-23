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
		this.pad2 = new Paddle2(787, 320, 10, 100);
		this.b = new Ball(250, 500, 20, 20);;
		/*Ball ball = 
		Paddle1 paddle1 = ;
		Paddle2 paddle2 = ;*/
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
			System.out.println("test");
			b.speed = Math.abs(b.speed);
			
			playSound("PongBlip.wav");
			
		}
		else if(b.collisionBox.intersects(pad2.collisionBox)) {
			System.out.println("test2");
			b.speed = -(Math.abs(b.speed));
			
			playSound("PongBlip.wav");
		}
		//else if()
		
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
