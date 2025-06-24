
public class RandomEnemy extends Enemy {
	int life =2;
	public RandomEnemy(double x,double y,double vx,double vy) {
		super(x,y,vx,vy);
	}
	public void move() {
		super.move();
		vx=Math.random()*4-2;
	}
	public void draw(MyFrame f) {
		f.setColor(0, 117, 107);
		f.fillRect(x-10, y, 10, 20);
		f.setColor(0, 117, 107);
		f.fillRect(x+10, y, 10, 20);
		f.setColor(0, 117, 107);
		f.fillRect(x, y+20, 10, 10);
	}
}
