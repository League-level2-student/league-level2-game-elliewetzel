import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball extends GameObject{
	 Random c ;
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
		
	}

	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		
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
		x-=speed;
		if(x<=0) {
			speed = -speed;
		}
			if(x>=800) {
				speed = -speed;
			}
	}
	
	public void update() {
		
	//need something?
		super.update();
	}
}
