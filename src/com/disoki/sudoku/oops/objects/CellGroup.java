/****************************************************************
 * 
 * Copyright (C) 2022 Dhinesh Sornakili. All rights reserved.
 * https://github.com/disoki/sudoku.git
 * 
 * Project 	: Sudoku Problem Solving with OOPS / Java
 * Version	: 1.0
 * 
 * Author 	: Dhinesh Sornakili
 * Created 	: 15.01.2022
 * 
 ****************************************************************/

package com.disoki.sudoku.oops.objects;

import java.util.ArrayList;


/****************************************************************
 * 
 * Class : CellGroup
 * 
 * The Parent Object for Row, Column and Cube 
 * which are formed by linking multiple cells
 * 
 ****************************************************************/

public abstract class CellGroup {
	
	/**
	 * Constants / Variables Declaration 
	 **/
	protected Integer index = null;
	protected ArrayList<Cell> linkedCells = null;
	
	
	/**
	 * Constructor 
	 **/
	public CellGroup(int index, int matrix, ArrayList<Cell> cells) {
		this.construct(index, matrix, cells);
	}
	
	
	/**
	 * Protected Methods 
	 **/	
	
	// Return the list of values that are solved in the CellGroup
	protected ArrayList<String> getSolvedValues(){
		ArrayList<String> solvedValues = new ArrayList<String>();
		for (Cell cell:linkedCells) {
			if (cell.getValue() !=0 ) {
				solvedValues.add(cell.getValue().toString());
			}
		}
		return solvedValues;
	}	
	
	// Building the CellGroup with index and list of cells linked with them
	protected void construct(int index, int matrix, ArrayList<Cell> cells) {
		this.setIndex(index);
		this.linkCells(matrix, cells);
	}

	/**
	 * Abstraction - Abstract Methods will be implemented in child  
	 **/
	
	// Identify the list of cells in the CellGroup,link them to this CellGroup and the CellGroup to the cells 
	abstract void linkCells(int matrix, ArrayList<Cell> cells);
	
	
	/**	 
	 * Getters & Setters Methods 
	 **/	
	protected Integer getIndex() {
		return index;
	}

	protected void setIndex(Integer index) {
		this.index = index;
	}

}
