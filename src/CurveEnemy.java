
public class CurveEnemy extends Enemy {
	int life =3+GameWorld.stage ;
	public CurveEnemy(double x,double y,double vx,double vy) {
		super(x,y,vx,vy);
	}
	public void move() {
		super.move();
		if(x<GameWorld.player.x) {
			x++;
			vx = +GameWorld.stage ;
		}
		if(x>GameWorld.player.x) {
			x--;
			vx = -GameWorld.stage ;
		}
	}
	public void draw(MyFrame f) {
		f.setColor(0,0,0);
		f.fillOval(x,y,30,30);
		f.setColor(255, 255, 255);
		f.fillOval(x+5, y, 20, 30);
	}
}
 