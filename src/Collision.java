/*
 Collision.Java (for Super Mario: The Zakaryan Strikes Back)
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

//Imports specific packages needed for the code

public class Collision {

	private Rectangle lowerArray[]; // Creates a Rectangle array
	private Rectangle higherArray[]; // Creates a Rectangle array
	public Rectangle recLower, recHigher; // Creates public rectangles
	private Rectangle[] mapRecArray; // Creates a Rectangle array
	private MarioSprite userSprite; // Creates a MarioSprite
	public CoinCollision CoinCollision; // Creates a CoinCollision
	public EnemyCollision EnemyCollision; // Creates an EnemyCollision

	public Collision(Rectangle[] mapInput) {
		mapRecArray = mapInput; // mapRecArray is set equal to mapInput
		lowerArray = new Rectangle[mapRecArray.length]; // lowerArray is set
														// equal to the length
														// of mapRecArray
		higherArray = new Rectangle[mapRecArray.length]; // higherArray is set
															// equal to the
															// length of
															// mapRecArray
	}

	public void add(MarioSprite userInput, CoinCollision coinInput,
			EnemyCollision enemyInput) {
		userSprite = userInput; // userSprite is set equal to userInput
		CoinCollision = coinInput; // coinCollision is set equal to coinInput
		EnemyCollision = enemyInput; // enemyCollision is set equal to
										// enemyInput
	}

	public void checkBelow() {

		boolean done1 = false, done2 = false, done3 = false; // Creates
																// booleans, all
																// are set to
																// false

		recLower = new Rectangle(1000, 1000, 1000, 1000); // Sets the position
															// and size of
															// recLower
		recHigher = new Rectangle(0, 0, 0, 0); // Sets the position and size of
												// recHigher

		for (int i = 0; i <= mapRecArray.length - 1; i++) { // a for loop
			lowerArray[i] = new Rectangle(1000, 1000, 1000, 1000); // Sets the
																	// position
																	// and size
																	// of
																	// lowerArray
			higherArray[i] = new Rectangle(0, 0, 0, 0); // Sets the position and
														// size of higherArray
			if (userSprite.x + 12 >= mapRecArray[i].getX()
					&& userSprite.x <= mapRecArray[i].getX()
							+ mapRecArray[i].getWidth()) { // If the user is
															// colliding with
															// the X position of
															// the map Rec...
				if (userSprite.y + 16 <= mapRecArray[i].getY()) { // If the user
																	// is
																	// colliding
																	// below the
																	// mapRecArray...
					lowerArray[i] = mapRecArray[i]; // Sets the lowerArray to
													// mapRecArray
				}
				if (userSprite.y >= mapRecArray[i].getY()
						+ mapRecArray[i].getHeight()) { // If the user is
														// colliding above the
														// mapRecArray...
					higherArray[i] = mapRecArray[i]; // Sets the higherArray to
														// mapRecArray
				}
			}
			if (i == mapRecArray.length - 1)
				done1 = true; // If "i" is equal to the mapRecArray subtract
								// one, then done1 is set to true
		}

		// Lower
		if (done1) { // If done1 is true...
			for (int i = 0; i <= mapRecArray.length - 1; i++) { // a for loop
				if (lowerArray[i].getY() - (userSprite.y + 16) < recLower
						.getY() - (userSprite.y + 16)) { // If the user is
															// colliding below
															// the Rec...
					recLower = lowerArray[i]; // recLower is set to lowerArray
				}
				if (i == mapRecArray.length - 1)
					done2 = true; // If "i" is equal to the mapRecArray subtract
									// one, then done2 is set to true
			}
		}

		// Higher
		if (done2) { // If done2 is true...
			for (int i = 0; i <= mapRecArray.length - 1; i++) { // a for loop
				if (Math.abs(userSprite.y + 16 - higherArray[i].getY()) < Math
						.abs(userSprite.y + 16 - recHigher.getY())) { // If the
																		// user
																		// is
																		// colliding
																		// above
																		// the
																		// Rec...
					recHigher = higherArray[i]; // recHigher is set to
												// higherArray
				}
				if (i == mapRecArray.length - 1)
					done3 = true; // If "i" is equal to the mapRecArray subtract
									// one, then done3 is set to true
			}
		}

		if (done3) { // If done3 is true...
			if (userSprite.y + 16 < recLower.getY()) { // If the user's Y
														// position is below the
														// recLower...
				userSprite.y += 10; // Stops the user's jump
				if (!userSprite.invincible)
					EnemyCollision.bigCheckBelow(); // Checks below for enemy
												// collision
				CoinCollision.collision(); // Checks for collision with coins
			}
			if (userSprite.y + 16 >= recLower.getY()) { // If the user's Y
														// position is above the
														// recLower...
				userSprite.y = (int) (recLower.getY() - 16); // The user's Y
																// position is
																// set to
																// recLower
																// subtract 16
				CoinCollision.collision(); // Checks for collision with coins
			}
		}

		userSprite.checkFall(); // Checks if user is falling
	}

	public void checkRight() {

		if (!userSprite.middle) { // If middle is false...
			for (int i = 0; i <= mapRecArray.length - 1; i++) { // a for loop
				if (userSprite.x + 12 >= mapRecArray[i].getX()
						&& userSprite.x + 12 <= mapRecArray[i].getX()
								+ mapRecArray[i].getWidth()) { // If the user is
																// colliding
																// with the X
																// position of
																// the map
																// Rec...
					if (mapRecArray[i] != lowerArray[i]
							&& mapRecArray[i] != higherArray[i]) // If the map
																	// Rec isn't
																	// equal to
																	// lower or
																	// higher
																	// array...
						userSprite.x = (int) (mapRecArray[i].getX() - 12); // The
																			// X
																			// position
																			// of
																			// userSprite
																			// is
																			// set
																			// equal
																			// to
																			// the
																			// mapRecArray
																			// X
																			// position
																			// subtract
																			// 12
				}
			}
		}

		if (userSprite.middle) { // If middle is true...
			for (int i = 0; i <= mapRecArray.length - 1; i++) { // a for loop
				if (userSprite.x + 12 >= mapRecArray[i].getX()
						&& userSprite.x + 12 <= mapRecArray[i].getX()
								+ mapRecArray[i].getWidth()) { // If the user is
																// colliding
																// with the X
																// position of
																// the map
																// Rec...
					if (mapRecArray[i] != lowerArray[i]
							&& mapRecArray[i] != higherArray[i]) // If the map
																	// Rec isn't
																	// equal to
																	// lower or
																	// higher
																	// array...
						userSprite.currMapPosX += userSprite.dx; // The
																	// userSprite's
																	// currMapPosX
																	// is set to
																	// the
																	// displacement
																	// of
																	// userSprite
				}
			}
		}
	}

	public void checkLeft() {

		if (!userSprite.middle) { // If middle is false...
			for (int i = 0; i <= mapRecArray.length - 1; i++) { // a for loop
				if (userSprite.x + 12 >= mapRecArray[i].getX()
						&& userSprite.x + 12 <= mapRecArray[i].getX()
								+ mapRecArray[i].getWidth()) { // If the user is
																// colliding
																// with the X
																// position of
																// the map
																// Rec...
					if (mapRecArray[i] != lowerArray[i]
							&& mapRecArray[i] != higherArray[i]) // If the map
																	// Rec isn't
																	// equal to
																	// lower or
																	// higher
																	// array...
						userSprite.x = (int) (mapRecArray[i].getX() + mapRecArray[i]
								.getWidth()); // The X position of the
												// userSprite is set equal to
												// the sum of mapRecArray X
												// position and the width of the
												// mapRecArray
				}
			}
		}

		if (userSprite.middle) { // If middle is true...
			for (int i = 0; i <= mapRecArray.length - 1; i++) { // a for loop
				if (userSprite.x >= mapRecArray[i].getX()
						&& userSprite.x <= mapRecArray[i].getX()
								+ mapRecArray[i].getWidth()) { // If the user is
																// colliding
																// with the X
																// position of
																// the map
																// Rec...
					if (mapRecArray[i] != lowerArray[i]
							&& mapRecArray[i] != higherArray[i]) // If the map
																	// Rec isn't
																	// equal to
																	// lower or
																	// higher
																	// array...
						userSprite.currMapPosX += userSprite.dx; // The
																	// userSprite's
																	// currMapPosX
																	// is set to
																	// the
																	// displacement
																	// of
																	// userSprite
				}
			}
		}
	}

	public boolean checkAbove() {

		boolean collide = false; // Creates the boolean collide to false;

		for (int i = 0; i < mapRecArray.length - 1; i++) { // a for loop
			if (userSprite.x <= mapRecArray[i].getX()
					+ mapRecArray[i].getWidth()
					&& userSprite.x >= mapRecArray[i].getX()) { // If the user
																// is colliding
																// with the X
																// position of
																// the map
																// Rec...
				if (userSprite.y - 10 >= mapRecArray[i].getY()
						&& userSprite.y - 10 <= mapRecArray[i].getY()
								+ mapRecArray[i].getHeight()) { // If the user
																// is colliding
																// with the Y
																// position of
																// the map
																// Rec...
					collide = true; // Collide is set to true
				}
			}
		}
		return collide; // Returns collide
	}
}