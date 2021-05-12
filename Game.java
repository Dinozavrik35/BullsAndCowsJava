import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.*;

import javax.swing.*;


public class Game {
	
	static String rules = "<html><div align=center>Компьютер загадывает 4-значное число,<br>состоящее из неповторяющихся цифр.<br>" +
"Ваша задача - угадать его за 10 ходов. В качестве подсказок<br>выступают “коровы”" +
" (цифра угадана, но её позиция - нет)<br>и “быки” (когда совпадает и цифра и её позиция).<br>" +
"То есть если загадано число “1234”, а вы называете<br>“6531”, то результатом будет 1" +
" корова (цифра “1”)<br>и 1 бык (цифра “3”).<br>Число загадано! Ваш ход.</html>";
				
	static String rulesScore = "Здесь будут отображаться\nваши очки.\n" +
"В начале каждой игры\nвам даётся 10000 очков.\n" +
"За каждый неправильный\nход вы теряете 1000 очков.\n1 угаданный “бык”\nприбавляет вам 500 очков.\n" +
"1 “корова” - 250 очков.\nВаш прогресс сохраняется.";
	
	static int number;
	static ArrayList<String> first_list;
	static ArrayList<String> second_list;
	static String player_name;
	static String start_player_score = "0";
	static int player_score = 0;
	static int attemps = 0;
	static int attemps_screen;
	static String move;
	static String result;
	static int bulls = 0;
	static int cows = 0;
	static int bulls_score = 0;
	static int cows_score = 0;
	static int game_score = 10000;
	static String second_right_text = "";
	static String second_left_text = "";
	
	static CowLabel labelFirst = new CowLabel("Введите ваше имя: ", 53, 40, 60, 520, 150, true);
	static CowLabel labelSecond = new CowLabel("Счёт: 10000", 24, 410, 10, 150, 30, false);
	static CowLabel labelThird = new CowLabel(rules, 18, 40, 60, 520, 200, false);
	
	static CowTextPane labelFourth = new CowTextPane(rulesScore, 19, 40, 350, 250, 235, false);
	static CowTextPane labelFifth = new CowTextPane("Здесь будут отображаться\nваши ходы.", 19, 310, 350, 250, 235, false);
	
	static CowLabel labelSixth = new CowLabel("Попыток осталось: 10", 17, 35, 700, 170, 30, false);
	static CowLabel labelSeventh = new CowLabel("", 27, 40, 60, 520, 200, false);	
	
	static CowButton button = new CowButton ("Начать игру", 43, 100, 400, 400, 100, "firstScreenDelete", true);
	static CowButton secondButton = new CowButton ("Сделать ход", 20, 400, 700, 170, 30, "secondScreenDelete", false);
	static CowButton thirdButton = new CowButton ("Выход", 38, 100, 400, 400, 100, "exit", false);
	
	static CowTextField textField = new CowTextField(33, 200, 290, 200, 50, true);
	static CowTextField secondTextField = new CowTextField(20, 225, 700, 150, 30, false);
	
	
	public static void main(String[] args) {	
	
//interface	(start) ------------------------------------------------------
		
		ImageIcon image = new ImageIcon("cow.png");
		
		JLabel background = new JLabel ();
		background.setIcon(image);
		background.setBounds(0, 0, 615, 800);
			
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 615, 839);
		
		layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(labelFirst, JLayeredPane.DRAG_LAYER);
		layeredPane.add(textField, JLayeredPane.DRAG_LAYER);
		layeredPane.add(button, JLayeredPane.DRAG_LAYER);		
		layeredPane.add(labelSecond, JLayeredPane.DRAG_LAYER);
		layeredPane.add(labelThird, JLayeredPane.DRAG_LAYER);
		layeredPane.add(labelFourth, JLayeredPane.DRAG_LAYER);
		layeredPane.add(labelFifth, JLayeredPane.DRAG_LAYER);
		layeredPane.add(labelSixth, JLayeredPane.DRAG_LAYER);
		layeredPane.add(secondTextField, JLayeredPane.DRAG_LAYER);
		layeredPane.add(secondButton, JLayeredPane.DRAG_LAYER);
		layeredPane.add(labelSeventh, JLayeredPane.DRAG_LAYER);
		layeredPane.add(thirdButton, JLayeredPane.DRAG_LAYER);
		
		CowFrame frame = new CowFrame();
		frame.add(layeredPane);	
		
//interface (end)	------------------------------------------------------		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("firstScreenDelete".equals(e.getActionCommand())) {
					player_name = textField.getText();
					if (player_name.length() < 1) {
						JOptionPane.showMessageDialog(
								null, "Пожалуйста, введите ваше имя!", 
								"Ошибка", JOptionPane.ERROR_MESSAGE);
					}
					else {				
						inicialization();
						LinkedHashSet<String> numberSet = new LinkedHashSet<String>();
						while (numberSet.size() < 5) {
							int min = 1000;
							int max = 9999;
							int diff = max - min;
							Random random = new Random();
							number = random.nextInt(diff + 1);
							number += min;
							for (int i = 0; i < 4; i++) {
								numberSet.add(String.valueOf(String.valueOf(number).charAt((i))));
							}
							if (numberSet.size() == 4) {
								if (String.valueOf(number).charAt((0)) != '0') {
									first_list = new ArrayList<String>(numberSet);
									break;
								}
								else {
									numberSet.clear();
									continue;
								}
							}
							else {
								numberSet.clear();
								continue;
							}
						}
						labelFirst.setVisible(false);
						textField.setVisible(false);
						button.setVisible(false);
						labelSecond.setVisible(true);
						labelThird.setVisible(true);
						labelFourth.setVisible(true);
						labelFifth.setVisible(true);
						labelSixth.setVisible(true);
						secondTextField.setVisible(true);
						secondButton.setVisible(true);
					}
				}
			}
		});
		
		secondButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("secondScreenDelete".equals(e.getActionCommand())) player_moves();			
			}  
		});
		
		thirdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("exit".equals(e.getActionCommand())) {
					if (result == "Вы победили!") {
						try {
					    Desktop.getDesktop().browse(new URL
					    		("https://www.youtube.com/watch?v=8pIpi1HDEhU&ab_channel=MarianD%C4%85b").toURI());
						} catch (Exception ex) {}
					}
					save();
				    System.exit(0);				
				}
			}
	       
		});
	}
	
	public static void showThirdScreen() {		
		labelSecond.setVisible(false);
		labelThird.setVisible(false);
		labelFourth.setVisible(false);
		labelFifth.setVisible(false);
		labelSixth.setVisible(false);
		secondTextField.setVisible(false);
		secondButton.setVisible(false);
		labelSeventh.setVisible(true);
		thirdButton.setVisible(true);
	}
	
	public static void save() {	
		
		try {
			File def_file = new File("game.txt");
			if (def_file.exists()) {}
			else {
				def_file.createNewFile(); 
				FileOutputStream oFile = new FileOutputStream(def_file, false);
			    oFile.close();
			}

			FileWriter game0 = new FileWriter("bac0.txt");
			FileReader game = new FileReader("game.txt");
			BufferedReader reader = new BufferedReader(game);
			
			String ss;
			
			while (true) {
				
				String line = reader.readLine();
				
				if (line == null) {break;}
							
	            String name_place = "";
	            String symbol;

	            int k = line.length();
	            for (int i = 0; i < k; i++) {
	            	symbol = line.substring(i, i+1);
		    		if (symbol.equals("\t")) {
		    			name_place = line.substring(0, i);
						if (name_place.equals(player_name)) {}
						else if (name_place == "") {break;}
						else {
							game0.append(line);
							game0.append("\n");
						}
		    		}
		    		continue;
	            }	   
			}
			
	        ss = player_name + "\t" + player_score;
			game0.append(ss);
			game0.append("\n");
	        game0.close();
	        game.close();
	        reader.close();
		    
	        def_file.delete();
	        File bac_file = new File("bac0.txt");
	        bac_file.renameTo(def_file);
		}
        catch(IOException ex) {}	
	}
	
	public static void player_moves() {
		
			if (attemps < 10) {			
				attemps += 1;
				attemps_screen = 10 - attemps;
				move = secondTextField.getText();
				
				try {
					Integer.parseInt(move);
					if (move.length() == 4) {
						
						LinkedHashSet<String> for_second_list = new LinkedHashSet<String>();
						for (int i = 0; i < 4; i++) {
							for_second_list.add(String.valueOf(move.charAt((i))));
						}
						second_list = new ArrayList<String>(for_second_list);
						
					    if (first_list.equals(second_list)) {
					    	result = "Вы победили!";
						    player_score += game_score;
						    player_score += Integer.parseInt(start_player_score);
						    labelSeventh.setText("<html><div align=center>" + result + " Загаданное число: "
								+ number + "<br>Спасибо за игру!<br>Общий счёт: " + player_score + "</html>");
						    showThirdScreen();
					    }
						else if (attemps_screen == 0) {
							result = "Вы проиграли.";
							player_score += game_score;
						    player_score += Integer.parseInt(start_player_score);
						    labelSeventh.setText("<html><div align=center>" + result + " Загаданное число: "
								+ number + "<br>Спасибо за игру!<br>Общий счёт: " + player_score + "</html>");
							showThirdScreen();
						}
						                
						if (first_list.get(0).equals(second_list.get(0))) {bulls += 1;}
						if (first_list.get(1).equals(second_list.get(1))) {bulls += 1;}
						if (first_list.get(2).equals(second_list.get(2))) {bulls += 1;}
						if (first_list.get(3).equals(second_list.get(3))) {bulls += 1;}

						for (int i = 0; i < 4; i++) {
							cows += Collections.frequency(second_list, first_list.get(i));
						}
						cows -= bulls;
						for_second_list.clear();
						second_list.clear();			
					}
					else throw new Exception();				
				}
				catch(Exception ex) {   
					JOptionPane.showMessageDialog(
							null, "Число должно состоять из 4 неповторяющихся цифр!", 
							"Ошибка", JOptionPane.ERROR_MESSAGE);
					secondTextField.setText(null);
					bulls = 0;
					cows = 0;
					attemps -= 1;
					return;	
		        }
			
				cows_score = 250 * cows;
				bulls_score = 500 * bulls;
				
				game_score -= 1000;
				game_score += cows_score + bulls_score;
				
				String attemps_text = "Попыток осталось: " + String.valueOf(attemps_screen);
				
				second_right_text += move + ": быки - " +
						String.valueOf(bulls) + ", коровы - " + String.valueOf(cows) + "\n";
				
				second_left_text += "быки: +" + String.valueOf(bulls_score) + 
						", коровы: +" + String.valueOf(cows_score) + "\n";
				
				secondTextField.setText(null);
				labelFourth.setText(second_left_text);
				labelFifth.setText(second_right_text);
				labelSixth.setText(attemps_text);
				labelSecond.setText("Счёт: " + String.valueOf(game_score));
				
				bulls = 0;
				cows = 0;		
			}
		}
	
		public static void inicialization() {
			
			try {	
				FileReader game = new FileReader("game.txt");
				BufferedReader reader = new BufferedReader(game);
				
				while (true) {
					
					String perem = null;
					String line = reader.readLine();
					
					if (line == perem) {break;}		
					
		            String name_place = "";
		            String symbol;

		            int k = line.length();
		            
		            for (int i = 0; i < k; i++) {	            	
		            	symbol = line.substring(i, i + 1);	
			    		if (symbol.equals("\t")) {
			    			name_place = line.substring(0, i);
							if (name_place.equals(player_name)) {
								start_player_score = line.substring(i + 1);
								break;
							}
			    		}
		            }
				}
		        game.close();
			}
			catch(IOException ex) {}	
	}
}
