import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JPanel;
import lejos.pc.comm.*;//imports
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class okno {

	private JFrame frame;
	private Movements mov;
	private int song = 0;
	int currentInd = 0;


	public okno() {
		mov = new Movements();
		initialize();
		frame.setVisible(true);
		mov.calibrate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.setBounds(100, 100, 648, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBackground(new Color(102, 102, 153));
		btnNewButton.addActionListener(new plusListener());
		
		btnNewButton.setBounds(47, 21, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cal");
		btnNewButton_1.setBackground(new Color(102, 102, 153));
		btnNewButton_1.addActionListener(new escapeListener());
		btnNewButton_1.setBounds(216, 21, 205, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBackground(new Color(102, 102, 153));
		btnNewButton_2.setBounds(47, 52, 85, 21);
		btnNewButton_2.addActionListener(new minusListener());
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Play");
		btnNewButton_3.setBackground(new Color(102, 102, 153));
		btnNewButton_3.setBounds(494, 21, 85, 52);
		btnNewButton_3.addActionListener(new playListener());
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Next");
		btnNewButton_4.setBackground(new Color(102, 102, 153));
		btnNewButton_4.setBounds(216, 52, 205, 21);
		btnNewButton_4.addActionListener(new nextListener());
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mov.playOneNode(0);
			}
		});
		btnNewButton_5.setBounds(47, 176, 39, 221);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mov.playOneNode(4);
			}
		});
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(327, 176, 39, 175);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mov.playOneNode(1);
			}
		});
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(116, 176, 39, 211);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mov.playOneNode(5);
			}
		});
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setBounds(395, 176, 39, 164);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mov.playOneNode(2);
			}
		});
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setBounds(185, 176, 39, 199);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mov.playOneNode(6);
			}
		});
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.setBounds(465, 176, 39, 150);
		frame.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mov.playOneNode(3);
			}
		});
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.setBounds(259, 176, 39, 186);
		frame.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mov.playOneNode(7);
			}
		});
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 6));
		btnNewButton_12.setBounds(540, 176, 39, 137);
		frame.getContentPane().add(btnNewButton_12);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(45, 190, 534, 16);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(47, 282, 534, 16);
		frame.getContentPane().add(panel_1);
	}
	
	
	
		 class plusListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
			 mov.possitions[currentInd] += 5;
			 mov.moveTo(currentInd);
		 }
	 }
		 class minusListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
			 mov.possitions[currentInd] -= 5;
			 mov.moveTo(currentInd);
		 }
	 }
	 	 class nextListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
			 currentInd += 1;
 
			 
			 if(currentInd > 7)
			 {				 
				currentInd = 0;
			 }
			 mov.moveTo(currentInd);	
		 }
	 }
	 class escapeListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
			 mov.calibrate();
		 }
	 }
	 
	 class playListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
			List<String> lines = new ArrayList<String>();
			List<String> parsedLines = new ArrayList<String>();
			Dictionary<String, String> inputDictionary = new Hashtable<String, String>();
			inputDictionary.put("c1", "0");
			inputDictionary.put("d1", "1");
			inputDictionary.put("e1", "2");
			inputDictionary.put("f1", "3");
			inputDictionary.put("g1", "4");
			inputDictionary.put("a1", "5");
			inputDictionary.put("h1", "6");
			inputDictionary.put("c2", "7");
			float tempo;
			float duration;
			float durationNext = 0;
			String note ="";
			char parsedChar;
			//File reading
			try 
			{
				File myObj ;
				if(song == 0)
				{
					 myObj = new File("barka.txt");
					song++;
				}
				else
				{
					 myObj = new File("PIRACI.txt");
					 song--;
				}
				Scanner myReader = new Scanner(myObj);
				while (myReader.hasNextLine()) 
				{
					String data = myReader.nextLine();
					lines.add(data);	
				}
				myReader.close();
			} 
				
			catch (FileNotFoundException e) 
			{
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			
			//
			tempo = 4 * 60 / Float.parseFloat(lines.get(0));
			lines.remove(0);
			int i;
			
			Date date = new Date();
			long start = date.getTime();

			for(i = 0; i < lines.size(); i = i + 1) 
			{
				duration = lines.get(i).charAt(0);
				note = lines.get(i).substring(1);
				if(duration == 1 || duration%2 == 0) 
				{
					duration = 1/duration;
				}
				else 
				{
					duration = duration - 1;
					duration = 1 / duration;
					duration = duration * 3 / 2;
				}
				duration = duration * tempo * 10000;
				//Send the info to the driver here from the parsedLines
				if(note.contains("xx") == false) 
				{
					parsedChar = inputDictionary.get(note).charAt(0);
					System.out.println("Sending char: " + parsedChar);
					// INSERT YOUR SEND FUNCTION HERE WITH parsedChar ARGUMENT
					mov.moveTo(parsedChar-'0');
				}
				int waitTime = (int)(durationNext);
				
			    date = new Date();
				long now = date.getTime();
				
				while(now - start < waitTime)
				{
					date = new Date();
				    now = date.getTime();
					mov.sleep(1);
				}
				
				if(note.contains("xx") == false) 
				{
					//Send the bonk signal here
					mov.makeSound();
					
					// INSERT YOUR SEND FUNCTION HERE WITH BONK ARGUMENT
				}
				
				date = new Date();
			    start = date.getTime();
				
				mov.sleep(135);
				
				
				durationNext = duration;
			}	
		} 
	 }
	 
	 class CListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
			mov.playOneNode(0);
		 }
	 }
	 
	 class DListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
				 mov.playOneNode(1);
		 }
	 }
	 
	 class EListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
				mov.playOneNode(2);
		 }
	 }
	 	 class FListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
	 public void actionPerformed(ActionEvent evt)
		 {
				mov.playOneNode(3);
		 }
	 }
	 class GListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
				mov.playOneNode(4); 
		 }
	 }
	 class AListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
				mov.playOneNode(5);
		 }
	 }
	 class HListener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
				mov.playOneNode(6);
		 }
	 }
	 class C1Listener implements ActionListener // listeners for three buttons, options button does not do anything yet
	 {
		 public void actionPerformed(ActionEvent evt)
		 {
				mov.playOneNode(7);
		 }
	 }
}
