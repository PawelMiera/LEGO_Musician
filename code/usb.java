import java.awt.EventQueue;

public class usb{
	
	
	public static void main(String[] args) 
	{
        System.out.println("Cymbaly");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					okno window = new okno();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		
		
		/*SwingUtilities.invokeLater(new Runnable(){
		public void run(){
        usb.buildGUI();
		
		 }
		});*/
    }
	/*
	public void buildGUI() //Simple GUI building
	{
		mov.calibrate();
		frame = new JFrame(""); //new JFrame
		frame.setSize(1124,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		buttonPanel = new JPanel(new GridLayout(2,3));
		buttonPanel1 = new JPanel(new GridLayout(1,8));
		
		plus = new JButton("+");
		plus.addActionListener(new plusListener());
		minus = new JButton("-");
		minus.addActionListener(new minusListener());
		next = new JButton("NEXT");
		next.addActionListener(new nextListener());
		escape = new JButton("CAL");
		escape.addActionListener(new escapeListener());
		play = new JButton("Play");
		play.addActionListener(new playListener());
		
		C = new JButton("C");
		C.addActionListener(new CListener());	
		D = new JButton("D");
		D.addActionListener(new DListener());
		E = new JButton("E");
		E.addActionListener(new EListener());	
		F = new JButton("F");
		F.addActionListener(new FListener());	
		G = new JButton("G");
		G.addActionListener(new GListener());	
		A = new JButton("A");
		A.addActionListener(new AListener());	
		H = new JButton("H");
		H.addActionListener(new HListener());	
		C1 = new JButton("C1");
		C1.addActionListener(new C1Listener());	
		
		buttonPanel.add(plus);
		buttonPanel.add(minus);
		buttonPanel.add(next);
		buttonPanel.add(escape);
		buttonPanel.add(play);
		
		buttonPanel1.add(C);
		buttonPanel1.add(D);
		buttonPanel1.add(E);
		buttonPanel1.add(F);
		buttonPanel1.add(G);
		buttonPanel1.add(A);
		buttonPanel1.add(H);
		buttonPanel1.add(C1);
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		frame.getContentPane().add(buttonPanel1, BorderLayout.SOUTH);
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
				File myObj = new File("input.txt");
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
	 }*/

	
}

