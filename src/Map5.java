/*
 Map5.Java (for Super Mario: The Zakaryan Strikes Back)
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

public class Map5 extends JPanel implements ActionListener { // Extends JPanel
																// and
																// implements
																// ActionListener

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MarioSprite userSprite; // Creates a new MarioSprite called
									// userSprite
	private BigCollision BigCollision;
	private CoinCollision CoinCollision;
	private Collision Collision;
	private EnemyCollision EnemyCollision;
	private MysteryCollision MysteryCollision;
	private ImageIcon map5; // Creates an ImageIcon
	private Timer timer; // Creates a timer
	private ShroomCollision ShroomCollision;
	private ShroomSprite s1;
	private ShroomSprite[] shroomArray = new ShroomSprite[1];
	public static int coins = Map4.coins, lives = Map4.lives;
	public static boolean big = Map4.big;

	public Rectangle floorRec1, floorRec2, floorRec3;
	public Rectangle boxRec1, boxRec2, boxRec3, boxRec4, boxRec5, boxRec6,
			boxRec7, boxRec8, boxRec9;
	public Rectangle pipeRec1, pipeRec2, pipeRec3, pipeRec4, pipeRec5,
			pipeRec6, pipeRec7, pipeRec8, pipeRec9, pipeRec10, pipeRec11,
			pipeRec12, pipeRec13, pipeRec14, pipeRec15, pipeRec16, pipeRec17,
			pipeRec18, pipeRec19, pipeRec20, pipeRec21, pipeRec22;
	public Rectangle brickRec1, brickRec2, brickRec3, brickRec4, brickRec5,
			brickRec6, brickRec7, brickRec8, brickRec9, brickRec10, brickRec11;
	public Rectangle blockRec1, blockRec2, blockRec3, blockRec4;

	// Creates Rectangles that are used for collision purposes

	public MysteryBox mb1, mb2, mb3, mb4, mb5, mb6, mb7, mb8, mb9;
	public CoinSprite c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13,
			c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26,
			c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37, c38, c39,
			c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50, c51, c52,
			c53, c54, c55, c56, c57, c58, c59, c60, c61, c62, c63, c64, c65,
			c66, c67, c68, c69, c70, c71, c72, c73, c74, c75, c76, c77, c78,
			c79, c80, c81, c82, c83, c84, c85, c86, c87, c88, c89, c90, c91,
			c92, c93, c94, c95, c96, c97, c98, c99, c100;
	public Enemy e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14,
			e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27,
			e28, e29, e30, e31, e32, e33, e34, e35, e36, e37, e38, e39, e40,
			e41, e42, e43;

	// Creates new MysteryBoxes, CoinSprites, and Enemies

	public Rectangle[] mapRecArray = new Rectangle[49]; // Creates an array of
														// Rectangles
	public MysteryBox[] mbArray = new MysteryBox[9]; // Creates an array of
														// MysteryBoxes
	public CoinSprite[] coinArray = new CoinSprite[100]; // Creates an array of
															// CoinSprites
	public Enemy[] enemyArray = new Enemy[43]; // Creates an array of Enemies
	private int mapEnd = -2929; // The end of the map
	private long t, end;
	private MainMenu menu = new MainMenu();
	private boolean checkedTime = false, checkedTime2 = false;
	private int menuOpen = 0;

	public Map5() {

		map5 = new ImageIcon("resources/1-5.png"); // The ImageIcon is set to
													// the picture
		addKeyListener(new KeyPasser()); // Adds a KeyPasser
		setFocusable(true); // Becomes the focus of the keyListener

		floorRec1 = new Rectangle(0, 199, 640, 50);
		floorRec2 = new Rectangle(804, 199, 1453, 50);
		floorRec3 = new Rectangle(2338, 199, 1000, 50);

		// Dictates the size and position of floorRecs

		boxRec1 = new Rectangle(864, 71, 16, 16);
		boxRec2 = new Rectangle(880, 71, 16, 16);
		boxRec3 = new Rectangle(896, 71, 16, 16);
		boxRec4 = new Rectangle(2752, 151, 16, 16);
		boxRec5 = new Rectangle(2768, 151, 16, 16);
		boxRec6 = new Rectangle(2832, 151, 16, 16);
		boxRec7 = new Rectangle(2848, 151, 16, 16);
		boxRec8 = new Rectangle(2816, 87, 16, 16);
		boxRec9 = new Rectangle(2784, 87, 16, 16);

		// Dictates the size and position of boxRecs

		pipeRec1 = new Rectangle(273, 167, 30, 32);
		pipeRec2 = new Rectangle(337, 103, 62, 32);
		pipeRec3 = new Rectangle(481, 119, 30, 80);
		pipeRec4 = new Rectangle(609, 151, 30, 50);
		pipeRec5 = new Rectangle(657, 0, 30, 70);
		pipeRec6 = new Rectangle(753, 0, 30, 70);
		pipeRec7 = new Rectangle(705, 167, 30, 50);
		pipeRec8 = new Rectangle(801, 151, 30, 50);
		pipeRec9 = new Rectangle(961, 87, 30, 120);
		pipeRec10 = new Rectangle(1106, 167, 30, 32);
		pipeRec11 = new Rectangle(1137, 135, 30, 64);
		pipeRec12 = new Rectangle(1168, 103, 31, 96);
		pipeRec13 = new Rectangle(1409, 0, 30, 134);
		pipeRec14 = new Rectangle(1489, 135, 30, 65);
		pipeRec15 = new Rectangle(1666, 167, 62, 32);
		pipeRec16 = new Rectangle(1729, 151, 30, 50);
		pipeRec17 = new Rectangle(1920, 0, 31, 70);
		pipeRec18 = new Rectangle(1920, 151, 31, 50);
		pipeRec19 = new Rectangle(2225, 135, 30, 65);
		pipeRec20 = new Rectangle(2337, 151, 30, 50);
		pipeRec21 = new Rectangle(2433, 167, 30, 32);
		pipeRec22 = new Rectangle(2609, 119, 30, 80);

		// Dictates the size and position of pipeRecs

		brickRec1 = new Rectangle(320, 135, 96, 16);
		brickRec2 = new Rectangle(439, 135, 16, 16);
		brickRec3 = new Rectangle(816, 71, 32, 16);
		brickRec4 = new Rectangle(992, 103, 16, 16);
		brickRec5 = new Rectangle(992, 151, 64, 16);
		brickRec6 = new Rectangle(1200, 119, 112, 16);
		brickRec7 = new Rectangle(1632, 151, 32, 16);
		brickRec8 = new Rectangle(2752, 87, 32, 16);
		brickRec9 = new Rectangle(2800, 87, 16, 16);
		brickRec10 = new Rectangle(2832, 87, 32, 16);
		brickRec11 = new Rectangle(2784, 151, 48, 16);

		// Dictates the size and position of brickRecs

		blockRec1 = new Rectangle(849, 119, 78, 1);
		blockRec2 = new Rectangle(897, 151, 47, 1);
		blockRec3 = new Rectangle(1346, 167, 125, 1);
		blockRec4 = new Rectangle(2465, 167, 125, 1);

		// Dictates the size and position of blockRecs

		mb1 = new MysteryBox(864, 71);
		mb2 = new MysteryBox(880, 71);
		mb3 = new MysteryBox(896, 71);
		mb4 = new MysteryBox(2752, 151);
		mb5 = new MysteryBox(2768, 151);
		mb6 = new MysteryBox(2832, 151);
		mb7 = new MysteryBox(2848, 151);
		mb8 = new MysteryBox(2816, 87);
		mb9 = new MysteryBox(2784, 87);

		// Dictates the position of mystery boxes

		c1 = new CoinSprite(517, 178);
		c2 = new CoinSprite(532, 178);
		c3 = new CoinSprite(547, 178);
		c4 = new CoinSprite(562, 178);
		c5 = new CoinSprite(577, 178);
		c6 = new CoinSprite(592, 178);
		c7 = new CoinSprite(517, 163);
		c8 = new CoinSprite(532, 163);
		c9 = new CoinSprite(547, 163);
		c10 = new CoinSprite(562, 163);
		c11 = new CoinSprite(577, 163);
		c12 = new CoinSprite(592, 163);
		c13 = new CoinSprite(517, 148);
		c14 = new CoinSprite(532, 148);
		c15 = new CoinSprite(547, 148);
		c16 = new CoinSprite(562, 148);
		c17 = new CoinSprite(577, 148);
		c18 = new CoinSprite(592, 148);
		c19 = new CoinSprite(517, 133);
		c20 = new CoinSprite(532, 133);
		c21 = new CoinSprite(547, 133);
		c22 = new CoinSprite(562, 133);
		c23 = new CoinSprite(577, 133);
		c24 = new CoinSprite(592, 133);
		c25 = new CoinSprite(840, 178);
		c26 = new CoinSprite(855, 178);
		c27 = new CoinSprite(870, 178);
		c28 = new CoinSprite(885, 178);
		c29 = new CoinSprite(900, 178);
		c30 = new CoinSprite(915, 178);
		c31 = new CoinSprite(930, 178);
		c32 = new CoinSprite(840, 163);
		c33 = new CoinSprite(855, 163);
		c34 = new CoinSprite(870, 163);
		c35 = new CoinSprite(885, 163);
		c36 = new CoinSprite(900, 163);
		c37 = new CoinSprite(915, 163);
		c38 = new CoinSprite(930, 163);
		c39 = new CoinSprite(1000, 178);
		c40 = new CoinSprite(1015, 178);
		c41 = new CoinSprite(1030, 178);
		c42 = new CoinSprite(1045, 178);
		c43 = new CoinSprite(1060, 178);
		c44 = new CoinSprite(1075, 178);
		c45 = new CoinSprite(1200, 160);
		c46 = new CoinSprite(1215, 160);
		c47 = new CoinSprite(1230, 160);
		c48 = new CoinSprite(1245, 160);
		c49 = new CoinSprite(1260, 160);
		c50 = new CoinSprite(1275, 160);
		c51 = new CoinSprite(1290, 160);
		c52 = new CoinSprite(1305, 160);
		c53 = new CoinSprite(1545, 178);
		c54 = new CoinSprite(1560, 178);
		c55 = new CoinSprite(1575, 178);
		c56 = new CoinSprite(1590, 178);
		c57 = new CoinSprite(1785, 178);
		c58 = new CoinSprite(1800, 178);
		c59 = new CoinSprite(1815, 178);
		c60 = new CoinSprite(1830, 178);
		c61 = new CoinSprite(1845, 178);
		c62 = new CoinSprite(1860, 178);
		c63 = new CoinSprite(1875, 178);
		c64 = new CoinSprite(1785, 163);
		c65 = new CoinSprite(1800, 163);
		c66 = new CoinSprite(1815, 163);
		c67 = new CoinSprite(1830, 163);
		c68 = new CoinSprite(1845, 163);
		c69 = new CoinSprite(1860, 163);
		c70 = new CoinSprite(1875, 163);
		c71 = new CoinSprite(2000, 178);
		c72 = new CoinSprite(2015, 178);
		c73 = new CoinSprite(2030, 178);
		c74 = new CoinSprite(2045, 178);
		c75 = new CoinSprite(2060, 178);
		c76 = new CoinSprite(2075, 178);
		c77 = new CoinSprite(2090, 178);
		c78 = new CoinSprite(2105, 178);
		c79 = new CoinSprite(2120, 178);
		c80 = new CoinSprite(2135, 178);
		c81 = new CoinSprite(2000, 163);
		c82 = new CoinSprite(2015, 163);
		c83 = new CoinSprite(2030, 163);
		c84 = new CoinSprite(2045, 163);
		c85 = new CoinSprite(2060, 163);
		c86 = new CoinSprite(2075, 163);
		c87 = new CoinSprite(2090, 163);
		c88 = new CoinSprite(2105, 163);
		c89 = new CoinSprite(2120, 163);
		c90 = new CoinSprite(2135, 163);
		c91 = new CoinSprite(2000, 148);
		c92 = new CoinSprite(2015, 148);
		c93 = new CoinSprite(2030, 148);
		c94 = new CoinSprite(2045, 148);
		c95 = new CoinSprite(2060, 148);
		c96 = new CoinSprite(2075, 148);
		c97 = new CoinSprite(2090, 148);
		c98 = new CoinSprite(2105, 148);
		c99 = new CoinSprite(2120, 148);
		c100 = new CoinSprite(2135, 148);

		// Dictates the position of coins

		e1 = new Enemy(180, 254, 183);
		e2 = new Enemy(210, 240, 183);
		e3 = new Enemy(275, 290, 151);
		e4 = new Enemy(345, 385, 87);
		e5 = new Enemy(325, 400, 183);
		e6 = new Enemy(375, 425, 183);
		e7 = new Enemy(410, 464, 183);
		e8 = new Enemy(480999, 4959999, 103); // moved out of playable area to make game easier
		e9 = new Enemy(530, 576, 183);
		e10 = new Enemy(550, 576, 183);
		e11 = new Enemy(611999, 6259999, 135); // moved out of playable area to make game easier
		e12 = new Enemy(709999, 7239999, 151); // moved out of playable area to make game easier
		e13 = new Enemy(800999, 8209999, 135); // moved out of playable area to make game easier
		e14 = new Enemy(898, 926, 135);
		e15 = new Enemy(870, 910, 103);
		e16 = new Enemy(850, 880, 183);
		e17 = new Enemy(900, 940, 183);
		e18 = new Enemy(1010, 1040, 135);
		e19 = new Enemy(1000, 1030, 183);
		e20 = new Enemy(1050, 1087, 183);
		e21 = new Enemy(1170, 1180, 87);
		e22 = new Enemy(1210, 1250, 103);
		e23 = new Enemy(1260, 1300, 103);
		e24 = new Enemy(1200, 1300, 103);
		e25 = new Enemy(1360, 1400, 183);
		e26 = new Enemy(1430, 1472, 183);
		e27 = new Enemy(1415999, 14509999, 151); // moved out of playable area to make game easier
		e28 = new Enemy(1490, 1500, 119);
		e29 = new Enemy(1626, 1636, 183);
		e30 = new Enemy(1626999, 16369999, 135); // moved out of playable area to make game easier
		e31 = new Enemy(1670, 1700, 151);
		e32 = new Enemy(1787, 1885, 183);
		e33 = new Enemy(1810, 1860, 183);
		e34 = new Enemy(1960999, 19909999, 183); // moved out of playable area to make game easier
		e35 = new Enemy(1975, 1995, 183);
		e36 = new Enemy(2000999, 20459999, 183); // moved out of playable area to make game easier
		e37 = new Enemy(2030, 2070, 183);
		e38 = new Enemy(2100999, 21509999, 183); // moved out of playable area to make game easier
		e39 = new Enemy(2125999, 22009999, 183); // moved out of playable area to make game easier
		e40 = new Enemy(1980999, 22009999, 183); // moved out of playable area to make game easier
		e41 = new Enemy(2150, 2200, 183);
		e42 = new Enemy(2480, 2540, 151);
		e43 = new Enemy(2500, 2560, 151);

		// Dictates the position of enemies

		s1 = new ShroomSprite(mb1.getX(), -10000000);

		mapRecArray[0] = floorRec1;
		mapRecArray[1] = floorRec2;
		mapRecArray[2] = floorRec3;

		// Sets the floorRecs to the array of Rectangles

		mapRecArray[3] = boxRec1;
		mapRecArray[4] = boxRec2;
		mapRecArray[5] = boxRec3;
		mapRecArray[6] = boxRec4;
		mapRecArray[7] = boxRec5;
		mapRecArray[8] = boxRec6;
		mapRecArray[9] = boxRec7;
		mapRecArray[10] = boxRec8;
		mapRecArray[11] = boxRec9;

		mapRecArray[12] = pipeRec1;
		mapRecArray[13] = pipeRec2;
		mapRecArray[14] = pipeRec3;
		mapRecArray[15] = pipeRec4;
		mapRecArray[16] = pipeRec5;
		mapRecArray[17] = pipeRec6;
		mapRecArray[18] = pipeRec7;
		mapRecArray[19] = pipeRec8;
		mapRecArray[20] = pipeRec9;
		mapRecArray[21] = pipeRec10;
		mapRecArray[22] = pipeRec11;
		mapRecArray[23] = pipeRec12;
		mapRecArray[24] = pipeRec13;
		mapRecArray[25] = pipeRec14;
		mapRecArray[26] = pipeRec15;
		mapRecArray[27] = pipeRec16;
		mapRecArray[28] = pipeRec17;
		mapRecArray[29] = pipeRec18;
		mapRecArray[30] = pipeRec19;
		mapRecArray[31] = pipeRec20;
		mapRecArray[32] = pipeRec21;
		mapRecArray[33] = pipeRec22;

		mapRecArray[34] = brickRec1;
		mapRecArray[35] = brickRec2;
		mapRecArray[36] = brickRec3;
		mapRecArray[37] = brickRec4;
		mapRecArray[38] = brickRec5;
		mapRecArray[39] = brickRec6;
		mapRecArray[40] = brickRec7;
		mapRecArray[41] = brickRec8;
		mapRecArray[42] = brickRec9;
		mapRecArray[43] = brickRec10;
		mapRecArray[44] = brickRec11;

		// Sets the brickRecs to the array of Rectangles

		mapRecArray[45] = blockRec1;
		mapRecArray[46] = blockRec2;
		mapRecArray[47] = blockRec3;
		mapRecArray[48] = blockRec4;

		// Sets the blockRecs to the array of Rectangles

		mbArray[0] = mb1;
		mbArray[1] = mb2;
		mbArray[2] = mb3;
		mbArray[3] = mb4;
		mbArray[4] = mb5;
		mbArray[5] = mb6;
		mbArray[6] = mb7;
		mbArray[7] = mb8;
		mbArray[8] = mb9;

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
		enemyArray[39] = e40;
		enemyArray[40] = e41;
		enemyArray[41] = e42;
		enemyArray[42] = e43;

		// Sets the enemies to the array of Enemies

		shroomArray[0] = s1;

		BigCollision = new BigCollision(mapRecArray);
		CoinCollision = new CoinCollision(coinArray);
		Collision = new Collision(mapRecArray);
		EnemyCollision = new EnemyCollision(enemyArray);
		ShroomCollision = new ShroomCollision(shroomArray);
		MysteryCollision = new MysteryCollision(mbArray, shroomArray);
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
		floorRec2.setBounds(804 + userSprite.currMapPosX,
				(int) floorRec2.getY(), (int) floorRec2.getWidth(),
				(int) floorRec2.getHeight());
		floorRec3.setBounds(2338 + userSprite.currMapPosX,
				(int) floorRec3.getY(), (int) floorRec3.getWidth(),
				(int) floorRec3.getHeight());

		// Sets the bounds of floorRecs

		boxRec1.setBounds(864 + userSprite.currMapPosX, (int) boxRec1.getY(),
				(int) boxRec1.getWidth(), (int) boxRec1.getHeight());
		boxRec2.setBounds(880 + userSprite.currMapPosX, (int) boxRec2.getY(),
				(int) boxRec2.getWidth(), (int) boxRec2.getHeight());
		boxRec3.setBounds(896 + userSprite.currMapPosX, (int) boxRec3.getY(),
				(int) boxRec3.getWidth(), (int) boxRec3.getHeight());
		boxRec4.setBounds(2752 + userSprite.currMapPosX, (int) boxRec4.getY(),
				(int) boxRec4.getWidth(), (int) boxRec4.getHeight());
		boxRec5.setBounds(2768 + userSprite.currMapPosX, (int) boxRec5.getY(),
				(int) boxRec5.getWidth(), (int) boxRec5.getHeight());
		boxRec6.setBounds(2832 + userSprite.currMapPosX, (int) boxRec6.getY(),
				(int) boxRec6.getWidth(), (int) boxRec6.getHeight());
		boxRec7.setBounds(2848 + userSprite.currMapPosX, (int) boxRec7.getY(),
				(int) boxRec7.getWidth(), (int) boxRec7.getHeight());
		boxRec8.setBounds(2816 + userSprite.currMapPosX, (int) boxRec8.getY(),
				(int) boxRec8.getWidth(), (int) boxRec8.getHeight());
		boxRec9.setBounds(2784 + userSprite.currMapPosX, (int) boxRec9.getY(),
				(int) boxRec9.getWidth(), (int) boxRec9.getHeight());

		// Sets the bounds of boxRecs

		pipeRec1.setBounds(273 + userSprite.currMapPosX, (int) pipeRec1.getY(),
				(int) pipeRec1.getWidth(), (int) pipeRec1.getHeight());
		pipeRec2.setBounds(337 + userSprite.currMapPosX, (int) pipeRec2.getY(),
				(int) pipeRec2.getWidth(), (int) pipeRec2.getHeight());
		pipeRec3.setBounds(481 + userSprite.currMapPosX, (int) pipeRec3.getY(),
				(int) pipeRec3.getWidth(), (int) pipeRec3.getHeight());
		pipeRec4.setBounds(609 + userSprite.currMapPosX, (int) pipeRec4.getY(),
				(int) pipeRec4.getWidth(), (int) pipeRec4.getHeight());
		pipeRec5.setBounds(657 + userSprite.currMapPosX, (int) pipeRec5.getY(),
				(int) pipeRec5.getWidth(), (int) pipeRec5.getHeight());
		pipeRec6.setBounds(753 + userSprite.currMapPosX, (int) pipeRec6.getY(),
				(int) pipeRec6.getWidth(), (int) pipeRec6.getHeight());
		pipeRec7.setBounds(705 + userSprite.currMapPosX, (int) pipeRec7.getY(),
				(int) pipeRec7.getWidth(), (int) pipeRec7.getHeight());
		pipeRec8.setBounds(801 + userSprite.currMapPosX, (int) pipeRec8.getY(),
				(int) pipeRec8.getWidth(), (int) pipeRec8.getHeight());
		pipeRec9.setBounds(961 + userSprite.currMapPosX, (int) pipeRec9.getY(),
				(int) pipeRec9.getWidth(), (int) pipeRec9.getHeight());
		pipeRec10.setBounds(1106 + userSprite.currMapPosX,
				(int) pipeRec10.getY(), (int) pipeRec10.getWidth(),
				(int) pipeRec10.getHeight());
		pipeRec11.setBounds(1137 + userSprite.currMapPosX,
				(int) pipeRec11.getY(), (int) pipeRec11.getWidth(),
				(int) pipeRec11.getHeight());
		pipeRec12.setBounds(1168 + userSprite.currMapPosX,
				(int) pipeRec12.getY(), (int) pipeRec12.getWidth(),
				(int) pipeRec12.getHeight());
		pipeRec13.setBounds(1409 + userSprite.currMapPosX,
				(int) pipeRec13.getY(), (int) pipeRec13.getWidth(),
				(int) pipeRec13.getHeight());
		pipeRec14.setBounds(1489 + userSprite.currMapPosX,
				(int) pipeRec14.getY(), (int) pipeRec14.getWidth(),
				(int) pipeRec14.getHeight());
		pipeRec15.setBounds(1666 + userSprite.currMapPosX,
				(int) pipeRec15.getY(), (int) pipeRec15.getWidth(),
				(int) pipeRec15.getHeight());
		pipeRec16.setBounds(1729 + userSprite.currMapPosX,
				(int) pipeRec16.getY(), (int) pipeRec16.getWidth(),
				(int) pipeRec16.getHeight());
		pipeRec17.setBounds(1920 + userSprite.currMapPosX,
				(int) pipeRec17.getY(), (int) pipeRec17.getWidth(),
				(int) pipeRec17.getHeight());
		pipeRec18.setBounds(1920 + userSprite.currMapPosX,
				(int) pipeRec18.getY(), (int) pipeRec18.getWidth(),
				(int) pipeRec18.getHeight());
		pipeRec19.setBounds(2225 + userSprite.currMapPosX,
				(int) pipeRec19.getY(), (int) pipeRec19.getWidth(),
				(int) pipeRec19.getHeight());
		pipeRec20.setBounds(2337 + userSprite.currMapPosX,
				(int) pipeRec20.getY(), (int) pipeRec20.getWidth(),
				(int) pipeRec20.getHeight());
		pipeRec21.setBounds(2433 + userSprite.currMapPosX,
				(int) pipeRec21.getY(), (int) pipeRec21.getWidth(),
				(int) pipeRec21.getHeight());
		pipeRec22.setBounds(2609 + userSprite.currMapPosX,
				(int) pipeRec22.getY(), (int) pipeRec22.getWidth(),
				(int) pipeRec22.getHeight());

		// Sets the bounds of pipeRecs

		brickRec1.setBounds(320 + userSprite.currMapPosX,
				(int) brickRec1.getY(), (int) brickRec1.getWidth(),
				(int) brickRec1.getHeight());
		brickRec2.setBounds(439 + userSprite.currMapPosX,
				(int) brickRec2.getY(), (int) brickRec2.getWidth(),
				(int) brickRec2.getHeight());
		brickRec3.setBounds(816 + userSprite.currMapPosX,
				(int) brickRec3.getY(), (int) brickRec3.getWidth(),
				(int) brickRec3.getHeight());
		brickRec4.setBounds(992 + userSprite.currMapPosX,
				(int) brickRec4.getY(), (int) brickRec4.getWidth(),
				(int) brickRec4.getHeight());
		brickRec5.setBounds(992 + userSprite.currMapPosX,
				(int) brickRec5.getY(), (int) brickRec5.getWidth(),
				(int) brickRec5.getHeight());
		brickRec6.setBounds(1200 + userSprite.currMapPosX,
				(int) brickRec6.getY(), (int) brickRec6.getWidth(),
				(int) brickRec6.getHeight());
		brickRec7.setBounds(1632 + userSprite.currMapPosX,
				(int) brickRec7.getY(), (int) brickRec7.getWidth(),
				(int) brickRec7.getHeight());
		brickRec8.setBounds(2752 + userSprite.currMapPosX,
				(int) brickRec8.getY(), (int) brickRec8.getWidth(),
				(int) brickRec8.getHeight());
		brickRec9.setBounds(2800 + userSprite.currMapPosX,
				(int) brickRec9.getY(), (int) brickRec9.getWidth(),
				(int) brickRec9.getHeight());
		brickRec10.setBounds(2832 + userSprite.currMapPosX,
				(int) brickRec10.getY(), (int) brickRec10.getWidth(),
				(int) brickRec10.getHeight());
		brickRec11.setBounds(2784 + userSprite.currMapPosX,
				(int) brickRec11.getY(), (int) brickRec11.getWidth(),
				(int) brickRec11.getHeight());

		// Sets the bounds of brickRecs

		blockRec1.setBounds(849 + userSprite.currMapPosX,
				(int) blockRec1.getY(), (int) blockRec1.getWidth(),
				(int) blockRec1.getHeight());
		blockRec2.setBounds(897 + userSprite.currMapPosX,
				(int) blockRec2.getY(), (int) blockRec2.getWidth(),
				(int) blockRec2.getHeight());
		blockRec3.setBounds(1346 + userSprite.currMapPosX,
				(int) blockRec3.getY(), (int) blockRec3.getWidth(),
				(int) blockRec3.getHeight());
		blockRec4.setBounds(2465 + userSprite.currMapPosX,
				(int) blockRec4.getY(), (int) blockRec4.getWidth(),
				(int) blockRec4.getHeight());

		// Sets the bounds of blockRecs

		mb1.move(userSprite.currMapPosX);
		mb2.move(userSprite.currMapPosX);
		mb3.move(userSprite.currMapPosX);
		mb4.move(userSprite.currMapPosX);
		mb5.move(userSprite.currMapPosX);
		mb6.move(userSprite.currMapPosX);
		mb7.move(userSprite.currMapPosX);
		mb8.move(userSprite.currMapPosX);
		mb9.move(userSprite.currMapPosX);

		// The mystery boxes move across the map

		mb1.animate();
		mb2.animate();
		mb3.animate();
		mb4.animate();
		mb5.animate();
		mb6.animate();
		mb7.animate();
		mb8.animate();
		mb9.animate();

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
		e40.move(userSprite.currMapPosX);
		e41.move(userSprite.currMapPosX);
		e42.move(userSprite.currMapPosX);
		e43.move(userSprite.currMapPosX);

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
				g2d.drawString("Map 5", 175, 50);
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
			g2d.drawImage(map5.getImage(), userSprite.currMapPosX, 0, null); // Draws
																				// the
																				// map
			g2d.drawImage(userSprite.getImage(), userSprite.getX(),
					userSprite.getY(), null); // Draws the userSprite (Mario)

			g2d.drawImage(mb1.getImage(), mb1.getX(), mb1.getY(), null);
			g2d.drawImage(mb2.getImage(), mb2.getX(), mb2.getY(), null);
			g2d.drawImage(mb3.getImage(), mb3.getX(), mb3.getY(), null);
			g2d.drawImage(mb4.getImage(), mb4.getX(), mb4.getY(), null);
			g2d.drawImage(mb5.getImage(), mb5.getX(), mb5.getY(), null);
			g2d.drawImage(mb6.getImage(), mb6.getX(), mb6.getY(), null);
			g2d.drawImage(mb7.getImage(), mb7.getX(), mb7.getY(), null);
			g2d.drawImage(mb8.getImage(), mb8.getX(), mb8.getY(), null);
			g2d.drawImage(mb9.getImage(), mb9.getX(), mb9.getY(), null);

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
			g2d.drawImage(e40.getImage(), e40.getX(), e40.getY(), null);
			g2d.drawImage(e41.getImage(), e41.getX(), e41.getY(), null);
			g2d.drawImage(e42.getImage(), e42.getX(), e42.getY(), null);
			g2d.drawImage(e43.getImage(), e43.getX(), e43.getY(), null);

			// Draws the Enemies

			g2d.drawImage(s1.getImage(), s1.getX(), s1.getY(), null);

			g2d.drawString("Coins: " + coins, 0, 10); // Shows how many coins
														// Mario has collected
			g2d.drawString("Lives: " + lives, 0, 20); // Shows how many lives
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
		userSprite.mapPort(livesInput + 1, coinsInput, bigInput);
	}

	public void destroy() { // Stops timer within this panel when level is
							// finished, so containing objects do not continue
							// to run when next panel is loaded.
		timer.stop();
	}
}