/*
 CoinCollision.Java (for Super Mario: The Zakaryan Strikes Back)
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
import javax.swing.*;

//Imports specific packages needed for the code

public class CoinCollision {

	ImageIcon empty = new ImageIcon(); // Creates an imageicon
	private CoinSprite[] coinArray; // Creates a coinsprite
	private MarioSprite userSprite; // Creates a mariosprite

	public CoinCollision(CoinSprite[] coinInput) {
		coinArray = coinInput; // sets the coinArray equal to coinInput
	}

	public void addUserSprite(MarioSprite userInput) {
		userSprite = userInput; // sets the userSprite equal to userInput
	}

	public void collision() {

		empty = new ImageIcon("resources/empty.png"); // Sets the imageIcon to
														// empty

		for (int i = 0; i < coinArray.length; i++) { // a for loop
			if (userSprite.y + 16 >= coinArray[i].getY()
					&& userSprite.y <= coinArray[i].getY() + 16
					&& userSprite.x + 16 >= coinArray[i].getX()
					&& userSprite.x <= coinArray[i].getX() + 16) {

				// Detects if the user is colliding with the coin

				coinArray[i].stop(); // Stops at the specific mysteryBox
				if (coinArray[i].getImage() != empty.getImage()) // If the
																	// coinSprite
																	// isn't
																	// equal to
																	// empty...
					userSprite.addCoin(); // Adds a coin
				if (coinArray[i].taken == false) { // If the coin isn't taken...
					try { // A try/catch
						Sound.playActionMusic("nsmb_coin.wav"); // Plays a song
						coinArray[i].taken = true; // Taken becomes true
					} catch (Exception e) { // Catches an error
						// TODO Auto-generated catch block
						e.printStackTrace(); // Prints out the error
					}
				}
				coinArray[i].setImage(empty); // The coinArray is set to empty
			}
		}
	}

	public void bigCollision() {

		empty = new ImageIcon("resources/empty.png"); // Sets the imageicon to
														// empty

		for (int i = 0; i < coinArray.length; i++) { // a for loop
			if (userSprite.y + 16 >= coinArray[i].getY()
					&& userSprite.y <= coinArray[i].getY() + 16
					&& userSprite.x + 16 >= coinArray[i].getX()
					&& userSprite.x <= coinArray[i].getX() + 16) {

				// Detects if the user is colliding with the coin

				coinArray[i].stop(); // Stops at the specific coin
				if (coinArray[i].getImage() != empty.getImage()) // If the
																	// coinSprite
																	// isn't
																	// equal to
																	// empty...
					userSprite.addCoin(); // Adds a coin
				if (coinArray[i].taken == false) { // If the coin isn't taken...
					try { // A try/catch
						Sound.playActionMusic("nsmb_coin.wav"); // Plays a song
						coinArray[i].taken = true; // Taken becomes true
					} catch (Exception e) { // Catches an error
						// TODO Auto-generated catch block
						e.printStackTrace(); // Prints out the error
					}
				}
				coinArray[i].setImage(empty); // The coinArray is set to empty
			}
		}
	}
}
