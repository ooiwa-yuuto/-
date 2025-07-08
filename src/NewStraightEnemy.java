
public class NewStraightEnemy extends NewEnemy {
	int life =1 ;
	public NewStraightEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		// TODO 自動生成されたコンストラクター・スタブ
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
		f.setColor(0, 0, 0);
		f.fillOval(x, y, 25, 20);
		f.setColor(0,0,0);
		f.fillRect(x+17, y+0.5, 10, 20);
		f.setColor(0, 0, 0);
		f.fillRect(x+24,y+3, 10, 14);
	}
	public void generator() {
		// TODO 自動生成されたメソッド・スタブ
		if(life == 0) {
			 for (int i = 0; i < 12; i++) {
				 GameWorld.enemyBulles.add(new EnemyBulles(x,y,0,1+GameWorld.stage));
			 }
	}
		if(life == 0) {
			 for (int i = 0; i < 12; i++) {
				 GameWorld.enemyBulles.add(new EnemyBulles(x+17,y,0,1+GameWorld.stage));
			 }
	}
		if(life == 0) {
			 for (int i = 0; i < 12; i++) {
				 GameWorld.enemyBulles.add(new EnemyBulles(x-17,y,0,1+GameWorld.stage));
			 }
	}
		
	}
}
