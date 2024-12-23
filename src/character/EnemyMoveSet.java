package character;

import main.MainFrame;

public class EnemyMoveSet {
	public GamePanel g = new GamePanel();
	
	public EnemyMoveSet(GamePanel g) {
		this.g=g;
	}
	
	public void MultiAttack() {
		g.turn = 2;
		g.multiAttack=1;
		g.Run();
		
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		int frame = 0;
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(frame < 280) {
					frame++;
				} else {
					return;
				}
				delta--;
			}
		}
	}
	public void Heal() {
		g.turn = 2;
		g.Character_damage(-5);
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		int frame = 0;
		MainFrame.sound.playSFX(6);
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(frame < 80) {
					frame++;
				} else {
					return;
				}
				delta--;
			}
		}
	}
	public void StrongHit() {
		g.turn = 2;
		g.Stronghit=1;
		g.Run();
		
		double delta = 0;
		long lastTime = System.nanoTime();
		double drawInterval = 1000000000/60;
		int frame = 0;
		while(true) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				if(frame < 170) {
					frame++;
				} else {
					return;
				}
				delta--;
			}
		}
	}
	

}