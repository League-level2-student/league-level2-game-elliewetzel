import java.awt.Color;
import java.awt.Graphics;

public class Paddle1 extends GameObject{

	public Paddle1(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 19;
		
	}
	void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		collisionBox.setBounds(x, y, width, height);
		drawCollisionBox(g);
	}
	
	public void up() {
		y-=speed;
		if(y < 0) {
			y = 1;
			
		}
	}
	public void down() {
		y+=speed;
		if(y > 650) {
			y = 640;
		}
	}
	public void left() {
		x-=speed;
		if(x < 0) {
			x = 2;
		}
	}
	public void right() {
		x+=speed;
		if(x > 800) {
			x = 799;
		}
	}
	
	public void update() {
		super.update();
	}

}
