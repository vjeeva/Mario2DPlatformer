/*
 Map3.Java (for Super Mario: The Zakaryan Strikes Back)
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

public class Map3 extends JPanel implements ActionListener { // Extends JPanel and implements ActionListener

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
	private ImageIcon map3; // Creates an ImageIcon
	private Timer timer; // Creates a timer
	private ShroomCollision ShroomCollision;
	private ShroomSprite s1;
	private ShroomSprite[] shroomArray = new ShroomSprite[1];
	public static int coins = Map2.coins, lives = Map2.lives;
	public static boolean big = Map2.big;
	
	public Rectangle floorRec1, floorRec2;
	public Rectangle boxRec1, boxRec2;
	public Rectangle brickRec1, brickRec2, brickRec3, brickRec4, brickRec5, brickRec6, brickRec7, brickRec8, brickRec9, brickRec10, brickRec11, brickRec12, brickRec13, brickRec14, brickRec15, brickRec16, brickRec17, brickRec18, brickRec19, brickRec20, brickRec21, brickRec22, brickRec23, brickRec24, brickRec25, brickRec26, brickRec27, brickRec28, brickRec29, brickRec30, brickRec31, brickRec32, brickRec33, brickRec34, brickRec35, brickRec36, brickRec37, brickRec38, brickRec39, brickRec40, brickRec41, brickRec42;
	public Rectangle blockRec1, blockRec2, blockRec3, blockRec4, blockRec5, blockRec6;
	
	// Creates Rectangles that are used for collision purposes
	
	public MysteryBox mb1, mb2;
	public CoinSprite c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50, c51, c52, c53, c54, c55, c56, c57, c58, c59, c60, c61, c62, c63, c64, c65, c66, c67, c68, c69, c70, c71, c72, c73, c74, c75, c76, c77, c78, c79, c80, c81, c82, c83, c84, c85, c86, c87, c88, c89, c90, c91, c92, c93, c94, c95, c96, c97, c98, c99, c100;
	public Enemy e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e32, e33, e34, e35, e36, e37, e38, e39;
	
	// Creates new MysteryBoxes, CoinSprites, and Enemies
	
	public Rectangle[] mapRecArray = new Rectangle[52]; // Creates an array of Rectangles
	public MysteryBox[] mbArray = new MysteryBox[2]; // Creates an array of MysteryBoxes
	public CoinSprite[] coinArray = new CoinSprite[100]; // Creates an array of CoinSprites
	public Enemy[] enemyArray = new Enemy[39]; // Creates an array of Enemies
	private int mapEnd = -2194; // The end of the map
	private long t, end;
	private MainMenu menu = new MainMenu();
	private boolean checkedTime = false, checkedTime2 = false;
	private int menuOpen = 0;

	public Map3() {

		map3 = new ImageIcon("resources/1-3.png"); // The ImageIcon is set to the picture
		addKeyListener(new KeyPasser()); // Adds a KeyPasser
		setFocusable(true); // Becomes the focus of the keyListener

		floorRec1 = new Rectangle(0, 199, 336, 50);
		floorRec2 = new Rectangle(1825, 199, 780, 50);
		
		// Dictates the size and position of floorRecs
		
		boxRec1 = new Rectangle(896, 103, 16, 16);
		boxRec2 = new Rectangle(1856, 135, 16, 16);
		
		// Dictates the size and position of boxRecs
		
		brickRec1 = new Rectangle(309, 183, 14, 14);
		brickRec2 = new Rectangle(323, 169, 14, 14);
		brickRec3 = new Rectangle(337, 155, 14, 14);
		brickRec4 = new Rectangle(351, 141, 14, 14);
		brickRec5 = new Rectangle(365, 127, 14, 14);
		brickRec6 = new Rectangle(379, 113, 14, 14);
		brickRec7 = new Rectangle(393, 99, 14, 14);
		brickRec8 = new Rectangle(407, 85, 14, 14);
		brickRec9 = new Rectangle(421, 71, 14, 14);
		brickRec10 = new Rectangle(435, 57, 14, 14);
		brickRec11 = new Rectangle(449, 43, 78, 14);
		brickRec12 = new Rectangle(545, 55, 32, 48);
		brickRec13 = new Rectangle(608, 87, 63, 14);
		brickRec14 = new Rectangle(673, 119, 14, 63);
		brickRec15 = new Rectangle(705, 71, 46, 14);
		brickRec16 = new Rectangle(705, 135, 78, 14);
		brickRec17 = new Rectangle(785, 87, 79, 14);
		brickRec18 = new Rectangle(850, 103, 14, 46);
		brickRec19 = new Rectangle(880, 151, 47, 14);
		brickRec20 = new Rectangle(913, 166, 14, 47);
		brickRec21 = new Rectangle(960, 183, 47, 14);
		brickRec22 = new Rectangle(944, 87, 47, 14);
		brickRec23 = new Rectangle(992, 135, 47, 14);
		brickRec24 = new Rectangle(1040, 151, 47, 14);
		brickRec25 = new Rectangle(1045, 87, 31, 30);
		brickRec26 = new Rectangle(1105, 87, 31, 14);
		brickRec27 = new Rectangle(1120, 119, 15, 62);
		brickRec28 = new Rectangle(1153, 119, 47, 14);
		brickRec29 = new Rectangle(1169, 103, 14, 14);
		brickRec30 = new Rectangle(1153, 183, 62, 14);
		brickRec31 = new Rectangle(1233, 119, 47, 14);
		brickRec32 = new Rectangle(1265, 135, 14, 47);
		brickRec33 = new Rectangle(1233, 183, 207, 14);
		brickRec34 = new Rectangle(1297, 87, 47, 14);
		brickRec35 = new Rectangle(1329, 7, 14, 80);
		brickRec36 = new Rectangle(1422, 151, 15, 30);
		brickRec37 = new Rectangle(1440, 119, 144, 14);
		brickRec38 = new Rectangle(1473, 135, 14, 62);
		brickRec39 = new Rectangle(1489, 183, 47, 14);
		brickRec40 = new Rectangle(1605, 143, 47, 14);
		brickRec41 = new Rectangle(1665, 113, 126, 14);
		brickRec42 = new Rectangle(1872, 103, 112, 95);
		
		// Dictates the size and position of brickRecs
		
		blockRec1 = new Rectangle(2003, 167, 42, 1);
		blockRec2 = new Rectangle(2018, 119, 58, 1);
		blockRec3 = new Rectangle(2353, 104, 62, 1);
		blockRec4 = new Rectangle(2385, 167, 62, 1);
		blockRec5 = new Rectangle(2515, 151, 50, 1);
		blockRec6 = new Rectangle(2545, 120, 20, 1);
		
		// Dictates the size and position of blockRecs
		
		mb1 = new MysteryBox(896, 103);
		mb2 = new MysteryBox(1856, 135);
		
		// Dictates the position of mystery boxes
		
		c1 = new CoinSprite(140, 178);
		c2 = new CoinSprite(155, 178);
		c3 = new CoinSprite(170, 178);
		c4 = new CoinSprite(185, 178);
		c5 = new CoinSprite(200, 178);
		c6 = new CoinSprite(215, 178);
		c7 = new CoinSprite(230, 178);
		c8 = new CoinSprite(245, 178);
		c9 = new CoinSprite(260, 178);
		c10 = new CoinSprite(275, 178);
		c11 = new CoinSprite(290, 178);
		c12 = new CoinSprite(450, 22);
		c13 = new CoinSprite(465, 22);
		c14 = new CoinSprite(480, 22);
		c15 = new CoinSprite(495, 22);
		c16 = new CoinSprite(510, 22);
		c17 = new CoinSprite(547, 34);
		c18 = new CoinSprite(562, 34);
		c19 = new CoinSprite(610, 66);
		c20 = new CoinSprite(625, 66);
		c21 = new CoinSprite(640, 66);
		c22 = new CoinSprite(655, 66);
		c23 = new CoinSprite(702, 50);
		c24 = new CoinSprite(717, 50);
		c25 = new CoinSprite(732, 50);
		c26 = new CoinSprite(702, 114);
		c27 = new CoinSprite(717, 114);
		c28 = new CoinSprite(732, 114);
		c29 = new CoinSprite(747, 114);
		c30 = new CoinSprite(762, 114);
		c31 = new CoinSprite(785, 66);
		c32 = new CoinSprite(800, 66);
		c33 = new CoinSprite(815, 66);
		c34 = new CoinSprite(830, 66);
		c35 = new CoinSprite(845, 66);
		c36 = new CoinSprite(960, 162);
		c37 = new CoinSprite(975, 162);
		c38 = new CoinSprite(990, 162);
		c39 = new CoinSprite(947, 66);
		c40 = new CoinSprite(962, 66);
		c41 = new CoinSprite(977, 66);
		c42 = new CoinSprite(1045, 66);
		c43 = new CoinSprite(1060, 66);
		c44 = new CoinSprite(1045, 46);
		c45 = new CoinSprite(1060, 46);
		c46 = new CoinSprite(1045, 26);
		c47 = new CoinSprite(1060, 26);
		c48 = new CoinSprite(1150, 162);
		c49 = new CoinSprite(1165, 162);
		c50 = new CoinSprite(1180, 162);
		c51 = new CoinSprite(1195, 162);
		c52 = new CoinSprite(1150, 142);
		c53 = new CoinSprite(1165, 142);
		c54 = new CoinSprite(1180, 142);
		c55 = new CoinSprite(1195, 142);
		c56 = new CoinSprite(1150, 98);
		c57 = new CoinSprite(1169, 82);
		c58 = new CoinSprite(1169, 62);
		c59 = new CoinSprite(1187, 98);
		c60 = new CoinSprite(1283, 162);
		c61 = new CoinSprite(1298, 162);
		c62 = new CoinSprite(1313, 162);
		c63 = new CoinSprite(1328, 162);
		c64 = new CoinSprite(1343, 162);
		c65 = new CoinSprite(1358, 162);
		c66 = new CoinSprite(1373, 162);
		c67 = new CoinSprite(1388, 162);
		c68 = new CoinSprite(1403, 162);
		c69 = new CoinSprite(1283, 147);
		c70 = new CoinSprite(1298, 147);
		c71 = new CoinSprite(1313, 147);
		c72 = new CoinSprite(1328, 147);
		c73 = new CoinSprite(1343, 147);
		c74 = new CoinSprite(1358, 147);
		c75 = new CoinSprite(1373, 147);
		c76 = new CoinSprite(1388, 147);
		c77 = new CoinSprite(1403, 147);
		c78 = new CoinSprite(1283, 132);
		c79 = new CoinSprite(1298, 132);
		c80 = new CoinSprite(1313, 132);
		c81 = new CoinSprite(1328, 132);
		c82 = new CoinSprite(1343, 132);
		c83 = new CoinSprite(1358, 132);
		c84 = new CoinSprite(1373, 132);
		c85 = new CoinSprite(1388, 132);
		c86 = new CoinSprite(1403, 132);
		c87 = new CoinSprite(2002, 146);
		c88 = new CoinSprite(2017, 146);
		c89 = new CoinSprite(2032, 146);
		c90 = new CoinSprite(2019, 98);
		c91 = new CoinSprite(2034, 98);
		c92 = new CoinSprite(2049, 98);
		c93 = new CoinSprite(2064, 98);
		c94 = new CoinSprite(2002, 126);
		c95 = new CoinSprite(2017, 126);
		c96 = new CoinSprite(2032, 126);
		c97 = new CoinSprite(2019, 78);
		c98 = new CoinSprite(2034, 78);
		c99 = new CoinSprite(2049, 78);
		c100 = new CoinSprite(2064, 78);
		
		// Dictates the position of coins
		
		e1 = new Enemy(145999, 2909999, 183); // moved out of playable area to make game easier
		e2 = new Enemy(175999, 2109999, 183); // moved out of playable area to make game easier
		e3 = new Enemy(160999, 2509999, 183); // moved out of playable area to make game easier
		e4 = new Enemy(150999, 2509999, 183); // moved out of playable area to make game easier
		e5 = new Enemy(250999, 2909999, 183); // moved out of playable area to make game easier
		e6 = new Enemy(200999, 2309999, 183); // moved out of playable area to make game easier
		e7 = new Enemy(240999, 2809999, 183); // moved out of playable area to make game easier
		e8 = new Enemy(450999, 5139999, 27); // moved out of playable area to make game easier
		e9 = new Enemy(485, 500, 27);
		e10 = new Enemy(611999, 6609999, 71); // moved out of playable area to make game easier
		e11 = new Enemy(630999, 6609999, 71); // moved out of playable area to make game easier
		e12 = new Enemy(710, 740, 55);
		e13 = new Enemy(710, 770, 119);
		e14 = new Enemy(740, 770, 119);
		e15 = new Enemy(786, 850, 71);
		e16 = new Enemy(810, 850, 71);
		e17 = new Enemy(884, 912, 135);
		e18 = new Enemy(947, 977, 71);
		e19 = new Enemy(960, 990, 167);
		e20 = new Enemy(1150, 1205, 167);
		e21 = new Enemy(1234999, 12649999, 103); // moved out of playable area to make game easier
		e22 = new Enemy(1283999, 13469999, 167); // moved out of playable area to make game easier
		e23 = new Enemy(1300999, 13469999, 167); // moved out of playable area to make game easier
		e24 = new Enemy(1325999, 14109999, 167); // moved out of playable area to make game easier
		e25 = new Enemy(1350999, 14109999, 167); // moved out of playable area to make game easier
		e26 = new Enemy(1444999, 15709999, 103); // moved out of playable area to make game easier
		e27 = new Enemy(1474, 1570, 103);
		e28 = new Enemy(1504999, 15709999, 103); // moved out of playable area to make game easier
		e29 = new Enemy(1534, 1570, 103);
		e30 = new Enemy(1605, 1635, 127);
		e31 = new Enemy(1668999, 17809999, 97); // moved out of playable area to make game easier
		e32 = new Enemy(1700, 1780, 97);
		e33 = new Enemy(1730999, 17809999, 97); // moved out of playable area to make game easier
		e34 = new Enemy(1700, 1725, 97);
		e35 = new Enemy(1871999, 18909999, 87); // moved out of playable area to make game easier
		e36 = new Enemy(1885, 1970, 87);
		e37 = new Enemy(1900999, 19409999, 87); // moved out of playable area to make game easier
		e38 = new Enemy(1920, 1970, 87);
		e39 = new Enemy(19409999, 1970999, 87); // moved out of playable area to make game easier
		
		// Dictates the position of enemies
		
		s1 = new ShroomSprite (mb1.getX(), -10000000);
		
		mapRecArray[0] = floorRec1;
		mapRecArray[1] = floorRec2;
		
		// Sets the floorRecs to the array of Rectangles
		
		mapRecArray[2] = boxRec1;
		mapRecArray[3] = boxRec2;
		
		// Sets the boxRecs to the array of Rectangles
		
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
		mapRecArray[21] = brickRec18;
		mapRecArray[22] = brickRec19;
		mapRecArray[23] = brickRec20;
		mapRecArray[24] = brickRec21;
		mapRecArray[25] = brickRec22;
		mapRecArray[26] = brickRec23;
		mapRecArray[27] = brickRec24;
		mapRecArray[28] = brickRec25;
		mapRecArray[29] = brickRec26;
		mapRecArray[30] = brickRec27;
		mapRecArray[31] = brickRec28;
		mapRecArray[32] = brickRec29;
		mapRecArray[33] = brickRec30;
		mapRecArray[34] = brickRec31;
		mapRecArray[35] = brickRec32;
		mapRecArray[36] = brickRec33;
		mapRecArray[37] = brickRec34;
		mapRecArray[38] = brickRec35;
		mapRecArray[39] = brickRec36;
		mapRecArray[40] = brickRec37;
		mapRecArray[41] = brickRec38;
		mapRecArray[42] = brickRec39;
		mapRecArray[43] = brickRec40;
		mapRecArray[44] = brickRec41;
		mapRecArray[45] = brickRec42;
		
		// Sets the brickRecs to the array of Rectangles
	
		mapRecArray[46] = blockRec1;
		mapRecArray[47] = blockRec2;
		mapRecArray[48] = blockRec3;
		mapRecArray[49] = blockRec4;
		mapRecArray[50] = blockRec5;
		mapRecArray[51] = blockRec6;
		
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
		floorRec2.setBounds(1825 + userSprite.currMapPosX, (int)floorRec2.getY(), (int)floorRec2.getWidth(), (int)floorRec2.getHeight());
		
		// Sets the bounds of floorRecs
		
		boxRec1.setBounds(896 + userSprite.currMapPosX, (int)boxRec1.getY(), (int)boxRec1.getWidth(), (int)boxRec1.getHeight());
		boxRec2.setBounds(1856 + userSprite.currMapPosX, (int)boxRec2.getY(), (int)boxRec2.getWidth(), (int)boxRec2.getHeight());
		
		// Sets the bounds of boxRecs
		
		brickRec1.setBounds(309 + userSprite.currMapPosX, (int)brickRec1.getY(), (int)brickRec1.getWidth(), (int)brickRec1.getHeight());
		brickRec2.setBounds(323 + userSprite.currMapPosX, (int)brickRec2.getY(), (int)brickRec2.getWidth(), (int)brickRec2.getHeight());
		brickRec3.setBounds(337 + userSprite.currMapPosX, (int)brickRec3.getY(), (int)brickRec3.getWidth(), (int)brickRec3.getHeight());
		brickRec4.setBounds(351 + userSprite.currMapPosX, (int)brickRec4.getY(), (int)brickRec4.getWidth(), (int)brickRec4.getHeight());
		brickRec5.setBounds(365 + userSprite.currMapPosX, (int)brickRec5.getY(), (int)brickRec5.getWidth(), (int)brickRec5.getHeight());
		brickRec6.setBounds(379 + userSprite.currMapPosX, (int)brickRec6.getY(), (int)brickRec6.getWidth(), (int)brickRec6.getHeight());
		brickRec7.setBounds(393 + userSprite.currMapPosX, (int)brickRec7.getY(), (int)brickRec7.getWidth(), (int)brickRec7.getHeight());
		brickRec8.setBounds(407 + userSprite.currMapPosX, (int)brickRec8.getY(), (int)brickRec8.getWidth(), (int)brickRec8.getHeight());
		brickRec9.setBounds(421 + userSprite.currMapPosX, (int)brickRec9.getY(), (int)brickRec9.getWidth(), (int)brickRec9.getHeight());
		brickRec10.setBounds(435 + userSprite.currMapPosX, (int)brickRec10.getY(), (int)brickRec10.getWidth(), (int)brickRec10.getHeight());
		brickRec11.setBounds(449 + userSprite.currMapPosX, (int)brickRec11.getY(), (int)brickRec11.getWidth(), (int)brickRec11.getHeight());
		brickRec12.setBounds(545 + userSprite.currMapPosX, (int)brickRec12.getY(), (int)brickRec12.getWidth(), (int)brickRec12.getHeight());
		brickRec13.setBounds(608 + userSprite.currMapPosX, (int)brickRec13.getY(), (int)brickRec13.getWidth(), (int)brickRec13.getHeight());
		brickRec14.setBounds(673 + userSprite.currMapPosX, (int)brickRec14.getY(), (int)brickRec14.getWidth(), (int)brickRec14.getHeight());
		brickRec15.setBounds(705 + userSprite.currMapPosX, (int)brickRec15.getY(), (int)brickRec15.getWidth(), (int)brickRec15.getHeight());
		brickRec16.setBounds(705 + userSprite.currMapPosX, (int)brickRec16.getY(), (int)brickRec16.getWidth(), (int)brickRec16.getHeight());
		brickRec17.setBounds(785 + userSprite.currMapPosX, (int)brickRec17.getY(), (int)brickRec17.getWidth(), (int)brickRec17.getHeight());
		brickRec18.setBounds(850 + userSprite.currMapPosX, (int)brickRec18.getY(), (int)brickRec18.getWidth(), (int)brickRec18.getHeight());
		brickRec19.setBounds(880 + userSprite.currMapPosX, (int)brickRec19.getY(), (int)brickRec19.getWidth(), (int)brickRec19.getHeight());
		brickRec20.setBounds(913 + userSprite.currMapPosX, (int)brickRec20.getY(), (int)brickRec20.getWidth(), (int)brickRec20.getHeight());
		brickRec21.setBounds(960 + userSprite.currMapPosX, (int)brickRec21.getY(), (int)brickRec21.getWidth(), (int)brickRec21.getHeight());
		brickRec22.setBounds(944 + userSprite.currMapPosX, (int)brickRec22.getY(), (int)brickRec22.getWidth(), (int)brickRec22.getHeight());
		brickRec23.setBounds(992 + userSprite.currMapPosX, (int)brickRec23.getY(), (int)brickRec23.getWidth(), (int)brickRec23.getHeight());
		brickRec24.setBounds(1040 + userSprite.currMapPosX, (int)brickRec24.getY(), (int)brickRec24.getWidth(), (int)brickRec24.getHeight());
		brickRec25.setBounds(1045 + userSprite.currMapPosX, (int)brickRec25.getY(), (int)brickRec25.getWidth(), (int)brickRec25.getHeight());
		brickRec26.setBounds(1105 + userSprite.currMapPosX, (int)brickRec26.getY(), (int)brickRec26.getWidth(), (int)brickRec26.getHeight());
		brickRec27.setBounds(1120 + userSprite.currMapPosX, (int)brickRec27.getY(), (int)brickRec27.getWidth(), (int)brickRec27.getHeight());
		brickRec28.setBounds(1153 + userSprite.currMapPosX, (int)brickRec28.getY(), (int)brickRec28.getWidth(), (int)brickRec28.getHeight());
		brickRec29.setBounds(1169 + userSprite.currMapPosX, (int)brickRec29.getY(), (int)brickRec29.getWidth(), (int)brickRec29.getHeight());
		brickRec30.setBounds(1153 + userSprite.currMapPosX, (int)brickRec30.getY(), (int)brickRec30.getWidth(), (int)brickRec30.getHeight());
		brickRec31.setBounds(1233 + userSprite.currMapPosX, (int)brickRec31.getY(), (int)brickRec31.getWidth(), (int)brickRec31.getHeight());
		brickRec32.setBounds(1265 + userSprite.currMapPosX, (int)brickRec32.getY(), (int)brickRec32.getWidth(), (int)brickRec32.getHeight());
		brickRec33.setBounds(1233 + userSprite.currMapPosX, (int)brickRec33.getY(), (int)brickRec33.getWidth(), (int)brickRec33.getHeight());
		brickRec34.setBounds(1297 + userSprite.currMapPosX, (int)brickRec34.getY(), (int)brickRec34.getWidth(), (int)brickRec34.getHeight());
		brickRec35.setBounds(1329 + userSprite.currMapPosX, (int)brickRec35.getY(), (int)brickRec35.getWidth(), (int)brickRec35.getHeight());
		brickRec36.setBounds(1422 + userSprite.currMapPosX, (int)brickRec36.getY(), (int)brickRec36.getWidth(), (int)brickRec36.getHeight());
		brickRec37.setBounds(1440 + userSprite.currMapPosX, (int)brickRec37.getY(), (int)brickRec37.getWidth(), (int)brickRec37.getHeight());
		brickRec38.setBounds(1473 + userSprite.currMapPosX, (int)brickRec38.getY(), (int)brickRec38.getWidth(), (int)brickRec38.getHeight());
		brickRec39.setBounds(1489 + userSprite.currMapPosX, (int)brickRec39.getY(), (int)brickRec39.getWidth(), (int)brickRec39.getHeight());
		brickRec40.setBounds(1605 + userSprite.currMapPosX, (int)brickRec40.getY(), (int)brickRec40.getWidth(), (int)brickRec40.getHeight());
		brickRec41.setBounds(1665 + userSprite.currMapPosX, (int)brickRec41.getY(), (int)brickRec41.getWidth(), (int)brickRec41.getHeight());
		brickRec42.setBounds(1872 + userSprite.currMapPosX, (int)brickRec42.getY(), (int)brickRec42.getWidth(), (int)brickRec42.getHeight());
		
		// Sets the bounds of brickRecs
		
		blockRec1.setBounds(2003 + userSprite.currMapPosX, (int)blockRec1.getY(), (int)blockRec1.getWidth(), (int)blockRec1.getHeight());
		blockRec2.setBounds(2018 + userSprite.currMapPosX, (int)blockRec2.getY(), (int)blockRec2.getWidth(), (int)blockRec2.getHeight());
		blockRec3.setBounds(2353 + userSprite.currMapPosX, (int)blockRec3.getY(), (int)blockRec3.getWidth(), (int)blockRec3.getHeight());
		blockRec4.setBounds(2385 + userSprite.currMapPosX, (int)blockRec4.getY(), (int)blockRec4.getWidth(), (int)blockRec4.getHeight());
		blockRec5.setBounds(2515 + userSprite.currMapPosX, (int)blockRec5.getY(), (int)blockRec5.getWidth(), (int)blockRec5.getHeight());
		blockRec6.setBounds(2545 + userSprite.currMapPosX, (int)blockRec6.getY(), (int)blockRec6.getWidth(), (int)blockRec6.getHeight());
		
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
				g2d.drawString("Map 3", 175, 50);
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
		g2d.drawImage(map3.getImage(), userSprite.currMapPosX, 0, null); // Draws the map
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
		g2d.drawString("CurrMapPosX" + userSprite.currMapPosX, 0, 30);
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