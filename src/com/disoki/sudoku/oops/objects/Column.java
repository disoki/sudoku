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
 * Class : Column
 * 
 * The object that consists of cells 
 * forming vertical columns in the Sudoku
 * 
 * Inheritance : Extending from the Parent Class -  Cell Group
 * 
 ****************************************************************/

public class Column extends CellGroup{
	
	/**
	 * Constructor 
	 **/
	public Column(int columnIndex, int matrix, ArrayList<Cell> cells) {
		super(columnIndex, matrix, cells);
		this.construct(columnIndex, matrix, cells);
	}
	
	

	/**
	 * 
	 * Method Overriding - Redefining the linkCells method for Column 
	 * 
	 * Identify the list of cells in the column,link them to this column and the column to the cells
	 * 
	 **/
	protected void linkCells(int matrix, ArrayList<Cell> cells) {
		int cellIndex = 0;
		linkedCells = new ArrayList<Cell>();
		
		for (cellIndex=this.getIndex(); cellIndex<Math.pow(matrix,2); cellIndex+=matrix){			
			Cell cell = cells.get(cellIndex);
			this.linkedCells.add(cell);
			cell.setLinkedColumn(this);
		}
	}

}
