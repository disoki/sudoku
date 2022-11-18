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

package com.disoki.sudoku.basic.objects;

import java.util.ArrayList;


/****************************************************************
 * 
 * Class : Cube
 * 
 * The object that consists of cells 
 * forming sub square matrix in the Sudoku
 * 
 ****************************************************************/

public class Cube {

	/**
	 * Constants / Variables Declaration 
	 **/
	private Integer index = null;
	private ArrayList<Cell> linkedCells = null;
	
	
	/**
	 * Constructor 
	 **/
	public Cube(int cubeIndex, int matrix, ArrayList<Cell> cells) {
		this.constructCube(cubeIndex, matrix, cells);
	}
	
	
	/**
	 * Protected Methods 
	 **/
	
	// Return the list of values that are solved in the Cube
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
	
	// Building the cube with index and list of cells linked with them
	private void constructCube(int cubeIndex, int matrix, ArrayList<Cell> cells) {
		this.setIndex(cubeIndex);
		this.linkCells(matrix, cells);
	}

	// Identify the list of cells in the cube,link them to this cube and the cube to the cells
	private void linkCells(int matrix, ArrayList<Cell> cells) {
		int cellIndex = 0;
		linkedCells = new ArrayList<Cell>();
		
		for (int count=0; count<matrix; count++){	

			cellIndex = ((count % 3) + (matrix * (int)Math.floor(count/3))) + (((this.getIndex() %3)*3) + (27 * (int) Math.floor(this.getIndex()/3)));
			Cell cell = cells.get(cellIndex);
			this.linkedCells.add(cell);
			cell.setLinkedCube(this);
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
