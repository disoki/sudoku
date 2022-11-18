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

package com.disoki.sudoku.basic.objects;

import java.util.ArrayList;


/****************************************************************
 * 
 * Class : Row
 * 
 * The object that consists of cells 
 * forming horizontal rows in the Sudoku
 * 
 ****************************************************************/

public class Row {
	
	/**
	 * Constants / Variables Declaration 
	 **/
	private Integer index = null;
	private ArrayList<Cell> linkedCells = null;
	
	
	/**
	 * Constructor 
	 **/
	public Row(int rowIndex, int matrix, ArrayList<Cell> cells) {
		this.constructRow(rowIndex, matrix, cells);
	}
	
	
	/**
	 * Protected Methods 
	 **/	
	
	// Return the list of values that are solved in the Row
	protected ArrayList<String> getSolvedValues(){
		ArrayList<String> solvedValues = new ArrayList<String>();
		for (Cell cell:linkedCells) {
			if (cell.getValue() !=0 ) {
				solvedValues.add(cell.getValue().toString());
			}
		}
		return solvedValues;
	}
	
	
	/**
	 * Private Methods 
	 **/	
	
	// Building the row with index and list of cells linked with them
	private void constructRow(int rowIndex, int matrix, ArrayList<Cell> cells) {
		this.setIndex(rowIndex);
		this.linkCells(matrix, cells);
	}

	// Identify the list of cells in the row,link them to this row and the row to the cells 
	private void linkCells(int matrix, ArrayList<Cell> cells) {
		int cellIndex = 0;
		linkedCells = new ArrayList<Cell>();
		
		for (cellIndex=(this.getIndex()*matrix); cellIndex<((this.getIndex()*matrix) + matrix); cellIndex++){			
			Cell cell = cells.get(cellIndex);
			this.linkedCells.add(cell);
			cell.setLinkedRow(this);
		}
		
	}

	
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
