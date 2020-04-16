package ihm.synthese;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ihm.ParaADN;

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

	public void setFormat(int format) 
	{
		this.format = format;
		
		switch(this.format)
		{
			case 0:
				this.setBounds(50, ParaADN.HAUTEUR_CONTENU - 100, ParaADN.LARGEUR_CONTENU - 100, 50);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 30));

				break;
			case 1:
				this.setBounds(ParaADN.LARGEUR_CONTENU - 300, 50, 280, 150);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				break;
			case 2:
				this.setBounds(50, 70, ParaADN.LARGEUR_CONTENU - 100, 70);
				this.setForeground(new Color(64, 149, 204));
				this.setFont(new Font("Comic sans MS", Font.BOLD, 45));
				break;
			case 3:
				this.setBounds(0, 0, 1065, 100);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				break;
			case 20:
				this.setBounds(50, 200, ParaADN.LARGEUR_CONTENU / 2 - 50, 200);
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				break;
			case 21:
				this.setBounds(50, ParaADN.HAUTEUR_CONTENU - 120, ParaADN.LARGEUR_CONTENU - 100, 80);
				this.setForeground(new Color(238, 26, 36));
				this.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				break;
		}
		
		this.setOpaque(true);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		this.setBackground(Color.WHITE);
	}
	
	public void setComment(String texte, int format)
	{
		this.setFormat(format);
		this.setText(texte);	
		
		System.out.println("On met à jour le com");
		this.repaint();
	}
	
	
	
}
