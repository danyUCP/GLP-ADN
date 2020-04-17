package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * BoutonMenu est la classe qui gère la personnalisation des boutons du menu
 * 
 * @author Daniel
 */
@SuppressWarnings("serial")
public class BoutonMenu extends JButton implements MouseListener
{
	public BoutonMenu(String nom, String iconFile)
	{
		super("  " + nom + "  ");
		
		this.setIcon(new ImageIcon(iconFile));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.setFocusPainted(false);
		this.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
	    this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setBackground(new Color(50, 50, 50));
		this.setForeground(Color.WHITE);
		
		this.addMouseListener(this);
	}

	public void mouseEntered(MouseEvent e) 
	{
		if(this.isEnabled())
			this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	}

	public void mouseExited(MouseEvent e) 
	{
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
