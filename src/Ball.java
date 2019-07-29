import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball extends GameObject{
	int speedy = 0;
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 3;
		
	}

	
	public int getX() {
		return x;
	}
	 /*need to put in speed increments depending on score, and if someone reaches 16 points make it game over*/
	
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
		//x-=speed;
		/*if(x<=0) {
			speed = -speed;
		}
			if(x>=800) {
				speed = -speed;
			}
*/	}
	
	public void update() {
		
	//need something?
		x+=speed;
		y+=speedy;
		
		super.update();
	}
}
