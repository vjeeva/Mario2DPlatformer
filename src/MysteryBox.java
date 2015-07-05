/*
 MysteryBox.Java (for Super Mario: The Zakaryan Strikes Back)
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
import javax.swing.*;

//Imports specific packages needed for the code

public class MysteryBox {

	private final int fx;
	private int x;
	private int y;
	private Image still;
	private ImageIcon mb1, mb2, mb3, mb4;
	public static ImageIcon mbe;
	private int i = 0; //Frame counter for animation
	
	// Decelerations for integers, ImageIcons, and an image
	
	public MysteryBox(int xi, int yi) {

		mb1 = new ImageIcon("resources/mb1.png");
		mb2 = new ImageIcon("resources/mb2.png");
		mb3 = new ImageIcon("resources/mb3.png");
		mb4 = new ImageIcon("resources/mb4.png");
		mbe = new ImageIcon("resources/mbe.png");
		
		// The ImageIcons are set to the pictures

		still = mb1.getImage(); // The image still is set to mb1

		fx = xi; // fx equals xi
		x = fx; // x equals fx
		y = yi; // y equals yi
	}

	public int getX() {
		return x; // Returns X
	}

	public int getY() {
		return y; // Returns Y
	}

	public Image getImage() {
		return still; // Returns the image still
	}

	public void setImage(ImageIcon i) {
		still = i.getImage(); // Sets the image to i
	}
	public void move(int dx) {
		x = fx + dx; // x is equal to 
	}

	public void animate() { // Animates the coins

		i++; // i is equal to i + 1
		if (i == 1)
			still = mb2.getImage();
		if (i == 2)
			still = mb3.getImage();
		if (i == 3)
			still = mb4.getImage();
		if (i == 4) {
			still = mb1.getImage();
			i = 0;
		
		// If statements that switch between the pictures, causing animation
		}
	}
	public void stop() {
		i = 5; // Sets i to 5
	}
}
