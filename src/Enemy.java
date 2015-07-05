/*
 Enemy.Java (for Super Mario: The Zakaryan Strikes Back)
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
import java.util.*;
import javax.swing.*;

//Imports specific packages needed for the code

public class Enemy {

	private final int fxi; // Declares a final integer
	private final int fxf; // Declares a final integer
	private int x; // Declares an integer
	private int y; // Declares an integer
	private Image still; // Declares an Image
	private ImageIcon el1, el2, er1, er2, erd, eld; // Declares an ImageIcon
	private int i = 0; // Declares an integer
	private int fi; // Declares an integer
	private int j = 0; // Declares an integer
	private boolean forward; // Declares a boolean
	private boolean dead; // Declares a boolean
	Random enemyGen = new Random(); // Declares a random generator
	boolean cannotDie = false; // Declares a boolean

	public Enemy(int xi, int xif, int yi) {

		int i = enemyGen.nextInt(13) + 1; // Generators random integers between
											// 1 and 13

		if (i == 1 || i == 5 || i == 8 || i == 11) { // If the random integer is
														// equal to 1, the
														// enemies are set to
														// pictures of goombas

			el1 = new ImageIcon("resources/goomba1.png");
			el2 = new ImageIcon("resources/goomba2.png");
			er1 = new ImageIcon("resources/goomba1.png");
			er2 = new ImageIcon("resources/goomba2.png");
			erd = new ImageIcon("resources/goombad.png");
			eld = new ImageIcon("resources/goombad.png");

			// Sets the ImageIcons to the pictures

		} else if (i == 2 || i == 6 || i == 9 || i == 12) { // If the random
															// integer is equal
															// to 2, the enemies
															// are set to
															// pictures of
															// ghosts

			el1 = new ImageIcon("resources/ghostL1.png");
			el2 = new ImageIcon("resources/ghostL2.png");
			er1 = new ImageIcon("resources/ghostR1.png");
			er2 = new ImageIcon("resources/ghostR2.png");
			erd = new ImageIcon("resources/ghostRd.png");
			eld = new ImageIcon("resources/ghostLd.png");

			// Sets the ImageIcons to the pictures

		} else if (i == 3 || i == 7 || i == 10 || i == 13) { // If the random
																// integer is
																// equal to 3,
																// the enemies
																// are set to
																// pictures of
																// shyguys

			el1 = new ImageIcon("resources/shyguyL1.png");
			el2 = new ImageIcon("resources/shyguyL2.png");
			er1 = new ImageIcon("resources/shyguyR1.png");
			er2 = new ImageIcon("resources/shyguyR2.png");
			erd = new ImageIcon("resources/shyguyRd.png");
			eld = new ImageIcon("resources/shyguyLd.png");

			// Sets the ImageIcons to the pictures

		} else if (i == 4) { // If the random integer is equal to 1, the enemies
								// are set to pictures of porcupines

			cannotDie = true;

			el1 = new ImageIcon("resources/porcupineL.png");
			el2 = new ImageIcon("resources/porcupineL.png");
			er1 = new ImageIcon("resources/porcupineR.png");
			er2 = new ImageIcon("resources/porcupineR.png");
			erd = new ImageIcon("resources/porcupineR.png");
			eld = new ImageIcon("resources/porcupineL.png");

			// Sets the ImageIcons to the pictures
		}

		still = er1.getImage(); // Sets still to the ImageIcon er1
		fxi = xi; // fxi equals xi
		x = fxi; // x equals fxi
		fxf = xif; // fxf equals xif
		y = yi; // y equals yi
		fi = (fxf - fxi) / 3; // fi equals the the final subtract the intital
								// fx, divided by 3
		forward = true; // Sets the boolean to true
		dead = false; // Sets the boolean to false
	}

	public int getX() {
		return x; // Returns x
	}

	public int getY() {
		return y; // Returns y
	}

	public Image getImage() {
		return still; // Returns the image still
	}

	public void move(int currMapPosX) {
		if (!dead) { // If dead is false...
			if (forward) { // If forward is true...
				i++; // i equals i + 1
				if (fi - i != 0) { // If fi subtract i does not equal zero...
					x = fxi + currMapPosX + i * 3; // x is equal to fxi + the
													// currMapPosX + i
													// multiplied by 3
					j++; // j equals j + 1
					if (j == 1) // If j equals 1...
						still = er2.getImage(); // Still is set to enemy picture
												// facing right
					if (j == 2) { // If j equals 2...
						still = er1.getImage(); // Still is set to enemy picture
												// facing right
						j = 0; // j is set to zero
					}
				} else { // If fi subtract i does equal zero...
					forward = false; // Forward is set to false
					i = 0; // i is set to zero
				}
			}

			if (!forward) { // If forward is false...
				i++; // i equals i + 1
				if (fi - i != 0) { // If fi - i does not equal zero...
					x = fxf + currMapPosX - i * 3; // x is equal to fxf +
													// currMapPosX - i
													// multiplied by 3
					j++; // j equals j + 1
					if (j == 1) // If j is equal to 1...
						still = el2.getImage(); // Still is set to enemy picture
												// facing left
					if (j == 2) { // If j is equal to 2...
						still = el1.getImage(); // Still is set to enemy picture
												// facing left
						j = 0; // j is set to zero
					}
				} else { // If fi - i does equal zero...
					forward = true; // Forward is set to true
					i = 0; // i is set to zero
				}

			}
		} else { // If dead is equal to true...
			if (forward) // If forward is true...
				x = fxi + currMapPosX + i * 3; // x is equal to fxi +
												// currMapPosX + i multiplied by
												// 3
			if (!forward) // If forward isn't true...
				x = fxf + currMapPosX - i * 3; // x is equal to fxf +
												// currMapPosX - i multiplied by
												// 3
			j++; // j is equal to j + 1
			ImageIcon empty = new ImageIcon("resources/empty.png"); // ImageIcon
																	// is set to
																	// the
																	// picture
																	// of
																	// "empty"
			if (j >= 5) { // If j is greater than or equal to 5...
				still = empty.getImage(); // Still is set to the picture of
											// "empty"
				x = -100000; // x is set to that value
			}
		}
	}

	public void killed() { // Kills the enemy

		if (cannotDie == false) { // If cannotDie is false...

			if (forward) { // If forward is true...
				still = erd.getImage(); // Still is set to the picture of the
										// enemy facing right when it dies
			} else {
				still = eld.getImage(); // Still is set to the picture of the
										// enemy facing left when it dies
			}
			j = 0; // j is set to zero
			y += 7; // y equals y + 7
			dead = true; // Dead is set to true

		}
	}
}
