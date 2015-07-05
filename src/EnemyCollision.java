/*
 EnemyCollision.Java (for Super Mario: The Zakaryan Strikes Back)
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

public class EnemyCollision{
	
	private Enemy[] enemyArray; // Creates an enemey array
	private MarioSprite userSprite; // Creates a mariosprite
	
	public EnemyCollision(Enemy[] enemyInput){
		enemyArray = enemyInput; // Sets enemyArray equal to enemyInput
	}
	
	public void addUserSprite(MarioSprite userInput){
		userSprite = userInput; // Sets userSprite equal to userInput
	}

	public void checkLeftRight() {
		for (int i = 0; i <= enemyArray.length - 1; i++) { // a for loop
			if (userSprite.y >= enemyArray[i].getY() && userSprite.y <= enemyArray[i].getY() + 16) { // If the user is colliding with the Y position of the enemy...
				if (userSprite.x + 16 >= enemyArray[i].getX() && userSprite.x <= enemyArray[i].getX() + 16) { // If the user is colliding with the X position of the enemy...
					userSprite.death(); // The user dies
				}
			}
		}
	}
	
	public void bigCheckLeftRight() {
		for (int i = 0; i <= enemyArray.length - 1; i++) { // a for loop
			if (userSprite.y >= enemyArray[i].getY() - 16 && userSprite.y + 16 <= enemyArray[i].getY() + 16) { // If the big user is colliding with the Y position of the enemy...
				if (userSprite.x + 16 >= enemyArray[i].getX() && userSprite.x <= enemyArray[i].getX() + 16) {  // If the big user is colliding with the X position of the enemy...
					userSprite.enemyHit(); // The big user is hit, but doesn't die
				}
			}
		}
	}
	
	public void checkBelow() {
		for (int i = 0; i <= enemyArray.length - 1; i++) { // a for loop
			if (userSprite.x + 16 >= enemyArray[i].getX() && userSprite.x <= enemyArray[i].getX() + 16) { // If the user is colliding with the X position of the enemy...
				if (userSprite.y >= enemyArray[i].getY() && userSprite.y <= enemyArray[i].getY() + 16) { // If the user is colliding with the Y position of the enemy...
					if (!enemyArray[i].cannotDie){ // If the enemy can die...
						enemyArray[i].killed(); // The enemy dies
						userSprite.j = 0; // J is set to zero
						userSprite.jump = true; // User jumps after killing enemy
					} else { // If the enemy can't die...
						userSprite.enemyHit(); // The user is hit
					}
				}
			}
		}
	}
	
	public void bigCheckBelow() {
		for (int i = 0; i <= enemyArray.length - 1; i++) { // a for loop
			if (userSprite.x + 16 >= enemyArray[i].getX() && userSprite.x <= enemyArray[i].getX() + 16) { // If the big user is colliding with the X position of the enemy...
				if (userSprite.y >= enemyArray[i].getY() - 26 && userSprite.y + 26 <= enemyArray[i].getY() + 16) { // If the big user is colliding with the Y position of the enemy...
					if (!enemyArray[i].cannotDie){ // If the enemy can die...
						enemyArray[i].killed(); // The enemy is killed
						userSprite.j = 0; // J is set to zero
						userSprite.jump = true; // User jumps after killing enemy
					} else { // If the enemy can't die...
						userSprite.enemyHit(); // The big user is hit, but doesn't die
					}
				}
			}
		}
	}
}