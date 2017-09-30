/**
 * This class was inspired from the example provided - originally coded by Michael Kolling (31 July 2000)
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class UserInterface implements ActionListener
{
	private CalcEngine calc;
	private boolean showingAuthor;
	private JFrame frame;
	private JTextField display;
	
	/**
	 * Create a user interface for a given calcEngine
	 */
	
	public UserInterface(CalcEngine engine)
	{
		calc = engine;
		showingAuthor = true;
		makeFrame();
		frame.setVisible(true);
	}
	
	public void setVisible(boolean visible)
	{
		frame.setVisible(visible);
	}
	
	public void makeFrame()
	{
		frame = new JFrame(calc.getTitle());
		
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);
		
		//matrix of 5 columns, 4 rows
		JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
<<<<<<< HEAD
		addButton(buttonPanel, "PF");
		addButton(buttonPanel, "(");
		addButton(buttonPanel, ")");
		addButton(buttonPanel, "AC");
		addButton(buttonPanel, "7");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "9");
		addButton(buttonPanel, "*");
		addButton(buttonPanel, "4");
		addButton(buttonPanel, "5");
		addButton(buttonPanel, "6");
		addButton(buttonPanel, "+");
		addButton(buttonPanel, "1");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "3");
		addButton(buttonPanel, "-");
		addButton(buttonPanel, "0");
		addButton(buttonPanel, "^");
		addButton(buttonPanel, "/");
		addButton(buttonPanel, "=");
=======
		addButton(buttonPanel, "C");
		addButton(buttonPanel, "(");
		addButton(buttonPanel, ")");
		addButton(buttonPanel, "=");
		addButton(buttonPanel, "7");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "9");
		addButton(buttonPanel, "+");
		addButton(buttonPanel, "4");
		addButton(buttonPanel, "5");
		addButton(buttonPanel, "6");
		addButton(buttonPanel, "-");
		addButton(buttonPanel, "1");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "3");
		addButton(buttonPanel, "*");
		addButton(buttonPanel, "PF");
		addButton(buttonPanel, "0");
		addButton(buttonPanel, "^");
		addButton(buttonPanel, "/");
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
	}
	
	private void addButton(Container panel, String buttonText)
	{
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();
		switch(command)
		{
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "(":
			case ")":
			case "*":
			case "/":
			case "-":
			case "+":
			case "^":
				calc.buttonPressed(command);
				displayString();
				break;
				
<<<<<<< HEAD
			case "AC":
=======
			case "C":
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
				calc.clear();
				displayString();
				break;
				
			//displays the postfix equivalent of the infix
			case "PF":
<<<<<<< HEAD
				calc.toPostFix(calc.getDisplayValue());
=======
				calc.convertInfix(calc.getDisplayValue());
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
				displayString();
				calc.clear();
				break;
				
			case "=":
<<<<<<< HEAD
				calc.evaluatePostfix(calc.toPostFix(calc.getDisplayValue()));
=======
				calc.evaluatePostfix(calc.convertInfix(calc.getDisplayValue()));
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
				displayString();
				calc.clear();
				break;
		}
	}
	
	//displays the value
	private void displayString()
	{
		display.setText(calc.getDisplayValue());
	}
}
