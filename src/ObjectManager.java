import java.awt.Graphics;

public class ObjectManager {
	Paddle1 pad1;
	Paddle2 pad2;
	Ball b = new Ball(250, 500, 20, 20);
	
	public ObjectManager(Paddle1 pad1, Paddle2 pad2) {
		this.pad1 = pad1;
		this.pad2 = pad2;
	}
	
	
	public void update() {
		
	}

	void draw(Graphics g) {
		pad1.draw(g);
		pad2.draw(g);
		b.draw(g);
	}

	void purgeObjects() {
		
	}
	
}
