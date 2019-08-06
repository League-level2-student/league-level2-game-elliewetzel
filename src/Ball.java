import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ball extends GameObject implements ActionListener{
	int speedy = 0;
	boolean paused = false;
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 3;
		
	}

	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		collisionBox.setBounds(x, y, width, height);
		drawCollisionBox(g);
		 if(y<=1) {
			speedy = Math.abs(speedy);
		}
		else if(y>=630) {
			speedy = -Math.abs(speedy);
		}
	}
	
	
	void direction() {
		}
	
	public void update() {
		if(!paused) {
		x+=speed;
		y+=speedy;
		
		super.update();}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(paused) {
			paused = false;
		}
		
	}
}
