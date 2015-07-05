/*
 ShroomSprite.Java (for Super Mario: The Zakaryan Strikes Back)
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
// Import the specific packages necessary such as ImageIcon and Image 

public class ShroomSprite { 

	private final int fx;//Decalring total shroom displacement  
	private static int width;//Decalring width 
	private int x;//Decalring x
	private int y;//Decalring y 
	private Image still;//Declaring the still image 
	static ImageIcon s1;//Declating the ImagIcon for the shroom 
	static ImageIcon cEmpty;//Declaring the empty ImageIcon for the shroom 

	public ShroomSprite(int xi, int yi) {

		s1 = new ImageIcon("resources/s1.png");
		cEmpty = new ImageIcon("resources/empty.png");

		still = cEmpty.getImage();//Assigning the Empty Image to still
		fx = xi;//Assigning x position to the total shroom displacement of the shroom
		x = fx;//Assigning that to x
		y = yi;//Assigning the y position of the shroom the normal y postiion intiallly assigned 
	}

	public ShroomSprite() {
		
		s1 = new ImageIcon("resources/s1.png");//Assisgning the shroom pic to s1
		cEmpty = new ImageIcon("resources/empty.png");//Declaring the cEmpty as an empty transparent ImageIcon
		fx = x;//
	}

	public int getX() {//Method to get X coordinate 
		return x;
	}

	public int getY() {//Method to get Y coordinate 
		return y;
	}

	public Image getImage() {//returns the current state of still as an image type 
		return still;
	}

	public void move(int dx) {//The move method for the shroom with dx as the movement distance parameter 
		x = fx + dx; // Changing the x coordinate of the shroom to allow it to move infinitely by using dx 
	}


	public void setImage(ImageIcon i) {//Setting image method of the shroom
		still = i.getImage();//Sets the image of the shroom to a transparent empty one so it would seem invisible on scrren
	}
	
	public boolean hit() {//Method that tells wether the shroom is either visible or not 
		if(still == s1.getImage())//If statement that return the shroom screen visibility as a boolean if it can be seen or not
		return true;
			return false;
	}

	public  int getWidth() {//Method to return the with of the shroom
		
		width = 16;//Sets the width of the shroom to 16 
		return width;
	}
	
	public void setX(int xi){//Sets the x coordinate according to xi 
		x = xi;
	}
	public void setY(int yi){//Sets the y coordinate according to yi 
		y = yi;
	}

}