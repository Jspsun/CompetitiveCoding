/**
 * This porgram is the title page
 * @author Andy Jin, and Clement Lau
 * @version Final Project Duration
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Title_PagePic extends JComponent
{
	BufferedImage img = ImageIO.read(new File("title page pic.png"));
	JFrame frame1 = new JFrame("Code Push");

	Title_PagePic() throws IOException
	{
	}

	/*
	 * This method creates and imports the title page, which is the pictures
	 * Void mehtod
	 */
	public void displayMenu() throws IOException
	{

		// frame1.setLayout(new FlowLayout());
		frame1.setSize(900, 900); // Change back to original resolution later
									// (1050x90), fits on school monitors
		frame1.setResizable(false);

		JButton buttonStart = new JButton("PLAY");
		buttonStart.setSize(100, 100);
		buttonStart.addActionListener(new play());

		frame1.setContentPane(new JPanel() {
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(img, 0, 0, null);
			}
		});

		frame1.getContentPane().add(buttonStart);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true); // Make the frame visible
	}

	/*
	 * This mehtod performs the actions for the play button Implements the
	 * actions of button play
	 */
	public static class play implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			JFrame frame2 = new JFrame("Play");
			frame2.setSize(1050, 900);
			frame2.setVisible(true);
		}
	}

	public static void main(String args[]) throws IOException
	{

		Title_PagePic graphics = new Title_PagePic();
		graphics.displayMenu();
	}
}
