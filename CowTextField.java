import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class CowTextField extends JTextField {
	
	int font_size;
	int x;
	int y;
	int x_size;
	int y_size;
	boolean visible;
	
	public CowTextField(int font_size, int x, int y, int x_size, int y_size, boolean visible) {
		    
	    this.font_size = font_size; //размер текста в поле для ввода
	    this.x = x; //координата x расположения поля для ввода в окне
	    this.y = y; //координата y расположения поля для ввода в окне
	    this.x_size = x_size; //размер поля для ввода (ширина)
	    this.y_size = y_size; //размер поля для ввода (длина)
	    this.visible = visible; //отображение поля для ввода
    
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		
		this.setBounds(x, y, x_size, y_size);
		this.setBorder(border);
		this.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		
	    if (visible == false) this.setVisible(false);
	}
}
