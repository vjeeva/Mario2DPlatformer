/*
 MysteryCollision.Java (for Super Mario: The Zakaryan Strikes Back)
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

public class MysteryCollision{

	private MarioSprite userSprite; // Creates a mariosprite
	private MysteryBox[] mbArray; // Creates an array of mysteryboxes
	private ShroomSprite[] shroomArray; // Creates an array of shrooms
	private int take = 0; // creates an integer and set to 0
	
	public MysteryCollision(MysteryBox[] mbInput,ShroomSprite[] shroomInput){
		mbArray = mbInput; // mbArray is set equal to mbInput
		shroomArray = shroomInput; // shroomArray is set equal to shroomInput
	}
	
	public void addUserSprite(MarioSprite userInput){
		userSprite = userInput; // // sets usersprite equal to userinput
	}

	public void taken() {
		
		for (int i = 0; i < mbArray.length ; i++) { // a for loop
			if (userSprite.x <= mbArray[i].getX() + 16 && userSprite.x >= mbArray[i].getX()) { // If the user is colliding with the X position of mysterybox...
				if (userSprite.y - 10 >= mbArray[i].getY() && userSprite.y - 10 <=mbArray[i].getY() + 16) { // If the user is colliding with the Y position of the mysterybox...
					mbArray[i].stop(); // Stops at the specific mysteryBox
					if (mbArray[i].getImage() != MysteryBox.mbe.getImage()) { // If the mbArray image isn't equal to the mysterybox image... 
						Map1.coins++; // Increases coin count by one
					}
					
					mbArray[i].setImage(MysteryBox.mbe); // Sets the mbarray image to mysterybox image
				if (MainMenu.mapNumber == 1){ // If user is in map 1...
					if (mbArray[0].getImage() == MysteryBox.mbe.getImage() && take == 0) { // If the first mbArray image is equal to mysterybox image and take is equal to 0...
						shroomArray[0].setY(mbArray[0].getY() - 16); // Sets the Y position of the shroom relative to the mysterybox
						shroomArray[0].setImage(ShroomSprite.s1); // Sets the image of the shroom
						take ++; // Take is increased by one
						Map1.coins--; // Coins is decreased by one
					}
				}
				
				if (MainMenu.mapNumber == 2){ // If user is in map 2...
					if (mbArray[0].getImage() == MysteryBox.mbe.getImage() && take == 0) { // If the first mbArray image is equal to mysterybox image and take is equal to 0...
						shroomArray[0].setY(mbArray[0].getY() - 16); // Sets the Y position of the shroom relative to the mysterybox
						shroomArray[0].setImage(ShroomSprite.s1); // Sets the image of the shroom
						take ++; // Take is increased by one
						Map2.coins--; // Coins is decreased by one
					}
				}
				if (MainMenu.mapNumber == 3){ // If user is in map 3...
					if (mbArray[1].getImage() == MysteryBox.mbe.getImage() && take == 0) { // If the first mbArray image is equal to mysterybox image and take is equal to 0...
						shroomArray[0].setY(mbArray[1].getY() - 16); // Sets the Y position of the shroom relative to the mysterybox
						shroomArray[0].setImage(ShroomSprite.s1); // Sets the image of the shroom
						take ++; // Take is increased by one
						Map3.coins--; // Coins is decreased by one
					}
				}
				if (MainMenu.mapNumber == 4){ // If user is in map 4...
					if (mbArray[0].getImage() == MysteryBox.mbe.getImage() && take == 0) { // If the first mbArray image is equal to mysterybox image and take is equal to 0...
						shroomArray[0].setY(mbArray[0].getY() - 16); // Sets the Y position of the shroom relative to the mysterybox
						shroomArray[0].setImage(ShroomSprite.s1); // Sets the image of the shroom
						take ++; // Take is increased by one
						Map4.coins--; // Coins is decreased by one
					}
				}
				if (MainMenu.mapNumber == 5){ // If user is in map 5...
					if (mbArray[0].getImage() == MysteryBox.mbe.getImage() && take == 0) { // If the first mbArray image is equal to mysterybox image and take is equal to 0...
						shroomArray[0].setY(mbArray[0].getY() - 16); // Sets the Y position of the shroom relative to the mysterybox
						shroomArray[0].setImage(ShroomSprite.s1); // Sets the image of the shroom
						take ++; // Take is increased by one
						Map5.coins--; // Coins is decreased by one
					}
				}
				if (MainMenu.mapNumber == 6){ // If user is in map 6...
					if (mbArray[0].getImage() == MysteryBox.mbe.getImage() && take == 0) { // If the first mbArray image is equal to mysterybox image and take is equal to 0...
						shroomArray[0].setY(mbArray[0].getY() - 16); // Sets the Y position of the shroom relative to the mysterybox
						shroomArray[0].setImage(ShroomSprite.s1); // Sets the image of the shroom
						take ++; // Take is increased by one
						Map6.coins--; // Coins is decreased by one
					}
				}
				if (MainMenu.mapNumber == 7){ // If user is in map 7...
					if (mbArray[0].getImage() == MysteryBox.mbe.getImage() && take == 0) { // If the first mbArray image is equal to mysterybox image and take is equal to 0...
						shroomArray[0].setY(mbArray[0].getY() - 16); // Sets the Y position of the shroom relative to the mysterybox
						shroomArray[0].setImage(ShroomSprite.s1); // Sets the image of the shroom
						take ++; // Take is increased by one
						Map7.coins--; // Coins is decreased by one
					}
				}
				}
			}	
		}
	} 
}