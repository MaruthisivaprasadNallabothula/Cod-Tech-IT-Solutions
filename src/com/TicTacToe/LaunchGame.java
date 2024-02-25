package com.TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class LaunchGame {

	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		HumanPlayer p1 = new HumanPlayer("bob",'x');
		AIPlayer p2 = new AIPlayer("TAI", 'o');
		Player cp;
		cp=p1;
	while(true) {
		System.out.println(cp.name + " turn");
		cp.makeMove();
		TicTacToe.dispBoard();
		if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) {
			System.out.println(cp.name+" has Won");
			break;
		}
		else if(TicTacToe.checkDraw()) {
			System.out.println("Game is a draw");
			break;
		}
		else {
			if(cp==p1) {
				cp=p2;
			}
			else {
				cp=p1;
			}
		}
	}

	}

}

/* class TicTacToe consists of methods like TicTacToe, initBoard, dispBoard, placeMark, checkRowWin,
 * checkDiagWin, checkColWin, checkDraw  */
class TicTacToe{
	static char[][] board; // 2D character array with board as variable name
	
/*This TicTacToe method will create an 3*3 TicTacToe board */
    public TicTacToe() {
		board = new char[3][3];
		initBoard();
	}
	
/* This initBoard method will create an 3*3 TicTacToe board with empty spaces */ 	
	void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j] = ' ';
			}
		}
	}
	
/* This dispBoard method will display a 3*3 TicTacToe board in console */	
	static void dispBoard() {
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j] +" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
/*This placeMark method will take row, col, mark as inputs and based on those inputs, 
 * it will place the respected character on 3*3 TicTacToe board */
	 static void placeMark(int row, int col, char mark) {
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			board[row][col] = mark;
		}
		else {
			System.out.println("Invalid position");
		}
	}
/* This method will check for Column wise win and if player wins, the method will 
 * return a boolean value */	
	static boolean checkColWin() {
		for(int j=0; j<=2; j++) {
			if(board[0][j] != ' ' &&  board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
				return true;
			}
		}
		return false;
	}
/* This method will check for Row wise win and if player wins, the method will 
* return a boolean value */
	static boolean checkRowWin() {
		for(int i=0; i<=2;i++) {
			if(board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
				return true;
			}
		}
		return false;
	}
/* This method will check for Diagonal wise win and if player wins, the method will 
 * return a boolean value */
	static boolean checkDiagWin() {
		if(board[0][0] != ' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2] != ' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
			return true;
		}
		return false;
	}
/* This method will check for Draw and if game is Draw, the method will 
 * return a boolean value */
	static boolean checkDraw() {
		for(int i=0; i<=2; i++) {
			for(int j=0; j<=2; j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}
	
}
/*This Player class is a parent class for HumanPlayer class and AIPlayer class and 
 * also consists of one abstract makeMove method and isValidMove method */
abstract class Player{
	String name;
	char mark;
	
	abstract void makeMove();//abstract method, implementation was given by extended class 
	
/* This isValidMove method will take row and col as inputs and validate the player's  move and 
 * if inputs are with in the range then returns a boolean value */	
	boolean isValidMove(int row, int col) {
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			if(TicTacToe.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
}

/* HumanPlayer is a child class for Player class and gives implementation for 
 * makeMove abstract method */
class HumanPlayer extends Player{
	
	HumanPlayer(String name, char mark){
		this.name=name;
		this.mark=mark;
	}
	
/* This makeMove method will take row and col as inputs and validate these inputs given,
 * if these inputs are correct then it will place a mark in 3*3 TicTacToe board */
	void makeMove() {
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		do {
			System.out.println("Enter the Row and col");
			System.out.println("Enter in 0 0 format");
			 row = sc.nextInt();
			 col = sc.nextInt();
		}while(!isValidMove(row, col));
		TicTacToe.placeMark(row, col, mark);
	}
}
/* AIPlayer is a child class for Player class and gives implementation for 
 * makeMove abstract method */
class AIPlayer extends Player{
	AIPlayer(String name, char mark){
		this.name=name;
		this.mark=mark;
	}
/* This makeMove method will generate row and col inputs randomly with help of Random class and validate 
 * these inputs given, if these inputs are correct then it will place a mark in 3*3 TicTacToe board */
	void makeMove() {
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		do {
			Random r = new Random();
			 row = r.nextInt(3);
			 col = r.nextInt(3);
		}while(!isValidMove(row, col));
		TicTacToe.placeMark(row, col, mark);
	}
	
}
	
	
