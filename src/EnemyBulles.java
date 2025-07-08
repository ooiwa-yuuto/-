
public class EnemyBulles extends NewEnemy {
	int life =1 ;
	public EnemyBulles(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void draw(MyFrame f) {
		f.setColor(200, 200, 200);
		f.fillRect(x+10, y, 10, 30);
	}
	public void move() {
		x+= vx;
		y+= vy;
	}

}
