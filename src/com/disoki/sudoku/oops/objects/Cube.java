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

package com.disoki.sudoku.oops.objects;

import java.util.ArrayList;


/****************************************************************
 * 
 * Class : Cube
 * 
 * The object that consists of cells 
 * forming sub square matrix in the Sudoku
 * 
 ****************************************************************/

public class Cube extends CellGroup{
	
	/**
	 * Constructor 
	 **/
	public Cube(int cubeIndex, int matrix, ArrayList<Cell> cells) {
		super(cubeIndex, matrix, cells);
		this.construct(cubeIndex, matrix, cells);
	}
	
	

	// Identify the list of cells in the cube,link them to this cube and the cube to the cells
	protected void linkCells(int matrix, ArrayList<Cell> cells) {
		int cellIndex = 0;
		linkedCells = new ArrayList<Cell>();
		
		for (int count=0; count<matrix; count++){	

			cellIndex = ((count % 3) + (matrix * (int)Math.floor(count/3))) + (((this.getIndex() %3)*3) + (27 * (int) Math.floor(this.getIndex()/3)));
			Cell cell = cells.get(cellIndex);
			this.linkedCells.add(cell);
			cell.setLinkedCube(this);
		}
	}
	
}
