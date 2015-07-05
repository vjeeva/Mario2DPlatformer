/*
 Map7.Java (for Super Mario: The Zakaryan Strikes Back)
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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//Imports specific packages needed for the code

public class Map7 extends JPanel implements ActionListener { // Extends JPanel
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
	private ImageIcon map7; // Creates an ImageIcon
	private Timer timer; // Creates a timer
	private ShroomCollision ShroomCollision;
	private ShroomSprite s1;
	private ShroomSprite[] shroomArray = new ShroomSprite[1];
	public static int coins = Map6.coins, lives = Map6.lives;
	public static boolean big = Map6.big;

	public Rectangle floorRec1, floorRec2, floorRec3, floorRec4, floorRec5,
			floorRec6, floorRec7, floorRec8, floorRec9, floorRec10, floorRec11,
			floorRec12;
	public Rectangle pipeRec1;
	public Rectangle brickRec1, brickRec2, brickRec3, brickRec4, brickRec5,
			brickRec6, brickRec7, brickRec8, brickRec9, brickRec10, brickRec11,
			brickRec12, brickRec13, brickRec14, brickRec15, brickRec16,
			brickRec17, brickRec18, brickRec19, brickRec20, brickRec21,
			brickRec22, brickRec23, brickRec24, brickRec25, brickRec26,
			brickRec27, brickRec28, brickRec29, brickRec30, brickRec31,
			brickRec32, brickRec33, brickRec34, brickRec35, brickRec36,
			brickRec37, brickRec38, brickRec39, brickRec40, brickRec41,
			brickRec42, brickRec43, brickRec44, brickRec45, brickRec46;

	// Creates Rectangles that are used for collision purposes

	public MysteryBox mb1;
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
			e28, e29, e30, e31, e32, e33, e34, e35, e36, e37, e38, e39;

	// Creates new MysteryBoxes, CoinSprites, and Enemies

	public Rectangle[] mapRecArray = new Rectangle[59]; // Creates an array of
														// Rectangles
	public MysteryBox[] mbArray = new MysteryBox[1]; // Creates an array of
														// MysteryBoxes
	public CoinSprite[] coinArray = new CoinSprite[100]; // Creates an array of
															// CoinSprites
	public Enemy[] enemyArray = new Enemy[39]; // Creates an array of Enemies
	private int mapEnd = -2413; // The end of the map
	private long t, end;
	private MainMenu menu = new MainMenu();
	private boolean checkedTime = false, checkedTime2 = false, checkedTime3 = false;
	private int menuOpen = 0;
	private int musicPlayed = 0;

	public Map7() {

		map7 = new ImageIcon("resources/1-7.png"); // The ImageIcon is set to
													// the picture
		addKeyListener(new KeyPasser()); // Adds a KeyPasser
		setFocusable(true); // Becomes the focus of the keyListener

		floorRec1 = new Rectangle(0, 183, 120, 50);
		floorRec2 = new Rectangle(320, 151, 64, 50);
		floorRec3 = new Rectangle(384, 167, 64, 50);
		floorRec4 = new Rectangle(450, 151, 62, 50);
		floorRec5 = new Rectangle(540, 167, 32, 50);
		floorRec6 = new Rectangle(602, 153, 60, 50);
		floorRec7 = new Rectangle(673, 137, 70, 50);
		floorRec8 = new Rectangle(770, 152, 30, 50);
		floorRec9 = new Rectangle(831, 137, 70, 50);
		floorRec10 = new Rectangle(928, 121, 75, 50);
		floorRec11 = new Rectangle(1037, 108, 54, 50);
		floorRec12 = new Rectangle(1185, 183, 305, 50);

		// Dictates the size and position of floorRecs

		pipeRec1 = new Rectangle(256, 151, 31, 40);

		// Dictates the size and position of pipeRecs

		brickRec1 = new Rectangle(112, 167, 16, 16);
		brickRec2 = new Rectangle(128, 151, 32, 32);
		brickRec3 = new Rectangle(144, 119, 32, 32);
		brickRec4 = new Rectangle(160, 71, 16, 48);
		brickRec5 = new Rectangle(176, 55, 80, 48);
		brickRec6 = new Rectangle(240, 103, 16, 110);
		brickRec7 = new Rectangle(256, 183, 32, 32);
		brickRec8 = new Rectangle(288, 135, 16, 80);
		brickRec9 = new Rectangle(304, 135, 16, 32);
		brickRec10 = new Rectangle(509, 137, 32, 32);
		brickRec11 = new Rectangle(568, 137, 32, 32);
		brickRec12 = new Rectangle(640, 121, 32, 32);
		brickRec13 = new Rectangle(738, 121, 32, 32);
		brickRec14 = new Rectangle(799, 121, 32, 32);
		brickRec15 = new Rectangle(896, 105, 32, 32);
		brickRec16 = new Rectangle(1004, 92, 32, 32);
		brickRec17 = new Rectangle(1089, 90, 16, 32);
		brickRec18 = new Rectangle(1105, 106, 16, 32);
		brickRec19 = new Rectangle(1121, 122, 16, 32);
		brickRec20 = new Rectangle(1137, 138, 16, 32);
		brickRec21 = new Rectangle(1153, 154, 32, 32);
		brickRec22 = new Rectangle(1200, 135, 48, 48);
		brickRec23 = new Rectangle(1280, 167, 128, 16);
		brickRec24 = new Rectangle(1296, 151, 112, 16);
		brickRec25 = new Rectangle(1312, 135, 96, 16);
		brickRec26 = new Rectangle(1328, 119, 80, 16);
		brickRec27 = new Rectangle(1344, 103, 64, 16);
		brickRec28 = new Rectangle(1360, 87, 48, 16);
		brickRec29 = new Rectangle(1376, 71, 32, 16);
		brickRec30 = new Rectangle(1408, 71, 16, 112);
		brickRec31 = new Rectangle(1489, 175, 96, 16);
		brickRec32 = new Rectangle(1505, 159, 80, 16);
		brickRec33 = new Rectangle(1521, 143, 64, 16);
		brickRec34 = new Rectangle(1537, 127, 48, 16);
		brickRec35 = new Rectangle(1553, 95, 32, 32);
		brickRec36 = new Rectangle(1569, 79, 191, 50);
		brickRec37 = new Rectangle(1761, 87, 31, 16);
		brickRec38 = new Rectangle(1776, 103, 32, 16);
		brickRec39 = new Rectangle(1792, 119, 32, 16);
		brickRec40 = new Rectangle(1808, 135, 32, 16);
		brickRec41 = new Rectangle(1824, 151, 32, 16);
		brickRec42 = new Rectangle(1745, 63, 16, 32);
		brickRec43 = new Rectangle(1840, 167, 64, 32);
		brickRec44 = new Rectangle(1936, 199, 112, 16);
		brickRec45 = new Rectangle(2040, 168, 316, 50);
		brickRec46 = new Rectangle(2356, 200, 455, 50);

		// Dictates the size and position of brickRecs

		mb1 = new MysteryBox(0, 0);

		// Dictates the position of mystery boxes

		c1 = new CoinSprite(324, 135);
		c2 = new CoinSprite(339, 135);
		c3 = new CoinSprite(354, 135);
		c4 = new CoinSprite(324, 120);
		c5 = new CoinSprite(339, 120);
		c6 = new CoinSprite(354, 120);
		c7 = new CoinSprite(324, 105);
		c8 = new CoinSprite(339, 105);
		c9 = new CoinSprite(354, 105);
		c10 = new CoinSprite(394, 151);
		c11 = new CoinSprite(409, 151);
		c12 = new CoinSprite(394, 136);
		c13 = new CoinSprite(409, 136);
		c14 = new CoinSprite(394, 121);
		c15 = new CoinSprite(409, 121);
		c16 = new CoinSprite(394, 106);
		c17 = new CoinSprite(409, 106);
		c18 = new CoinSprite(394, 91);
		c19 = new CoinSprite(409, 91);
		c20 = new CoinSprite(424, 151);
		c21 = new CoinSprite(424, 136);
		c22 = new CoinSprite(424, 121);
		c23 = new CoinSprite(424, 106);
		c24 = new CoinSprite(424, 91);
		c25 = new CoinSprite(176, 39);
		c26 = new CoinSprite(191, 39);
		c27 = new CoinSprite(206, 39);
		c28 = new CoinSprite(221, 39);
		c29 = new CoinSprite(236, 39);
		c30 = new CoinSprite(604, 137);
		c31 = new CoinSprite(619, 137);
		c32 = new CoinSprite(604, 122);
		c33 = new CoinSprite(619, 122);
		c34 = new CoinSprite(604, 107);
		c35 = new CoinSprite(619, 107);
		c36 = new CoinSprite(681, 121);
		c37 = new CoinSprite(696, 121);
		c38 = new CoinSprite(711, 121);
		c39 = new CoinSprite(681, 106);
		c40 = new CoinSprite(696, 106);
		c41 = new CoinSprite(711, 106);
		c42 = new CoinSprite(681, 91);
		c43 = new CoinSprite(696, 91);
		c44 = new CoinSprite(711, 91);
		c45 = new CoinSprite(681, 76);
		c46 = new CoinSprite(696, 76);
		c47 = new CoinSprite(711, 76);
		c48 = new CoinSprite(933, 105);
		c49 = new CoinSprite(948, 105);
		c50 = new CoinSprite(963, 105);
		c51 = new CoinSprite(978, 105);
		c52 = new CoinSprite(933, 90);
		c53 = new CoinSprite(948, 90);
		c54 = new CoinSprite(963, 90);
		c55 = new CoinSprite(978, 90);
		c56 = new CoinSprite(933, 75);
		c57 = new CoinSprite(948, 75);
		c58 = new CoinSprite(963, 75);
		c59 = new CoinSprite(978, 75);
		c60 = new CoinSprite(1425, 71);
		c61 = new CoinSprite(1440, 71);
		c62 = new CoinSprite(1425, 86);
		c63 = new CoinSprite(1440, 86);
		c64 = new CoinSprite(1425, 101);
		c65 = new CoinSprite(1440, 101);
		c66 = new CoinSprite(1425, 116);
		c67 = new CoinSprite(1440, 116);
		c68 = new CoinSprite(1425, 131);
		c69 = new CoinSprite(1440, 131);
		c70 = new CoinSprite(1425, 146);
		c71 = new CoinSprite(1440, 146);
		c72 = new CoinSprite(1425, 161);
		c73 = new CoinSprite(1440, 161);
		c74 = new CoinSprite(1940, 183);
		c75 = new CoinSprite(1955, 183);
		c76 = new CoinSprite(1970, 183);
		c77 = new CoinSprite(1985, 183);
		c78 = new CoinSprite(2000, 183);
		c79 = new CoinSprite(2015, 183);
		c80 = new CoinSprite(1940, 168);
		c81 = new CoinSprite(1955, 168);
		c82 = new CoinSprite(1970, 168);
		c83 = new CoinSprite(1985, 168);
		c84 = new CoinSprite(2000, 168);
		c85 = new CoinSprite(2015, 168);
		c86 = new CoinSprite(1940, 153);
		c87 = new CoinSprite(1955, 153);
		c88 = new CoinSprite(1970, 153);
		c89 = new CoinSprite(1985, 153);
		c90 = new CoinSprite(2000, 153);
		c91 = new CoinSprite(2015, 153);
		c92 = new CoinSprite(1940, 138);
		c93 = new CoinSprite(1955, 138);
		c94 = new CoinSprite(1970, 138);
		c95 = new CoinSprite(1985, 138);
		c96 = new CoinSprite(2000, 138);
		c97 = new CoinSprite(2015, 138);
		c98 = new CoinSprite(324, 90);
		c99 = new CoinSprite(339, 90);
		c100 = new CoinSprite(354, 90);

		// Dictates the position of coins

		e1 = new Enemy(176999, 2119999, 39); // moved out of playable area to make game easier
		e2 = new Enemy(176999, 2409999, 39); // moved out of playable area to make game easier
		e3 = new Enemy(261, 271, 135);
		e4 = new Enemy(289, 299, 119);
		e5 = new Enemy(324, 359, 135);
		e6 = new Enemy(394, 429, 151);
		e7 = new Enemy(464, 492, 135);
		e8 = new Enemy(513, 527, 121);
		e9 = new Enemy(541, 551, 151);
		e10 = new Enemy(569, 585, 121);
		e11 = new Enemy(604, 618, 137);
		e12 = new Enemy(640, 660, 105);
		e13 = new Enemy(680999, 7169999, 121);  // moved out of playable area to make game easier
		e14 = new Enemy(680, 710, 121);
		e15 = new Enemy(737, 758, 105);
		e16 = new Enemy(772, 786, 136);
		e17 = new Enemy(800999, 8159999, 105); // moved out of playable area to make game easier
		e18 = new Enemy(842, 877, 121);
		e19 = new Enemy(842, 860, 121);
		e20 = new Enemy(850999, 8709999, 121); // moved out of playable area to make game easier
		e21 = new Enemy(898, 913, 89);
		e22 = new Enemy(933, 975, 105);
		e23 = new Enemy(933999, 9509999, 105); // moved out of playable area to make game easier
		e24 = new Enemy(1003, 1018, 76);
		e25 = new Enemy(1038, 1073, 92);
		e26 = new Enemy(1038, 1060, 92);
		e27 = new Enemy(1200999, 12309999, 119); // moved out of playable area to make game easier
		e28 = new Enemy(1375, 1390, 55);
		e29 = new Enemy(1430, 1465, 167);
		e30 = new Enemy(1570, 1605, 63);
		e31 = new Enemy(1590999, 16059999, 63); // moved out of playable area to make game easier
		e32 = new Enemy(1619, 1640, 63);
		e33 = new Enemy(1580, 1640, 63);
		e34 = new Enemy(1640999, 17309999, 63); // moved out of playable area to make game easier
		e35 = new Enemy(1680, 1730, 63);
		e36 = new Enemy(2080, 2150, 152);
		e37 = new Enemy(2120999, 21509999, 152); // moved out of playable area to make game easier
		e38 = new Enemy(2080, 2340, 152);
		e39 = new Enemy(2200, 2340, 152);

		// Dictates the position of enemies

		s1 = new ShroomSprite(mb1.getX(), -10000000);

		mapRecArray[0] = floorRec1;
		mapRecArray[1] = floorRec2;
		mapRecArray[2] = floorRec3;
		mapRecArray[3] = floorRec4;
		mapRecArray[4] = floorRec5;
		mapRecArray[5] = floorRec6;
		mapRecArray[6] = floorRec7;
		mapRecArray[7] = floorRec8;
		mapRecArray[8] = floorRec9;
		mapRecArray[9] = floorRec10;
		mapRecArray[10] = floorRec11;
		mapRecArray[11] = floorRec12;

		// Sets the floorRecs to the array of Rectangles

		mapRecArray[12] = pipeRec1;

		// Sets the pipeRecs to the array of Rectangles

		mapRecArray[13] = brickRec1;
		mapRecArray[14] = brickRec2;
		mapRecArray[15] = brickRec3;
		mapRecArray[16] = brickRec4;
		mapRecArray[17] = brickRec5;
		mapRecArray[18] = brickRec6;
		mapRecArray[19] = brickRec7;
		mapRecArray[20] = brickRec8;
		mapRecArray[21] = brickRec9;
		mapRecArray[22] = brickRec10;
		mapRecArray[23] = brickRec11;
		mapRecArray[24] = brickRec12;
		mapRecArray[25] = brickRec13;
		mapRecArray[26] = brickRec14;
		mapRecArray[27] = brickRec15;
		mapRecArray[28] = brickRec16;
		mapRecArray[29] = brickRec17;
		mapRecArray[30] = brickRec18;
		mapRecArray[31] = brickRec19;
		mapRecArray[32] = brickRec20;
		mapRecArray[33] = brickRec21;
		mapRecArray[34] = brickRec22;
		mapRecArray[35] = brickRec23;
		mapRecArray[36] = brickRec24;
		mapRecArray[37] = brickRec25;
		mapRecArray[38] = brickRec26;
		mapRecArray[39] = brickRec27;
		mapRecArray[40] = brickRec28;
		mapRecArray[41] = brickRec29;
		mapRecArray[42] = brickRec30;
		mapRecArray[43] = brickRec31;
		mapRecArray[44] = brickRec32;
		mapRecArray[45] = brickRec33;
		mapRecArray[46] = brickRec34;
		mapRecArray[47] = brickRec35;
		mapRecArray[48] = brickRec36;
		mapRecArray[49] = brickRec37;
		mapRecArray[50] = brickRec38;
		mapRecArray[51] = brickRec39;
		mapRecArray[52] = brickRec40;
		mapRecArray[53] = brickRec41;
		mapRecArray[54] = brickRec42;
		mapRecArray[55] = brickRec43;
		mapRecArray[56] = brickRec44;
		mapRecArray[57] = brickRec45;
		mapRecArray[58] = brickRec46;

		// Sets the brickRecs to the array of Rectangles

		mbArray[0] = mb1;

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
		floorRec2.setBounds(320 + userSprite.currMapPosX,
				(int) floorRec2.getY(), (int) floorRec2.getWidth(),
				(int) floorRec2.getHeight());
		floorRec3.setBounds(384 + userSprite.currMapPosX,
				(int) floorRec3.getY(), (int) floorRec3.getWidth(),
				(int) floorRec3.getHeight());
		floorRec4.setBounds(450 + userSprite.currMapPosX,
				(int) floorRec4.getY(), (int) floorRec4.getWidth(),
				(int) floorRec4.getHeight());
		floorRec5.setBounds(540 + userSprite.currMapPosX,
				(int) floorRec5.getY(), (int) floorRec5.getWidth(),
				(int) floorRec5.getHeight());
		floorRec6.setBounds(602 + userSprite.currMapPosX,
				(int) floorRec6.getY(), (int) floorRec6.getWidth(),
				(int) floorRec6.getHeight());
		floorRec7.setBounds(673 + userSprite.currMapPosX,
				(int) floorRec7.getY(), (int) floorRec7.getWidth(),
				(int) floorRec7.getHeight());
		floorRec8.setBounds(770 + userSprite.currMapPosX,
				(int) floorRec8.getY(), (int) floorRec8.getWidth(),
				(int) floorRec8.getHeight());
		floorRec9.setBounds(831 + userSprite.currMapPosX,
				(int) floorRec9.getY(), (int) floorRec9.getWidth(),
				(int) floorRec9.getHeight());
		floorRec10.setBounds(928 + userSprite.currMapPosX,
				(int) floorRec10.getY(), (int) floorRec10.getWidth(),
				(int) floorRec10.getHeight());
		floorRec11.setBounds(1037 + userSprite.currMapPosX,
				(int) floorRec11.getY(), (int) floorRec11.getWidth(),
				(int) floorRec11.getHeight());
		floorRec12.setBounds(1185 + userSprite.currMapPosX,
				(int) floorRec12.getY(), (int) floorRec12.getWidth(),
				(int) floorRec12.getHeight());

		// Sets the bounds of floorRecs

		pipeRec1.setBounds(256 + userSprite.currMapPosX, (int) pipeRec1.getY(),
				(int) pipeRec1.getWidth(), (int) pipeRec1.getHeight());

		// Sets the bounds of pipeRecs

		brickRec1.setBounds(112 + userSprite.currMapPosX,
				(int) brickRec1.getY(), (int) brickRec1.getWidth(),
				(int) brickRec1.getHeight());
		brickRec2.setBounds(128 + userSprite.currMapPosX,
				(int) brickRec2.getY(), (int) brickRec2.getWidth(),
				(int) brickRec2.getHeight());
		brickRec3.setBounds(144 + userSprite.currMapPosX,
				(int) brickRec3.getY(), (int) brickRec3.getWidth(),
				(int) brickRec3.getHeight());
		brickRec4.setBounds(160 + userSprite.currMapPosX,
				(int) brickRec4.getY(), (int) brickRec4.getWidth(),
				(int) brickRec4.getHeight());
		brickRec5.setBounds(176 + userSprite.currMapPosX,
				(int) brickRec5.getY(), (int) brickRec5.getWidth(),
				(int) brickRec5.getHeight());
		brickRec6.setBounds(240 + userSprite.currMapPosX,
				(int) brickRec6.getY(), (int) brickRec6.getWidth(),
				(int) brickRec6.getHeight());
		brickRec7.setBounds(256 + userSprite.currMapPosX,
				(int) brickRec7.getY(), (int) brickRec7.getWidth(),
				(int) brickRec7.getHeight());
		brickRec8.setBounds(288 + userSprite.currMapPosX,
				(int) brickRec8.getY(), (int) brickRec8.getWidth(),
				(int) brickRec8.getHeight());
		brickRec9.setBounds(304 + userSprite.currMapPosX,
				(int) brickRec9.getY(), (int) brickRec9.getWidth(),
				(int) brickRec9.getHeight());
		brickRec10.setBounds(509 + userSprite.currMapPosX,
				(int) brickRec10.getY(), (int) brickRec10.getWidth(),
				(int) brickRec10.getHeight());
		brickRec11.setBounds(568 + userSprite.currMapPosX,
				(int) brickRec11.getY(), (int) brickRec11.getWidth(),
				(int) brickRec11.getHeight());
		brickRec12.setBounds(640 + userSprite.currMapPosX,
				(int) brickRec12.getY(), (int) brickRec12.getWidth(),
				(int) brickRec12.getHeight());
		brickRec13.setBounds(738 + userSprite.currMapPosX,
				(int) brickRec13.getY(), (int) brickRec13.getWidth(),
				(int) brickRec13.getHeight());
		brickRec14.setBounds(799 + userSprite.currMapPosX,
				(int) brickRec14.getY(), (int) brickRec14.getWidth(),
				(int) brickRec14.getHeight());
		brickRec15.setBounds(896 + userSprite.currMapPosX,
				(int) brickRec15.getY(), (int) brickRec15.getWidth(),
				(int) brickRec15.getHeight());
		brickRec16.setBounds(1004 + userSprite.currMapPosX,
				(int) brickRec16.getY(), (int) brickRec16.getWidth(),
				(int) brickRec16.getHeight());
		brickRec17.setBounds(1089 + userSprite.currMapPosX,
				(int) brickRec17.getY(), (int) brickRec17.getWidth(),
				(int) brickRec17.getHeight());
		brickRec18.setBounds(1105 + userSprite.currMapPosX,
				(int) brickRec18.getY(), (int) brickRec18.getWidth(),
				(int) brickRec18.getHeight());
		brickRec19.setBounds(1121 + userSprite.currMapPosX,
				(int) brickRec19.getY(), (int) brickRec19.getWidth(),
				(int) brickRec19.getHeight());
		brickRec20.setBounds(1137 + userSprite.currMapPosX,
				(int) brickRec20.getY(), (int) brickRec20.getWidth(),
				(int) brickRec20.getHeight());
		brickRec21.setBounds(1153 + userSprite.currMapPosX,
				(int) brickRec21.getY(), (int) brickRec21.getWidth(),
				(int) brickRec21.getHeight());
		brickRec22.setBounds(1200 + userSprite.currMapPosX,
				(int) brickRec22.getY(), (int) brickRec22.getWidth(),
				(int) brickRec22.getHeight());
		brickRec23.setBounds(1280 + userSprite.currMapPosX,
				(int) brickRec23.getY(), (int) brickRec23.getWidth(),
				(int) brickRec23.getHeight());
		brickRec24.setBounds(1296 + userSprite.currMapPosX,
				(int) brickRec24.getY(), (int) brickRec24.getWidth(),
				(int) brickRec24.getHeight());
		brickRec25.setBounds(1312 + userSprite.currMapPosX,
				(int) brickRec25.getY(), (int) brickRec25.getWidth(),
				(int) brickRec25.getHeight());
		brickRec26.setBounds(1328 + userSprite.currMapPosX,
				(int) brickRec26.getY(), (int) brickRec26.getWidth(),
				(int) brickRec26.getHeight());
		brickRec27.setBounds(1344 + userSprite.currMapPosX,
				(int) brickRec27.getY(), (int) brickRec27.getWidth(),
				(int) brickRec27.getHeight());
		brickRec28.setBounds(1360 + userSprite.currMapPosX,
				(int) brickRec28.getY(), (int) brickRec28.getWidth(),
				(int) brickRec28.getHeight());
		brickRec29.setBounds(1376 + userSprite.currMapPosX,
				(int) brickRec29.getY(), (int) brickRec29.getWidth(),
				(int) brickRec29.getHeight());
		brickRec30.setBounds(1408 + userSprite.currMapPosX,
				(int) brickRec30.getY(), (int) brickRec30.getWidth(),
				(int) brickRec30.getHeight());
		brickRec31.setBounds(1489 + userSprite.currMapPosX,
				(int) brickRec31.getY(), (int) brickRec31.getWidth(),
				(int) brickRec31.getHeight());
		brickRec32.setBounds(1505 + userSprite.currMapPosX,
				(int) brickRec32.getY(), (int) brickRec32.getWidth(),
				(int) brickRec32.getHeight());
		brickRec33.setBounds(1521 + userSprite.currMapPosX,
				(int) brickRec33.getY(), (int) brickRec33.getWidth(),
				(int) brickRec33.getHeight());
		brickRec34.setBounds(1537 + userSprite.currMapPosX,
				(int) brickRec34.getY(), (int) brickRec34.getWidth(),
				(int) brickRec34.getHeight());
		brickRec35.setBounds(1553 + userSprite.currMapPosX,
				(int) brickRec35.getY(), (int) brickRec35.getWidth(),
				(int) brickRec35.getHeight());
		brickRec36.setBounds(1569 + userSprite.currMapPosX,
				(int) brickRec36.getY(), (int) brickRec36.getWidth(),
				(int) brickRec36.getHeight());
		brickRec37.setBounds(1761 + userSprite.currMapPosX,
				(int) brickRec37.getY(), (int) brickRec37.getWidth(),
				(int) brickRec37.getHeight());
		brickRec38.setBounds(1776 + userSprite.currMapPosX,
				(int) brickRec38.getY(), (int) brickRec38.getWidth(),
				(int) brickRec38.getHeight());
		brickRec39.setBounds(1792 + userSprite.currMapPosX,
				(int) brickRec39.getY(), (int) brickRec39.getWidth(),
				(int) brickRec39.getHeight());
		brickRec40.setBounds(1808 + userSprite.currMapPosX,
				(int) brickRec40.getY(), (int) brickRec40.getWidth(),
				(int) brickRec40.getHeight());
		brickRec41.setBounds(1824 + userSprite.currMapPosX,
				(int) brickRec41.getY(), (int) brickRec41.getWidth(),
				(int) brickRec41.getHeight());
		brickRec42.setBounds(1745 + userSprite.currMapPosX,
				(int) brickRec42.getY(), (int) brickRec42.getWidth(),
				(int) brickRec42.getHeight());
		brickRec43.setBounds(1840 + userSprite.currMapPosX,
				(int) brickRec43.getY(), (int) brickRec43.getWidth(),
				(int) brickRec43.getHeight());
		brickRec44.setBounds(1936 + userSprite.currMapPosX,
				(int) brickRec44.getY(), (int) brickRec44.getWidth(),
				(int) brickRec44.getHeight());
		brickRec45.setBounds(2040 + userSprite.currMapPosX,
				(int) brickRec45.getY(), (int) brickRec45.getWidth(),
				(int) brickRec45.getHeight());
		brickRec46.setBounds(2356 + userSprite.currMapPosX,
				(int) brickRec46.getY(), (int) brickRec46.getWidth(),
				(int) brickRec46.getHeight());

		// Sets the bounds of brickRecs

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
		if (MainMenu.mapNumber != 7) {
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
					System.out.println("Fag");
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
					g2d.drawString("Map 7", 175, 50);
					if ((end - System.currentTimeMillis()) / 1000 == 0) {
						try {
							Sound.resume();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else if (lives <= 0) {
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
			} else if (MainMenu.mapNumber == 8) {
				Sound.pauseMusic();
				if (musicPlayed == 0) {
				try {
					Sound.playActionMusic("Troll.wav");
					musicPlayed++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				long end = System.currentTimeMillis();
				long ms = end - MainMenu.start;
				String time = String.format(
						"%d minute(s), %d seconds",
						TimeUnit.MILLISECONDS.toMinutes(ms),
						TimeUnit.MILLISECONDS.toSeconds(ms)
								- TimeUnit.MINUTES
										.toSeconds(TimeUnit.MILLISECONDS
												.toMinutes(ms)));
				g2d.setColor(Color.BLACK);
				g2d.drawRect(0, 0, 10000, 10000);
				g2d.fillRect(0, 0, 10000, 10000);
				Font f = new Font("Verdana", Font.BOLD, 20);
				g2d.setColor(Color.red);
				if (checkedTime3 == false) {
					t = System.currentTimeMillis();
					checkedTime3 = true;
				}
				end = t + 3000;
					if (System.currentTimeMillis() >= end) {	
						g2d.drawString("...for wasting " + time
								+ " of your life", 100, 100);
						g2d.drawString("trying to finish this game. :P", 100, 125);
				}
				g2d.setFont(f);
				g2d.drawString("CONGRATULATIONS!!", 100, 50);
			}
		} else if (userSprite.dead == false) {
			g2d.drawImage(map7.getImage(), userSprite.currMapPosX, 0, null); // Draws
																				// the
																				// map
			g2d.drawImage(userSprite.getImage(), userSprite.getX(),
					userSprite.getY(), null); // Draws the userSprite (Mario)

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