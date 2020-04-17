package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * BoutonCommande est la classe qui gère la personnalisation des boutons du panneau de commande
 * 
 * @author Daniel
 */
@SuppressWarnings("serial")
public class BoutonCommande extends JButton implements MouseListener
{
	public BoutonCommande(String nom)
	{
		super("  " + nom + "  ");
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.setFocusPainted(false);
		this.setFont(new Font("Verdana", Font.PLAIN, 20));
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
