
/**
 * 
 * @author fritzgs
 *Student number 20071968
 *BSc in Computer Forensics - Year 2
<<<<<<< HEAD
=======
 * 
 * Known issues: 
 * 1) The clear button doesn't function fully - it will clear the display but the previous displayValue is still set.
 * 2) If the answer to an equation equals a negative value ... it will only display the ablsolute value.
 * 3) Some equations aren't resulting the right answer...
 *
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
 */
public class Calculator
{
	private CalcEngine engine;
	private UserInterface gui;

	/**
	 * Create a new calculator and show it.
	 */
	public Calculator()
	{
		engine = new CalcEngine();
		gui = new UserInterface(engine);
	}
	

//	/**
//	 * In case the window was closed, show it again.
//	 */
	public void show()
	{
		gui.setVisible(true);
	}
	
	public static void main(String[] args)
	{	
		CalcEngine calc = new CalcEngine();
		Calculator main = new Calculator();
		main.show();

		while(true);
	}
}