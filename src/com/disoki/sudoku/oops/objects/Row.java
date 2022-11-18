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
 * Class : Row
 * 
 * The object that consists of cells 
 * forming horizontal rows in the Sudoku
 * 
 * Inheritance : Extending from the Parent Class -  Cell Group
 * 
 ****************************************************************/

public class Row extends CellGroup{
	
	/**
	 * Constructor 
	 **/
	public Row(int rowIndex, int matrix, ArrayList<Cell> cells) {
		super(rowIndex, matrix, cells);
		this.construct(rowIndex, matrix, cells);
	}
	
	
	/**
	 * 
	 * Method Overriding - Redefining the linkCells method for Row 
	 * 
	 * Identify the list of cells in the row,link them to this row and the row to the cells
	 * 
	 **/
	protected void linkCells(int matrix, ArrayList<Cell> cells) {
		int cellIndex = 0;
		linkedCells = new ArrayList<Cell>();
		
		for (cellIndex=(this.getIndex()*matrix); cellIndex<((this.getIndex()*matrix) + matrix); cellIndex++){			
			Cell cell = cells.get(cellIndex);
			this.linkedCells.add(cell);
			cell.setLinkedRow(this);
		}
		
	}

}
