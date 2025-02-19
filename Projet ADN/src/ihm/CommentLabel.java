package ihm;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * CommentLabel est la classe qui g�re l'affichage des commentaires descriptifs
 */
@SuppressWarnings("serial")
public class CommentLabel extends JLabel
{
	private String texte;
	private int format;
	
	public CommentLabel(String texte, int format)
	{
		super(texte);
		
		this.format = format;
		this.texte = texte;
		
		initLabel();
	}
	
	private void initLabel()
	{
		this.setFormat(this.format);
		this.setText(this.texte);		
	}

	public String getTexte() 
	{
		return texte;
	}

	public int getFormat() 
	{
		return format;
	}

	/**
	 * Cet methode permet de personnaliser le format des commentaires
	 */
	public void setFormat(int format) 
	{
		this.format = format;
		
		this.setOpaque(true);

		switch(this.format)
		{
			case 0:
				this.setBounds(50, ParaADN.HAUTEUR_CONTENU - 100, ParaADN.LARGEUR_CONTENU - 100, 50);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 30));
				this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				this.setBackground(Color.WHITE);
				break;
			case 1:
				this.setBounds(ParaADN.LARGEUR_CONTENU - 300, 50, 280, 150);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				this.setBackground(Color.WHITE);
				break;
			case 2:
				this.setBounds(50, 70, ParaADN.LARGEUR_CONTENU - 100, 70);
				this.setForeground(new Color(64, 149, 204));
				this.setFont(new Font("Comic sans MS", Font.BOLD, 45));
				this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				this.setBackground(Color.WHITE);
				break;
			case 3:
				this.setBounds(0, 0, 1065, 100);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				this.setBackground(Color.WHITE);
				break;
			case 4:
				this.setBounds(0, 0, 350, 200);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				this.setOpaque(false);
				break;
			case 5:
				this.setBounds(0, 0, 1065, 150);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				this.setBackground(Color.WHITE);
				break;
			case 6:
				this.setBounds(400, 350, 650, 300);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				this.setBackground(Color.WHITE);
				break;
			case 20:
				this.setBounds(50, 200, ParaADN.LARGEUR_CONTENU / 2 - 50, 200);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				this.setBackground(Color.WHITE);
				break;
			case 21:
				this.setBounds(50, ParaADN.HAUTEUR_CONTENU - 120, ParaADN.LARGEUR_CONTENU - 100, 80);
				this.setForeground(new Color(238, 26, 36));
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				this.setBackground(Color.WHITE);
				break;
		}
		
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		
	}
	
	public void setComment(String texte, int format)
	{
		this.setFormat(format);
		this.setText(texte);	
		
		this.repaint();
	}
	
	
	
}
