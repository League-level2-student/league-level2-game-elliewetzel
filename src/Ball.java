import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{
	boolean left = true;
	boolean right = false;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
		//x = x+1;
	}

	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		//direction();
		/*if(x<=0) {
			
			x = x+=speed;
			//x = -1 * x;
		}
		else if(x>= 800) {
			
			x = x-=speed;
			//x = -1 * x;
		}
		else if(y<=0) {
			
			y = y+=speed;
			//y = -1 * y;
		}
		else if(y>=650) {
			y = y-=speed;
			//y = -1 * y;
		}*/
	}
	
	void direction() {
		x = x-=speed;
		if(left) {
			if(x<=0) {
				x = -1 * x;
				left = false;
				right = true;
			}
		}
		if(right) {
			if(x>=800) {
				x = -1*x;
				right = false;
				left = true;
			}
		}
	}
	
	public void update() {
		
	//need something?
		super.update();
	}
}
