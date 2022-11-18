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
 * Class : Column
 * 
 * The object that consists of cells 
 * forming vertical columns in the Sudoku
 * 
 ****************************************************************/

public class Column {
	
	/**
	 * Constants / Variables Declaration 
	 **/
	private Integer index = null;
	private ArrayList<Cell> linkedCells = null;
	
	
	/**
	 * Constructor 
	 **/
	public Column(int columnIndex, int matrix, ArrayList<Cell> cells) {
		this.constructColumn(columnIndex, matrix, cells);
	}
	
	
	/**
	 * Protected Methods 
	 **/	
	
	// Return the list of values that are solved in the Column
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
	
	// Building the column with index and list of cells linked with them
	private void constructColumn(int columnIndex, int matrix, ArrayList<Cell> cells) {
		this.setIndex(columnIndex);
		this.linkCells(matrix, cells);
	}

	// Identify the list of cells in the column,link them to this column and the column to the cells
	private void linkCells(int matrix, ArrayList<Cell> cells) {
		int cellIndex = 0;
		linkedCells = new ArrayList<Cell>();
		
		for (cellIndex=this.getIndex(); cellIndex<Math.pow(matrix,2); cellIndex+=matrix){			
			Cell cell = cells.get(cellIndex);
			this.linkedCells.add(cell);
			cell.setLinkedColumn(this);
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
