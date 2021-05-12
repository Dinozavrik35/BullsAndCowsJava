import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class CowButton extends JButton {
	
	String text;
	int font_size;
	int x;
	int y;
	int x_size;
	int y_size;
	String command;
	boolean visible;
	
	public CowButton (String text, int font_size, int x, int y, int x_size, int y_size, String command, boolean visible) {
		
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		    
	    this.text = text; //текст кнопки
	    this.font_size = font_size; //размер текста
	    this.x = x; //координата x расположения кнопки в окне
	    this.y = y; //координата y расположения кнопки в окне
	    this.x_size = x_size; //размер кнопки (ширина)
	    this.y_size = y_size; //размер кнопки (длина)
	    this.command = command; //команда действия кнопки
	    this.visible = visible; //отображение кнопки

		this.setText(text);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		this.setForeground(Color.black);
		this.setOpaque(true);
		this.setBackground(Color.white);
		this.setBorder(border);
		this.setFocusable(false);
		this.setActionCommand(command);
		this.setBounds(x, y, x_size, y_size);
		
	    if (visible == false) this.setVisible(false);
	}
}
