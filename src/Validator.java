/******************************************************************************** 
Name: Chen, Qinyu
 class: CS-170-03
Assignment: Lab4(Operation program )
 Description: Input Validation; Exception Handling
 ********************************************************************************/
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.*;
/************************************************
@author Qinyu Chen <br>
@version 1.1.3<br>
 class: CS-170-03<br>
 Assignment: Lab4PartI (operation program )<br>
 Description: validating inputs<br>
 ***********************************************/
public class Validator 
{
	
public static int validateIntWithRange(String data, String prompt, int min, int max)
{
	boolean isValid = false;
	int intYear = 4;
  while(!isValid)
  {
	   data = JOptionPane.showInputDialog(null, prompt);
	   try 
	   {
	  intYear = Integer.parseInt(data); 
	     if(intYear < min)
	    	 throw new Exception();
	     else if(intYear > max)
	    	 throw new Exception();
	     
	     isValid = true;
	   }catch(NumberFormatException e)
	   {
		   e.printStackTrace();
		   JOptionPane.showMessageDialog(null,"\nData input error.  Please enter an integer...","Invalid Input",-1);
	   }catch (Exception e)
	   {
		 JOptionPane.showMessageDialog(null, "Input data out of the range error. Please check the data and try again...","Invalid Input",-1);;  
	   }
  }
return intYear;	
}
public static double validateDoubleWithRange(String input, String prompt, double min, double max)
{
    double data = 3.00;
	boolean isValid = false;
  while(!isValid)
  {	
   input = JOptionPane.showInputDialog(null, prompt);
   try 
   {
   data = Double.parseDouble(input);
   if(data < min)
  	 throw new Exception();
   else if(data > max)
  	 throw new Exception();
   isValid = true;
   }catch(NumberFormatException e)
   {
	   JOptionPane.showMessageDialog(null,"Data input error.  Please enter a number...","Invalid Input",-1); 
   }catch (Exception e)
   {
	 JOptionPane.showMessageDialog(null, "Input data out of the range error. Please check the data and try again...","Invalid Input",-1);;  
   }
  }
  return data;
}
public static int validatePositiveInt(String input, String prompt)
{
	boolean isValid = false;
	
	int num = 0;
	while(!isValid)
	{
		 input = JOptionPane.showInputDialog(null, prompt);
	  try {
		  num = Integer.parseInt(input); 
		  if (num <0)
			  throw new Exception();
		 
		  isValid = true;
		  
	  }catch(NumberFormatException e)
	  {
		
		
		  JOptionPane.showMessageDialog(null,"Invalid Input!You must enter an positive interger","Invalid Input",-1); 
		  continue;
	  }catch(Exception e)
	  {
		
		  JOptionPane.showMessageDialog(null,"Invalid Input!You must enter an positive interger","Invalid Input",-1); 
		
		 
		  continue;  
	  }
	      
	
	
     }//end of while loop
	return num;
  }//end of the method
public static String OptionsMatch(String choice, String prompt, String...options)	
{   String[] Options = options;
	
      
   String msg = String.join(" or ", Options);
	boolean isValid = false;
    while(!isValid)
    {
    	choice = JOptionPane.showInputDialog(null,prompt);
    	try 
    	{
    		boolean find = false;
    	for(String option : Options)
    	{
    		if(choice.equalsIgnoreCase(option))
    		{
    			find = true;
    			break;
    		}
    	}
    	if(find) 
    		isValid = true;
    	else 
    		throw new Exception();
    	
    	
    	}catch(Exception e)
    	
    	{
    	    
    		JOptionPane.showMessageDialog(null,"Error: please enter "+msg,"Invalid Input",-1);
    	}
    }
	return choice;
}

public static String OptionsMatch(String choice, JTextArea prompt, String...options)	
{   String[] Options = options;
	
      
   String msg = String.join(" or ", Options);
	boolean isValid = false;
    while(!isValid)
    {
    	choice = JOptionPane.showInputDialog(null,prompt);
    	try 
    	{
    		boolean find = false;
    	for(String option : Options)
    	{
    		if(choice.equalsIgnoreCase(option))
    		{
    			find = true;
    			break;
    		}
    	}
    	if(find) 
    		isValid = true;
    	else 
    		throw new Exception();
    	
    	
    	}catch(Exception e)
    	
    	{
    		  
    		JOptionPane.showMessageDialog(null,"Error: please enter "+msg,"Invalid Input",-1);
    	}
    }
	return choice;
}
   public static String ValidateName(String input, String prompt)
     {
	   String trimedinput = "";
	   
	  boolean isValid = false;
	  while(!isValid)
	  {
		  input = JOptionPane.showInputDialog(null,prompt);  
		   trimedinput = input.trim();
		  try {
			  //throw exception of the name field is empty
			  if(trimedinput.isEmpty()||trimedinput == ""||trimedinput == null)
			  {
				  throw new Exception();
			  }else {
				 
				  isValid = true;
			  }
		  }catch(Exception e){
			  
	    		JOptionPane.showMessageDialog(null,"Error:Name cannot be empty ","Invalid Input",-1);
	    		continue;
		  }//end of try-catch block
	  }//end of while loop
	  
     return trimedinput;
     }

 
}
