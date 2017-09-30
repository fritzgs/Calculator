
/**
 * 
 * @author fritzgs
 *Student number 20071968
 *BSc in Computer Forensics - Year 2
 * 
 *
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
	

	/**
	 * In case the window was closed, show it again.
	 */
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
