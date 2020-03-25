package ihm.synthese;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class CommentLabel extends JLabel
{
	private String texte;
	private int format;
	
	public CommentLabel(int format, String texte)
	{
		this.format = format;
		this.texte = texte;
		
		initLabel();
	}
	
	private void initLabel()
	{
		switch(this.format)
		{
			case 0:
				this.setSize(500, 60);
				break;
			case 1:
				this.setSize(100, 150);
				break;
			case 2:
				break;
		}
		
		//this.setFont(font);
		this.setText(texte);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
		this.setBackground(Color.BLUE);
		
	}

	public String getTexte() 
	{
		return texte;
	}

	public void setTexte(String texte) 
	{
		this.texte = texte;
	}
	
}
