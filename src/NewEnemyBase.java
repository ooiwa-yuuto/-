
public class NewEnemyBase extends NewEnemy {

	public NewEnemyBase(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		// TODO 自動生成されたコンストラクター・スタブ
		life=20+GameWorld.stage ;
		score =10;
	}
	public void move() {
		super.move();
		if (x>300) vx=-GameWorld.stage;
		if (x<100) vx=GameWorld.stage;
		if(Math.random()<0.05) {
			GameWorld.newenemies.add(new NewStraightEnemy(x,y,0,1+GameWorld.stage));
		}
	}
	public void draw(MyFrame f) {
	    // 中央胴体（本体）
		f.setColor(0, 0, 0);
	    f.fillRect(x+10, y+10, 16, 40);

	    // コックピット
	    f.setColor(0, 0, 0);
	    f.fillOval(x+10, y+5, 16, 16);

	    // 主翼
	    f.setColor(0, 0, 0);
	    f.fillRect(x-12, y+20, 60, 13);

	    // エンジン（主翼の下に配置）
	    f.setColor(0, 0, 0);
	    f.fillOval(x-7, y+27, 10, 16);
	    f.setColor(0, 0, 0);
	    f.fillOval(x+28, y+27, 10, 16);

	    // 尾翼
	    f.setColor(0, 0, 0);
	    f.fillRect(x+12, y+45, 14, 20);
	    f.setColor(0, 0, 0);
	    f.fillRect(x+7, y+47, 16, 12);
	    f.setColor(0, 0, 0);
	    f.fillRect(x+14, y+47, 16, 12);

	}
}
