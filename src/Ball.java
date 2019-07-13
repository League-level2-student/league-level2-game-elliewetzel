import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
		//x = x+1;
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		x = x+=speed;
		if(x<=0) {
			x = -1 * x;
			x = x-=speed;
		}
		else if(x>= 800) {
			x = -1 * x;
		}
		else if(y<=0) {
			y = -1 * y;
		}
		else if(y>=650) {
			y = -1 * y;
		}
	}
	
	public void update() {		
		//x = x-=speed; //should go to paddle1 first
	//need something?
		super.update();
	}
}
