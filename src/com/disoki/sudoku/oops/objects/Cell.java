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
 * Class : Cell
 * 
 * The primitive object that has 
 * the core properties and methods of Sudoku
 * 
 ****************************************************************/

public class Cell {
	
	/**
	 * Constants / Variables Declaration 
	 **/
	private Integer index = null;
	private Integer value = 0;
	
	private Row linkedRow = null;
	private Column linkedColumn = null;
	private Cube linkedCube = null;
	
	private ArrayList<String> possibleValues = null;


	
	/**
	 * Constructor 
	 **/
	public Cell(int cellIndex, int matrix) {
		this.constructCell(cellIndex, matrix);
	}
	
	
	/**
	 * Protected Methods 
	 **/	
	
	// The cell will identify the possible values that can be filled 
	protected void calculatePossibleValues() {
		this.possibleValues.removeAll(this.linkedRow.getSolvedValues());
		this.possibleValues.removeAll(this.linkedColumn.getSolvedValues());
		this.possibleValues.removeAll(this.linkedCube.getSolvedValues());
	}
	
	// Check whether this cell is eligible to be solved, with ONE possible value
	protected Boolean isEligibleToSolve() {
		Boolean isEligible = false;
		if(this.possibleValues.size() == 1) {
			isEligible = true;
		}
		return isEligible;
	}
	
	// Solving this current cell by filling the value
	protected void solve() {
		this.setValue(Integer.parseInt(this.possibleValues.get(0)));
	}
	
	
	
	/**
	 * Private Methods 
	 **/	
	
	// Building the cell with index and initialising the possible values
	private void constructCell(int cellIndex, int matrix) {
		this.setIndex(cellIndex);
		this.initPossibleValues(matrix);
	}
	
	// Initialising the possible values of the cell with maximum combinations of the matrix
	private void initPossibleValues(int matrix) {	
		this.possibleValues = new ArrayList<String>();
		for (int count=0; count<matrix; count++) {
			this.possibleValues.add(Integer.toString(count+1));
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

	protected Integer getValue() {
		return value;
	}

	protected void setValue(Integer value) {
		this.value = value;
	}

	protected Row getLinkedRow() {
		return linkedRow;
	}

	protected void setLinkedRow(Row linkedRow) {
		this.linkedRow = linkedRow;
	}

	protected Column getLinkedColumn() {
		return linkedColumn;
	}

	protected void setLinkedColumn(Column linkedColumn) {
		this.linkedColumn = linkedColumn;
	}

	protected Cube getLinkedCube() {
		return linkedCube;
	}

	protected void setLinkedCube(Cube linkedCube) {
		this.linkedCube = linkedCube;
	}


}
