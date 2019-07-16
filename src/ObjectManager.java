import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObjectManager implements ActionListener{
	Paddle1 pad1;
	Paddle2 pad2;
	Ball b = new Ball(250, 500, 20, 20);
	int score1 = 0;
	int score2 = 0;
	
	public int getScore1() {
		return score1;
	}
	public int getScore2() {
		return score2;
	}
	
	public ObjectManager(Paddle1 pad1, Paddle2 pad2, Ball b) {
		this.pad1 = pad1;
		this.pad2 = pad2;
		this.b = b;
	}
	
	
	public void update() {
		checkCollision();
	}

	void draw(Graphics g) {
		pad1.draw(g);
		pad2.draw(g);
		b.draw(g);
	}

	
	void checkCollision() {
		
		if(b.collisionBox.intersects(pad1.collisionBox)) {
			
			b.speed = -1*b.speed;
			System.out.println(b.speed);
			
		}
		else if(pad2.collisionBox.intersects(b.collisionBox)) {
			
			//b.speed = -b.speed;
			
		}
		//else if()
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
