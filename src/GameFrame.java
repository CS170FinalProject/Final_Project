import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class GameFrame extends JFrame
{
	String username;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	GamePanel panel;
	
	public GameFrame(String username,boolean visible)
	{
		this.username = username;
		setVisible(visible);
		
		setMinimumSize(new Dimension(530,490));
		pack();
		centerWindow(this);
		panel = new GamePanel(this.username);
		panel.setVisible(true);
		add(panel);
		
		
	}
	private void centerWindow(JFrame frame) {		//Programmer-definded method to centering a window open
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//Compute center width
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//Compute ceenter height
		setLocation(centeredWidth, centeredHeight);						//call method in JFrame
	}
	public void closeThis()
	{
		this.dispose();
	}
}
class GamePanel extends JPanel
{
    String username;
    CardLayout card; 
    JPanel Qu1 = new JPanel(),
    		Qu2 = new JPanel(),
    		Qu3 = new JPanel(),
    		Qu4 = new JPanel(),
    		Qu5 = new JPanel(),
    		Qu6 = new JPanel(),
    		resultPanel = new JPanel(),
    		rankingPanel = new JPanel();
    ButtonGroup group1,group2,group3,group4,group5,group6;
    int score = 0;
    ArrayList<String> answers = new ArrayList<String>();
    
    		
    
    public GamePanel(String username)
    {
    	this.username = username;
    	card=new CardLayout(40,30); 
    	setLayout(card);
    	
    	setBGcolor();
    	 
    	 Qu1Panel(this);
    	
    	Qu2Panel(this);
    	Qu3Panel(this);
    	Qu4Panel(this);
    	Qu5Panel(this);
    	Qu6Panel(this);
    	//DisplayScore();
    	
    System.out.println(score);
    	
    }
    public void setBGcolor()
    {
    	Qu1.setBackground(Color.WHITE);
    	Qu2.setBackground(Color.white);
    	Qu3.setBackground(Color.WHITE);
    	Qu4.setBackground(Color.WHITE);
    	Qu5.setBackground(Color.WHITE);
    	Qu6.setBackground(Color.WHITE);
    	resultPanel.setBackground(Color.white);
    	
    }
    public void Qu6Panel(JPanel panel)
    {
    	Container verticalbox = Box.createVerticalBox();
   	 JButton nextBtn = new JButton("Next");
    	JLabel errormsg = new JLabel("Please select an answer");
    	
    	errormsg.setVisible(false);
    	errormsg.setForeground(Color.red);
    	verticalbox.add(errormsg);
    	JLabel label= new JLabel("Choose the one in correct order: ");
    	verticalbox.add(label);
    	JRadioButton btnOT = new JRadioButton("O P Q S T"),//wrong
    			btnVZ = new JRadioButton("V W X Y Z");//CORRECT
    	group6= new ButtonGroup();
    	
    	group6.add(btnVZ);
    	group6.add(btnOT);
    	verticalbox.add(btnVZ);
    	verticalbox.add(btnOT);
    	 nextBtn.addActionListener(new ActionListener()
		  {
			 public void actionPerformed(ActionEvent e)
			 {
			  if(btnVZ.isSelected())
			  {
				 
				  addScore();
				 
				  DisplayScore(score,panel);
				
				  card.next(panel);
				
				  
			  }
			  else if(btnOT.isSelected())
			  {
				 
				 
				  DisplayScore(score,panel);
				 
				  card.next(panel);
			  }else {
				  errormsg.setVisible(true);
			  }
			 
			 }
		  });
   	 verticalbox.add(nextBtn);
   	 Qu6.add(verticalbox);
   	 add(Qu6);
    	
    }
    public void Qu5Panel(JPanel panel)
    {
    	 Container verticalbox = Box.createVerticalBox();
    	 JButton nextBtn = new JButton("Next");
     	JLabel errormsg = new JLabel("Please select an answer");
     	
     	errormsg.setVisible(false);
     	errormsg.setForeground(Color.red);
     	verticalbox.add(errormsg);
     	JLabel label= new JLabel("Choose the one in correct order: ");
     	verticalbox.add(label);
     	JRadioButton btnRV = new JRadioButton("R S T U V"),//correct
     			btnIM = new JRadioButton("I K L P M");//wrong
     	group5= new ButtonGroup();
     	
     	group5.add(btnIM);
     	group5.add(btnRV);
     	verticalbox.add(btnIM);
     	verticalbox.add(btnRV);
     	 nextBtn.addActionListener(new ActionListener()
		  {
			 public void actionPerformed(ActionEvent e)
			 {
			  if(btnIM.isSelected())
			  {
				 
			
				
				  card.next(panel);
				
				  
			  }
			  else if(btnRV.isSelected())
			  {
				 
				 addScore();
				
				 
				  card.next(panel);
			  }else {
				  errormsg.setVisible(true);
			  }
			 
			 }
		  });
    	 verticalbox.add(nextBtn);
    	 Qu5.add(verticalbox);
    	 add(Qu5);
     	
     	
    }
    public void Qu4Panel(JPanel panel)
    {
    	 Container verticalbox = Box.createVerticalBox();
    	 JButton nextBtn = new JButton("Next");
     	JLabel errormsg = new JLabel("Please select an answer");
     	errormsg.setVisible(false);
     	errormsg.setForeground(Color.red);
     	verticalbox.add(errormsg);
     	JLabel label= new JLabel("Choose the one in correct order: ");
     	JRadioButton btnOR = new JRadioButton("O P Q R"),//correct
     			btnUX = new JRadioButton("U W K X");
     	group4 = new ButtonGroup();
     	group4.add(btnOR);
     	group4.add(btnUX);
     	verticalbox.add(label);
     	verticalbox.add(btnOR);
     	verticalbox.add(btnUX);
     	 nextBtn.addActionListener(new ActionListener()
		  {
			 public void actionPerformed(ActionEvent e)
			 {
			  if(btnOR.isSelected())
			  {
				 
				//  score += 10;
				  addScore();
				 
				
				
				  card.next(panel);
				
				  
			  }
			  else if(btnUX.isSelected())
			  {
				 
				  System.out.println(score);
				
				 
				  card.next(panel);
			  }else {
				  errormsg.setVisible(true);
			  }
			 
			 }
		  });
     	 verticalbox.add(nextBtn);
     	Qu4.add(verticalbox);
     	add(Qu4);
     	
    }
    public void Qu3Panel(JPanel panel)
    {
    	 Container verticalbox = Box.createVerticalBox();
    	 JButton nextBtn = new JButton("Next");
     	JLabel errormsg = new JLabel("Please select an answer");
     	errormsg.setVisible(false);
     	errormsg.setForeground(Color.red);
     	verticalbox.add(errormsg);
     	JLabel label= new JLabel("Choose the one in correct order: ");
     	JRadioButton btnGIH = new JRadioButton("G I H"),//wrong
     			btnXRW = new JRadioButton("X R W"),//wrong,
     			btnSTU = new JRadioButton("S T U");//correct;
     	group3 = new ButtonGroup();
     	group3.add(btnGIH);
     	group3.add(btnXRW);
     	group3.add(btnSTU);
     	verticalbox.add(label);
     	verticalbox.add(btnGIH);
     	verticalbox.add(btnXRW);
     	verticalbox.add(btnSTU);
     	nextBtn.addActionListener(new ActionListener()
		  {
			 public void actionPerformed(ActionEvent e)
			 {
			  if(btnGIH.isSelected())
			  {
				//  System.out.println(btnK.getText());
			
				 
				  System.out.println(score);
				 
				  card.next(panel);
				
				  
			  }
			  else if(btnXRW.isSelected())
			  {
				  System.out.println(btnXRW.getText());
				
				  System.out.println(score);
				
				  card.next(panel);
			  }else if(btnSTU.isSelected())
			  {
				 addScore();
				
				  card.next(panel);
			  }
			  else {
				  errormsg.setVisible(true);
			  }
			 
			 }
		  });
     	 verticalbox.add(nextBtn);
     	 Qu3.add(verticalbox);
     	 add(Qu3);
    }
    public void Qu2Panel(JPanel panel)
    {
    	 Container verticalbox = Box.createVerticalBox();
    	 JButton nextBtn = new JButton("Next");
     	JLabel errormsg = new JLabel("Please select an answer");
     	errormsg.setVisible(false);
     	errormsg.setForeground(Color.red);
     	verticalbox.add(errormsg);
     	JLabel label= new JLabel("What comes after J in the alphabet?");
     	JRadioButton btnK = new JRadioButton("K"),
     			btnP = new JRadioButton("P");
     	group2 = new ButtonGroup();
     	group2.add(btnK);
     	group2.add(btnP);
     	verticalbox.add(label);
     	verticalbox.add(btnK);
     	verticalbox.add(btnP);
     	 nextBtn.addActionListener(new ActionListener()
		  {
			 public void actionPerformed(ActionEvent e)
			 {
			  if(btnK.isSelected())
			  {
				  System.out.println(btnK.getText());
				//  score += 10;
				  addScore();
				 
				  System.out.println(score);
				
				  card.next(panel);
				
				  
			  }
			  else if(btnP.isSelected())
			  {
				  System.out.println(btnP.getText());
				  answers.add(btnP.getText());
				  System.out.println(score);
				 
				  card.next(panel);
			  }else {
				  errormsg.setVisible(true);
			  }
			 
			 }
		  });
     	 verticalbox.add(nextBtn);
     	 Qu2.add(verticalbox);
     	 add(Qu2);
    	 
    }
    public void Qu1Panel(JPanel panel)
    
    { Container verticalbox = Box.createVerticalBox();
    	JRadioButton btnC= new JRadioButton();
    	btnC.setText("C");
    	JRadioButton btnE = new JRadioButton();
    	JButton nextBtn = new JButton("Next");
    	JLabel errormsg = new JLabel("Please select an answer");
    	errormsg.setVisible(false);
    	errormsg.setForeground(Color.red);
    	verticalbox.add(errormsg);
    	//nextBtn.setEnabled(false);
    	btnE.setText("E");
    	group1 = new ButtonGroup();
    	group1.add(btnC);
    	group1.add(btnE);
    	
    	
    	 JLabel label = new JLabel("What comes after D in the alphabet?");
    	 verticalbox.add(label);
    	 verticalbox.add(btnC);
    	 verticalbox.add(btnE);
    	 verticalbox.add(nextBtn);
    	 nextBtn.addActionListener(new ActionListener()
		  {
			 public void actionPerformed(ActionEvent e)
			 {
			  if(btnC.isSelected())
			  {
				  System.out.println(btnC.getText());
				  card.next(panel);
				  
			  }
			  else if(btnE.isSelected())
			  {
				  System.out.println(btnE.getText());
				  addScore();
				  //score += 10;
				  card.next(panel);
				 
			  }else {
				  errormsg.setVisible(true);
			  }
			 
			 }
		  });
    	 Qu1.add(verticalbox);
    	
    	 add(Qu1);
    	
    }
    public void DisplayScore(int score,JPanel panel)
    {
    	
    	Container verticalbox = Box.createVerticalBox();
    JLabel label = new JLabel("Your score is: ");
   JLabel scoreLabel = new JLabel(Integer.toString(score));
   Font scoreFont = new Font("san-serif",Font.PLAIN, 25);
   label.setAlignmentX(CENTER_ALIGNMENT);
   scoreLabel.setAlignmentX(CENTER_ALIGNMENT);
   scoreLabel.setForeground(new Color(250,45,46));
   scoreLabel.setFont(scoreFont);
   JButton nextBtn = new JButton("Okay");
   nextBtn.setAlignmentX(CENTER_ALIGNMENT);
    verticalbox.add(label);
  verticalbox.add(scoreLabel);
  verticalbox.add(nextBtn);
    resultPanel.add(verticalbox);
    add(resultPanel);
    
   
   
	 nextBtn.addActionListener(new ActionListener()
	  {
		 public void actionPerformed(ActionEvent e)
		 {
		   Object src = e.getSource();
		   if(src == nextBtn)
		   {
			   File myFile = new File("usersinfo.txt");
			    try {
			    	PrintWriter out = new PrintWriter(new FileWriter(myFile, true));
			    	out.println(username.trim()+":"+score);
			    	out.close();
			    }catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    SortData();
			    card.next(panel);
		   }
		 }
	  });
    	
    }
    public void SortData()
    
    {
    	 File myFile = new File("usersinfo.txt");
    	 String info = "";
    	 ArrayList<String> usersinfo = new ArrayList<String>();
    	
    	try {
    		BufferedReader in = new BufferedReader( //Create input file
			           new FileReader(myFile));
    		 String line = in.readLine();
    		 info+=line;
    		 usersinfo.add(line);
			 //Read in a line from file
			 while (line != null) {
			     //  System.out.print(line);
				 //System.out.print(this.ifNewUser(line).toString());
		
				
			       line = in.readLine();
			       
			       if(line == null)
			    	   break;
			       info += line;
			       usersinfo.add(line);
			       
			    }
			    in.close();
			   
    	}catch (FileNotFoundException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	} catch (IOException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	
    
    	//String[] users = info.split(",");
    	System.out.println(usersinfo.toString());
    	StoreInfo(usersinfo);
    	
    }
    public void StoreInfo(ArrayList<String> usersinfo)
    {
    ArrayList<UserInfo> usersdata = new ArrayList<UserInfo>();
    	for(String info: usersinfo)
    	{
    		String[] parse = info.split(":");
    		System.out.println(parse[1]);
    		try {
    		UserInfo user = new UserInfo(parse[0],Integer.parseInt(parse[1]));
    		usersdata.add(user);
    		}catch(NumberFormatException e)
    		{
    			continue;
    		}
    		
    	}
    		
    	LeaderBoard(usersdata);
    }
    public void LeaderBoard(ArrayList<UserInfo> usersdata)
    
    
    {
        String rank = "Rank\tUsername\tScore\t\n";
    	Collections.sort(usersdata, new NumberComparator());	
    	int count = 0;
    	ArrayList<UserInfo> topFive = new ArrayList<UserInfo>();
    	for(UserInfo user: usersdata)
    	{
    		count++;
    		if(count > 5)
    			break;
    		System.out.println(user.getName()+"\t"+user.getScore());
    		topFive.add(user);
    	}
    	int ranknum =1;
    	for(UserInfo user: topFive)
    	{
    	rank += ranknum+"\t"+user.getName()+"\t"+user.getScore()+"\t\n";
    	ranknum++;
    	}
    	JTextArea displayrank = new JTextArea(rank);
    	displayrank.setEditable(false);
    	rankingPanel.add(displayrank);
    	add(rankingPanel);
    	
    	
    }
    public void addScore()
    {
    	score += 10;
    	
    }
    
}
