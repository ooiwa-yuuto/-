
public class PlayerBullet2 extends Character {
	public PlayerBullet2(double x,double y, double vx,double vy) {
		super(x,y,vx,vy);
	}
	public void draw(MyFrame f) {
		f.setColor(200, 200, 200);
		f.fillRect(x+10, y, 10, 30);
	}
	public void move() {
		x+= vx;
		y+= vy;
		vy -=2;
		vx +=0.1;
	}
}
