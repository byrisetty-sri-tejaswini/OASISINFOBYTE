import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class QuizTest extends JFrame implements ActionListener
{
	JLabel label;
	JRadioButton radioButtons[]=new JRadioButton[5];
	JButton btnNext,btnResult;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];

	Timer timer; // Timer for quiz duration
	int timeRemaining;
	JLabel timerLabel;

	QuizTest(String s){
		super(s);
		label=new JLabel();
		add(label);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			radioButtons[i]=new JRadioButton();
			add(radioButtons[i]);
			bg.add(radioButtons[i]);
		}
		btnNext=new JButton("Next");
		btnResult=new JButton("Result");
		btnResult.setVisible(false);
		btnResult.addActionListener(this);
		btnNext.addActionListener(this);
		add(btnNext);
		add(btnResult);
		setData();
		label.setBounds(30,40,450,20);
		radioButtons[0].setBounds(50,80,450,20);
		radioButtons[1].setBounds(50,110,200,20);
		radioButtons[2].setBounds(50,140,200,20);
		radioButtons[3].setBounds(50,170,200,20);
		btnNext.setBounds(100,240,100,30);
		btnResult.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);

		 timeRemaining = 20; // Change this to set the desired quiz duration in seconds
      		timer = new Timer(1000, this); // Timer fires every 1 second
        	timer.setInitialDelay(0);
        	timer.start();
		// Create and configure the timer label
		timerLabel = new JLabel("Time Remaining: 20 seconds"); // Change the initial time as needed
		timerLabel.setBounds(400, 10, 200, 20); // Adjust the position and size as needed
		add(timerLabel);
		

	}

	void setData(){
		radioButtons[4].setSelected(true);
		if(current==0){
			label.setText("Q1 : What is the national fruit");
			radioButtons[0].setText("Apple");
			radioButtons[1].setText("Banana");
			radioButtons[2].setText("Grapes");
			radioButtons[3].setText("Mango");
		}
		if(current==1){
			label.setText("Q2 : What is size of boolean variable");
			radioButtons[0].setText("8");
			radioButtons[1].setText("16");
			radioButtons[2].setText("32");
			radioButtons[3].setText("not known");
		}
		if(current==2){
			label.setText("Q3 : What is the capital of India?");
			radioButtons[0].setText("Gujarat");
			radioButtons[1].setText("Rajasthan");
			radioButtons[2].setText("New Delhi");
			radioButtons[3].setText("Sikkim");
		}
		if(current==3){
			label.setText("Q4 : Which is the Largest animal");
			radioButtons[0].setText("Mammal");
			radioButtons[1].setText("Elephant");
			radioButtons[2].setText("Blue Whale");
			radioButtons[3].setText("Giraffe");
		}
		if(current==4){
			label.setText("Q5 : What are the statements used in java");
			radioButtons[0].setText("if");
			radioButtons[1].setText("if-else");
			radioButtons[2].setText("nested-if");
			radioButtons[3].setText("All the above");
		}
		label.setBounds(30,40,450,20);
		for(int i=0,j=0;i<90;i+=30,j++){
			radioButtons[j].setBounds(50,80+i,200,20);
		}
	}

	boolean checkAns(){
		if(current==0){
			return(radioButtons[3].isSelected());
		}
		if(current==1){
			return(radioButtons[0].isSelected());
		}
		if(current==2){
			return(radioButtons[2].isSelected());
		}
		if(current==3){
			return(radioButtons[2].isSelected());
		}
		if(current==4){
			return(radioButtons[3].isSelected());
		}
		return false;
	}
	
	public static void main(String[] args){
		new QuizTest("Simple Quiz App");
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnNext){
			if(checkAns())
			{	
				count=count+1;
			}
			current++;
			setData();
			
			if(current==4){
				btnNext.setEnabled(false);
				btnResult.setVisible(true);
				btnResult.setText("Result");
				 timer.stop();
			}
		}
		else if(e.getActionCommand().equals("Result")){
			if(checkAns())
			{
				count=count+1;
			}
			current++;
	 		int timeTaken = 20 - timeRemaining;
			JOptionPane.showMessageDialog(this,"Correct Answers are "+count);
			System.exit(0);
		}
		else if (e.getSource() == timer) {
           	if (timeRemaining > 0) {
               	timeRemaining--;
             	timerLabel.setText("Time Remaining: " + timeRemaining + " seconds");
      		} 	
      	 	else
	    	{
            	btnResult.doClick();
        	}
		}
    }
}