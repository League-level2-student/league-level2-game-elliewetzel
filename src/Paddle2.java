import java.awt.Color;
import java.awt.Graphics;

public class Paddle2 extends GameObject{

	public Paddle2(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
	}
	void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
	public void up() {
		y-=speed;
		if(y <0) {
			y = 1;
		}
	}
	public void down() {
		y+=speed;
		if(y > 650) {
			y = 649;
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
		
	}
}
