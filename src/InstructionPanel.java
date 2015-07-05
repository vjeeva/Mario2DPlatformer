/*
 InstructionPanel.Java (for Super Mario: The Zakaryan Strikes Back)
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

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class InstructionPanel {

	public InstructionPanel() {
		JFrame frame = new JFrame("Super Mario: The Zakaryan Strikes Back"); //JFrame to display instructions
		JPanel panel = new JPanel(); //JPanel to display instructions
		
		BufferedImage left = null;
		BufferedImage right = null;
		BufferedImage space = null;
		BufferedImage fall = null;
		BufferedImage goomba = null;
		BufferedImage ghost = null;
		BufferedImage porcupine = null;
		BufferedImage shyGuy = null;
		BufferedImage background = null;
		
		//BufferedImages to show the pictures inside the instructions
		
		JLabel backgroundPicture;
		JLabel leftPicture;
		JLabel rightPicture;
		JLabel spaceBarPicture;
		JLabel fallPicture;
		JLabel goombaPicture;
		JLabel ghostPicture;
		JLabel porcupinePicture;
		JLabel shyGuyPicture;
		
		//JLabels to store the pictures inside
		
		JLabel title = new JLabel("INSTRUCTIONS");
		JLabel leftInstruction = new JLabel(
				"Press the left arrow key and Mario will move to the left.");
		JLabel rightInstruction = new JLabel(
				"Press the right arrow key and Mario will move to the right.");
		JLabel spaceBarInstruction = new JLabel(
				"Press the space bar and Mario will");
		JLabel spaceBarInstruction2 = new JLabel("jump up.");
		JLabel fallInstruction = new JLabel(
				"There are pits across the map where you can fall ");
		JLabel fallInstruction2 = new JLabel(
				"through if you are not careful. Jump across them, and");
		JLabel fallInstruction3 = new JLabel("you will be safe.");
		JLabel enemyInstruction = new JLabel(
				"Enemies will appear across the map that will make");
		JLabel enemyInstruction2 = new JLabel(
				"you lose a life if you run into them. However, you");
		JLabel enemyInstruction3 = new JLabel(
				"may destroy them if you jump right on top of them.");
		JLabel cannotDieEnemyInstruction = new JLabel(
				"However, some enemies cannot be destroyed, and");
		JLabel cannotDieEnemyInstruction2 = new JLabel(
				"they kill you instantly. Avoid them at all costs!");
		
		//JLabels to display the actual instructions
		
		Font f = new Font("Segoe Black UI", Font.BOLD, 50); //font for the title
		Font f2 = new Font("Verdana", Font.PLAIN, 15); //font for the instructions

		panel.setLayout(null); //setting layout to null for absolute positioning

		try {
			background = ImageIO.read(new File(
					"resources/instruction_background.jpg"));
			left = ImageIO.read(new File("resources/left arrow.png"));
			right = ImageIO.read(new File("resources/right arrow.png"));
			space = ImageIO.read(new File("resources/space bar.png"));
			fall = ImageIO.read(new File("resources/map pitfall.png"));
			goomba = ImageIO.read(new File("resources/goomba1.png"));
			ghost = ImageIO.read(new File("resources/ghostR1.png"));
			porcupine = ImageIO.read(new File("resources/porcupineR.png"));
			shyGuy = ImageIO.read(new File("resources/shyguyR1.png"));
			
			//converts the images to data that java can read
		} catch (Exception e) {
			e.printStackTrace(); //prints any errors that may occur
		}

		backgroundPicture = new JLabel(new ImageIcon(background));
		leftPicture = new JLabel(new ImageIcon(left));
		rightPicture = new JLabel(new ImageIcon(right));
		spaceBarPicture = new JLabel(new ImageIcon(space));
		fallPicture = new JLabel(new ImageIcon(fall));
		goombaPicture = new JLabel(new ImageIcon(goomba));
		ghostPicture = new JLabel(new ImageIcon(ghost));
		porcupinePicture = new JLabel(new ImageIcon(porcupine));
		shyGuyPicture = new JLabel(new ImageIcon(shyGuy));
		
		//stores the pictures inside JLabels

		title.setFont(f);
		title.setBounds(266, 15, 450, 40);
		backgroundPicture.setBounds(0, 0, 900, 745);
		leftPicture.setBounds(222, 65, 17, 20);
		leftInstruction.setBounds(245, 65, 450, 20);
		leftInstruction.setFont(f2);
		rightPicture.setBounds(222, 90, 19, 20);
		rightInstruction.setBounds(247, 90, 450, 20);
		rightInstruction.setFont(f2);
		spaceBarPicture.setBounds(222, 115, 172, 20);
		spaceBarInstruction.setBounds(400, 115, 450, 20);
		spaceBarInstruction2.setBounds(400, 140, 450, 20);
		spaceBarInstruction.setFont(f2);
		spaceBarInstruction2.setFont(f2);
		fallPicture.setBounds(222, 165, 45, 20);
		fallInstruction.setBounds(273, 165, 450, 20);
		fallInstruction2.setBounds(273, 190, 450, 20);
		fallInstruction3.setBounds(273, 215, 450, 20);
		fallInstruction.setFont(f2);
		fallInstruction2.setFont(f2);
		fallInstruction3.setFont(f2);
		goombaPicture.setBounds(222, 240, 16, 16);
		ghostPicture.setBounds(244, 240, 16, 16);
		shyGuyPicture.setBounds(266, 240, 16, 15);
		enemyInstruction.setBounds(288, 240, 450, 20);
		enemyInstruction2.setBounds(288, 265, 450, 20);
		enemyInstruction3.setBounds(288, 290, 450, 20);
		enemyInstruction.setFont(f2);
		enemyInstruction2.setFont(f2);
		enemyInstruction3.setFont(f2);
		porcupinePicture.setBounds(222, 315, 15, 15);
		cannotDieEnemyInstruction.setBounds(243, 315, 450, 20);
		cannotDieEnemyInstruction2.setBounds(243, 340, 450, 20);
		cannotDieEnemyInstruction.setFont(f2);
		cannotDieEnemyInstruction2.setFont(f2);

		//sets the size and positioning of the JLabels holding the instructions and the images
		
		panel.add(title);
		panel.add(leftPicture);
		panel.add(leftInstruction);
		panel.add(rightPicture);
		panel.add(rightInstruction);
		panel.add(spaceBarPicture);
		panel.add(spaceBarInstruction);
		panel.add(spaceBarInstruction2);
		panel.add(fallPicture);
		panel.add(fallInstruction);
		panel.add(fallInstruction2);
		panel.add(fallInstruction3);
		panel.add(goombaPicture);
		panel.add(ghostPicture);
		panel.add(shyGuyPicture);
		panel.add(enemyInstruction);
		panel.add(enemyInstruction2);
		panel.add(enemyInstruction3);
		panel.add(porcupinePicture);
		panel.add(cannotDieEnemyInstruction);
		panel.add(cannotDieEnemyInstruction2);
		panel.add(backgroundPicture);
		
		//adds all the objects into the JPanel to be displayed 

		frame.add(panel); //adds the JPanel to the JFrame to display
		frame.setSize(900, 450); //sets size of JFrame
		frame.setVisible(true); //makes JFrame visible 
	}
}
