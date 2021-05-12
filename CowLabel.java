import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class CowLabel extends JLabel {
	
	String text;
	int font_size;
	int x;
	int y;
	int x_size;
	int y_size;
	boolean visible;
	
	public CowLabel(String text, int font_size, int x, int y, int x_size, int y_size, boolean visible) {
		
		Border border = BorderFactory.createLineBorder(Color.black, 2);
	    
	    this.text = text; //текст лейбла
	    this.font_size = font_size; //размер текста
	    this.x = x; //координата x расположения лейбла в окне
	    this.y = y; //координата y расположения лейбла в окне
	    this.x_size = x_size; //размер лейбла (ширина)
	    this.y_size = y_size; //размер лейбла (длина)
	    this.visible = visible; //отображение лейбла

	    this.setText(text);
	    this.setHorizontalAlignment(SwingConstants.CENTER);
	    this.setVerticalAlignment(SwingConstants.CENTER);
	    this.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
	    this.setForeground(Color.black);
	    this.setOpaque(true); //заполняет фон цветом
	    this.setBackground(Color.white);
	    this.setBorder(border);
	    this.setBounds(x, y, x_size, y_size);
	    
	    if (visible == false) this.setVisible(false);
	}

}
