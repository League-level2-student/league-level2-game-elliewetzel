import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball extends GameObject{
	 Random c ;
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
			speed = -Math.abs(speed);
		}
		else if(y>=645) {
			speed = Math.abs(speed);
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
		//y-=speed;
		super.update();
	}
}
