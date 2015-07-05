/*
 MarioSprite.Java (for Super Mario: The Zakaryan Strikes Back)
 By: Varjitt J, Rushil P, Bassem S, Francis Z
 To: Mr. D'Addario
 Due Date: January 27, 2014
 Period 1

 Program Description: This is a rendition of the famous Super Mario made by Nintendo.
 It has small & big mario, numerous types of enemies, and 7 levels. You must clear
 each level to finish the game. You do so by getting your character to the end of the map.
 You only get one run, starting with 20 lives. You get another life when you reach
 100 coins. No saves, no cheats. Good Luck.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 //Importing the required packages needed for the MarioSprite such as Image, ImagIcon and other GUI related items in the class 


public class MarioSprite {

	public int x, y;
	public int dx, dy, mapEnd, currMapPosX;
	public boolean jump, dead;
	public int landPosition;
	public boolean middle;
	public Image still;
	private ImageIcon msr1, msr2, msl1, msl2, mr1, mr2, mr3, ml1, ml2, ml3;
	private boolean faceRight;
	private int i, h;
	public int j;
	public Rectangle[] mapRecArray;
	public CoinSprite[] coinArray;
	public MysteryBox[] mbArray;
	public Enemy[] enemyArray;
	public BigCollision BigCollision;
	public CoinCollision CoinCollision;
	public Collision Collision;
	public EnemyCollision EnemyCollision;
	public MysteryCollision MysteryCollision;
	public ShroomSprite[] shroomArray;
	public ShroomCollision ShroomCollision;
	private MainMenu menu = new MainMenu();
	public boolean invincible;
   
	//Declarations of all necessary variables/objects used by mario throughout the entire game throughout every map
	
	public MarioSprite(int mapEndInput, Rectangle[] recInput,
			CoinSprite[] coinInput, MysteryBox[] mbInput, Enemy[] enemyInput,
			ShroomSprite[] shroomInput, BigCollision mapBigCollision,
			CoinCollision mapCoinCollision, Collision mapCollision,
			EnemyCollision mapEnemyCollision,
			MysteryCollision mapMysteryCollision,
			ShroomCollision mapShroomCollision) {

		//Declares the main constructor for mario that includes all arrays and objects used in every map from 1-7
		//Such as mapEndInput,coinInput, mysterybox Input, etc...
		
		
		msr1 = new ImageIcon("resources/msr1.png");
		msr2 = new ImageIcon("resources/msr2.png");
		msl1 = new ImageIcon("resources/msl1.png");
		msl2 = new ImageIcon("resources/msl2.png");
		mr1 = new ImageIcon("resources/mr1.png");
		mr2 = new ImageIcon("resources/mr2.png");
		mr3 = new ImageIcon("resources/mr3.png");
		ml1 = new ImageIcon("resources/ml1.png");
		ml2 = new ImageIcon("resources/ml2.png");
		ml3 = new ImageIcon("resources/ml3.png");
		
		//Decalrations of each if the sprite movements(walking,turning,etc..) for Mario for both small and big
		
		BigCollision = mapBigCollision;
		CoinCollision = mapCoinCollision;
		Collision = mapCollision;
		EnemyCollision = mapEnemyCollision;
		MysteryCollision = mapMysteryCollision;
		ShroomCollision = mapShroomCollision;

		//Equating the paramter contents to the original MarioSprite collision objects to be changed as he moves from map to map 
		
		still = mr2.getImage();
		x = 90;
		y = 100;
		i = 0;
		j = 0;
		
		//Setting the original image state and position of mario on the GUI
		
		mapEnd = mapEndInput;
		mapRecArray = recInput;
		coinArray = coinInput;
		mbArray = mbInput;
		enemyArray = enemyInput;
		shroomArray = shroomInput;
		
		//Equating the paramter contents to the original MarioSprite object arrays to be changed as he moves from map to map 
	}

	public void moveX() {
		
		// Move X method for mariosprite that allows for him to move while the map moving with him both 
		//in his big and small forms.It also adjusts all map collsions,enemy collisions shroomcollsion and Mariosprite movements   
		
		
		if (x >= 205)
			middle = true;//States that mario's position is in the middle of the window

		x += dx;

		if (dx == 7) {
			if (middle) {

				if (currMapPosX <= mapEnd) {
					currMapPosX = mapEnd;//Checks if mario is at the end of a specific map and switches to the next one 
					if (x >= 393) {
						x = 393;//Setting Mario's x postion to 393
						h++;
						if (h == 1) {
							menu.nextLevel();//Mario level switch 
						}
					}
				} else {
					x = 205;
					currMapPosX -= dx;//Moves the map to follow mario's movements 
				}
				i += 1;//Incrementing i by 1 which controls mario's animation
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct form whether he is big or small for map1 and adjusts the sprites
					if (!Map1.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct form whether he is big or small for map2 and adjusts the sprites
					if (!Map2.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct form whether he is big or small for map3 and adjusts the sprites
					if (!Map1.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct form whether he is big or small for map4 and adjusts the sprites
					if (!Map4.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct form whether he is big or small for map5 and adjusts the sprites
					if (!Map5.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct form whether he is big or small for map6 and adjusts the sprites
					if (!Map6.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct form whether he is big or small for map7 and adjusts the sprites
					if (!Map7.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				}
			} else {//All that there is in this if statement assumes that mario's postion is not in the middle of the map and that he is still and changes map movements according to that

				middle = false;//States that mario's position is not in the middle of the window
				i += 1;//Incrementing i by 1
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct form whether he is big or small for map1 and adjusts the sprites
					if (!Map1.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct form whether he is big or small for map2 and adjusts the sprites
					if (!Map2.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct form whether he is big or small for map3 and adjusts the sprites
					if (!Map3.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct form whether he is big or small for map4 and adjusts the sprites
					if (!Map4.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct form whether he is big or small for map5 and adjusts the sprites
					if (!Map5.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct form whether he is big or small for map6 and adjusts the sprites
					if (!Map6.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct form whether he is big or small for map7 and adjusts the sprites
					if (!Map7.big) {
						if (i == 1) {
							still = msr2.getImage();
						}
						if (i == 2) {
							still = msr1.getImage();
							i = 0;
						}
					} else {
						if (i == 1) {
							still = mr2.getImage();
						}
						if (i == 2) {
							still = mr1.getImage();
							i = 0;
						}
					}
				}
			}
		}

		if (dx == 0) {
			i = 0;//Setting i to 0 controllling mario's animation
			if (faceRight == true) {
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct form whether he is big or small for map1 and adjusts the sprites
					if (!Map1.big)
						still = msr1.getImage();
					else
						still = mr3.getImage();
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct form whether he is big or small for map2 and adjusts the sprites
					if (!Map2.big)
						still = msr1.getImage();
					else
						still = mr3.getImage();
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct form whether he is big or small for map3 and adjusts the sprites
					if (!Map3.big)
						still = msr1.getImage();
					else
						still = mr3.getImage();
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct form whether he is big or small for map4 and adjusts the sprites
					if (!Map4.big)
						still = msr1.getImage();
					else
						still = mr3.getImage();
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct form whether he is big or small for map5 and adjusts the sprites
					if (!Map5.big)
						still = msr1.getImage();
					else
						still = mr3.getImage();
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct form whether he is big or small for map6 and adjusts the sprites
					if (!Map6.big)
						still = msr1.getImage();
					else
						still = mr3.getImage();
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct form whether he is big or small for map7 and adjusts the sprites
					if (!Map7.big)
						still = msr1.getImage();
					else
						still = mr3.getImage();
				}
			} else if (faceRight == false) {
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct form whether he is big or small for map1 and adjusts the sprites
					if (!Map1.big)
						still = msl1.getImage();
					else
						still = ml3.getImage();
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct form whether he is big or small for map2 and adjusts the sprites
					if (!Map2.big)
						still = msl1.getImage();
					else
						still = ml3.getImage();
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct form whether he is big or small for map3 and adjusts the sprites
					if (!Map3.big)
						still = msl1.getImage();
					else
						still = ml3.getImage();
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct form whether he is big or small for map4 and adjusts the sprites
					if (!Map4.big)
						still = msl1.getImage();
					else
						still = ml3.getImage();
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct form whether he is big or small for map5 and adjusts the sprites
					if (!Map5.big)
						still = msl1.getImage();
					else
						still = ml3.getImage();
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct form whether he is big or small for map6 and adjusts the sprites
					if (!Map6.big)
						still = msl1.getImage();
					else
						still = ml3.getImage();
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct form whether he is big or small for map7 and adjusts the sprites
					if (!Map7.big)
						still = msl1.getImage();
					else
						still = ml3.getImage();
				}
			}
		}

		if (dx == -7) {
			if (middle && currMapPosX > 0) {
				x = 205;//Changes Mario's x coordinate to 205
				currMapPosX = 0;//Setting the Current Map Postion to 0
				i += -1;//Decrementing i by 1 which controls mario's animation
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct form whether he is big or small for map1 and adjusts the sprites
					if (!Map1.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}

				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct form whether he is big or small for map2 and adjusts the sprites
					if (!Map2.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}

				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct form whether he is big or small for map3 and adjusts the sprites
					if (!Map3.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}

				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct form whether he is big or small for map4 and adjusts the sprites
					if (!Map4.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}

				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct form whether he is big or small for map5 and adjusts the sprites
					if (!Map5.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}

				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct form whether he is big or small for map6 and adjusts the sprites
					if (!Map6.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}

				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct form whether he is big or small for map7 and adjusts the sprites
					if (!Map7.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}

				}
			} else {

				if (currMapPosX < 0) {
					if (currMapPosX <= mapEnd) {
						currMapPosX = mapEnd;//Sets the current Map position to the end 
						if (x <= 205) {
							middle = true;//Sets the middle boolean true indicating mario is in the middle 
							currMapPosX -= dx;//Subtracting mario's movement distance from the cureent map position 
						}
					} else {
						x -= dx;//Equating the difference between mario's original x coordinate to x itself
						currMapPosX -= dx;//Equating the difference between current map position and displacement to itself
					}
				} else {
					middle = false;
					if (x <= 0)
						x = 0;//Equating mario's x coordinate to 0
				}
				i += -1;
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct form whether he is big or small for map1 and adjusts the sprites
					if (!Map1.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct form whether he is big or small for map2 and adjusts the sprites
					if (!Map2.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct form whether he is big or small for map3 and adjusts the sprites
					if (!Map3.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct form whether he is big or small for map4 and adjusts the sprites
					if (!Map4.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct form whether he is big or small for map5 and adjusts the sprites
					if (!Map5.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct form whether he is big or small for map6 and adjusts the sprites
					if (!Map6.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct form whether he is big or small for map7 and adjusts the sprites
					if (!Map7.big) {
						if (i == -1) {
							still = msl2.getImage();
						}
						if (i == -2) {
							still = msl1.getImage();
							i = 0;
						}
					} else {
						if (i == -1) {
							still = ml2.getImage();
						}
						if (i == -2) {
							still = ml1.getImage();
							i = 0;
						}
					}
				}
			}
		}

		if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
			if (!Map1.big) {
				Collision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					Collision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					Collision.checkLeft();
					ShroomCollision.collision();
				}
			} else {
				BigCollision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					BigCollision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					BigCollision.checkLeft();
					ShroomCollision.collision();
				}
			}
		} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
			if (!Map2.big) {
				Collision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					Collision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					Collision.checkLeft();
					ShroomCollision.collision();
				}
			} else {
				BigCollision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					BigCollision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					BigCollision.checkLeft();
					ShroomCollision.collision();
				}
			}
		} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
			if (!Map3.big) {
				Collision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					Collision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					Collision.checkLeft();
					ShroomCollision.collision();
				}
			} else {
				BigCollision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					BigCollision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					BigCollision.checkLeft();
					ShroomCollision.collision();
				}
			}
		} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
			if (!Map4.big) {
				Collision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					Collision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					Collision.checkLeft();
					ShroomCollision.collision();
				}
			} else {
				BigCollision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					BigCollision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					BigCollision.checkLeft();
					ShroomCollision.collision();
				}
			}
		} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
			if (!Map5.big) {
				Collision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					Collision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					Collision.checkLeft();
					ShroomCollision.collision();
				}
			} else {
				BigCollision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					BigCollision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					BigCollision.checkLeft();
					ShroomCollision.collision();
				}
			}
		} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
			if (!Map6.big) {
				Collision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					Collision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					Collision.checkLeft();
					ShroomCollision.collision();
				}
			} else {
				BigCollision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					BigCollision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					BigCollision.checkLeft();
					ShroomCollision.collision();
				}
			}
		} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
			if (!Map7.big) {
				Collision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					Collision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					Collision.checkLeft();
					ShroomCollision.collision();
				}
			} else {
				BigCollision.checkBelow();
				ShroomCollision.collision();
				if (dx == 7) {
					BigCollision.checkRight();
					ShroomCollision.collision();
				}

				if (dx == -7) {
					BigCollision.checkLeft();
					ShroomCollision.collision();
				}
			}
		}

		if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
			if (!Map1.big) {
				CoinCollision.collision();
				ShroomCollision.collision();
				if (!invincible) {
					EnemyCollision.checkLeftRight();
					ShroomCollision.collision();
				}
			} else {
				CoinCollision.bigCollision();
				EnemyCollision.bigCheckLeftRight();
				ShroomCollision.collision();
			}
		} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
			if (!Map2.big) {
				CoinCollision.collision();
				ShroomCollision.collision();
				if (!invincible) {
					EnemyCollision.checkLeftRight();
					ShroomCollision.collision();
				}
			} else {
				CoinCollision.bigCollision();
				EnemyCollision.bigCheckLeftRight();
				ShroomCollision.collision();
			}
		} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
			if (!Map3.big) {
				CoinCollision.collision();
				ShroomCollision.collision();
				if (!invincible) {
					EnemyCollision.checkLeftRight();
					ShroomCollision.collision();
				}
			} else {
				CoinCollision.bigCollision();
				EnemyCollision.bigCheckLeftRight();
				ShroomCollision.collision();
			}
		} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
			if (!Map4.big) {
				CoinCollision.collision();
				ShroomCollision.collision();
				if (!invincible) {
					EnemyCollision.checkLeftRight();
					ShroomCollision.collision();
				}
			} else {
				CoinCollision.bigCollision();
				EnemyCollision.bigCheckLeftRight();
				ShroomCollision.collision();
			}
		} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
			if (!Map5.big) {
				CoinCollision.collision();
				ShroomCollision.collision();
				if (!invincible) {
					EnemyCollision.checkLeftRight();
					ShroomCollision.collision();
				}
			} else {
				CoinCollision.bigCollision();
				EnemyCollision.bigCheckLeftRight();
				ShroomCollision.collision();
			}
		} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
			if (!Map6.big) {
				CoinCollision.collision();
				ShroomCollision.collision();
				if (!invincible) {
					EnemyCollision.checkLeftRight();
					ShroomCollision.collision();
				}
			} else {
				CoinCollision.bigCollision();
				EnemyCollision.bigCheckLeftRight();
				ShroomCollision.collision();
			}
		} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
			if (!Map7.big) {
				CoinCollision.collision();
				ShroomCollision.collision();
				if (!invincible) {
					EnemyCollision.checkLeftRight();
					ShroomCollision.collision();
				}
			} else {
				CoinCollision.bigCollision();
				EnemyCollision.bigCheckLeftRight();
				ShroomCollision.collision();
			}
		}
	}

	public void jump() {

		j++;//Incrementing j that controls the jump sequence
		if (j == 1) {
			try {
				Sound.playActionMusic("nsmb_jump.wav");//Jump sound execution 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//Printing the error if it exists
			}
			if (Collision.checkAbove() == true) {
				j = 0;//Setting the jump number to 0 this number executes each of the jumping phases as Mario goes up then comes back down  
				jump = false;//Jump is set false
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			} else {
				y -= 20;//Moving mario's position up by 20 
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			}
		}
		if (j == 2) {
			if (Collision.checkAbove() == true) {
				j = 0;//Setting the jump number to 0 this number executes each of the jumping phases as Mario goes up then comes back down  
				jump = false;//Jump is false
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			} else {
				y -= 20;//Moving mario's position up by 20 
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			}
		}
		if (j == 3) {
			if (Collision.checkAbove() == true) {
				j = 0;//Setting the jump number to 0 this number executes each of the jumping phases as Mario goes up then comes back down  
				jump = false;//Jump is false
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			} else {
				y -= 20;//Moving mario's position up by 20 
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			}
		}
		if (j == 4) {
			if (Collision.checkAbove() == true) {
				j = 0;//Setting the jump number to 0 this number executes each of the jumping phases as Mario goes up then comes back down  
				jump = false;//Jump is false
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}

				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}

				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}

				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}

				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}

				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}

				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}

				}
			} else {
				y -= 20;//Moving mario's position up by 20 
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			}
		}
		if (j == 5) {
			if (Collision.checkAbove() == true) {
				j = 0;//Setting the jump number to 0 this number executes each of the jumping phases as Mario goes up then comes back down  
				jump = false;//Jump is false
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			} else {
				y -= 20;//Moving mario's position up by 20 
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			}
		}
		if (j == 6) {
			if (Collision.checkAbove() == true) {
				j = 0;//Setting the jump number to 0 this number executes each of the jumping phases as Mario goes up then comes back down  
				jump = false;//Jump is false
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			} else {
				y -= 20;//Moving mario's position up by 20 
				MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
				if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
					if (!Map1.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
					if (!Map2.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
					if (!Map3.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
					if (!Map4.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
					if (!Map5.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
					if (!Map6.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
					if (!Map7.big) {
						CoinCollision.collision();
						ShroomCollision.collision();
					} else {
						CoinCollision.bigCollision();
						ShroomCollision.collision();
					}
				}
			}
		}
		if (j == 13) {
			jump = false;//Jump is false
			j = 0;//Setting the jump number to 0 this number executes each of the jumping phases as Mario goes up then comes back down  
			MysteryCollision.taken();//MysteryCollsion is activated to see wether any mysteryboxes have been hit 
			if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
				if (!Map1.big) {
					CoinCollision.collision();
					ShroomCollision.collision();
				} else {
					CoinCollision.bigCollision();
					ShroomCollision.collision();
				}
			} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
				if (!Map2.big) {
					CoinCollision.collision();
					ShroomCollision.collision();
				} else {
					CoinCollision.bigCollision();
					ShroomCollision.collision();
				}
			} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
				if (!Map3.big) {
					CoinCollision.collision();
					ShroomCollision.collision();
				} else {
					CoinCollision.bigCollision();
					ShroomCollision.collision();
				}
			} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
				if (!Map4.big) {
					CoinCollision.collision();
					ShroomCollision.collision();
				} else {
					CoinCollision.bigCollision();
					ShroomCollision.collision();
				}
			} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
				if (!Map5.big) {
					CoinCollision.collision();
					ShroomCollision.collision();
				} else {
					CoinCollision.bigCollision();
					ShroomCollision.collision();
				}
			} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
				if (!Map6.big) {
					CoinCollision.collision();
					ShroomCollision.collision();
				} else {
					CoinCollision.bigCollision();
					ShroomCollision.collision();
				}
			} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
				if (!Map7.big) {
					CoinCollision.collision();
					ShroomCollision.collision();
				} else {
					CoinCollision.bigCollision();
					ShroomCollision.collision();
				}
			}
		}
	}

	public void addCoin() {
		if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
			Map1.coins++;
			if (Map1.coins == 100) {
				Map1.lives++;
				Map1.coins = 0;
			}
		} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
			Map2.coins++;
			if (Map2.coins == 100) {
				Map2.lives++;
				Map2.coins = 0;
			}
		} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
			Map3.coins++;
			if (Map3.coins == 100) {
				Map3.lives++;
				Map3.coins = 0;
			}
		} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
			Map4.coins++;
			if (Map4.coins == 100) {
				Map4.lives++;
				Map4.coins = 0;
			}
		} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
			Map5.coins++;
			if (Map5.coins == 100) {
				Map5.lives++;
				Map5.coins = 0;
			}
		} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
			Map6.coins++;
			if (Map6.coins == 100) {
				Map6.lives++;
				Map6.coins = 0;
			}
		} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
			Map7.coins++;
			if (Map7.coins == 100) {
				Map7.lives++;
				Map7.coins = 0;
			}
		}
	}

	public void enemyHit() {
		if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map
			if (Map1.big == true) {
				Map1.big = false;//Keeping mario in the small state
				invincible = true;//Keeping invenciblty frame on
				y += 10;//Moving Mario down by 10
				still = msr2.getImage();//Changing the still state of mario
				i = 0;//Setting i to 0 to stop animation 
				try {
					Sound.playActionMusic("nsmb_power_down.wav");//Playing powerdown music 
				} catch (Exception e) {
					e.printStackTrace();//Printing errors if encountered 
				}
			} else {
				death();//Exectuting death animation 
			}
		} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
			if (Map2.big) {
				Map2.big = false;//Keeping mario in the small state
				invincible = true;//Keeping invenciblty frame on
				y += 10;//Moving Mario down by 10
				still = msr2.getImage();//Changing the still state of mario
				i = 0;//Setting i to 0 to stop animation 
				try {
					Sound.playActionMusic("nsmb_power_down.wav");//Playing powerdown music 
				} catch (Exception e) {
					e.printStackTrace();//Printing errors if encountered 
				}
			} else {
				death();//Exectuting death animation 
			}
		} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
			if (Map3.big) {
				Map3.big = false;//Keeping mario in the small state
				invincible = true;//Keeping invenciblty frame on
				y += 10;//Moving Mario down by 10
				still = msr2.getImage();//Changing the still state of mario
				i = 0;//Setting i to 0 to stop animation 
				try {
					Sound.playActionMusic("nsmb_power_down.wav");//Playing powerdown music 
				} catch (Exception e) {
					e.printStackTrace();//Printing errors if encountered 
				}
			} else {
				death();//Exectuting death animation 
			}
		} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
			if (Map4.big) {
				Map4.big = false;//Keeping mario in the small state
				invincible = true;//Keeping invenciblty frame on
				y += 10;//Moving Mario down by 10
				still = msr2.getImage();//Changing the still state of mario
				i = 0;//Setting i to 0 to stop animation 
				try {
					Sound.playActionMusic("nsmb_power_down.wav");//Playing powerdown music 
				} catch (Exception e) {
					e.printStackTrace();//Printing errors if encountered 
				}
			} else {
				death();//Exectuting death animation 
			}
		} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
			if (Map5.big) {
				Map5.big = false;//Keeping mario in the small state
				invincible = true;//Keeping invenciblty frame on
				y += 10;//Moving Mario down by 10
				still = msr2.getImage();//Changing the still state of mario
				i = 0;//Setting i to 0 to stop animation 
				try {
					Sound.playActionMusic("nsmb_power_down.wav");//Playing powerdown music 
				} catch (Exception e) {
					e.printStackTrace();//Printing errors if encountered 
				}
			} else {
				death();//Exectuting death animation 
			}
		} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
			if (Map6.big) {
				Map6.big = false;//Keeping mario in the small state
				invincible = true;//Keeping invenciblty frame on
				y += 10;//Moving Mario down by 10
				still = msr2.getImage();//Changing the still state of mario
				i = 0;//Setting i to 0 to stop animation 
				try {
					Sound.playActionMusic("nsmb_power_down.wav");//Playing powerdown music 
				} catch (Exception e) {
					e.printStackTrace();//Printing errors if encountered 
				}
			} else {
				death();//Exectuting death animation 
			}
		} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
			if (Map7.big) {
				Map7.big = false;//Keeping mario in the small state
				invincible = true;//Keeping invenciblty frame on
				y += 10;//Moving Mario down by 10
				still = msr2.getImage();//Changing the still state of mario
				i = 0;//Setting i to 0 to stop animation 
				try {
					Sound.playActionMusic("nsmb_power_down.wav");//Playing powerdown music 
				} catch (Exception e) {
					e.printStackTrace();//Printing errors if encountered 
				}
			} else {
				death();//Exectuting death animation 
			}
		}
	}

	public void death() {
		dead = true;//Setting death to true 
	}

	public int getX() {
		return x;//Method to get mario's x coordinate 
	}

	public int getY() {
		return y;//Method to get mario's y coordinate 
	}

	public Image getImage() {
		return still;//Method return mario's current sprite that he is in
	}

	public void checkFall() {
		if (y >= 220)
			dead = true;//Setting death to true 
	}

	public void keyPressed(KeyEvent e) {//Keppressed method used to allow Mario to move left and right throughout the game from the left and right key buttons
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -7;
			faceRight = false;//Setting faceright off meaning he is facing left

		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 7;
			faceRight = true;//Setting faceright on meaning he is facing right

		}

		if (MainMenu.mapNumber == 1) {//Makes sure of mario's correct collision is correct for Map1 for all of mario's postions on the map and that Mario's function for jumping still works
			if (!Map1.big) {
				if (Collision.recLower.getX() != 1000
						&& y == (int) (Collision.recLower.getY() - 16)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			} else {
				if (BigCollision.recLower.getX() != 1000
						&& y == (int) (BigCollision.recLower.getY() - 26)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			}
		} else if (MainMenu.mapNumber == 2) {//Makes sure of mario's correct collision is correct for Map2 for all of mario's postions on the map
			if (!Map2.big) {
				if (Collision.recLower.getX() != 1000
						&& y == (int) (Collision.recLower.getY() - 16)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			} else {
				if (BigCollision.recLower.getX() != 1000
						&& y == (int) (BigCollision.recLower.getY() - 26)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			}
		} else if (MainMenu.mapNumber == 3) {//Makes sure of mario's correct collision is correct for Map3 for all of mario's postions on the map
			if (!Map3.big) {
				if (Collision.recLower.getX() != 1000
						&& y == (int) (Collision.recLower.getY() - 16)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			} else {
				if (BigCollision.recLower.getX() != 1000
						&& y == (int) (BigCollision.recLower.getY() - 26)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			}
		} else if (MainMenu.mapNumber == 4) {//Makes sure of mario's correct collision is correct for Map4 for all of mario's postions on the map
			if (!Map4.big) {
				if (Collision.recLower.getX() != 1000
						&& y == (int) (Collision.recLower.getY() - 16)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			} else {
				if (BigCollision.recLower.getX() != 1000
						&& y == (int) (BigCollision.recLower.getY() - 26)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			}
		} else if (MainMenu.mapNumber == 5) {//Makes sure of mario's correct collision is correct for Map5 for all of mario's postions on the map
			if (!Map5.big) {
				if (Collision.recLower.getX() != 1000
						&& y == (int) (Collision.recLower.getY() - 16)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			} else {
				if (BigCollision.recLower.getX() != 1000
						&& y == (int) (BigCollision.recLower.getY() - 26)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			}
		} else if (MainMenu.mapNumber == 6) {//Makes sure of mario's correct collision is correct for Map6 for all of mario's postions on the map
			if (!Map6.big) {
				if (Collision.recLower.getX() != 1000
						&& y == (int) (Collision.recLower.getY() - 16)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			} else {
				if (BigCollision.recLower.getX() != 1000
						&& y == (int) (BigCollision.recLower.getY() - 26)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			}
		} else if (MainMenu.mapNumber == 7) {//Makes sure of mario's correct collision is correct for Map7 for all of mario's postions on the map
			if (!Map7.big) {
				if (Collision.recLower.getX() != 1000
						&& y == (int) (Collision.recLower.getY() - 16)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			} else {
				if (BigCollision.recLower.getX() != 1000
						&& y == (int) (BigCollision.recLower.getY() - 26)) {
					if (key == KeyEvent.VK_SPACE) {
						jump = true;//Setting jump to true 
					}
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT)
			dx = 0;//Setting the displacement to 0
		if (key == KeyEvent.VK_RIGHT)
			dx = 0;//Setting the displacement to 0
	}

	public void reset() {//Reseting all mario variables 
		if (MainMenu.mapNumber == 1)
			Map1.big = false;//Keeping Mario in the small state in Map 1
		else if (MainMenu.mapNumber == 2)
			Map2.big = false;//Keeping Mario in the small state in Map 2
		else if (MainMenu.mapNumber == 3)
			Map3.big = false;//Keeping Mario in the small state in Map 3 
		else if (MainMenu.mapNumber == 4)
			Map4.big = false;//Keeping Mario in the small state in Map 4
		else if (MainMenu.mapNumber == 5)
			Map5.big = false;//Keeping Mario in the small state in Map 5
		else if (MainMenu.mapNumber == 6)
			Map6.big = false;//Keeping Mario in the small state in Map 6 
		else if (MainMenu.mapNumber == 7)
			Map7.big = false;//Keeping Mario in the small state in Map 7 
		dead = false;//Setting the death false
		still = msr1.getImage();//Setting still sprite to small mario 
		x = 90;//Setting x to 99
		dx = 0;//Setting dx to 0
		middle = false;//Setting middle to false
		invincible = false;//Setting invinciblity frame off
		y = 100;//Setting y to 100
		i = 0;//Setting i to 0
		j = 0;//Setting j to 0
		currMapPosX = 0;//Setting current map Position to 0
	}

	public void mapPort(int livesInput, int coinsInput, boolean bigInput) {
		if (MainMenu.mapNumber == 1) {//Porting all of Mario's info from Map 1 such as coins and state
			Map1.lives = livesInput;//Porting the lives
			Map1.coins = coinsInput;//Porting the coins
			Map1.big = bigInput;//Porting mario's state of large or small 
			if (Map1.big) {//Making sure at Map 1 mario is at the right size
				still = mr1.getImage();
			} else
				still = msr1.getImage();
		} else if (MainMenu.mapNumber == 2) {//Porting all of Mario's info from Map 2 such as coins and state
			Map2.lives = livesInput;//Porting the lives
			Map2.coins = coinsInput;//Porting the coins
			Map2.big = bigInput;//Porting mario's state of large or small
			if (Map2.big) {//Making sure at Map 2 mario is at the right size
				still = mr1.getImage();
			} else
				still = msr1.getImage();
		} else if (MainMenu.mapNumber == 3) {//Porting all of Mario's info from Map 3 such as coins and state
			Map3.lives = livesInput;//Porting the lives
			Map3.coins = coinsInput;//Porting the coins
			Map3.big = bigInput;//Porting mario's state of large or small
			if (Map3.big) {//Making sure at Map 3 mario is at the right size
				still = mr1.getImage();
			} else
				still = msr1.getImage();
		} else if (MainMenu.mapNumber == 4) {//Porting all of Mario's info from Map 4 such as coins and state
			Map4.lives = livesInput;//Porting the lives
			Map4.coins = coinsInput;//Porting the coins
			Map4.big = bigInput;//Porting mario's state of large or small
			if (Map4.big) {//Making sure at Map 4 mario is at the right size
				still = mr1.getImage();
			} else
				still = msr1.getImage();
		} else if (MainMenu.mapNumber == 5) {//Porting all of Mario's info from Map 5 such as coins and state
			Map5.lives = livesInput;//Porting the lives
			Map5.coins = coinsInput;//Porting the coins
			Map5.big = bigInput;//Porting mario's state of large or small
			if (Map5.big) {//Making sure at Map 5 mario is at the right size
				still = mr1.getImage();
			} else
				still = msr1.getImage();
		} else if (MainMenu.mapNumber == 6) {//Porting all of Mario's info from Map 6 such as coins and state
			Map6.lives = livesInput;//Porting the lives
			Map6.coins = coinsInput;//Porting the coins
			Map6.big = bigInput;//Porting mario's state of large or small
			if (Map6.big) {//Making sure at Map 6 mario is at the right size
				still = mr1.getImage();
			} else
				still = msr1.getImage();
		} else if (MainMenu.mapNumber == 7) {//Porting all of Mario's info from Map 7 such as coins and state
			Map7.lives = livesInput;//Porting the lives
			Map7.coins = coinsInput;//Porting the coins
			Map7.big = bigInput;//Porting mario's state of large or small
			if (Map7.big) {//Making sure at Map 7 mario is at the right size
				still = mr1.getImage();
			} else
				still = msr1.getImage();
		}
	}
}
