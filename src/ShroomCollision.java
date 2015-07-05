/*
 ShroomCollision.Java (for Super Mario: The Zakaryan Strikes Back)
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

import javax.swing.ImageIcon;

//Imports specific packages needed for the code

public class ShroomCollision {

	ImageIcon empty = new ImageIcon(); // Creates an imageicon
	private ShroomSprite[] shroomArray; // Creates an array
	private MarioSprite userSprite; // Creates a mariosprite

	public ShroomCollision(ShroomSprite[] shroomInput) {
		shroomArray = shroomInput; // Sets the array equal to shroominput
	}

	public void addUserSprite(MarioSprite userInput) {
		userSprite = userInput;// sets usersprite equal to userinput
	}

	public void collision() {

		empty = new ImageIcon("resources/empty.png"); // Sets the imageicon to a picture of empty

		for (int i = 0; i < shroomArray.length; i++) {
			if (userSprite.y + 16 >= shroomArray[i].getY()
					&& userSprite.y <= shroomArray[i].getY() + 16
					&& userSprite.x + 16 >= shroomArray[i].getX()
					&& userSprite.x <= shroomArray[i].getX() + 16
					&& shroomArray[i].hit() == true) {
				
				// Detects if the user is colliding with the mushroom sprite
				
				shroomArray[i].setY(-100000);// Sets the shroom off the map
				shroomArray[i].setImage(ShroomSprite.cEmpty); // sets the image
				if (MainMenu.mapNumber == 1) {
					if (!Map1.big) { // if the user is not big...
						Map1.big = true; // The user becomes big if he touches the mushroom
						try { // A try catch statement
							Sound.playActionMusic("nsmb_power-up.wav"); // Plays a song
						} catch (Exception e) { // Catches an error
							// TODO Auto-generated catch block
							e.printStackTrace();// Prints the error
						}
					} else // If the user is already big...
						Map1.lives++;// Increase the player's life by one
				} else if (MainMenu.mapNumber == 2) {
					if (!Map2.big) { // if the user is not big...
						Map2.big = true; // The user becomes big if he touches the mushroom
						try { // A try catch statement
							Sound.playActionMusic("nsmb_power-up.wav"); // Plays a song
						} catch (Exception e) { // Catches an error
							// TODO Auto-generated catch block
							e.printStackTrace();// Prints the error
						}
					} else // If the user is already big...
						Map2.lives++;// Increase the player's life by one
				} else if (MainMenu.mapNumber == 3) {
					if (!Map3.big) { // if the user is not big...
						Map3.big = true; // The user becomes big if he touches the mushroom
						try { // A try catch statement
							Sound.playActionMusic("nsmb_power-up.wav"); // Plays a song
						} catch (Exception e) { // Catches an error
							// TODO Auto-generated catch block
							e.printStackTrace();// Prints the error
						}
					} else // If the user is already big...
						Map3.lives++;// Increase the player's life by one
				} else if (MainMenu.mapNumber == 4) {
					if (!Map4.big) { // if the user is not big...
						Map4.big = true; // The user becomes big if he touches the mushroom
						try { // A try catch statement
							Sound.playActionMusic("nsmb_power-up.wav"); // Plays a song
						} catch (Exception e) { // Catches an error
							// TODO Auto-generated catch block
							e.printStackTrace();// Prints the error
						}
					} else // If the user is already big...
						Map4.lives++;// Increase the player's life by one
				} else if (MainMenu.mapNumber == 5) {
					if (!Map5.big) { // if the user is not big...
						Map5.big = true; // The user becomes big if he touches the mushroom
						try { // A try catch statement
							Sound.playActionMusic("nsmb_power-up.wav"); // Plays a song
						} catch (Exception e) { // Catches an error
							// TODO Auto-generated catch block
							e.printStackTrace();// Prints the error
						}
					} else // If the user is already big...
						Map5.lives++;// Increase the player's life by one
				} else if (MainMenu.mapNumber == 6) {
					if (!Map6.big) { // if the user is not big...
						Map6.big = true; // The user becomes big if he touches the mushroom
						try { // A try catch statement
							Sound.playActionMusic("nsmb_power-up.wav"); // Plays a song
						} catch (Exception e) { // Catches an error
							// TODO Auto-generated catch block
							e.printStackTrace();// Prints the error
						}
					} else // If the user is already big...
						Map6.lives++;// Increase the player's life by one
				} else if (MainMenu.mapNumber == 7) {
					if (!Map7.big) { // if the user is not big...
						Map7.big = true; // The user becomes big if he touches the mushroom
						try { // A try catch statement
							Sound.playActionMusic("nsmb_power-up.wav"); // Plays a song
						} catch (Exception e) { // Catches an error
							// TODO Auto-generated catch block
							e.printStackTrace();// Prints the error
						}
					} else // If the user is already big...
						Map7.lives++;// Increase the player's life by one
				}
			}
		}
	}
}

