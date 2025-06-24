import java.util.Vector;

public class GameFrame extends MyFrame {
public void run() {
	GameWorld.player=new Player(100,300,0,0);
	addKeyListener(GameWorld.player);
	GameWorld.playerBullets=new Vector<PlayerBullet>();
	GameWorld.playerBullets2=new Vector<PlayerBullet2>();
	GameWorld.playerBullets3=new Vector<PlayerBullet3>();
	GameWorld.enemies=new Vector<Enemy>();
	GameWorld.enemies.add(new EnemyBase(100,50,1,0));
	while(true) {
		clear();
		GameWorld.player.draw(this);
		GameWorld.player.move();
		movePlayerBullets();
		movePlayerBullets2();
		movePlayerBullets3();
		moveEnemies();
		checkPlayerAndEnemies();
		checkPlayerBulletsAndEnemies();
		sleep(0.03);
	}
}
	public void movePlayerBullets() {
		int i=0;
		while(i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			b.draw(this);
			b.move();
			if(b.y<0) {
				GameWorld.playerBullets.remove(i);
			}
			else{
				i++;
			}
		}
	}
	public void movePlayerBullets2() {
		int i=0;
		while(i<GameWorld.playerBullets2.size()) {
			PlayerBullet2 b=GameWorld.playerBullets2.get(i);
			b.draw(this);
			b.move();
			if(b.y<0) {
				GameWorld.playerBullets2.remove(i);
			}
			else{
				i++;
			}
		}
	}
	public void movePlayerBullets3() {
		int i=0;
		while(i<GameWorld.playerBullets3.size()) {
			PlayerBullet3 b=GameWorld.playerBullets3.get(i);
			b.draw(this);
			b.move();
			if(b.y<0) {
				GameWorld.playerBullets3.remove(i);
			}
			else{
				i++;
			}
		}
	}
	
	public void moveEnemies() {
		for (int i=0 ; i<GameWorld.enemies.size(); i++) {
			Enemy e=GameWorld.enemies.get(i);
			e.draw(this);
			e.move();
		}
	}
	
	public void checkPlayerAndEnemies() {
		for(int i=0; i<GameWorld.enemies.size(); i++) {
			Enemy e=GameWorld.enemies.get(i);
			if(checkHit(GameWorld.player,e)) {
				System.out.println("やられた！"); 
				GameWorld.player.y= -1000;
			}
		}
	}
	
	public void checkPlayerBulletsAndEnemies() {
		int i=0;
		while (i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			int j=0;
			int hits=0;
			while(j<GameWorld.enemies.size()) {
				Enemy e=GameWorld.enemies.get(j);
				if(checkHit(e,b)) {
					System.out.println("あたり");
					hits++;
					e.life--;
				}
				if(e.life<=0) {
					GameWorld.enemies.remove(j);
				}
				else {
					j++;	
				}
			}
			if(hits>0) {
				GameWorld.playerBullets.remove(i);
			}
			else {
				i++;	
			}
		}
	}
	
	public boolean checkHit(Character a,Character b) {
		if(Math.abs(a.x-b.x)<=10 && Math.abs(a.y-b.y)<=10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

