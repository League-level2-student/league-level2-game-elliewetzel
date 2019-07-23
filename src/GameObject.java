import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
int x;
int y;
int width;
int height;
int speed = 0;
Rectangle collisionBox;


public GameObject(int x, int y, int width, int height) {
this.x = x;
this.y = y;
this.width = width;
this.height = height;
collisionBox = new Rectangle(x, y, width, height);
}

public void update() {
	//drawCollisionBox(g);
	collisionBox.setBounds(x, y, width, height);
//	System.out.println("" +x+ ", " + y);
}

public void drawCollisionBox(Graphics g) {
	g.setColor(Color.yellow);
	g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
}

}
