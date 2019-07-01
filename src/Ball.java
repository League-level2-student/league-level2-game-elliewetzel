import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(10, 10, 10, 10);
	}
}
