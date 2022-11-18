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
import java.util.UUID;


/****************************************************************
 * 
 * Class : Sudoku
 * 
 * The object which is the logical / virtual 
 * twin of the Sudoku Game 
 * 
 ****************************************************************/

public class Sudoku { 
	
	/**
	 * Constants / Variables Declaration 
	 **/
	private static final int MATRIX = 9;

	private String id = null;
	private ArrayList<Cell> cells = null;
	private ArrayList<Row> rows = null;
	private ArrayList<Column> columns = null;
	private ArrayList<Cube> cubes = null;
	
	private ArrayList<Cell> listOfCellsToSolve = null;

	
	/**
	 * Constructor 
	 **/
	public Sudoku() {
		
		this.id = UUID.randomUUID().toString();
		
		this.constructSudoku();
	}
	
	
	
	/**
	 * Public Methods 
	 **/	
	
	// Loading User Inputs to the Constructed Sudoku
	public void load(ArrayList<String> userInput) throws Exception {
		
		this.listOfCellsToSolve = new ArrayList<Cell>();

		if(userInput.size()>= Math.pow(MATRIX,2)) {
			for (int cellIndex = 0; cellIndex < Math.pow(MATRIX,2); cellIndex++) {
				if(!userInput.get(cellIndex).equals("0")) {
					this.cells.get(cellIndex).setValue(Integer.parseInt((String)userInput.get(cellIndex)));
				}
				else {
					this.listOfCellsToSolve.add(cells.get(cellIndex));
				}
			}
		}
		else {
			System.out.print("Please input proper Sudoku Problem !");
			System.exit(0);
		}
	}
	
	
	// Solving the Sudoku loaded with User Input
	public void solve() {
		this.play();
	}
	
	
	// Print Sudoku Cell Values in the <MATRIX> Format
	public void print() {
		
		System.out.println("--------------------");

		for (Cell cell:cells) {
			if(cell.getIndex() !=0 && cell.getIndex()%MATRIX == 0) {
				System.out.println("");
			}
			if(cell.getIndex() !=0 && cell.getIndex()%27 == 0) {
				System.out.println("--------------------");
			}
			if(cell.getIndex()%3 == 0  || cell.getIndex()%27 == 0) {
				System.out.print("|");
			}
			System.out.print(cell.getValue() + " ");
		}
		System.out.println("\n--------------------\n\n");

	}

	
	
	
	
	/**
	 * Private Methods 
	 **/
	
	// Sudoku Object Construction
	private void constructSudoku() {
		this.generateCells();
		this.generateRows();
		this.generateColumns();
		this.generateCubes();
	}

	// Generating List of Cell Objects to Sudoku  
	private void generateCells() {
		Cell cell = null;
		cells = new ArrayList<Cell>();

		for (int cellIndex = 0; cellIndex < Math.pow(MATRIX,2); cellIndex++) {
			cell = new Cell(cellIndex, MATRIX);
			cells.add(cell);
		}
	}

	// Generating List of Row Objects to Sudoku
	private void generateRows() {
		Row row = null;
		rows = new ArrayList<Row>();

		for (int rowIndex = 0; rowIndex < MATRIX; rowIndex++) {
			row = new Row(rowIndex, MATRIX, cells);
			rows.add(row);
		}
	}

	// Generating List of Column Objects to Sudoku
	private void generateColumns() {
		Column column = null;
		columns = new ArrayList<Column>();

		for (int columnIndex = 0; columnIndex < MATRIX; columnIndex++) {
			column = new Column(columnIndex, MATRIX, cells);
			columns.add(column);
		}
	}

	// Generating List of Cube Objects to Sudoku
	private void generateCubes() {
		Cube cube = null;
		cubes = new ArrayList<Cube>();

		for (int cubeIndex = 0; cubeIndex < MATRIX; cubeIndex++) {
			cube = new Cube(cubeIndex, MATRIX, cells);
			cubes.add(cube);
		}
	}

	
	
	// Playing Sudoku to Solve the Problem
	private void play() {
		Cell cellToSolve = null;
		
		this.calculatePossibleValues();
		cellToSolve = this.pickCellToSolve();
		
		if( cellToSolve != null) {
			cellToSolve.solve();
			this.listOfCellsToSolve.remove(cellToSolve);
			this.solve();
		}
	}
	
	// Calculating Possible solvable values for Each Cell
	private void calculatePossibleValues() {
		for (Cell cell:this.listOfCellsToSolve) {
			cell.calculatePossibleValues();
		}
	}
	
	// Picking a cell that is eligible to solve
	private Cell pickCellToSolve() {
		for (Cell cell:this.listOfCellsToSolve) {
			if(cell.isEligibleToSolve()) {
				return cell;
			}
		}
		return null;		
	}
	
}
