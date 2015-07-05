/*
 Map4.Java (for Super Mario: The Zakaryan Strikes Back)
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

//Imports specific packages needed for the code

public class Map4 extends JPanel implements ActionListener { // Extends JPanel and implements ActionListener

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MarioSprite userSprite; // Creates a new MarioSprite called userSprite
	private BigCollision BigCollision;
	private CoinCollision CoinCollision;
	private Collision Collision;
	private EnemyCollision EnemyCollision;
	private MysteryCollision MysteryCollision;
	private ImageIcon map4; // Creates an ImageIcon
	private Timer timer; // Creates a timer
	private ShroomCollision ShroomCollision;
	private ShroomSprite s1;
	private ShroomSprite[] shroomArray = new ShroomSprite[1];
	public static int coins = Map3.coins, lives = Map3.lives;
	public static boolean big = Map3.big;
	
	public Rectangle floorRec1, floorRec2;
	public Rectangle boxRec1, boxRec2;
	public Rectangle brickRec1, brickRec2, brickRec3, brickRec4, brickRec5, brickRec6, brickRec7, brickRec8, brickRec9, brickRec10, brickRec11, brickRec12, brickRec13, brickRec14, brickRec15, brickRec16, brickRec17;
	public Rectangle blockRec1, blockRec2, blockRec3, blockRec4, blockRec5, blockRec6, blockRec7, blockRec8, blockRec9, blockRec10, blockRec11, blockRec12, blockRec13, blockRec14, blockRec15;
	
	// Creates Rectangles that are used for collision purposes
	
	public MysteryBox mb1, mb2;
	public CoinSprite c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50, c51, c52, c53, c54, c55, c56, c57, c58, c59, c60, c61, c62, c63, c64, c65, c66, c67, c68, c69, c70, c71, c72, c73, c74, c75, c76, c77, c78, c79, c80, c81, c82, c83, c84, c85, c86, c87, c88, c89, c90, c91, c92, c93, c94, c95, c96, c97, c98, c99, c100;
	public Enemy e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e32, e33, e34, e35, e36, e37, e38, e39;
	
	// Creates new MysteryBoxes, CoinSprites, and Enemies
	
	public Rectangle[] mapRecArray = new Rectangle[36]; // Creates an array of Rectangles
	public MysteryBox[] mbArray = new MysteryBox[2]; // Creates an array of MysteryBoxes
	public CoinSprite[] coinArray = new CoinSprite[100]; // Creates an array of CoinSprites 
	public Enemy[] enemyArray = new Enemy[39]; // Creates an array of Enemies
	private int mapEnd = -2098; // The end of the map
	private long t, end;
	private MainMenu menu = new MainMenu();
	private boolean checkedTime = false, checkedTime2 = false;
	private int menuOpen = 0;

	public Map4() {

		map4 = new ImageIcon("resources/1-4.png"); // The ImageIcon is set to the picture
		addKeyListener(new KeyPasser()); // Adds a KeyPasser
		setFocusable(true); // Becomes the focus of the keyListener

		floorRec1 = new Rectangle(0, 199, 671, 50);
		floorRec2 = new Rectangle(720, 199, 1777, 50);
		
		// Dictates the size and position of floorRecs
		
		boxRec1 = new Rectangle(160, 151, 16, 16);
		boxRec2 = new Rectangle(176, 151, 16, 16);
		
		// Dictates the size and position of boxRecs
		
		brickRec1 = new Rectangle(64, 167, 16, 32);
		brickRec2 = new Rectangle(224, 167, 16, 32);
		brickRec3 = new Rectangle(480, 71, 16, 32);
		brickRec4 = new Rectangle(480, 151, 32, 15);
		brickRec5 = new Rectangle(480, 183, 16, 16);
		brickRec6 = new Rectangle(512, 167, 96, 15);
		brickRec7 = new Rectangle(992, 167, 192, 32);
		brickRec8 = new Rectangle(1056, 135, 128, 32);
		brickRec9 = new Rectangle(1200, 103, 192, 96);
		brickRec10 = new Rectangle(1312, 72, 16, 32);
		brickRec11 = new Rectangle(1392, 151, 48, 48);
		brickRec12 = new Rectangle(1408, 119, 32, 32);
		brickRec13 = new Rectangle(1440, 119, 48, 15);
		brickRec14 = new Rectangle(1457, 151, 48, 48);
		brickRec15 = new Rectangle(1504, 103, 48, 96);
		brickRec16 = new Rectangle(1552, 135, 96, 64);
		brickRec17 = new Rectangle(1648, 167, 96, 32);
		
		// Dictates the size and position of brickRecs
		
		blockRec1 = new Rectangle(272, 151, 96, 0);
		blockRec2 = new Rectangle(320, 103, 96, 0);
		blockRec3 = new Rectangle(288, 71, 63, 0);
		blockRec4 = new Rectangle(272, 39, 63, 0);
		blockRec5 = new Rectangle(736, 167, 63, 0);
		blockRec6 = new Rectangle(799, 167, 63, 0);
		blockRec7 = new Rectangle(799, 135, 63, 0);
		blockRec8 = new Rectangle(832, 103, 63, 0);
		blockRec9 = new Rectangle(862, 135, 130, 0);
		blockRec10 = new Rectangle(896, 87, 96, 0);
		blockRec11 = new Rectangle(896, 55, 63, 0);
		blockRec12 = new Rectangle(992, 103, 63, 0);
		blockRec13 = new Rectangle(992, 71, 63, 0);
		blockRec14 = new Rectangle(1200, 71, 63, 0);
		blockRec15 = new Rectangle(1328, 71, 63, 0);
		
		// Dictates the size and position of blockRecs
		
		mb1 = new MysteryBox(160, 151);
		mb2 = new MysteryBox(176, 151);
		
		// Dictates the position of mystery boxes
		
		c1 = new CoinSprite(275, 129);
		c2 = new CoinSprite(290, 129);
		c3 = new CoinSprite(305, 129);
		c4 = new CoinSprite(320, 129);
		c5 = new CoinSprite(335, 129);
		c6 = new CoinSprite(350, 129);
		c7 = new CoinSprite(325, 82);
		c8 = new CoinSprite(340, 82);
		c9 = new CoinSprite(355, 82);
		c10 = new CoinSprite(370, 82);
		c11 = new CoinSprite(385, 82);
		c12 = new CoinSprite(400, 82);
		c13 = new CoinSprite(2000, 163);
		c14 = new CoinSprite(2000, 148);
		c15 = new CoinSprite(2000, 133);
		c16 = new CoinSprite(2000, 118);
		c17 = new CoinSprite(275, 18);
		c18 = new CoinSprite(290, 18);
		c19 = new CoinSprite(305, 18);
		c20 = new CoinSprite(320, 18);
		c21 = new CoinSprite(512, 146);
		c22 = new CoinSprite(527, 146);
		c23 = new CoinSprite(542, 146);
		c24 = new CoinSprite(557, 146);
		c25 = new CoinSprite(572, 146);
		c26 = new CoinSprite(587, 146);
		c27 = new CoinSprite(1060, 114);
		c28 = new CoinSprite(1075, 114);
		c29 = new CoinSprite(1090, 114);
		c30 = new CoinSprite(1105, 114);
		c31 = new CoinSprite(1120, 114);
		c32 = new CoinSprite(1135, 114);
		c33 = new CoinSprite(1150, 114);
		c34 = new CoinSprite(1165, 114);
		c35 = new CoinSprite(1955, 118);
		c36 = new CoinSprite(1955, 133);
		c37 = new CoinSprite(1955, 148);
		c38 = new CoinSprite(1955, 163);
		c39 = new CoinSprite(1955, 178);
		c40 = new CoinSprite(1970, 178);
		c41 = new CoinSprite(1985, 178);
		c42 = new CoinSprite(2000, 178);
		c43 = new CoinSprite(1060, 84);
		c44 = new CoinSprite(1075, 84);
		c45 = new CoinSprite(1090, 84);
		c46 = new CoinSprite(1105, 84);
		c47 = new CoinSprite(1120, 84);
		c48 = new CoinSprite(1135, 84);
		c49 = new CoinSprite(1150, 84);
		c50 = new CoinSprite(1165, 84);
		c51 = new CoinSprite(1185, 133);
		c52 = new CoinSprite(1185, 148);
		c53 = new CoinSprite(1185, 163);
		c54 = new CoinSprite(1185, 178);
		c55 = new CoinSprite(1440, 178);
		c56 = new CoinSprite(1440, 163);
		c57 = new CoinSprite(1440, 148);
		c58 = new CoinSprite(1440, 133);
		c59 = new CoinSprite(1455, 133);
		c60 = new CoinSprite(1470, 133);
		c61 = new CoinSprite(1485, 133);
		c62 = new CoinSprite(1550, 114);
		c63 = new CoinSprite(1565, 114);
		c64 = new CoinSprite(1580, 114);
		c65 = new CoinSprite(1595, 114);
		c66 = new CoinSprite(1610, 114);
		c67 = new CoinSprite(1550, 99);
		c68 = new CoinSprite(1565, 99);
		c69 = new CoinSprite(1580, 99);
		c70 = new CoinSprite(1595, 99);
		c71 = new CoinSprite(1610, 99);
		c72 = new CoinSprite(1550, 84);
		c73 = new CoinSprite(1565, 84);
		c74 = new CoinSprite(1580, 84);
		c75 = new CoinSprite(1595, 84);
		c76 = new CoinSprite(1610, 84);
		c77 = new CoinSprite(1625, 114);
		c78 = new CoinSprite(1625, 99);
		c79 = new CoinSprite(1625, 84);
		c80 = new CoinSprite(1860, 178);
		c81 = new CoinSprite(1860, 163);
		c82 = new CoinSprite(1860, 148);
		c83 = new CoinSprite(1860, 133);
		c84 = new CoinSprite(1860, 118);
		c85 = new CoinSprite(1930, 118);
		c86 = new CoinSprite(1915, 118);
		c87 = new CoinSprite(1900, 118);
		c88 = new CoinSprite(1885, 118);
		c89 = new CoinSprite(1885, 133);
		c90 = new CoinSprite(1885, 148);
		c91 = new CoinSprite(1900, 148);
		c92 = new CoinSprite(1915, 148);
		c93 = new CoinSprite(1930, 148);
		c94 = new CoinSprite(1930, 163);
		c95 = new CoinSprite(1930, 178);
		c96 = new CoinSprite(1915, 178);
		c97 = new CoinSprite(1900, 178);
		c98 = new CoinSprite(1885, 178);
		c99 = new CoinSprite(1185, 118);
		c100 = new CoinSprite(1185, 133);
		
		// Dictates the position of coins
		
		e1 = new Enemy(140, 180, 183);
		e2 = new Enemy(160, 210, 183);
		e3 = new Enemy(250, 300, 183);
		e4 = new Enemy(340, 360, 183);
		e5 = new Enemy(410, 464, 183);
		e6 = new Enemy(280, 345, 135);
		e7 = new Enemy(345, 384, 87);
		e8 = new Enemy(290, 330, 55);
		e9 = new Enemy(275, 315, 23);
		e10 = new Enemy(480, 500, 135);
		e11 = new Enemy(535, 590, 151);
		e12 = new Enemy(513, 611, 183);
		e13 = new Enemy(730, 760, 183);
		e14 = new Enemy(750, 780, 183);
		e15 = new Enemy(770, 800, 183);
		e16 = new Enemy(790, 820, 183);
		e17 = new Enemy(810, 840, 183);
		e18 = new Enemy(830, 860, 183);
		e19 = new Enemy(850, 880, 183);
		e20 = new Enemy(870, 900, 183);
		e21 = new Enemy(890, 920, 183);
		e22 = new Enemy(910, 940, 183);
		e23 = new Enemy(930, 960, 183);
		e24 = new Enemy(745, 820, 151);
		e25 = new Enemy(835, 900, 119);
		e26 = new Enemy(912, 970, 71);
		e27 = new Enemy(1060, 1115, 119);
		e28 = new Enemy(1080, 1150, 119);
		e29 = new Enemy(1270, 1295, 87);
		e30 = new Enemy(1318, 1360, 55);
		e31 = new Enemy(1423, 1472, 103);
		e32 = new Enemy(1458, 1493, 135);
		e33 = new Enemy(1654, 1724, 151);
		e34 = new Enemy(1752, 1900, 183);
		e35 = new Enemy(1800, 1850, 183);
		e36 = new Enemy(1775, 1925, 183);
		e37 = new Enemy(1825, 2046, 183);
		e38 = new Enemy(1900, 1950, 183);
		e39 = new Enemy(2000, 2030, 183);
		
		// Dictates the position of enemies
		
		s1 = new ShroomSprite (mb1.getX(), -10000000);
		
		mapRecArray[0] = floorRec1;
		mapRecArray[1] = floorRec2;
		
		// Sets the floorRecs to the array of Rectangles

		mapRecArray[2] = boxRec1;
		mapRecArray[3] = boxRec2;
		
		mapRecArray[4] = brickRec1;
		mapRecArray[5] = brickRec2;
		mapRecArray[6] = brickRec3;
		mapRecArray[7] = brickRec4;
		mapRecArray[8] = brickRec5;
		mapRecArray[9] = brickRec6;
		mapRecArray[10] = brickRec7;
		mapRecArray[11] = brickRec8;
		mapRecArray[12] = brickRec9;
		mapRecArray[13] = brickRec10;
		mapRecArray[14] = brickRec11;
		mapRecArray[15] = brickRec12;
		mapRecArray[16] = brickRec13;
		mapRecArray[17] = brickRec14;
		mapRecArray[18] = brickRec15;
		mapRecArray[19] = brickRec16;
		mapRecArray[20] = brickRec17;
		
		// Sets the brickRecs to the array of Rectangles
		
		mapRecArray[21] = blockRec1;
		mapRecArray[22] = blockRec2;
		mapRecArray[23] = blockRec3;
		mapRecArray[24] = blockRec4;
		mapRecArray[25] = blockRec5;
		mapRecArray[26] = blockRec6;
		mapRecArray[27] = blockRec7;
		mapRecArray[28] = blockRec8;
		mapRecArray[29] = blockRec9;
		mapRecArray[30] = blockRec10;
		mapRecArray[31] = blockRec11;
		mapRecArray[32] = blockRec12;
		mapRecArray[33] = blockRec13;
		mapRecArray[34] = blockRec14;
		mapRecArray[35] = blockRec15;
		
		// Sets the blockRecs to the array of Rectangles
		
		mbArray[0] = mb1;
		mbArray[1] = mb2;
		
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
		enemyArray[33] = e34;
		enemyArray[34] = e35;
		enemyArray[35] = e36;
		enemyArray[36] = e37;
		enemyArray[37] = e38;
		enemyArray[38] = e39;
		
		// Sets the enemies to the array of Enemies
		
		shroomArray[0] = s1;
		
		BigCollision = new BigCollision(mapRecArray);
		CoinCollision = new CoinCollision(coinArray);
		Collision = new Collision(mapRecArray);
		EnemyCollision = new EnemyCollision(enemyArray);
		ShroomCollision = new ShroomCollision(shroomArray);
		MysteryCollision = new MysteryCollision(mbArray,shroomArray);
		userSprite = new MarioSprite(mapEnd, mapRecArray, coinArray, mbArray, enemyArray,shroomArray, BigCollision, CoinCollision, Collision, EnemyCollision, MysteryCollision, ShroomCollision); // Creates a new MarioSprite
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

		floorRec1.setBounds(0 + userSprite.currMapPosX, (int)floorRec1.getY(), (int)floorRec1.getWidth(), (int)floorRec1.getHeight());
		floorRec2.setBounds(720 + userSprite.currMapPosX, (int)floorRec2.getY(), (int)floorRec2.getWidth(), (int)floorRec2.getHeight());
		
		// Sets the bounds of floorRecs
		
		boxRec1.setBounds(160 + userSprite.currMapPosX, (int)boxRec1.getY(), (int)boxRec1.getWidth(), (int)boxRec1.getHeight());
		boxRec2.setBounds(176 + userSprite.currMapPosX, (int)boxRec2.getY(), (int)boxRec2.getWidth(), (int)boxRec2.getHeight());
		
		// Sets the bounds of boxRecs
		
		brickRec1.setBounds(64 + userSprite.currMapPosX, (int)brickRec1.getY(), (int)brickRec1.getWidth(), (int)brickRec1.getHeight());
		brickRec2.setBounds(224 + userSprite.currMapPosX, (int)brickRec2.getY(), (int)brickRec2.getWidth(), (int)brickRec2.getHeight());
		brickRec3.setBounds(480 + userSprite.currMapPosX, (int)brickRec3.getY(), (int)brickRec3.getWidth(), (int)brickRec3.getHeight());
		brickRec4.setBounds(480 + userSprite.currMapPosX, (int)brickRec4.getY(), (int)brickRec4.getWidth(), (int)brickRec4.getHeight());
		brickRec5.setBounds(480 + userSprite.currMapPosX, (int)brickRec5.getY(), (int)brickRec5.getWidth(), (int)brickRec5.getHeight());
		brickRec6.setBounds(512 + userSprite.currMapPosX, (int)brickRec6.getY(), (int)brickRec6.getWidth(), (int)brickRec6.getHeight());
		brickRec7.setBounds(992 + userSprite.currMapPosX, (int)brickRec7.getY(), (int)brickRec7.getWidth(), (int)brickRec7.getHeight());
		brickRec8.setBounds(1056 + userSprite.currMapPosX, (int)brickRec8.getY(), (int)brickRec8.getWidth(), (int)brickRec8.getHeight());
		brickRec9.setBounds(1200 + userSprite.currMapPosX, (int)brickRec9.getY(), (int)brickRec9.getWidth(), (int)brickRec9.getHeight());
		brickRec10.setBounds(1312 + userSprite.currMapPosX, (int)brickRec10.getY(), (int)brickRec10.getWidth(), (int)brickRec10.getHeight());
		brickRec11.setBounds(1392 + userSprite.currMapPosX, (int)brickRec11.getY(), (int)brickRec11.getWidth(), (int)brickRec11.getHeight());
		brickRec12.setBounds(1408 + userSprite.currMapPosX, (int)brickRec12.getY(), (int)brickRec12.getWidth(), (int)brickRec12.getHeight());
		brickRec13.setBounds(1440 + userSprite.currMapPosX, (int)brickRec13.getY(), (int)brickRec13.getWidth(), (int)brickRec13.getHeight());
		brickRec14.setBounds(1457 + userSprite.currMapPosX, (int)brickRec14.getY(), (int)brickRec14.getWidth(), (int)brickRec14.getHeight());
		brickRec15.setBounds(1504 + userSprite.currMapPosX, (int)brickRec15.getY(), (int)brickRec15.getWidth(), (int)brickRec15.getHeight());
		brickRec16.setBounds(1552 + userSprite.currMapPosX, (int)brickRec16.getY(), (int)brickRec16.getWidth(), (int)brickRec16.getHeight());
		brickRec17.setBounds(1648 + userSprite.currMapPosX, (int)brickRec17.getY(), (int)brickRec17.getWidth(), (int)brickRec17.getHeight());
		
		// Sets the bounds of brickRecs
		
		blockRec1.setBounds(272 + userSprite.currMapPosX, (int)blockRec1.getY(), (int)blockRec1.getWidth(), (int)blockRec1.getHeight());
		blockRec2.setBounds(320 + userSprite.currMapPosX, (int)blockRec2.getY(), (int)blockRec2.getWidth(), (int)blockRec2.getHeight());
		blockRec3.setBounds(288 + userSprite.currMapPosX, (int)blockRec3.getY(), (int)blockRec3.getWidth(), (int)blockRec3.getHeight());
		blockRec4.setBounds(272 + userSprite.currMapPosX, (int)blockRec4.getY(), (int)blockRec4.getWidth(), (int)blockRec4.getHeight());
		blockRec5.setBounds(736 + userSprite.currMapPosX, (int)blockRec5.getY(), (int)blockRec5.getWidth(), (int)blockRec5.getHeight());
		blockRec6.setBounds(799 + userSprite.currMapPosX, (int)blockRec6.getY(), (int)blockRec6.getWidth(), (int)blockRec6.getHeight());
		blockRec7.setBounds(799 + userSprite.currMapPosX, (int)blockRec7.getY(), (int)blockRec7.getWidth(), (int)blockRec7.getHeight());
		blockRec8.setBounds(832 + userSprite.currMapPosX, (int)blockRec8.getY(), (int)blockRec8.getWidth(), (int)blockRec8.getHeight());
		blockRec9.setBounds(862 + userSprite.currMapPosX, (int)blockRec9.getY(), (int)blockRec9.getWidth(), (int)blockRec9.getHeight());
		blockRec10.setBounds(896 + userSprite.currMapPosX, (int)blockRec10.getY(), (int)blockRec10.getWidth(), (int)blockRec10.getHeight());
		blockRec11.setBounds(896 + userSprite.currMapPosX, (int)blockRec11.getY(), (int)blockRec11.getWidth(), (int)blockRec11.getHeight());
		blockRec12.setBounds(992 + userSprite.currMapPosX, (int)blockRec12.getY(), (int)blockRec12.getWidth(), (int)blockRec12.getHeight());
		blockRec13.setBounds(992 + userSprite.currMapPosX, (int)blockRec13.getY(), (int)blockRec13.getWidth(), (int)blockRec13.getHeight());
		blockRec14.setBounds(1200 + userSprite.currMapPosX, (int)blockRec14.getY(), (int)blockRec14.getWidth(), (int)blockRec14.getHeight());
		blockRec15.setBounds(1328 + userSprite.currMapPosX, (int)blockRec15.getY(), (int)blockRec15.getWidth(), (int)blockRec15.getHeight());
		
		// Sets the bounds of blockRecs
		
		mb1.move(userSprite.currMapPosX);
		mb2.move(userSprite.currMapPosX);
		
		// The mystery boxes move across the map
		
		mb1.animate();
		mb2.animate();
		
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
		e34.move(userSprite.currMapPosX);
		e35.move(userSprite.currMapPosX);
		e36.move(userSprite.currMapPosX);
		e37.move(userSprite.currMapPosX);
		e38.move(userSprite.currMapPosX);
		e39.move(userSprite.currMapPosX);
		
		// The enemies move across the map
		
		s1.move(userSprite.currMapPosX);
		
		if (userSprite.jump == true) // If input for jump is made, the user jumps
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
				g2d.drawString("Respawning in: " + ((end - System.currentTimeMillis()) / 1000), 175, 100);
				g2d.setColor(Color.white);
				g2d.setFont(f2);
				g2d.drawImage(livesIcon.getImage(), 175, 110, null);
				g2d.drawString("" + lives, 205, 128);
				g2d.setColor(Color.red);
				g2d.setFont(f);
				g2d.drawString("Map 4", 175, 50);
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
				Font f = new Font("Verdana", Font.BOLD, 20);
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
		g2d.drawImage(map4.getImage(), userSprite.currMapPosX, 0, null); // Draws the map
		g2d.drawImage(userSprite.getImage(), userSprite.getX(), userSprite.getY(), null); // Draws the userSprite (Mario)
		
		g2d.drawImage(mb1.getImage(), mb1.getX(), mb1.getY(), null);
		g2d.drawImage(mb2.getImage(), mb2.getX(), mb2.getY(), null);
		
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
		g2d.drawImage(e34.getImage(), e34.getX(), e34.getY(), null);
		g2d.drawImage(e35.getImage(), e35.getX(), e35.getY(), null);
		g2d.drawImage(e36.getImage(), e36.getX(), e36.getY(), null);
		g2d.drawImage(e37.getImage(), e37.getX(), e37.getY(), null);
		g2d.drawImage(e38.getImage(), e38.getX(), e38.getY(), null);
		g2d.drawImage(e39.getImage(), e39.getX(), e39.getY(), null);
		
		// Draws the Enemies
		
		g2d.drawImage(s1.getImage(), s1.getX(), s1.getY(), null);
		
		g2d.drawString("Coins: " + coins, 0, 10); // Shows how many coins Mario has collected
		g2d.drawString("Lives: " + lives, 0, 20); // Shows how many lives Mario has
	}
	}

	private class KeyPasser extends KeyAdapter { // Accepts input from the keyboard
		
		public void keyPressed(KeyEvent e) {
			userSprite.keyPressed(e); // Accepts input of keys being pressed, and passes it to userSprite
		}

		public void keyReleased(KeyEvent e) {
			userSprite.keyReleased(e); // Accepts input of keys being released, and passes it to userSprite
		}
	}

	
	public int returnLives(){
		return lives;
	}
	
	public int returnCoins(){
		return coins;
	}

	public boolean returnBig(){
		return big;
	}
	
	public void mapPort(int livesInput, int coinsInput, boolean bigInput){
		userSprite.mapPort(livesInput + 1,coinsInput,bigInput);
	}

	public void destroy() { // Stops timer within this panel when level is
		// finished, so containing objects do not continue
		// to run when next panel is loaded.
		timer.stop();
	}
}