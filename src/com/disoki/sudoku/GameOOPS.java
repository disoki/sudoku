/****************************************************************
 * 
 * Copyright (C) 2022 Dhinesh Sornakili. All rights reserved.
 * https://github.com/disoki/sudoku
 * 
 * Project 	: Sudoku Problem Solving with OOPS / Java
 * Version	: 1.0
 * 
 * Author 	: Dhinesh Sornakili
 * Created 	: 15.01.2022
 * 
 ****************************************************************/

package com.disoki.sudoku;

import java.util.ArrayList;
import java.util.Arrays;

import com.disoki.sudoku.oops.objects.Sudoku;


/****************************************************************
 * 
 * Class : Game
 * 
 * Main class which is runnable with 
 * the userInput to the application
 * 
 ****************************************************************/

public class GameOOPS {

	
	/** 
	 * Main function 
	 **/
	public static void main(String args[]) throws Exception {
		
		ArrayList<String> userInput = new ArrayList<String>();
		
		String[] inputList = {"6","5","9","0","1","0","2","8","0"
							 ,"1","0","0","0","5","0","0","3","0"
							 ,"2","0","0","8","0","0","0","1","0"
							 ,"0","0","0","1","3","5","0","7","0"
							 ,"8","0","0","9","0","0","0","0","2"
							 ,"0","0","3","0","7","8","6","4","0"
							 ,"3","0","2","0","0","9","0","0","4"
							 ,"0","0","0","0","0","1","8","0","0"
							 ,"0","0","8","7","6","0","0","0","0"
							};
		
		userInput.addAll(Arrays.asList(inputList));
		
		Sudoku sudoku =  new Sudoku();
		sudoku.load(userInput);
	
		System.out.println("Sudoku Problem :");
		sudoku.print();
		
		sudoku.solve();
		
		System.out.println("Solved Sudoku :");
		sudoku.print();
		
	}
}
