package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ARNPanel extends JPanel
{
	private JPanel section, contenu, menu, header, footer;
	private JButton transcription, maturation, synthese; 
	private Dimension dim;
	
	public ARNPanel()
	{
		this.dim = new Dimension(1200, 900);
		this.setPreferredSize(dim);
		this.setLayout(new BorderLayout());
		
		//-------------- PARTIE HEADER ------------------//
		header = new JPanel();
		header.setBackground(Color.BLUE);
		header.setPreferredSize(new Dimension(dim.width, 40));
		header.setLayout(new FlowLayout());
		this.add(header, BorderLayout.NORTH);
		
		//-------------- PARTIE SECTION -----------------//
		section = new JPanel();
		section.setBackground(Color.ORANGE);
		section.setPreferredSize(new Dimension(dim.width, dim.height - (100)));
		section.setLayout(new BorderLayout());
		this.add(section, BorderLayout.CENTER);
		
		//-------------- PARTIE MENU --------------------//
		menu = new JPanel();
		menu.setBackground(Color.DARK_GRAY);
		menu.setPreferredSize(new Dimension(1200 / 10, dim.height - (100)));
		menu.setLayout(new FlowLayout());
		
		initMenu();
		
		section.add(menu, BorderLayout.WEST);
		
		//-------------- PARTIE CONTENU -----------------//
		contenu = new JPanel();
		contenu.setBackground(Color.GREEN);
		contenu.setPreferredSize(new Dimension(9 * (1200 / 10), dim.height - (100)));
		contenu.setLayout(null);
		section.add(contenu, BorderLayout.CENTER);
		
		//-------------- PARTIE FOOTER ------------------//
		footer = new JPanel();
		footer.setBackground(Color.RED);
		footer.setPreferredSize(new Dimension(this.getPreferredSize().width, 60));
		footer.setLayout(new FlowLayout());
		this.add(footer, BorderLayout.SOUTH);


	}
	
	class BoutonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contenu.setBackground(Color.BLACK);
			footer.setBackground(Color.LIGHT_GRAY);
			
			initARNActivity(1);

			contenu.revalidate();
			contenu.repaint();
			//contenu.setVisible(true);
		}
	}
	
	public void initMenu()
	{
		menu.setLayout(new GridLayout(3, 1, 0, 100));
		transcription = new JButton("Transcription");
		maturation = new JButton("Maturation");
		synthese = new JButton("Synthèse");
		menu.add(transcription);
		menu.add(maturation);
		menu.add(synthese);	
		
		transcription.addActionListener(new BoutonListener());
	}
	
	public void initARNActivity(int activity)
	{
		contenu.removeAll();
		footer.removeAll();
		
		contenu.setLayout(new BorderLayout());
		footer.setLayout(new FlowLayout());
		
		contenu.add(new ARNActivity(footer, activity, contenu.getPreferredSize()), BorderLayout.CENTER);
	}
	
	/*
	public void paintComponent(Graphics g)
	{
		try 
		{
			Image img = ImageIO.read(new File("banane3.jpg"));
			g.drawImage(img, 0, 0, this);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
	    }                
	  
	}     
	*/
	

}
