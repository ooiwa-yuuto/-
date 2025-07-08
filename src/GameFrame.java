import java.util.Vector;

public class GameFrame extends MyFrame {
public void run() {
	GameWorld.player=new Player(100,300,0,0);
	addKeyListener(GameWorld.player);
	GameWorld.stage=1;
	GameWorld.score=0;
	while(true) {
		GameWorld.player.x=100;
		GameWorld.player.y=300;
		GameWorld.playerBullets=new Vector<PlayerBullet>();
		GameWorld.playerBullets2=new Vector<PlayerBullet2>();
		GameWorld.playerBullets3=new Vector<PlayerBullet3>();
		GameWorld.enemyBulles=new Vector<EnemyBulles>();
		GameWorld.enemies=new Vector<Enemy>();
		GameWorld.enemies.add(new EnemyBase(100,50,GameWorld.stage,0));
		GameWorld.newenemies=new Vector<NewEnemy>();
		GameWorld.newenemies.add(new NewEnemyBase(300,50,GameWorld.stage,0));
		GameWorld.enterPressed=false;
		while(true) {
			clear();
			drawString("Stage = "+GameWorld.stage,300,50,15);
			drawString("score = "+GameWorld.score,300,80,15);
			GameWorld.player.draw(this);
			GameWorld.player.move();
			movePlayerBullets();
			movePlayerBullets2();
			movePlayerBullets3();
			moveEnemyBullets();
			moveEnemies();
			moveNewEnemies();
			checkPlayerAndEnemies();
			checkPlayerBulletsAndEnemies();
			checkPlayerAndEnemies2();
			checkPlayerBulletsAndEnemies2();
			checkPlayerAndEnemyBullets();
			checkPlayerBulletsAndEnemyBullets() ;
			if(GameWorld.enemies.size()==0) {
				if(GameWorld.newenemies.size()==0) {
					setColor(0,0,0);
					drawString("クリア！",100,200,40);
					if(GameWorld.enterPressed) {
						GameWorld.stage++;
						break;
					}
				}
			}
			if (GameWorld.player.y<0) {
				setColor(0,0,0);
				drawString("ゲームオーバー!",50,200,40);
				if(GameWorld.enterPressed) {
					GameWorld.stage=1;
					GameWorld.score=0;
					break;
				}
			}  
			
			sleep(0.04);
		}
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
	
	public void moveEnemyBullets() {
	    int i = 0;
	    while (i < GameWorld.enemyBulles.size()) {
	        EnemyBulles b = GameWorld.enemyBulles.get(i);
	        b.draw(this);
	        b.move();
	        if (b.y > 400) {
	            GameWorld.enemyBulles.remove(i);
	        } else {
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
		int i=0;
		while(i<GameWorld.enemies.size()) {
			Enemy e=GameWorld.enemies.get(i);
			if(e.y>400) {
				GameWorld.enemies.remove(i);
			}
			else {
				i++;
			}
		}
	}
	
	public void moveNewEnemies() {
		for (int i=0 ; i<GameWorld.newenemies.size(); i++) {
			NewEnemy e=GameWorld.newenemies.get(i);
			e.draw(this);
			e.move();
		}
		int i=0;
		while(i<GameWorld.newenemies.size()) {
			NewEnemy e=GameWorld.newenemies.get(i);
			if(e.y>400) {
				GameWorld.newenemies.remove(i);
			}
			else {
				i++;
			}
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
	
	
	
	public void checkPlayerAndEnemyBullets() {
		for(int i=0; i<GameWorld.enemyBulles.size(); i++) {
			EnemyBulles e=GameWorld.enemyBulles.get(i);
			if(checkHit(GameWorld.player,e)) {
				System.out.println("やられた！"); 
				GameWorld.player.y= -1000;
			}
		}
	}
	
	public void checkPlayerAndEnemies2() {
		for(int i=0; i<GameWorld.newenemies.size(); i++) {
			NewEnemy e=GameWorld.newenemies.get(i);
			if(checkHit2(GameWorld.player,e)) {
				int j=0;
					while(j<GameWorld.newenemies.size()) {
						NewEnemy e1=GameWorld.newenemies.get(j);
						if(checkHit2(GameWorld.player,e1)) {
							e1.life--;
						}
						if(e1.life<=0) {
							double ex = e1.x;
						    double ey = e1.y;
						    GameWorld.newenemies.remove(j);
							NewStraightEnemy n = new NewStraightEnemy(ex,ey ,0, 1 + GameWorld.stage);
							n.life = 0;  
							n.generator();
							
						}
						else {
							j++;	
						}
					}
			}
		}
	}
	
	
	
	
	
	
	public void checkPlayerBulletsAndEnemyBullets() {
		int i=0;
		while (i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			int j=0;
			int hits=0;
			while(j<GameWorld.enemyBulles.size()) {
				EnemyBulles e=GameWorld.enemyBulles.get(j);
				if(checkHit(e,b)) {
					System.out.println("あたり");
					hits++;
					e.life--;
				}
				if(e.life<=0) {
					GameWorld.score+= e.score;
					GameWorld.enemyBulles.remove(j);
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
					GameWorld.score+= e.score;
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
		while (i<GameWorld.playerBullets2.size()) {
			PlayerBullet2 b=GameWorld.playerBullets2.get(i);
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
					GameWorld.score+= e.score;
					GameWorld.enemies.remove(j);
				}
				else {
					j++;	
				}
			}
			if(hits>0) {
				GameWorld.playerBullets2.remove(i);
			}
			else {
				i++;	
			}
		}
		while (i<GameWorld.playerBullets3.size()) {
			PlayerBullet3 b=GameWorld.playerBullets3.get(i);
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
					GameWorld.score+= e.score;
					GameWorld.enemies.remove(j);
				}
				else {
					j++;	
				}
			}
			if(hits>0) {
				GameWorld.playerBullets3.remove(i);
			}
			else {
				i++;	
			}
		}
	}
	
	
	
	
	public void checkPlayerBulletsAndEnemies2() {
		int i=0;
		while (i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			int j=0;
			int hits=0;
			while(j<GameWorld.newenemies.size()) {
				NewEnemy e=GameWorld.newenemies.get(j);
				if(checkHit(e,b)) {
					System.out.println("あたり");
					hits++;
					e.life--;
				}
				if(e.life<=0) {
					GameWorld.score+= e.score;
					GameWorld.newenemies.remove(j);
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
		while (i<GameWorld.playerBullets2.size()) {
			PlayerBullet2 b=GameWorld.playerBullets2.get(i);
			int j=0;
			int hits=0;
			while(j<GameWorld.newenemies.size()) {
				NewEnemy e=GameWorld.newenemies.get(j);
				if(checkHit(e,b)) {
					System.out.println("あたり");
					hits++;
					e.life--;
				}
				if(e.life<=0) {
					GameWorld.score+= e.score;
					GameWorld.newenemies.remove(j);
				}
				else {
					j++;	
				}
			}
			if(hits>0) {
				GameWorld.playerBullets2.remove(i);
			}
			else {
				i++;	
			}
		}
		while (i<GameWorld.playerBullets3.size()) {
			PlayerBullet3 b=GameWorld.playerBullets3.get(i);
			int j=0;
			int hits=0;
			while(j<GameWorld.newenemies.size()) {
				NewEnemy e=GameWorld.newenemies.get(j);
				if(checkHit(e,b)) {
					System.out.println("あたり");
					hits++;
					e.life--;
				}
				if(e.life<=0) {
					GameWorld.score+= e.score;
					GameWorld.newenemies.remove(j);
				}
				else {
					j++;	
				}
			}
			if(hits>0) {
				GameWorld.playerBullets3.remove(i);
			}
			else {
				i++;	
			}
		}
	}
	
	public boolean checkHit(Character a,Character b) {
		if(Math.abs(a.x-b.x)<=20 && Math.abs(a.y-b.y)<=20) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkHit2(Character a,Character b) {
		if(Math.abs(a.x-b.x)<=120 && Math.abs(a.y-b.y)<=120) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean checkHit3(Character a,Character b) {
		if(Math.abs(a.x-b.x)<=60 && Math.abs(a.y-b.y)<=60) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

