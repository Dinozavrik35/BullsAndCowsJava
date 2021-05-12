import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;

public class CowTextPane extends JTextPane {
	
	String text;
	int font_size;
	int x;
	int y;
	int x_size;
	int y_size;
	boolean visible;
	
	public CowTextPane(String text, int font_size, int x, int y, int x_size, int y_size, boolean visible) {
			    
	    this.text = text; //текст 
	    this.font_size = font_size; //размер текста
	    this.x = x; //координата x расположения поля в окне
	    this.y = y; //координата y расположения поля в окне
	    this.x_size = x_size; //размер поля (ширина)
	    this.y_size = y_size; //размер поля (длина)
	    this.visible = visible; //отображение поля
		
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		
		StyledDocument doc = this.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		this.setText(text);
		this.setEditable(false);
		this.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		this.setForeground(Color.black);
		this.setOpaque(true);
		this.setBackground(Color.white);
		this.setBorder(border);
		this.setBounds(x, y, x_size, y_size);
		this.setVisible(visible);
	}
}
