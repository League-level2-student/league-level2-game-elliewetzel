import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
	
	public void update() {
		//x = x-=speed; //should go to paddle1 first
	//need something?
		super.update();
	}
}
