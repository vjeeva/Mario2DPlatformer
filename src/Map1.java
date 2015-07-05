/*
 Map1.Java (for Super Mario: The Zakaryan Strikes Back)
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

// Imports specific packages needed for the code

public class Map1 extends JPanel implements ActionListener { // Extends JPanel
																// and
																// implements
																// ActionListener

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MarioSprite userSprite; // Creates a new MarioSprite called
									// userSprite
	private BigCollision BigCollision;
	private CoinCollision CoinCollision;
	private Collision Collision;
	private EnemyCollision EnemyCollision;
	private MysteryCollision MysteryCollision;
	private ImageIcon map1; // Creates an ImageIcon
	private Timer timer; // Creates a timer
	private ShroomCollision ShroomCollision;
	private int invinCount = 0;
	public static int coins, lives;
	public static boolean big = true;

	private Rectangle floorRec1, floorRec2, floorRec3, floorRec4, floorRec5,
			floorRec6;
	private Rectangle boxRec1, boxRec2, boxRec3, boxRec4, boxRec5, boxRec6,
			boxRec7;
	private Rectangle pipeRec1, pipeRec2, pipeRec3, pipeRec4, pipeRec5,
			pipeRec6;
	private Rectangle brickRec1, brickRec2, brickRec3, brickRec4, brickRec5,
			brickRec6, brickRec7, brickRec8, brickRec9, brickRec10, brickRec11,
			brickRec12, brickRec13;
	private Rectangle blockRec1, blockRec2, blockRec3, blockRec4, blockRec5,
			blockRec6, blockRec7, blockRec8, blockRec9, blockRec10, blockRec11;

	// Creates Rectangles that are used for collision purposes

	private MysteryBox mb1, mb2, mb3, mb4, mb5, mb6, mb7;
	private CoinSprite c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13,
			c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26,
			c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37, c38, c39,
			c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50, c51, c52,
			c53, c54, c55, c56, c57, c58, c59, c60, c61, c62, c63, c64, c65,
			c66, c67, c68, c69, c70, c71, c72, c73, c74, c75, c76, c77, c78,
			c79, c80, c81, c82, c83, c84, c85, c86, c87, c88, c89, c90, c91,
			c92, c93, c94, c95, c96, c97, c98, c99, c100;
	private Enemy e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14,
			e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27,
			e28, e29, e30, e31, e32, e33;
	private ShroomSprite s1;

	// Creates new MysteryBoxes, CoinSprites, and Enemies

	private Rectangle[] mapRecArray = new Rectangle[43]; // Creates an array of
															// Rectangles
	private MysteryBox[] mbArray = new MysteryBox[7]; // Creates an array of
														// MysteryBoxes
	private CoinSprite[] coinArray = new CoinSprite[100]; // Creates an array of
															// CoinSprites
	private Enemy[] enemyArray = new Enemy[33]; // Creates an array of Enemies
	private ShroomSprite[] shroomArray = new ShroomSprite[1];
	private int mapEnd = -2407; // The end of the map
	private long t, end;
	private MainMenu menu = new MainMenu();
	private boolean checkedTime = false, checkedTime2 = false;
	private int menuOpen = 0;

	public Map1() {
		coins = 0;
		lives = 20;

		map1 = new ImageIcon("resources/1-1.png"); // The ImageIcon is set to
													// the picture
		addKeyListener(new KeyPasser()); // Adds a KeyPasser
		setFocusable(true); // Becomes the focus of the keyListener

		floorRec1 = new Rectangle(0, 205, 650, 50);
		floorRec2 = new Rectangle(620, 189, 462, 50);
		floorRec3 = new Rectangle(1147, 205, 351, 50);
		floorRec4 = new Rectangle(1531, 205, 80, 50);
		floorRec5 = new Rectangle(1659, 205, 575, 50);
		floorRec6 = new Rectangle(2252, 205, 577, 50);

		// Dictates the size and position of floorRecs

		boxRec1 = new Rectangle(172, 140, 16, 16);
		boxRec2 = new Rectangle(188, 140, 16, 16);
		boxRec3 = new Rectangle(220, 92, 16, 16);
		boxRec4 = new Rectangle(236, 92, 16, 16);
		boxRec5 = new Rectangle(412, 108, 16, 16);
		boxRec6 = new Rectangle(699, 140, 16, 16);
		boxRec7 = new Rectangle(1467, 156, 16, 16);

		// Dictates the size and position of boxRecs

		pipeRec1 = new Rectangle(348, 157, 31, 48);
		pipeRec2 = new Rectangle(1787, 173, 33, 30);
		pipeRec3 = new Rectangle(1852, 157, 31, 48);
		pipeRec4 = new Rectangle(2252, 157, 31, 50);
		pipeRec5 = new Rectangle(2315, 173, 33, 30);
		pipeRec6 = new Rectangle(2252, 0, 31, 107);

		// Dictates the size and position of pipeRecs

		brickRec1 = new Rectangle(652, 173, 16, 16);
		brickRec2 = new Rectangle(1499, 125, 32, 16);
		brickRec3 = new Rectangle(1564, 189, 48, 16);
		brickRec4 = new Rectangle(1580, 173, 32, 16);
		brickRec5 = new Rectangle(1597, 157, 16, 16);
		brickRec6 = new Rectangle(1659, 157, 16, 16);
		brickRec7 = new Rectangle(1659, 173, 32, 16);
		brickRec8 = new Rectangle(1659, 189, 48, 16);
		brickRec9 = new Rectangle(1947, 189, 112, 16);
		brickRec10 = new Rectangle(1963, 173, 80, 16);
		brickRec11 = new Rectangle(1979, 157, 64, 16);
		brickRec12 = new Rectangle(2091, 189, 32, 16);
		brickRec13 = new Rectangle(2091, 173, 16, 16);

		// Dictates the size and position of brickRecs

		blockRec1 = new Rectangle(237, 157, 47, 1);
		blockRec2 = new Rectangle(268, 125, 47, 1);
		blockRec3 = new Rectangle(398, 157, 78, 1);
		blockRec4 = new Rectangle(460, 125, 64, 1);
		blockRec5 = new Rectangle(508, 93, 64, 1);
		blockRec6 = new Rectangle(509, 173, 94, 1);
		blockRec7 = new Rectangle(1261, 173, 110, 1);
		blockRec8 = new Rectangle(1293, 141, 110, 1);
		blockRec9 = new Rectangle(1325, 109, 110, 1);
		blockRec10 = new Rectangle(2141, 157, 47, 1);
		blockRec11 = new Rectangle(2173, 60, 47, 1);

		// Dictates the size and position of blockRecs

		mb1 = new MysteryBox(172, 140);
		mb2 = new MysteryBox(188, 140);
		mb3 = new MysteryBox(220, 92);
		mb4 = new MysteryBox(236, 92);
		mb5 = new MysteryBox(412, 108);
		mb6 = new MysteryBox(699, 140);
		mb7 = new MysteryBox(1467, 156);

		// Dictates the position of mystery boxes

		c1 = new CoinSprite(240, 136);
		c2 = new CoinSprite(260, 136);
		c3 = new CoinSprite(275, 104);
		c4 = new CoinSprite(295, 104);
		c5 = new CoinSprite(359, 136);
		c6 = new CoinSprite(400, 136);
		c7 = new CoinSprite(420, 136);
		c8 = new CoinSprite(440, 136);
		c9 = new CoinSprite(470, 104);
		c10 = new CoinSprite(490, 104);
		c11 = new CoinSprite(520, 72);
		c12 = new CoinSprite(540, 72);
		c13 = new CoinSprite(530, 152);
		c14 = new CoinSprite(550, 152);
		c15 = new CoinSprite(1270, 152);
		c16 = new CoinSprite(1290, 152);
		c17 = new CoinSprite(1310, 152);
		c18 = new CoinSprite(1310, 120);
		c19 = new CoinSprite(1330, 120);
		c20 = new CoinSprite(1350, 120);
		c21 = new CoinSprite(1350, 88);
		c22 = new CoinSprite(1370, 88);
		c23 = new CoinSprite(1390, 88);
		c24 = new CoinSprite(1500, 104);
		c25 = new CoinSprite(1515, 104);
		c26 = new CoinSprite(1598, 136);
		c27 = new CoinSprite(1661, 136);
		c28 = new CoinSprite(1794, 152);
		c29 = new CoinSprite(1864, 136);
		c30 = new CoinSprite(1997, 136);
		c31 = new CoinSprite(2011, 136);
		c32 = new CoinSprite(2144, 136);
		c33 = new CoinSprite(2164, 136);
		c34 = new CoinSprite(2263, 136);
		c35 = new CoinSprite(2326, 152);
		c36 = new CoinSprite(800, 110);
		c37 = new CoinSprite(820, 110);
		c38 = new CoinSprite(840, 110);
		c39 = new CoinSprite(860, 110);
		c40 = new CoinSprite(880, 110);
		c41 = new CoinSprite(900, 110);
		c42 = new CoinSprite(920, 110);
		c43 = new CoinSprite(940, 110);
		c44 = new CoinSprite(960, 110);
		c45 = new CoinSprite(980, 110);
		c46 = new CoinSprite(1000, 110);
		c47 = new CoinSprite(1020, 110);
		c48 = new CoinSprite(1040, 110);
		c49 = new CoinSprite(1060, 110);
		c50 = new CoinSprite(800, 130);
		c51 = new CoinSprite(820, 130);
		c52 = new CoinSprite(840, 130);
		c53 = new CoinSprite(860, 130);
		c54 = new CoinSprite(880, 130);
		c55 = new CoinSprite(900, 130);
		c56 = new CoinSprite(920, 130);
		c57 = new CoinSprite(940, 130);
		c58 = new CoinSprite(960, 130);
		c59 = new CoinSprite(980, 130);
		c60 = new CoinSprite(1000, 130);
		c61 = new CoinSprite(1020, 130);
		c62 = new CoinSprite(1040, 130);
		c63 = new CoinSprite(1060, 130);
		c64 = new CoinSprite(800, 150);
		c65 = new CoinSprite(820, 150);
		c66 = new CoinSprite(840, 150);
		c67 = new CoinSprite(860, 150);
		c68 = new CoinSprite(880, 150);
		c69 = new CoinSprite(900, 150);
		c70 = new CoinSprite(920, 150);
		c71 = new CoinSprite(940, 150);
		c72 = new CoinSprite(960, 150);
		c73 = new CoinSprite(980, 150);
		c74 = new CoinSprite(1000, 150);
		c75 = new CoinSprite(1020, 150);
		c76 = new CoinSprite(1040, 150);
		c77 = new CoinSprite(1060, 150);
		c78 = new CoinSprite(1160, 120);
		c79 = new CoinSprite(1180, 120);
		c80 = new CoinSprite(1200, 120);
		c81 = new CoinSprite(1220, 120);
		c82 = new CoinSprite(1240, 120);
		c83 = new CoinSprite(1160, 140);
		c84 = new CoinSprite(1180, 140);
		c85 = new CoinSprite(1200, 140);
		c86 = new CoinSprite(1220, 140);
		c87 = new CoinSprite(1240, 140);
		c88 = new CoinSprite(1160, 140);
		c89 = new CoinSprite(1180, 140);
		c90 = new CoinSprite(1200, 140);
		c91 = new CoinSprite(1220, 140);
		c92 = new CoinSprite(1240, 140);
		c93 = new CoinSprite(1160, 160);
		c94 = new CoinSprite(1180, 160);
		c95 = new CoinSprite(1200, 160);
		c96 = new CoinSprite(1220, 160);
		c97 = new CoinSprite(1240, 160);
		c98 = new CoinSprite(2370, 184);
		c99 = new CoinSprite(2390, 184);
		c100 = new CoinSprite(2410, 184);

		// Dictates the position of coins

		e1 = new Enemy(140, 250, 189);
		e2 = new Enemy(240, 270, 189);
		e3 = new Enemy(270, 300, 189);
		e4 = new Enemy(394, 464, 189);
		e5 = new Enemy(506, 592, 189);
		e6 = new Enemy(620, 639, 173);
		e7 = new Enemy(674, 751, 173);
		e8 = new Enemy(740, 800, 173);
		e9 = new Enemy(770, 830, 173);
		e10 = new Enemy(850999, 9009999, 173); // moved out of playable area,
												// too many enemies is too hard
		e11 = new Enemy(99999, 9509999, 173); // moved out of playable area, too
												// many enemies is too hard
		e12 = new Enemy(999999, 9809999, 173); // moved out of playable area,
												// too many enemies is too hard
		e13 = new Enemy(970, 1000, 173);
		e14 = new Enemy(1000999, 106999999, 173); // moved out of playable area,
													// too many enemies is too
													// hard
		e15 = new Enemy(1160, 1200, 189);
		e16 = new Enemy(1215, 1240, 189);
		e17 = new Enemy(1260, 1300, 189);
		e18 = new Enemy(1320, 1400, 189);
		e19 = new Enemy(1420, 1480, 189);
		e20 = new Enemy(1717, 1766, 189);
		e21 = new Enemy(1822, 1836, 189);
		e22 = new Enemy(1892, 1927, 189);
		e23 = new Enemy(2060, 2080, 189);
		e24 = new Enemy(2130, 2214, 189);
		e25 = new Enemy(240, 270, 141);
		e26 = new Enemy(270, 300, 109);
		e27 = new Enemy(350, 366, 141);
		e28 = new Enemy(464, 506, 109);
		e29 = new Enemy(520, 580, 157);
		e30 = new Enemy(1340, 1410, 93);
		e31 = new Enemy(400, 450, 141);
		e32 = new Enemy(1500, 1520, 109);
		e33 = new Enemy(1980, 2030, 141);

		// Dictates the position of enemies

		s1 = new ShroomSprite(mb1.getX(), -10000000);

		mapRecArray[0] = floorRec1;
		mapRecArray[1] = floorRec2;
		mapRecArray[2] = floorRec3;
		mapRecArray[3] = floorRec4;
		mapRecArray[4] = floorRec5;
		mapRecArray[5] = floorRec6;

		// Sets the floorRecs to the array of Rectangles

		mapRecArray[6] = boxRec1;
		mapRecArray[7] = boxRec2;
		mapRecArray[8] = boxRec3;
		mapRecArray[9] = boxRec4;
		mapRecArray[10] = boxRec5;
		mapRecArray[11] = boxRec6;
		mapRecArray[12] = boxRec7;

		// Sets the boxRecs to the array of Rectangles

		mapRecArray[13] = pipeRec1;
		mapRecArray[14] = pipeRec2;
		mapRecArray[15] = pipeRec3;
		mapRecArray[16] = pipeRec4;
		mapRecArray[17] = pipeRec5;
		mapRecArray[18] = pipeRec6;

		// Sets the pipeRecs to the array of Rectangles

		mapRecArray[19] = brickRec1;
		mapRecArray[20] = brickRec2;
		mapRecArray[21] = brickRec3;
		mapRecArray[22] = brickRec4;
		mapRecArray[23] = brickRec5;
		mapRecArray[24] = brickRec6;
		mapRecArray[25] = brickRec7;
		mapRecArray[26] = brickRec8;
		mapRecArray[27] = brickRec9;
		mapRecArray[28] = brickRec10;
		mapRecArray[29] = brickRec11;
		mapRecArray[30] = brickRec12;
		mapRecArray[31] = brickRec13;

		// Sets the brickRecs to the array of Rectangles

		mapRecArray[32] = blockRec1;
		mapRecArray[33] = blockRec2;
		mapRecArray[34] = blockRec3;
		mapRecArray[35] = blockRec4;
		mapRecArray[36] = blockRec5;
		mapRecArray[37] = blockRec6;
		mapRecArray[38] = blockRec7;
		mapRecArray[39] = blockRec8;
		mapRecArray[40] = blockRec9;
		mapRecArray[41] = blockRec10;
		mapRecArray[42] = blockRec11;

		// Sets the blockRecs to the array of Rectangles

		mbArray[0] = mb1;
		mbArray[1] = mb2;
		mbArray[2] = mb3;
		mbArray[3] = mb4;
		mbArray[4] = mb5;
		mbArray[5] = mb6;
		mbArray[6] = mb7;

		// Sets the mystery boxes to the array of MysteryBoxes

		coinArray[0] = c1;
		coinArray[1] = c2;
		coinArray[2] = c3;
		coinArray[3] = c4;
		coinArray[4] = c5;
		coinArray[5] = c6;
		coinArray[6] = c7;
		coinArray[7] = c8;
		coinArray[8] = c9;
		coinArray[9] = c10;
		coinArray[10] = c11;
		coinArray[11] = c12;
		coinArray[12] = c13;
		coinArray[13] = c14;
		coinArray[14] = c15;
		coinArray[15] = c16;
		coinArray[16] = c17;
		coinArray[17] = c18;
		coinArray[18] = c19;
		coinArray[19] = c20;
		coinArray[20] = c21;
		coinArray[21] = c22;
		coinArray[22] = c23;
		coinArray[23] = c24;
		coinArray[24] = c25;
		coinArray[25] = c26;
		coinArray[26] = c27;
		coinArray[27] = c28;
		coinArray[28] = c29;
		coinArray[29] = c30;
		coinArray[30] = c31;
		coinArray[31] = c32;
		coinArray[32] = c33;
		coinArray[33] = c34;
		coinArray[34] = c35;
		coinArray[35] = c36;
		coinArray[36] = c37;
		coinArray[37] = c38;
		coinArray[38] = c39;
		coinArray[39] = c40;
		coinArray[40] = c41;
		coinArray[41] = c42;
		coinArray[42] = c43;
		coinArray[43] = c44;
		coinArray[44] = c45;
		coinArray[45] = c46;
		coinArray[46] = c47;
		coinArray[47] = c48;
		coinArray[48] = c49;
		coinArray[49] = c50;
		coinArray[50] = c51;
		coinArray[51] = c52;
		coinArray[52] = c53;
		coinArray[53] = c54;
		coinArray[54] = c55;
		coinArray[55] = c56;
		coinArray[56] = c57;
		coinArray[57] = c58;
		coinArray[58] = c59;
		coinArray[59] = c60;
		coinArray[60] = c61;
		coinArray[61] = c62;
		coinArray[62] = c63;
		coinArray[63] = c64;
		coinArray[64] = c65;
		coinArray[65] = c66;
		coinArray[66] = c67;
		coinArray[67] = c68;
		coinArray[68] = c69;
		coinArray[69] = c70;
		coinArray[70] = c71;
		coinArray[71] = c72;
		coinArray[72] = c73;
		coinArray[73] = c74;
		coinArray[74] = c75;
		coinArray[75] = c76;
		coinArray[76] = c77;
		coinArray[77] = c78;
		coinArray[78] = c79;
		coinArray[79] = c80;
		coinArray[80] = c81;
		coinArray[81] = c82;
		coinArray[82] = c83;
		coinArray[83] = c84;
		coinArray[84] = c85;
		coinArray[85] = c86;
		coinArray[86] = c87;
		coinArray[87] = c88;
		coinArray[88] = c89;
		coinArray[89] = c90;
		coinArray[90] = c91;
		coinArray[91] = c92;
		coinArray[92] = c93;
		coinArray[93] = c94;
		coinArray[94] = c95;
		coinArray[95] = c96;
		coinArray[96] = c97;
		coinArray[97] = c98;
		coinArray[98] = c99;
		coinArray[99] = c100;

		// Sets the coins to the array of Coins

		enemyArray[0] = e1;
		enemyArray[1] = e2;
		enemyArray[2] = e3;
		enemyArray[3] = e4;
		enemyArray[4] = e5;
		enemyArray[5] = e6;
		enemyArray[6] = e7;
		enemyArray[7] = e8;
		enemyArray[8] = e9;
		enemyArray[9] = e10;
		enemyArray[10] = e11;
		enemyArray[11] = e12;
		enemyArray[12] = e13;
		enemyArray[13] = e14;
		enemyArray[14] = e15;
		enemyArray[15] = e16;
		enemyArray[16] = e17;
		enemyArray[17] = e18;
		enemyArray[18] = e19;
		enemyArray[19] = e20;
		enemyArray[20] = e21;
		enemyArray[21] = e22;
		enemyArray[22] = e23;
		enemyArray[23] = e24;
		enemyArray[24] = e25;
		enemyArray[25] = e26;
		enemyArray[26] = e27;
		enemyArray[27] = e28;
		enemyArray[28] = e29;
		enemyArray[29] = e30;
		enemyArray[30] = e31;
		enemyArray[31] = e32;
		enemyArray[32] = e33;

		// Sets the enemies to the array of Enemies

		shroomArray[0] = s1;

		BigCollision = new BigCollision(mapRecArray);
		CoinCollision = new CoinCollision(coinArray);
		Collision = new Collision(mapRecArray);
		EnemyCollision = new EnemyCollision(enemyArray);
		MysteryCollision = new MysteryCollision(mbArray, shroomArray);
		ShroomCollision = new ShroomCollision(shroomArray);
		userSprite = new MarioSprite(mapEnd, mapRecArray, coinArray, mbArray,
				enemyArray, shroomArray, BigCollision, CoinCollision,
				Collision, EnemyCollision, MysteryCollision, ShroomCollision); // Creates
																				// a
																				// new
																				// MarioSprite
		BigCollision.add(userSprite, CoinCollision, EnemyCollision);
		CoinCollision.addUserSprite(userSprite);
		Collision.add(userSprite, CoinCollision, EnemyCollision);
		EnemyCollision.addUserSprite(userSprite);
		MysteryCollision.addUserSprite(userSprite);
		ShroomCollision.addUserSprite(userSprite);
		timer = new Timer(35, this); // Sets the speed of the timer
		timer.start(); // Starts the timer
	}

	public void actionPerformed(ActionEvent e) {

		userSprite.moveX(); // Moves the X-position of userSprite

		floorRec1.setBounds(0 + userSprite.currMapPosX, (int) floorRec1.getY(),
				(int) floorRec1.getWidth(), (int) floorRec1.getHeight());
		floorRec2.setBounds(620 + userSprite.currMapPosX,
				(int) floorRec2.getY(), (int) floorRec2.getWidth(),
				(int) floorRec2.getHeight());
		floorRec3.setBounds(1147 + userSprite.currMapPosX,
				(int) floorRec3.getY(), (int) floorRec3.getWidth(),
				(int) floorRec3.getHeight());
		floorRec4.setBounds(1531 + userSprite.currMapPosX,
				(int) floorRec4.getY(), (int) floorRec4.getWidth(),
				(int) floorRec4.getHeight());
		floorRec5.setBounds(1659 + userSprite.currMapPosX,
				(int) floorRec5.getY(), (int) floorRec5.getWidth(),
				(int) floorRec5.getHeight());
		floorRec6.setBounds(2252 + userSprite.currMapPosX,
				(int) floorRec6.getY(), (int) floorRec6.getWidth(),
				(int) floorRec6.getHeight());

		// Sets the bounds of floorRecs

		boxRec1.setBounds(172 + userSprite.currMapPosX, (int) boxRec1.getY(),
				(int) boxRec1.getWidth(), (int) boxRec1.getHeight());
		boxRec2.setBounds(188 + userSprite.currMapPosX, (int) boxRec2.getY(),
				(int) boxRec2.getWidth(), (int) boxRec2.getHeight());
		boxRec3.setBounds(220 + userSprite.currMapPosX, (int) boxRec3.getY(),
				(int) boxRec3.getWidth(), (int) boxRec3.getHeight());
		boxRec4.setBounds(236 + userSprite.currMapPosX, (int) boxRec4.getY(),
				(int) boxRec4.getWidth(), (int) boxRec4.getHeight());
		boxRec5.setBounds(412 + userSprite.currMapPosX, (int) boxRec5.getY(),
				(int) boxRec5.getWidth(), (int) boxRec5.getHeight());
		boxRec6.setBounds(699 + userSprite.currMapPosX, (int) boxRec6.getY(),
				(int) boxRec6.getWidth(), (int) boxRec6.getHeight());
		boxRec7.setBounds(1467 + userSprite.currMapPosX, (int) boxRec7.getY(),
				(int) boxRec7.getWidth(), (int) boxRec7.getHeight());

		// Sets the bounds of boxRecs

		pipeRec1.setBounds(348 + userSprite.currMapPosX, (int) pipeRec1.getY(),
				(int) pipeRec1.getWidth(), (int) pipeRec1.getHeight());
		pipeRec2.setBounds(1787 + userSprite.currMapPosX,
				(int) pipeRec2.getY(), (int) pipeRec2.getWidth(),
				(int) pipeRec2.getHeight());
		pipeRec3.setBounds(1852 + userSprite.currMapPosX,
				(int) pipeRec3.getY(), (int) pipeRec3.getWidth(),
				(int) pipeRec3.getHeight());
		pipeRec4.setBounds(2252 + userSprite.currMapPosX,
				(int) pipeRec4.getY(), (int) pipeRec4.getWidth(),
				(int) pipeRec4.getHeight());
		pipeRec5.setBounds(2315 + userSprite.currMapPosX,
				(int) pipeRec5.getY(), (int) pipeRec5.getWidth(),
				(int) pipeRec5.getHeight());
		pipeRec6.setBounds(2252 + userSprite.currMapPosX,
				(int) pipeRec6.getY(), (int) pipeRec6.getWidth(),
				(int) pipeRec6.getHeight());

		// Sets the bounds of pipeRecs

		brickRec1.setBounds(652 + userSprite.currMapPosX,
				(int) brickRec1.getY(), (int) brickRec1.getWidth(),
				(int) brickRec1.getHeight());
		brickRec2.setBounds(1499 + userSprite.currMapPosX,
				(int) brickRec2.getY(), (int) brickRec2.getWidth(),
				(int) brickRec2.getHeight());
		brickRec3.setBounds(1564 + userSprite.currMapPosX,
				(int) brickRec3.getY(), (int) brickRec3.getWidth(),
				(int) brickRec3.getHeight());
		brickRec4.setBounds(1580 + userSprite.currMapPosX,
				(int) brickRec4.getY(), (int) brickRec4.getWidth(),
				(int) brickRec4.getHeight());
		brickRec5.setBounds(1597 + userSprite.currMapPosX,
				(int) brickRec5.getY(), (int) brickRec5.getWidth(),
				(int) brickRec5.getHeight());
		brickRec6.setBounds(1659 + userSprite.currMapPosX,
				(int) brickRec6.getY(), (int) brickRec6.getWidth(),
				(int) brickRec6.getHeight());
		brickRec7.setBounds(1659 + userSprite.currMapPosX,
				(int) brickRec7.getY(), (int) brickRec7.getWidth(),
				(int) brickRec7.getHeight());
		brickRec8.setBounds(1659 + userSprite.currMapPosX,
				(int) brickRec8.getY(), (int) brickRec8.getWidth(),
				(int) brickRec8.getHeight());
		brickRec9.setBounds(1947 + userSprite.currMapPosX,
				(int) brickRec9.getY(), (int) brickRec9.getWidth(),
				(int) brickRec9.getHeight());
		brickRec10.setBounds(1963 + userSprite.currMapPosX,
				(int) brickRec10.getY(), (int) brickRec10.getWidth(),
				(int) brickRec10.getHeight());
		brickRec11.setBounds(1979 + userSprite.currMapPosX,
				(int) brickRec11.getY(), (int) brickRec11.getWidth(),
				(int) brickRec11.getHeight());
		brickRec12.setBounds(2091 + userSprite.currMapPosX,
				(int) brickRec12.getY(), (int) brickRec12.getWidth(),
				(int) brickRec12.getHeight());
		brickRec13.setBounds(2091 + userSprite.currMapPosX,
				(int) brickRec13.getY(), (int) brickRec13.getWidth(),
				(int) brickRec13.getHeight());

		// Sets the bounds of brickRecs

		blockRec1.setBounds(237 + userSprite.currMapPosX,
				(int) blockRec1.getY(), (int) blockRec1.getWidth(),
				(int) blockRec1.getHeight());
		blockRec2.setBounds(268 + userSprite.currMapPosX,
				(int) blockRec2.getY(), (int) blockRec2.getWidth(),
				(int) blockRec2.getHeight());
		blockRec3.setBounds(398 + userSprite.currMapPosX,
				(int) blockRec3.getY(), (int) blockRec3.getWidth(),
				(int) blockRec3.getHeight());
		blockRec4.setBounds(460 + userSprite.currMapPosX,
				(int) blockRec4.getY(), (int) blockRec4.getWidth(),
				(int) blockRec4.getHeight());
		blockRec5.setBounds(508 + userSprite.currMapPosX,
				(int) blockRec5.getY(), (int) blockRec5.getWidth(),
				(int) blockRec5.getHeight());
		blockRec6.setBounds(509 + userSprite.currMapPosX,
				(int) blockRec6.getY(), (int) blockRec6.getWidth(),
				(int) blockRec6.getHeight());
		blockRec7.setBounds(1261 + userSprite.currMapPosX,
				(int) blockRec7.getY(), (int) blockRec7.getWidth(),
				(int) blockRec7.getHeight());
		blockRec8.setBounds(1293 + userSprite.currMapPosX,
				(int) blockRec8.getY(), (int) blockRec8.getWidth(),
				(int) blockRec8.getHeight());
		blockRec9.setBounds(1325 + userSprite.currMapPosX,
				(int) blockRec9.getY(), (int) blockRec9.getWidth(),
				(int) blockRec9.getHeight());
		blockRec10.setBounds(2141 + userSprite.currMapPosX,
				(int) blockRec10.getY(), (int) blockRec10.getWidth(),
				(int) blockRec10.getHeight());
		blockRec11.setBounds(2173 + userSprite.currMapPosX,
				(int) blockRec11.getY(), (int) blockRec11.getWidth(),
				(int) blockRec11.getHeight());

		// Sets the bounds of blockRecs

		mb1.move(userSprite.currMapPosX);
		mb2.move(userSprite.currMapPosX);
		mb3.move(userSprite.currMapPosX);
		mb4.move(userSprite.currMapPosX);
		mb5.move(userSprite.currMapPosX);
		mb6.move(userSprite.currMapPosX);
		mb7.move(userSprite.currMapPosX);

		// The mystery boxes move across the map

		mb1.animate();
		mb2.animate();
		mb3.animate();
		mb4.animate();
		mb5.animate();
		mb6.animate();
		mb7.animate();

		// Animates the mystery boxes

		c1.move(userSprite.currMapPosX);
		c2.move(userSprite.currMapPosX);
		c3.move(userSprite.currMapPosX);
		c4.move(userSprite.currMapPosX);
		c5.move(userSprite.currMapPosX);
		c6.move(userSprite.currMapPosX);
		c7.move(userSprite.currMapPosX);
		c8.move(userSprite.currMapPosX);
		c9.move(userSprite.currMapPosX);
		c10.move(userSprite.currMapPosX);
		c11.move(userSprite.currMapPosX);
		c12.move(userSprite.currMapPosX);
		c13.move(userSprite.currMapPosX);
		c14.move(userSprite.currMapPosX);
		c15.move(userSprite.currMapPosX);
		c16.move(userSprite.currMapPosX);
		c17.move(userSprite.currMapPosX);
		c18.move(userSprite.currMapPosX);
		c19.move(userSprite.currMapPosX);
		c20.move(userSprite.currMapPosX);
		c21.move(userSprite.currMapPosX);
		c22.move(userSprite.currMapPosX);
		c23.move(userSprite.currMapPosX);
		c24.move(userSprite.currMapPosX);
		c25.move(userSprite.currMapPosX);
		c26.move(userSprite.currMapPosX);
		c27.move(userSprite.currMapPosX);
		c28.move(userSprite.currMapPosX);
		c29.move(userSprite.currMapPosX);
		c30.move(userSprite.currMapPosX);
		c31.move(userSprite.currMapPosX);
		c32.move(userSprite.currMapPosX);
		c33.move(userSprite.currMapPosX);
		c34.move(userSprite.currMapPosX);
		c35.move(userSprite.currMapPosX);
		c36.move(userSprite.currMapPosX);
		c37.move(userSprite.currMapPosX);
		c38.move(userSprite.currMapPosX);
		c39.move(userSprite.currMapPosX);
		c40.move(userSprite.currMapPosX);
		c41.move(userSprite.currMapPosX);
		c42.move(userSprite.currMapPosX);
		c43.move(userSprite.currMapPosX);
		c44.move(userSprite.currMapPosX);
		c45.move(userSprite.currMapPosX);
		c46.move(userSprite.currMapPosX);
		c47.move(userSprite.currMapPosX);
		c48.move(userSprite.currMapPosX);
		c49.move(userSprite.currMapPosX);
		c50.move(userSprite.currMapPosX);
		c51.move(userSprite.currMapPosX);
		c52.move(userSprite.currMapPosX);
		c53.move(userSprite.currMapPosX);
		c54.move(userSprite.currMapPosX);
		c55.move(userSprite.currMapPosX);
		c56.move(userSprite.currMapPosX);
		c57.move(userSprite.currMapPosX);
		c58.move(userSprite.currMapPosX);
		c59.move(userSprite.currMapPosX);
		c60.move(userSprite.currMapPosX);
		c61.move(userSprite.currMapPosX);
		c62.move(userSprite.currMapPosX);
		c63.move(userSprite.currMapPosX);
		c64.move(userSprite.currMapPosX);
		c65.move(userSprite.currMapPosX);
		c66.move(userSprite.currMapPosX);
		c67.move(userSprite.currMapPosX);
		c68.move(userSprite.currMapPosX);
		c69.move(userSprite.currMapPosX);
		c70.move(userSprite.currMapPosX);
		c71.move(userSprite.currMapPosX);
		c72.move(userSprite.currMapPosX);
		c73.move(userSprite.currMapPosX);
		c74.move(userSprite.currMapPosX);
		c75.move(userSprite.currMapPosX);
		c76.move(userSprite.currMapPosX);
		c77.move(userSprite.currMapPosX);
		c78.move(userSprite.currMapPosX);
		c79.move(userSprite.currMapPosX);
		c80.move(userSprite.currMapPosX);
		c81.move(userSprite.currMapPosX);
		c82.move(userSprite.currMapPosX);
		c83.move(userSprite.currMapPosX);
		c84.move(userSprite.currMapPosX);
		c85.move(userSprite.currMapPosX);
		c86.move(userSprite.currMapPosX);
		c87.move(userSprite.currMapPosX);
		c88.move(userSprite.currMapPosX);
		c89.move(userSprite.currMapPosX);
		c90.move(userSprite.currMapPosX);
		c91.move(userSprite.currMapPosX);
		c92.move(userSprite.currMapPosX);
		c93.move(userSprite.currMapPosX);
		c94.move(userSprite.currMapPosX);
		c95.move(userSprite.currMapPosX);
		c96.move(userSprite.currMapPosX);
		c97.move(userSprite.currMapPosX);
		c98.move(userSprite.currMapPosX);
		c99.move(userSprite.currMapPosX);
		c100.move(userSprite.currMapPosX);

		// The coins move across the map

		c1.animate();
		c2.animate();
		c3.animate();
		c4.animate();
		c5.animate();
		c6.animate();
		c7.animate();
		c8.animate();
		c9.animate();
		c10.animate();
		c11.animate();
		c12.animate();
		c13.animate();
		c14.animate();
		c15.animate();
		c16.animate();
		c17.animate();
		c18.animate();
		c19.animate();
		c20.animate();
		c21.animate();
		c22.animate();
		c23.animate();
		c24.animate();
		c25.animate();
		c26.animate();
		c27.animate();
		c28.animate();
		c29.animate();
		c30.animate();
		c31.animate();
		c32.animate();
		c33.animate();
		c34.animate();
		c35.animate();
		c36.animate();
		c37.animate();
		c38.animate();
		c39.animate();
		c40.animate();
		c41.animate();
		c42.animate();
		c43.animate();
		c44.animate();
		c45.animate();
		c46.animate();
		c47.animate();
		c48.animate();
		c49.animate();
		c50.animate();
		c51.animate();
		c52.animate();
		c53.animate();
		c54.animate();
		c55.animate();
		c56.animate();
		c57.animate();
		c58.animate();
		c59.animate();
		c60.animate();
		c61.animate();
		c62.animate();
		c63.animate();
		c64.animate();
		c65.animate();
		c66.animate();
		c67.animate();
		c68.animate();
		c69.animate();
		c70.animate();
		c71.animate();
		c72.animate();
		c73.animate();
		c74.animate();
		c75.animate();
		c76.animate();
		c77.animate();
		c78.animate();
		c79.animate();
		c80.animate();
		c81.animate();
		c82.animate();
		c83.animate();
		c84.animate();
		c85.animate();
		c86.animate();
		c87.animate();
		c88.animate();
		c89.animate();
		c90.animate();
		c91.animate();
		c92.animate();
		c93.animate();
		c94.animate();
		c95.animate();
		c96.animate();
		c97.animate();
		c98.animate();
		c99.animate();
		c100.animate();

		// Animates the coins

		e1.move(userSprite.currMapPosX);
		e2.move(userSprite.currMapPosX);
		e3.move(userSprite.currMapPosX);
		e4.move(userSprite.currMapPosX);
		e5.move(userSprite.currMapPosX);
		e6.move(userSprite.currMapPosX);
		e7.move(userSprite.currMapPosX);
		e8.move(userSprite.currMapPosX);
		e9.move(userSprite.currMapPosX);
		e10.move(userSprite.currMapPosX);
		e11.move(userSprite.currMapPosX);
		e12.move(userSprite.currMapPosX);
		e13.move(userSprite.currMapPosX);
		e14.move(userSprite.currMapPosX);
		e15.move(userSprite.currMapPosX);
		e16.move(userSprite.currMapPosX);
		e17.move(userSprite.currMapPosX);
		e18.move(userSprite.currMapPosX);
		e19.move(userSprite.currMapPosX);
		e20.move(userSprite.currMapPosX);
		e21.move(userSprite.currMapPosX);
		e22.move(userSprite.currMapPosX);
		e23.move(userSprite.currMapPosX);
		e24.move(userSprite.currMapPosX);
		e25.move(userSprite.currMapPosX);
		e26.move(userSprite.currMapPosX);
		e27.move(userSprite.currMapPosX);
		e28.move(userSprite.currMapPosX);
		e29.move(userSprite.currMapPosX);
		e30.move(userSprite.currMapPosX);
		e31.move(userSprite.currMapPosX);
		e32.move(userSprite.currMapPosX);
		e33.move(userSprite.currMapPosX);

		// The enemies move across the map

		s1.move(userSprite.currMapPosX);

		if (userSprite.jump == true) // If input for jump is made, the user
										// jumps
			userSprite.jump(); // User jumps
		if (lives > 0)
			repaint(); // Repaints the JPanel
		if (lives == 0) {
			System.exit(0);
		}
	}

	public void paint(Graphics g) {

		super.paint(g); // Instructs the graphic objects
		Graphics2D g2d = (Graphics2D) g; // Enhances the drawings
		g2d.scale(2, 2); // Scales the JPanel

		if (userSprite.dead == true) {
			if (checkedTime == false) {
				t = System.currentTimeMillis();
				checkedTime = true;
				lives--;
				if (lives > 0) {
					Sound.pauseMusic();
					try {
						Sound.playActionMusic("nsmb_death.wav");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (lives == 0) {
					Sound.pauseMusic();
					try {
						Sound.playActionMusic("nsmb_game_over.wav");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if (lives > 0) {
				end = t + 3196;
				g2d.setColor(Color.BLACK);
				g2d.drawRect(0, 0, 10000, 10000);
				g2d.fillRect(0, 0, 10000, 10000);
				Font f = new Font("Verdana", Font.PLAIN, 20);
				Font f2 = new Font("Verdana", Font.BOLD, 16);
				ImageIcon livesIcon = new ImageIcon("resources/mario_lives.png");
				g2d.setColor(Color.red);
				g2d.drawString(
						"Respawning in: "
								+ ((end - System.currentTimeMillis()) / 1000),
						175, 100);
				g2d.setColor(Color.white);
				g2d.setFont(f2);
				g2d.drawImage(livesIcon.getImage(), 175, 110, null);
				g2d.drawString("" + lives, 205, 128);
				g2d.setColor(Color.red);
				g2d.setFont(f);
				g2d.drawString("Map 1", 175, 50);
				if ((end - System.currentTimeMillis()) / 1000 == 0) {
					try {
						Sound.resume();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (lives <= 0) {
				g2d.setColor(Color.BLACK);
				g2d.drawRect(0, 0, 10000, 10000);
				g2d.fillRect(0, 0, 10000, 10000);
				Font f = new Font("Verdana", Font.BOLD, 26);
				g2d.setColor(Color.white);
				g2d.setFont(f);
				g2d.drawString("GAME OVER!", 125, 50);
			}

			if (System.currentTimeMillis() >= end) {
				if (lives > 0) {
					userSprite.reset();
					g2d.clearRect(0, 0, 10000, 10000);
					checkedTime = false;
				}
			}
		} else if (userSprite.dead == false) {
			g2d.drawImage(map1.getImage(), userSprite.currMapPosX, 0, null); // Draws
																				// the
																				// map
			if (userSprite.invincible)
				invinCount++;

			if (invinCount >= 0 && invinCount < 5) {
				g2d.drawImage(userSprite.getImage(), userSprite.getX(),
						userSprite.getY(), null); // Draws the userSprite
													// (Mario)
			}
			if (invinCount >= 5 && invinCount < 10) {
				g2d.drawImage(new ImageIcon("resources/empty.png").getImage(),
						userSprite.getX(), userSprite.getY(), null); // Draws an
																		// invisible
																		// frame
																		// for
																		// Mario
			}
			if (invinCount >= 10 && invinCount < 15) {
				g2d.drawImage(userSprite.getImage(), userSprite.getX(),
						userSprite.getY(), null); // Draws the userSprite
													// (Mario)
			}
			if (invinCount >= 15 && invinCount < 20) {
				g2d.drawImage(new ImageIcon("resources/empty.png").getImage(),
						userSprite.getX(), userSprite.getY(), null); // Draws an
																		// invisible
																		// frame
																		// for
																		// Mario
			}
			if (invinCount >= 20 && invinCount < 25) {
				g2d.drawImage(userSprite.getImage(), userSprite.getX(),
						userSprite.getY(), null); // Draws the userSprite
													// (Mario)
			}
			if (invinCount >= 25 && invinCount < 30) {
				g2d.drawImage(new ImageIcon("resources/empty.png").getImage(),
						userSprite.getX(), userSprite.getY(), null); // Draws an
																		// invisible
																		// frame
																		// for
																		// Mario
			}
			if (invinCount >= 30 && invinCount < 35) {
				g2d.drawImage(userSprite.getImage(), userSprite.getX(),
						userSprite.getY(), null); // Draws the userSprite
													// (Mario)
			}
			if (invinCount >= 35 && invinCount < 40) {
				g2d.drawImage(new ImageIcon("resources/empty.png").getImage(),
						userSprite.getX(), userSprite.getY(), null); // Draws an
																		// invisible
																		// frame
																		// for
																		// Mario
			}
			if (invinCount >= 40 && invinCount < 45) {
				g2d.drawImage(userSprite.getImage(), userSprite.getX(),
						userSprite.getY(), null); // Draws the userSprite
													// (Mario)
			}
			if (invinCount >= 45 && invinCount < 50) {
				g2d.drawImage(new ImageIcon("resources/empty.png").getImage(),
						userSprite.getX(), userSprite.getY(), null); // Draws an
																		// invisible
																		// frame
																		// for
																		// Mario
			}
			if (invinCount >= 50 && invinCount < 55) {
				g2d.drawImage(userSprite.getImage(), userSprite.getX(),
						userSprite.getY(), null); // Draws the userSprite
													// (Mario)
			}
			if (invinCount >= 55 && invinCount < 60) {
				g2d.drawImage(new ImageIcon("resources/empty.png").getImage(),
						userSprite.getX(), userSprite.getY(), null); // Draws an
																		// invisible
																		// frame
																		// for
																		// Mario
			}
			if (invinCount >= 60 && invinCount < 65) {
				g2d.drawImage(userSprite.getImage(), userSprite.getX(),
						userSprite.getY(), null); // Draws the userSprite
													// (Mario)
			}
			if (invinCount >= 65 && invinCount < 70) {
				g2d.drawImage(new ImageIcon("resources/empty.png").getImage(),
						userSprite.getX(), userSprite.getY(), null); // Draws an
																		// invisible
																		// frame
																		// for
																		// Mario
			}
			if (invinCount == 70) {
				userSprite.invincible = false;
				invinCount = 0;
				g2d.drawImage(userSprite.getImage(), userSprite.getX(),
						userSprite.getY(), null); // Draws the userSprite
													// (Mario)
			}

			g2d.drawImage(mb1.getImage(), mb1.getX(), mb1.getY(), null);
			g2d.drawImage(mb2.getImage(), mb2.getX(), mb2.getY(), null);
			g2d.drawImage(mb3.getImage(), mb3.getX(), mb3.getY(), null);
			g2d.drawImage(mb4.getImage(), mb4.getX(), mb4.getY(), null);
			g2d.drawImage(mb5.getImage(), mb5.getX(), mb5.getY(), null);
			g2d.drawImage(mb6.getImage(), mb6.getX(), mb6.getY(), null);
			g2d.drawImage(mb7.getImage(), mb7.getX(), mb7.getY(), null);

			// Draws the MysteryBoxes

			g2d.drawImage(c1.getImage(), c1.getX(), c1.getY(), null);
			g2d.drawImage(c2.getImage(), c2.getX(), c2.getY(), null);
			g2d.drawImage(c3.getImage(), c3.getX(), c3.getY(), null);
			g2d.drawImage(c4.getImage(), c4.getX(), c4.getY(), null);
			g2d.drawImage(c5.getImage(), c5.getX(), c5.getY(), null);
			g2d.drawImage(c6.getImage(), c6.getX(), c6.getY(), null);
			g2d.drawImage(c7.getImage(), c7.getX(), c7.getY(), null);
			g2d.drawImage(c8.getImage(), c8.getX(), c8.getY(), null);
			g2d.drawImage(c9.getImage(), c9.getX(), c9.getY(), null);
			g2d.drawImage(c10.getImage(), c10.getX(), c10.getY(), null);
			g2d.drawImage(c11.getImage(), c11.getX(), c11.getY(), null);
			g2d.drawImage(c12.getImage(), c12.getX(), c12.getY(), null);
			g2d.drawImage(c13.getImage(), c13.getX(), c13.getY(), null);
			g2d.drawImage(c14.getImage(), c14.getX(), c14.getY(), null);
			g2d.drawImage(c15.getImage(), c15.getX(), c15.getY(), null);
			g2d.drawImage(c16.getImage(), c16.getX(), c16.getY(), null);
			g2d.drawImage(c17.getImage(), c17.getX(), c17.getY(), null);
			g2d.drawImage(c18.getImage(), c18.getX(), c18.getY(), null);
			g2d.drawImage(c19.getImage(), c19.getX(), c19.getY(), null);
			g2d.drawImage(c20.getImage(), c20.getX(), c20.getY(), null);
			g2d.drawImage(c21.getImage(), c21.getX(), c21.getY(), null);
			g2d.drawImage(c22.getImage(), c22.getX(), c22.getY(), null);
			g2d.drawImage(c23.getImage(), c23.getX(), c23.getY(), null);
			g2d.drawImage(c24.getImage(), c24.getX(), c24.getY(), null);
			g2d.drawImage(c25.getImage(), c25.getX(), c25.getY(), null);
			g2d.drawImage(c26.getImage(), c26.getX(), c26.getY(), null);
			g2d.drawImage(c27.getImage(), c27.getX(), c27.getY(), null);
			g2d.drawImage(c28.getImage(), c28.getX(), c28.getY(), null);
			g2d.drawImage(c29.getImage(), c29.getX(), c29.getY(), null);
			g2d.drawImage(c30.getImage(), c30.getX(), c30.getY(), null);
			g2d.drawImage(c31.getImage(), c31.getX(), c31.getY(), null);
			g2d.drawImage(c32.getImage(), c32.getX(), c32.getY(), null);
			g2d.drawImage(c33.getImage(), c33.getX(), c33.getY(), null);
			g2d.drawImage(c34.getImage(), c34.getX(), c34.getY(), null);
			g2d.drawImage(c35.getImage(), c35.getX(), c35.getY(), null);
			g2d.drawImage(c36.getImage(), c36.getX(), c36.getY(), null);
			g2d.drawImage(c37.getImage(), c37.getX(), c37.getY(), null);
			g2d.drawImage(c38.getImage(), c38.getX(), c38.getY(), null);
			g2d.drawImage(c39.getImage(), c39.getX(), c39.getY(), null);
			g2d.drawImage(c40.getImage(), c40.getX(), c40.getY(), null);
			g2d.drawImage(c41.getImage(), c41.getX(), c41.getY(), null);
			g2d.drawImage(c42.getImage(), c42.getX(), c42.getY(), null);
			g2d.drawImage(c43.getImage(), c43.getX(), c43.getY(), null);
			g2d.drawImage(c44.getImage(), c44.getX(), c44.getY(), null);
			g2d.drawImage(c45.getImage(), c45.getX(), c45.getY(), null);
			g2d.drawImage(c46.getImage(), c46.getX(), c46.getY(), null);
			g2d.drawImage(c47.getImage(), c47.getX(), c47.getY(), null);
			g2d.drawImage(c48.getImage(), c48.getX(), c48.getY(), null);
			g2d.drawImage(c49.getImage(), c49.getX(), c49.getY(), null);
			g2d.drawImage(c50.getImage(), c50.getX(), c50.getY(), null);
			g2d.drawImage(c51.getImage(), c51.getX(), c51.getY(), null);
			g2d.drawImage(c52.getImage(), c52.getX(), c52.getY(), null);
			g2d.drawImage(c53.getImage(), c53.getX(), c53.getY(), null);
			g2d.drawImage(c54.getImage(), c54.getX(), c54.getY(), null);
			g2d.drawImage(c55.getImage(), c55.getX(), c55.getY(), null);
			g2d.drawImage(c56.getImage(), c56.getX(), c56.getY(), null);
			g2d.drawImage(c57.getImage(), c57.getX(), c57.getY(), null);
			g2d.drawImage(c58.getImage(), c58.getX(), c58.getY(), null);
			g2d.drawImage(c59.getImage(), c59.getX(), c59.getY(), null);
			g2d.drawImage(c60.getImage(), c60.getX(), c60.getY(), null);
			g2d.drawImage(c61.getImage(), c61.getX(), c61.getY(), null);
			g2d.drawImage(c62.getImage(), c62.getX(), c62.getY(), null);
			g2d.drawImage(c63.getImage(), c63.getX(), c63.getY(), null);
			g2d.drawImage(c64.getImage(), c64.getX(), c64.getY(), null);
			g2d.drawImage(c65.getImage(), c65.getX(), c65.getY(), null);
			g2d.drawImage(c66.getImage(), c66.getX(), c66.getY(), null);
			g2d.drawImage(c67.getImage(), c67.getX(), c67.getY(), null);
			g2d.drawImage(c68.getImage(), c68.getX(), c68.getY(), null);
			g2d.drawImage(c69.getImage(), c69.getX(), c69.getY(), null);
			g2d.drawImage(c70.getImage(), c70.getX(), c70.getY(), null);
			g2d.drawImage(c71.getImage(), c71.getX(), c71.getY(), null);
			g2d.drawImage(c72.getImage(), c72.getX(), c72.getY(), null);
			g2d.drawImage(c73.getImage(), c73.getX(), c73.getY(), null);
			g2d.drawImage(c74.getImage(), c74.getX(), c74.getY(), null);
			g2d.drawImage(c75.getImage(), c75.getX(), c75.getY(), null);
			g2d.drawImage(c76.getImage(), c76.getX(), c76.getY(), null);
			g2d.drawImage(c77.getImage(), c77.getX(), c77.getY(), null);
			g2d.drawImage(c78.getImage(), c78.getX(), c78.getY(), null);
			g2d.drawImage(c79.getImage(), c79.getX(), c79.getY(), null);
			g2d.drawImage(c80.getImage(), c80.getX(), c80.getY(), null);
			g2d.drawImage(c81.getImage(), c81.getX(), c81.getY(), null);
			g2d.drawImage(c82.getImage(), c82.getX(), c82.getY(), null);
			g2d.drawImage(c83.getImage(), c83.getX(), c83.getY(), null);
			g2d.drawImage(c84.getImage(), c84.getX(), c84.getY(), null);
			g2d.drawImage(c85.getImage(), c85.getX(), c85.getY(), null);
			g2d.drawImage(c86.getImage(), c86.getX(), c86.getY(), null);
			g2d.drawImage(c87.getImage(), c87.getX(), c87.getY(), null);
			g2d.drawImage(c88.getImage(), c88.getX(), c88.getY(), null);
			g2d.drawImage(c89.getImage(), c89.getX(), c89.getY(), null);
			g2d.drawImage(c90.getImage(), c90.getX(), c90.getY(), null);
			g2d.drawImage(c91.getImage(), c91.getX(), c91.getY(), null);
			g2d.drawImage(c92.getImage(), c92.getX(), c92.getY(), null);
			g2d.drawImage(c93.getImage(), c93.getX(), c93.getY(), null);
			g2d.drawImage(c94.getImage(), c94.getX(), c94.getY(), null);
			g2d.drawImage(c95.getImage(), c95.getX(), c95.getY(), null);
			g2d.drawImage(c96.getImage(), c96.getX(), c96.getY(), null);
			g2d.drawImage(c97.getImage(), c97.getX(), c97.getY(), null);
			g2d.drawImage(c98.getImage(), c98.getX(), c98.getY(), null);
			g2d.drawImage(c99.getImage(), c99.getX(), c99.getY(), null);
			g2d.drawImage(c100.getImage(), c100.getX(), c100.getY(), null);

			// Draws the Coins

			g2d.drawImage(e1.getImage(), e1.getX(), e1.getY(), null);
			g2d.drawImage(e2.getImage(), e2.getX(), e2.getY(), null);
			g2d.drawImage(e3.getImage(), e3.getX(), e3.getY(), null);
			g2d.drawImage(e4.getImage(), e4.getX(), e4.getY(), null);
			g2d.drawImage(e5.getImage(), e5.getX(), e5.getY(), null);
			g2d.drawImage(e6.getImage(), e6.getX(), e6.getY(), null);
			g2d.drawImage(e7.getImage(), e7.getX(), e7.getY(), null);
			g2d.drawImage(e8.getImage(), e8.getX(), e8.getY(), null);
			g2d.drawImage(e9.getImage(), e9.getX(), e9.getY(), null);
			g2d.drawImage(e10.getImage(), e10.getX(), e10.getY(), null);
			g2d.drawImage(e11.getImage(), e11.getX(), e11.getY(), null);
			g2d.drawImage(e12.getImage(), e12.getX(), e12.getY(), null);
			g2d.drawImage(e13.getImage(), e13.getX(), e13.getY(), null);
			g2d.drawImage(e14.getImage(), e14.getX(), e14.getY(), null);
			g2d.drawImage(e15.getImage(), e15.getX(), e15.getY(), null);
			g2d.drawImage(e16.getImage(), e16.getX(), e16.getY(), null);
			g2d.drawImage(e17.getImage(), e17.getX(), e17.getY(), null);
			g2d.drawImage(e18.getImage(), e18.getX(), e18.getY(), null);
			g2d.drawImage(e19.getImage(), e19.getX(), e19.getY(), null);
			g2d.drawImage(e20.getImage(), e20.getX(), e20.getY(), null);
			g2d.drawImage(e21.getImage(), e21.getX(), e21.getY(), null);
			g2d.drawImage(e22.getImage(), e22.getX(), e22.getY(), null);
			g2d.drawImage(e23.getImage(), e23.getX(), e23.getY(), null);
			g2d.drawImage(e24.getImage(), e24.getX(), e24.getY(), null);
			g2d.drawImage(e25.getImage(), e25.getX(), e25.getY(), null);
			g2d.drawImage(e26.getImage(), e26.getX(), e26.getY(), null);
			g2d.drawImage(e27.getImage(), e27.getX(), e27.getY(), null);
			g2d.drawImage(e28.getImage(), e28.getX(), e28.getY(), null);
			g2d.drawImage(e29.getImage(), e29.getX(), e29.getY(), null);
			g2d.drawImage(e30.getImage(), e30.getX(), e30.getY(), null);
			g2d.drawImage(e31.getImage(), e31.getX(), e31.getY(), null);
			g2d.drawImage(e32.getImage(), e32.getX(), e32.getY(), null);
			g2d.drawImage(e33.getImage(), e33.getX(), e33.getY(), null);

			// Draws the Enemies

			g2d.drawImage(s1.getImage(), s1.getX(), s1.getY(), null);

			g2d.drawString("Coins: " + coins, 0, 10); // Shows how
														// many
														// coins
														// Mario has
														// collected
			g2d.drawString("Lives: " + lives, 0, 20); // Shows how
														// many
														// lives
														// Mario has
		}
	}

	private class KeyPasser extends KeyAdapter { // Accepts input from the
													// keyboard

		public void keyPressed(KeyEvent e) {
			userSprite.keyPressed(e); // Accepts input of keys being pressed,
										// and passes it to userSprite
		}

		public void keyReleased(KeyEvent e) {
			userSprite.keyReleased(e); // Accepts input of keys being released,
										// and passes it to userSprite
		}
	}

	public int returnLives() {
		return lives;
	}

	public int returnCoins() {
		return coins;
	}

	public boolean returnBig() {
		return big;
	}

	public void mapPort(int livesInput, int coinsInput, boolean bigInput) {
		// userSprite.mapPort(livesInput,coinsInput,bigInput);
	}

	public void destroy() { // Stops timer within this panel when level is
							// finished, so containing objects do not continue
							// to run when next panel is loaded.
		timer.stop();
	}
}
