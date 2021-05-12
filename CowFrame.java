import java.awt.*;

import javax.swing.*;

public class CowFrame extends JFrame {
	
	public CowFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon icon = new ImageIcon("cow_logo.png");
		
		this.setBounds((screenSize.width - 615) / 2, (screenSize.height - 839) / 2, 615, 839);
		this.setSize(616, 839);
		this.setTitle("Bulls and Cows");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(icon.getImage());
		this.setLayout(null);
		this.setVisible(true);
	}
}
