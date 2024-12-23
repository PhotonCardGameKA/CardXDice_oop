package character;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import main.MainFrame;
import main.MainGame;


public class GamePanel extends JPanel {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel Character;
    private JLabel Enemy;
    private JProgressBar Char_PB;
    private JProgressBar Enemy_PB;
    public int turn =1;
    private ImageIcon attack;
    private ImageIcon idle;
    private ImageIcon walk;
    private ImageIcon die;
    private ImageIcon takehit;
    private ImageIcon death;
    public int destination=620;
    private int char_x=-140;
    private int char_y=20;
    public int x ;
    private int y;
    private int time_attack;
    private int time_die;
    public int  multiAttack =0;
    public int Stronghit =0;
    private int time_takehit=700;
	private JLabel Backgroud;
	private int time_defend=75;
	public int choice =1;
	private int time_back=4000;
	private int time_back1=1000;
	
	boolean isPlay = false;
    
	
	public GamePanel() {
		
		idle=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/idle.gif"));
		attack=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/attack.gif"));
		die=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/die.gif"));
		death=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/death.png"));
		takehit=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/takehit.gif"));
		walk=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/walk.gif"));
		setBackground(Color.DARK_GRAY);
		
		time_die=650;
		time_attack=775;
		
		
		
		x=850;
		y=0;
		
		
		this.setLayout(null);
		this.setBounds(0, -10, 1152, 270);
		
		
		Character = new JLabel();
		Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/idle.gif")));	
		Character.setBounds(-140, 20, 576, 256);
		this.add(Character);
		
		
		Enemy = new JLabel();
		Enemy.setIcon(idle);
		Enemy.setBounds(850, 0, 360, 307);
		this.add(Enemy);
		
		Char_PB = new JProgressBar();
		Char_PB.setValue(100);
		Char_PB.setIndeterminate(false);
		Char_PB.setForeground(Color.GREEN);
		Char_PB.setEnabled(false);
		Char_PB.setBackground(Color.WHITE);
		Char_PB.setBounds(39, 23, 178, 34);
		this.add(Char_PB);
		
		Enemy_PB = new JProgressBar();
		Enemy_PB.setValue(100);
		Enemy_PB.setForeground(Color.RED);
		Enemy_PB.setBounds(933, 23, 178, 34);
		this.add(Enemy_PB);
		
		Backgroud = new JLabel();
		Backgroud.setIcon(new ImageIcon(GamePanel.class.getResource("/background/background1.png")));
		Backgroud.setBounds(0, -28, 1370, 320 );
		this.add(Backgroud);
		
		
		
		
	}
	
	public void Phase1() {
		Character.setBounds(-140, 20, 576, 256);
		Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/idle.gif")));
		Backgroud.setIcon(new ImageIcon(GamePanel.class.getResource("/background/background1.png")));
		Enemy.setBounds(850, 0, 360, 307);
		idle=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/idle.gif"));
		Enemy.setIcon(idle);
		attack=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/attack.gif"));
		die=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/die.gif"));
		death=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/death.png"));
		takehit=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/takehit.gif"));
		walk=new ImageIcon(GamePanel.class.getResource("/anim/Enemy2/walk.gif"));
		
		destination=620;
		char_x=-140;
		char_y=20;
		time_die=650;
		time_attack=775;
		time_back=4000;
		time_takehit=700;
		time_defend=75;
		time_back1=1000;
		x=850;
		y=0;
	}
	
	
	public void Phase2() {
		Character.setBounds(-140, 10, 576, 256);
		Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/idle.gif")));
		Backgroud.setIcon(new ImageIcon(GamePanel.class.getResource("/background/background2.png")));
		Enemy.setBounds(903, -12, 576, 384);
		
		
		idle=new ImageIcon(GamePanel.class.getResource("/anim/Enemy3/idle.gif"));
		Enemy.setIcon(idle);
		attack=new ImageIcon(GamePanel.class.getResource("/anim/Enemy3/attack.gif"));
		die=new ImageIcon(GamePanel.class.getResource("/anim/Enemy3/die.gif"));
		death=new ImageIcon(GamePanel.class.getResource("/anim/Enemy3/death.png"));
		takehit=new ImageIcon(GamePanel.class.getResource("/anim/Enemy3/takehit.gif"));
		walk=new ImageIcon(GamePanel.class.getResource("/anim/Enemy3/walk.gif"));
		
		destination=700;
		char_x=-140;
		char_y=10;
		time_attack=900;
		time_die=650;
		time_back=4000;
		time_takehit=700;
		time_defend=75;
		time_back1=1000;
		x=903;
		y=-12;
	}
	public void PhaseBoss(){
		Character.setBounds(-140, 13, 576, 256);
		Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/idle.gif")));
		Backgroud.setIcon(new ImageIcon(GamePanel.class.getResource("/background/background3.png")));
		Enemy.setBounds(820, -35, 576, 384);
		idle=new ImageIcon(GamePanel.class.getResource("/anim/Enemy1/idle.gif"));
		Enemy.setIcon(idle);
		attack=new ImageIcon(GamePanel.class.getResource("/anim/Enemy1/attack.gif"));
		die=new ImageIcon(GamePanel.class.getResource("/anim/Enemy1/die.gif"));
		death=new ImageIcon(GamePanel.class.getResource("/anim/Enemy1/death.gif"));
		takehit=new ImageIcon(GamePanel.class.getResource("/anim/Enemy1/takehit.gif"));
		walk=new ImageIcon(GamePanel.class.getResource("/anim/Enemy1/walk.gif"));
		
		destination=550;
		char_x=-140;
		char_y=13;
		time_die=1300;
		time_attack=1450;
		time_back=4700;
		time_takehit=700;
		time_defend=150;
		time_back1=1600;
		x=820;
		y=-35;
		
	}
	
	public void Phase3() {
		Character.setBounds(-80, 0, 576, 256);
		Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/idle.gif")));
		Backgroud.setIcon(new ImageIcon(GamePanel.class.getResource("/background/background4.png")));
		Enemy.setBounds(650, -80, 640, 360);
        
		idle=new ImageIcon(GamePanel.class.getResource("/anim/Enemy4/idle.gif"));
		Enemy.setIcon(idle);
		attack=new ImageIcon(GamePanel.class.getResource("/anim/Enemy4/attack.gif"));
		die=new ImageIcon(GamePanel.class.getResource("/anim/Enemy4/die.gif"));
		death=new ImageIcon(GamePanel.class.getResource("/anim/Enemy4/death.png"));
		takehit=new ImageIcon(GamePanel.class.getResource("/anim/Enemy4/takehit.gif"));
		walk=new ImageIcon(GamePanel.class.getResource("/anim/Enemy4/walk.gif"));
		
		destination=500;
		time_attack=1500;
		time_die=2300;
		time_takehit=1200;
		time_defend=150;
		time_back=5000;
		time_back1=1870;
		char_x=-80;
		char_y=0;
		x=650;
		y=-80;
	}
	
	
	public void takehit() {
		Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/takehit.gif")));
	    Thread ani = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				Idle1(200);
			}
	    	
	    });
	    ani.start();
		
		
	}
	
	public void Idle1(int time) {
		Thread ani = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/idle.gif")));
				
			}
			
		});
		ani.start();
	}
	public void Idle2(int time) {
		Thread ani = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Enemy.setIcon(idle);
				
			}
			
		});
		ani.start();
	}
	
	public void Run() {
		if(turn==1) {
			
			Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/run.gif")));
				Thread ani= new Thread(new Runnable() {
					@Override
					public void run() {
						int x= Character.getLocation().x;
						int y= Character.getLocation().y;
					while(x<destination) {
						// TODO Auto-generated method stub
						x=x+120;
						Character.setLocation(x, y);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					switch(choice) {
					case 1 :
						Attack();
						isPlay = false;
						if(!isPlay) {
							MainFrame.sound.playSFX(3);
							isPlay = true;
						}
						try {
							Thread.sleep(1200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Back();
						break;
					case 2:
						Attack1();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Back();
					    break;
					case 3:
						Attack2();
						try {
							Thread.sleep(2850);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Back();
						break;
					case 4:
						Ulti();
						try {
							Thread.sleep(1900);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Back();
						break;
					}
					
					
					
					}
					
					
				});
				ani.start();
				
				
			}
		else {
			

			Enemy.setIcon(walk);
				Thread ani= new Thread(new Runnable() {
					@Override
					public void run() {
						int x= Enemy.getLocation().x;
						int y= Enemy.getLocation().y;
					while(x>110) {
						// TODO Auto-generated method stub
						x=x-120;
						Enemy.setLocation(x, y);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					if(Stronghit==1) {
						
						Attack();
						try {
							Thread.sleep(400);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int dmg = 50 - MainGame.shield;
						if(dmg < 0) {
							MainGame.shield = -dmg;
							dmg = 0;
						} else {
							MainGame.shield = 0;
						}
						Enemy_damege(dmg);
						MainGame.shieldTxt.setText("" + MainGame.shield);
						Stronghit=0;
					}
					
					if(multiAttack==0) {
					Attack();}
					
					if(multiAttack==1) {
						Thread ani = new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								int i =0 ;
								while(i<3) {
									Attack();
									i++;
									
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									int dmg = 3 - MainGame.shield;
									if(dmg < 0) {
										MainGame.shield = -dmg;
										dmg = 0;
									} else {
										MainGame.shield = 0;
									}
									Enemy_damege(dmg);
									MainGame.shieldTxt.setText("" + MainGame.shield);
								}
							}
							
						});
						ani.start();
						multiAttack=0;
						try {
							Thread.sleep(3600);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Back();
					}
					try {
						Thread.sleep(time_back1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Back();
					
					}
					
				});
				ani.start();
			
		}
		}
	
	public void Back() {
		if(turn ==1) {
			Character.setLocation(char_x, char_y);
		}
		else {
			Enemy.setLocation(x, y);
		}
	}
	
	public void Die() {
		if(turn==1) {
			Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/die.gif")));
			Thread ani = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(1100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/death.gif")));
				}
				
			});
			ani.start();
		}
		else {
			Enemy.setIcon(die);
			Thread ani = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(time_die);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Enemy.setIcon(death);
				}
				
			});
			ani.start();
			
		}
	}
	
	public void Ulti() {
		if(turn ==1) {
			Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/ulti.gif")));
			Idle1(1800);
			Thread ani = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(1400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Enemy.setIcon(takehit);
					Idle2(300);
				}
				
				
			});
			ani.start();
		}
		else {
			Enemy.setIcon(attack);
			Idle2(time_attack);
			Thread ani = new Thread(new Runnable() {

				

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(time_takehit);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/takehit.gif")));
					Idle1(200);
				}
				
				
			});
			ani.start();
		}
	}
	
	public void Attack2() {
		if(turn ==1) {
			Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/attack2.gif")));
			Idle1(2800);
			Thread ani = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Enemy.setIcon(takehit);
					Idle2(300);
				}
				
				
			});
			ani.start();
		}
		else {
			
			Enemy.setIcon(attack);
			Idle2(time_attack);
			Thread ani = new Thread(new Runnable() {

				

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(time_takehit);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/takehit.gif")));
					Idle1(200);
				}
				
				
			});
			ani.start();
		}
	}
	
	public void Attack1() {
		if(turn ==1) {
			Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/attack1.gif")));
			Idle1(1950);
			Thread ani = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(1400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Enemy.setIcon(takehit);
					Idle2(300);
				}
				
				
			});
			ani.start();
		}
		else {
			Enemy.setIcon(attack);
			Idle2(time_attack);
			Thread ani = new Thread(new Runnable() {

				

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(time_takehit);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/takehit.gif")));
					Idle1(600);
				}
				
				
			});
			ani.start();
		}
		
	}
	
	public void Attack() {
		if(turn ==1) {
			
			Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/attack.gif")));
			Idle1(1150);
			Thread ani = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(500);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Enemy.setIcon(takehit);
					Idle2(300);
				}
				
				
			});
			ani.start();
		}
		else {
			MainFrame.sound.playSFX(3);
			Enemy.setIcon(attack);
			Idle2(time_attack);
			
			Thread ani = new Thread(new Runnable() {

				

				@Override
				public void run() {
					
					// TODO Auto-generated method stub
					try {
						Thread.sleep(time_takehit);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/takehit.gif")));
					
					Idle1(200);
				}
				
				
			});
			ani.start();
		}
	
}
	public void Defend() {
		Enemy.setIcon(attack);
		Idle2(time_attack);
		Thread ani = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(time_defend);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Character.setIcon(new ImageIcon(GamePanel.class.getResource("/anim/Character/defend.gif")));
				Idle1(1150);
			}
		
		});
		ani.start();
		
	}
	public void Character_damage(int dmg) {
		this.Enemy_PB.setValue(this.Enemy_PB.getValue()-dmg);
		
	}
	public void Enemy_damege(int dmg) {
		this.Char_PB.setValue(this.Char_PB.getValue()-dmg);
	}
	
	public int Character_Hp() {
		return this.Char_PB.getValue();
	}
	
	public int Enemy_Hp() {
		return this.Enemy_PB.getValue();
	}
}
