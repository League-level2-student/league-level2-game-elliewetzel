import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObjectManager implements ActionListener{
	Paddle1 pad1;
	Paddle2 pad2;
	Ball b = new Ball(250, 500, 20, 20);
	int score1 = 0;
	int score2 = 0;
	
	public int getScore() {
		return score1;
		return score2;
	}
	
	public ObjectManager(Paddle1 pad1, Paddle2 pad2) {
		this.pad1 = pad1;
		this.pad2 = pad2;
	}
	
	
	public void update() {
		checkCollision();
	}

	void draw(Graphics g) {
		pad1.draw(g);
		pad2.draw(g);
		b.draw(g);
	}

	void purgeObjects() {
		
	}
	
	void checkCollision() {
		// Ball(250, 500, 20, 20);
		if(b.collisionBox.intersects(pad1.collisionBox)) {
			b.speed = -b.speed;
			
			
		}
		else if(pad2.collisionBox.intersects(b.collisionBox)) {
			b.speed = -b.speed;
		}
		//else if()
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
