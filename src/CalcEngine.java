/**
 * @author fritzgs
 * Student number 20071968
 * BSc in Computer Forensics - Year 2
 * 
 * 
 * @date 4 February 2017
 */

import java.util.Stack;
import java.lang.Math;

public class CalcEngine
{
	private Stack<Character> operatorStack = new Stack<>();
	private Stack<String> valueStack = new Stack<>();
	String displayValue;
	String postfix = "";
	char topOperator;
	
	public CalcEngine()
	{
		displayValue = "";
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
	public void buttonPressed(String button)
	{
		displayValue += button;
	}
	
	
	/**
	 * 
<<<<<<< HEAD
=======
	 * @param infix
	 * @return postfix
	 * 
	 * Here, an infix is taken in using the displayValue that the user has set from buttonPressed.
	 */
	public String convertInfix(String infix)
	{	
		//set the infix as the displayValue provided by the user.
		infix = displayValue;
		//as long as the infix length is greater than 0 do this loop
		for(int i = 0; i < infix.length(); i++)
		{
			//set the variable nextCharacter as the next character of the infix every time it loops
			char nextCharacter = infix.charAt(i);
			
			//Adding variables to postfix string
			switch(nextCharacter)
			{
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					postfix += nextCharacter;	//postfix = postfix + nextCharacter
					break;
					
				case '^':
					operatorStack.push(nextCharacter);
					break;
					
				case '+':
				case '-':
				case '*':
				case '/':
					//Check the precedence here to verify if the operator should be added to the postfix 
					if(!operatorStack.isEmpty() 
							&& checkPrecedence(nextCharacter) == true 
							&& operatorStack.peek() != '(')
					{
						postfix += operatorStack.pop();
					}
					//if it shouldn't be added to the postfix -> add to the operator stack
					operatorStack.push(nextCharacter);
					break;
					
					//push the left parenthesis to the operator stack
				case '(':
					if(infix.contains("("))
						operatorStack.push(nextCharacter);
					break;
					
					//if the next character is the right parenthesis, check if the peek isn't the left parenthesis
					//if not left parenthesis -> pop the operator stack then check for precedence
				case ')':
					while(operatorStack.peek()!='(')
					{
						topOperator = operatorStack.pop();
						//if the next character operator is <= the peek then add the pop to the postfix string.
						if(checkPrecedence(topOperator) == true)
						{
							postfix += operatorStack.pop();
						}
						else
							//if not add the top operator to the postfix.
							postfix += topOperator;
					}
					
					//when the ( is the peek in the operator stack ... get rid of it
					if(operatorStack.peek() == '(')
					{
						operatorStack.pop();
					}
			}
		}
		
		//the last in the stack should be the final step of the equation -> add it to the postfix
		while(!operatorStack.isEmpty())
		{
			postfix += operatorStack.pop();
		}
		//set the displayValue as the postfix.
		return displayValue = postfix;
	}
	
	/**
	 * 
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
	 * @param resultedPostfix
	 * @return valueStack.peek(); 
	 * 
	 * valueStack.peek() should be the result of the postfix
	 */
	public String evaluatePostfix(String resultedPostfix)
	{
		//resultedPostfix = postfix;
		String operandOne, operandTwo;
		double result;
		int index = 0;
		
		//while postfix > index do this
		while(resultedPostfix.length() > index)
		{
			char nextCharacter = resultedPostfix.charAt(index);
			index++;
			
			switch(nextCharacter)
			{
				//push numbers to the valueStack
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					valueStack.push(String.valueOf(nextCharacter));
					break;
					
				//push operators to the operator stack
				case '+':
				case '-':
				case '*':
				case '/':
				case '^':
					operatorStack.push(nextCharacter);
					break;
				
					default:
						break;		
						
			}
			
			//if the operator stack isn't empty and there are 2 numbers in the value stack do this
<<<<<<< HEAD
			while(!operatorStack.isEmpty() && valueStack.size() >= 2)
			{
				topOperator = operatorStack.pop(); //save the operator to top operator
				operandOne = valueStack.pop(); //save the peek of value stack to operandTwo
				operandTwo = valueStack.pop(); // save the new peek of the value stack to operandOne
=======
			while(!operatorStack.isEmpty() && valueStack.size() == 2)
			{
				topOperator = operatorStack.pop(); //save the operator to top operator
				operandTwo = valueStack.pop(); //save the peek of value stack to operandTwo
				operandOne = valueStack.pop(); // save the new peek of the value stack to operandOne
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
			
				result = result(topOperator, operandTwo, operandOne); //do this method which topOperator, operandTwo and operandOne as the parameters
				//convert result to string to add onto stack.
				String resultString = String.valueOf(result);
				valueStack.push(resultString); //push the result to the value stack 
			}
		}//end of loop --- there should only be one value at the value stack 
		
		//set the displayValue as the peek of the value stack.
		return displayValue = valueStack.peek(); 
	}
	
	/**
	 * 
	 * @param opor
	 * @param opand1
	 * @param opand2
	 * @return result
	 * 
	 * take in an operator character, two strings: both numbers
	 */
	private double result(char opor, String opand1, String opand2)
	{
		double result=0;
		//whatever operator is being tested do the matching case.
		switch(opor)
		{
			case '+':
<<<<<<< HEAD
				result = Double.parseDouble(opand2) + Double.parseDouble(opand1);
=======
				result = Double.parseDouble(opand1) + Double.parseDouble(opand2);
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
				break;
				
			case '-':
				result = Double.parseDouble(opand1) - Double.parseDouble(opand2);
				break;
				
			case '*':
				result = Double.parseDouble(opand1) * Double.parseDouble(opand2);
				break;
				
			case '/':
				result = Double.parseDouble(opand1) / Double.parseDouble(opand2);
				break;
				
			case '^':
<<<<<<< HEAD
				result = Math.pow(Double.parseDouble(opand2), Double.parseDouble(opand1));
=======
				result = Math.pow(Double.parseDouble(opand1), Double.parseDouble(opand2));
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
				break;
		}
		//return the result of that operator.
		return result;
	}
	
<<<<<<< HEAD
		
=======
	
	/**
	 * 
	 * @param operator
	 * @return value
	 * 
	 * value is the value of the operator
	 * 
	 * this method gives operators a value so that they can be compared with
	 * for precendce.
	 */
	private int operatorValue(char operator)
	{
		int value = 0;
		switch(operator)
		{
			case '+':
			case '-':
				value = 1;
			case '*':
			case '/':
				value = 2;
			case '^':
				value = 3;
		}
		return value;
	}
		
	/**
	 * 
	 * @param opCheck
	 * @return boolean
	 * 
	 * check for precedence here
	 * 
	 * If the nextCharacter operator being checked is less than or the same value as the peek 
	 * of the operator stack (as long as the stack isn't empty) -> return true
	 * if it is greater than ... then return false
	 */
	private boolean checkPrecedence(char opCheck)
	{
		if(operatorValue(opCheck) <= operatorValue(operatorStack.peek()) && !operatorStack.isEmpty())
		{
			return true;
		}
		else
			return false;
	}
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
	
	//reset the displayValue to empty string
	public void clear()
	{
		displayValue = "";
	}
	
	public String getTitle()
    {
        return("My Calculator");
    }

	public String getDisplayValue()
	{
		return displayValue;
	}	
<<<<<<< HEAD
	
	/**
	 * 
	 * @param input
	 * @return string (postfix)
	 */
	public String toPostFix(String input)
	{
		String result = new String("");
		for(int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			switch(ch)
			{
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					result += ch;
					break;
					
				case '(':
					operatorStack.push(ch);
					break;
					
				case ')':
					while(!operatorStack.isEmpty() && operatorStack.peek() != '(')
					{
						result += operatorStack.pop();
					}
					if(!operatorStack.isEmpty() && operatorStack.peek() != '(')
					{
						return "Invalid Expressions";
					}
					else 
					{
						operatorStack.pop();
					}
					
				case '+':
				case '-':
				case '/':
				case '*':
				case '^':
					while(!operatorStack.isEmpty() && prec(ch) <= prec(operatorStack.peek()))
					{
						result += operatorStack.pop();
					}
					operatorStack.push(ch);
			}//end switch	
		}//end forloop
		
		while(!operatorStack.isEmpty())
		{
			result += operatorStack.pop();
		}
		return displayValue = result;
	}
	
	/**
	 * 
	 * @param ch
	 * @return integer 
	 * 
	 * Checks precedence of operators 
	 *  + and - = 1
	 *  * and / = 2
	 *  	^ 	= 3
	 */
	
	private static int prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }
	
=======
>>>>>>> d0eb13363e97f3f0b19e45de1aef8333fd1e1d3d
}


