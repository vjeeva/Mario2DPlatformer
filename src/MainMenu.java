/*
 MainMenu.Java (for Super Mario: The Zakaryan Strikes Back)
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

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame; // creates JFrame to display menu
	private JPanel panel; // creates JPanel to put in all the JButtons, JLabels
							// and pictures

	private static Map1 map1 = new Map1();
	private static Map2 map2 = new Map2();
	private static Map3 map3 = new Map3();
	private static Map4 map4 = new Map4();
	private static Map5 map5 = new Map5();
	private static Map6 map6 = new Map6();
	private static Map7 map7 = new Map7();

	// initializes Maps 1 - 7 to use in the CardLayout

	public static long start; // creates long variable to get current time in
								// milliseconds in order to measure how long the
								// game has been played for

	private BufferedImage mario; // creates BufferedImage variable to put Mario
									// head picture inside JLabel
	public static int mapNumber = 1; // creates integer variable so the program
										// knows which map it is inside

	public static JFrame GUI = new JFrame(
			"Super Mario: The Zakaryan Strikes Back"); // creates JFrame to
														// display game inside
	private static JPanel map = new JPanel(); // creates JPanel to hold all the
												// complex animations inside
	private static CardLayout layout = new CardLayout(); // creates CardLayout
															// variable to
															// switch between
															// maps easily

	public MainMenu() {

	}

	public MainMenu(int s) {

		start = System.currentTimeMillis(); // gets current time in milliseconds
		JButton start; // "Start" button
		JButton instructions; // button to display instructions
		JButton exit; // button for exiting the game
		JLabel picture; // label to display Mario head picture
		JLabel titlePart1 = new JLabel("Super Mario: The Zakaryan"); // label to
																		// display
																		// part
																		// of
																		// title
		JLabel titlePart2 = new JLabel("Strikes Back"); // label to display
														// other part of title

		Font font = new Font("Segoe UI Black", Font.PLAIN, 20); // font for the
																// title
		frame = new JFrame("Super Mario: The Zakaryan Strikes Back"); // frame
																		// for
																		// starting
																		// menu
		panel = new JPanel(); // panel to hold all things inside the main menu
		panel.setLayout(null); // nullifying layout on jpanel to use absolute
								// positioning
		start = new JButton("Start"); // initializes start button
		instructions = new JButton("Instructions"); // initializes button to
													// display instructions
		exit = new JButton("Exit"); // initializes exit button

		start.setBounds(100, 200, 75, 25);
		instructions.setBounds(100, 230, 105, 25);
		exit.setBounds(100, 260, 75, 25);

		// positions and sets size for each button

		try {
			mario = ImageIO.read(new File("resources/mario_head.png")); // decodes
																		// the
																		// Mario
																		// head
																		// png
																		// so
																		// Java
																		// can
																		// read
																		// it
			Sound.playMusic("Main Menu Music.wav"); // plays main menu
													// background music
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // displays what kind of exception is being
									// given off and where is the cause of the
									// exception
		}

		picture = new JLabel(new ImageIcon(mario)); // stores the mario head
													// picture inside the JLabel
													// so it can be displayed
													// through it
		picture.setBounds(100, 75, 75, 100);
		titlePart1.setBounds(10, 0, 300, 75);
		titlePart1.setFont(font); // sets the font of the first part of the
									// title
		titlePart2.setBounds(10, 50, 150, 25);
		titlePart2.setFont(font); // sets the font of the second part of the
									// title

		// positions and sets the sizes of each JLabel

		panel.add(start);
		panel.add(instructions);
		panel.add(exit);
		panel.add(picture);
		panel.add(titlePart1);
		panel.add(titlePart2);

		// adds all the objects inside the main menu to the JPanel to be
		// displayed

		frame.add(panel); // adds the JPanel to the JFrame
		frame.setSize(300, 335); // sets the size of the JFrame
		frame.setVisible(true); // makes the JFrame visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when the JFrame
																// gets closed,
																// it terminates
																// the program
																// as well
		start.addActionListener(new ActionListener() { // action listener for
														// the start button

			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				Sound.pauseMusic(); // pauses main menu music
				try {
					Sound.playMusic("Super Mario Bros Background Music.wav"); // plays
																				// the
																				// game
																				// background
																				// music
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); // prints the error
				}
				map.setLayout(layout); // sets the JPanel layout to CardLAyout
										// for ease of switching maps

				Map1 map1 = new Map1(); // declares and initializes the first
										// map

				map.add(map1, "1"); // adds the first map to the card layout

				layout.show(map, "1"); // shows the first map

				GUI.add(map); // Adds the map
				GUI.setVisible(true); // Sets the JFrame visible
				GUI.setSize(800, 455); // Dictates the the size of the JFrame
				GUI.setResizable(false); // Sets resizable to false
				GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates
																	// the
																	// program
																	// when the
																	// user
																	// clicks
																	// the red
																	// "x"
																	// button

				MainMenu.this.frame.setVisible(false);
				MainMenu.this.frame.dispose();

				// gets rid of main menu frame
			}

		});
		instructions.addActionListener(new ActionListener() { // action listener
																// for
																// instructions
																// button
					public void actionPerformed(ActionEvent ae) {
						new InstructionPanel(); // initializes JFrame and JPanel
												// for instructions to show
					}
				});
		exit.addActionListener(new ActionListener() { // action listener for
														// exit button
			public void actionPerformed(ActionEvent ae) {
				System.exit(0); // terminates program
			}
		});

	}

	public void nextLevel() { // method for switching maps
		mapNumber++; // increases the mapNumber integer variable by 1

		if (mapNumber == 2) { // if mapNumber is equal to 2, the second map will
								// show and remove any traces of map1 except for
								// coins, lives and if mario is big or small
			map1.destroy();
			map2.mapPort(map1.returnLives(), map1.returnCoins(),
					map1.returnBig());
			map.add(map2, "2");
			layout.show(map, "2");
			map2.requestFocus(); // input is allowed in the second map and not
									// the first
		} else if (mapNumber == 3) { // if mapNumber is equal to 3, the second
										// map will
										// show and remove any traces of map2
										// except for
										// coins, lives and if mario is big or
										// small
			map2.destroy();
			map3.mapPort(map2.returnLives(), map2.returnCoins(),
					map2.returnBig());
			map.add(map3, "3");
			layout.show(map, "3");
			map3.requestFocus(); // input is allowed in the third map and not
									// the second
		} else if (mapNumber == 4) {// if mapNumber is equal to 2, the second
									// map will
									// show and remove any traces of map1 except
									// for
									// coins, lives and if mario is big or small
			map3.destroy();
			map4.mapPort(map3.returnLives(), map3.returnCoins(),
					map3.returnBig());
			map.add(map4, "4");
			layout.show(map, "4");
			map4.requestFocus(); // input is allowed in the fourth map and not
									// the third
		} else if (mapNumber == 5) {// if mapNumber is equal to 2, the second
									// map will
									// show and remove any traces of map1 except
									// for
									// coins, lives and if mario is big or small
			map4.destroy();
			map5.mapPort(map4.returnLives(), map4.returnCoins(),
					map4.returnBig());
			map.add(map5, "5");
			layout.show(map, "5");
			map5.requestFocus(); // input is allowed in the fifth map and not
									// the fourth
		} else if (mapNumber == 6) {// if mapNumber is equal to 2, the second
									// map will
									// show and remove any traces of map1 except
									// for
									// coins, lives and if mario is big or small
			map5.destroy();
			map6.mapPort(map5.returnLives(), map5.returnCoins(),
					map5.returnBig());
			map.add(map6, "6");
			layout.show(map, "6");
			map6.requestFocus(); // input is allowed in the sixth map and not
									// the fifth
		} else if (mapNumber == 7) {// if mapNumber is equal to 2, the second
									// map will
									// show and remove any traces of map1 except
									// for
									// coins, lives and if mario is big or small
			map6.destroy();
			map7.mapPort(map6.returnLives(), map6.returnCoins(),
					map6.returnBig());
			map.add(map7, "7");
			layout.show(map, "7");
			map7.requestFocus(); // input is allowed in the seventh map and not
									// the sixth
		} else if (mapNumber == 8) {
			map7.repaint(); // Map7.java has an if statement where if mapNumber
							// is equal to 8, a winning screen shows up
		}
	}
}

