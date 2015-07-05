/*

 CoinSprite.Java (for Super Mario: The Zakaryan Strikes Back)
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

public class CoinSprite {

	private final int fx;
	private static int width;
	private int x;
	private int y;
	private Image still;
	private ImageIcon c1, c2, c3, c4;
	static ImageIcon cEmpty;
	private int i = 0; // Frame counter for animation
	public boolean taken = false;

	// Decelerations for integers, ImageIcons, and an image

	public CoinSprite(int xi, int yi) {

		c1 = new ImageIcon("resources/c1.png");
		c2 = new ImageIcon("resources/c2.png");
		c3 = new ImageIcon("resources/c3.png");
		c4 = new ImageIcon("resources/c4.png");
		cEmpty = new ImageIcon("resources/empty.png");

		// The ImageIcons are set to the pictures

		still = c1.getImage(); // The image still is set to c1
		fx = xi; // fx equals xi
		x = fx; // x equals fx
		y = yi; // y equals yi
	}

	public CoinSprite() {

		c1 = new ImageIcon("resources/c1.png");
		c2 = new ImageIcon("resources/c2.png");
		c3 = new ImageIcon("resources/c3.png");
		c4 = new ImageIcon("resources/c4.png");
		cEmpty = new ImageIcon("resources/empty.png");

		// The ImageIcons are set to the pictures

		fx = x; // fx is equal to x
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

	public void move(int dx) { // Moves the coin across the map
		x = fx + dx; // x is equal to fx + dx
	}

	public void animate() { // Animates the coin

		i++; // i is equal to i + 1
		if (i == 1)
			still = c2.getImage();
		if (i == 2)
			still = c3.getImage();
		if (i == 3)
			still = c4.getImage();
		if (i == 4) {
			still = c1.getImage();
			i = 0;

			// If statements that switch between the pictures, causing animation
		}
	}

	public void stop() {
		i = 5; // i is equal to 5
	}

	public void setImage(ImageIcon i) {
		still = i.getImage(); // Still is set to the ImageIcon i
	}

	public static int getWidth() { // Gets the width of the coin

		width = 16; // Width is set to 16
		return width; // Returns width
	}
}