package echelon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Matrix {
	private int row;
	private int col;
	private int[][] matrix;
	
	public Matrix(int row, int col){
		this.row = row;
		this.col = col;
		matrix = new int[row][col];
		//Scanner kbd = new Scanner(System.in);
		//System.out.println("Do you want a randomly generated matrix or would you like to pick values?");
		//System.out.println("Type 'default' for random numbers. Type anything to proceed to type your own.");
		//String choice = kbd.nextLine();
		Random random = new Random();
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				//if(!choice.equals(new String("default"))){
					//matrix[i][j] = kbd.nextInt();
					//}
				//else{
					matrix[i][j] = random.nextInt(10);
				  // }
			}
		}
		//kbd.close();
	}

	
	public Matrix add(Matrix toAdd){
		int toAddCol = toAdd.getColSize();
		int toAddRow = toAdd.getRowSize();
		int[][] toAddMatrix = toAdd.getMatrix();
		Matrix toReturn = new Matrix(row, col); //random matrix to be edited
		if(col == toAddCol && row == toAddRow){
			for(int i = 0; i < matrix.length; i++){
				for(int j = 0; j < matrix[i].length; j++){
					toReturn.matrix[i][j] = matrix[i][j] + toAddMatrix[i][j];
				}
			}
		}
		else{
			throw new IllegalStateException("ERROR: Matrices must be of same dimensions");
		}
		return toReturn;
	}
	
	public Matrix subtract(Matrix toSubtract){
		int toSubCol = toSubtract.getColSize();
		int toSubRow = toSubtract.getRowSize();
		int[][] toAddMatrix = toSubtract.getMatrix();
		Matrix toReturn = new Matrix(row, col); //random matrix to be edited
		if(col == toSubCol && row == toSubRow){
			for(int i = 0; i < matrix.length; i++){
				for(int j = 0; j < matrix[i].length; j++){
					toReturn.matrix[i][j] = matrix[i][j] - toAddMatrix[i][j];
				}
			}
		}
		else{
			throw new IllegalStateException("ERROR: Matrices must be of same dimensions");
		}
		return toReturn;
	}
	
	
	public Matrix multiply(Matrix toMult){
		if(col == toMult.getRowSize()){//if it is possible to multiply
			int [][] answerHolder = new int[row][toMult.getColSize()];
			for (int i = 0; i < matrix.length; i++) { 
				for (int j = 0; j < toMult.matrix[0].length; j++) { 
					for (int k = 0; k < matrix[0].length; k++) {
						int summation = matrix[i][k] * toMult.matrix[k][j];
						answerHolder[i][j] += summation;
					}
				}
			}
			Matrix toReturn = new Matrix(row, toMult.getColSize());
			toReturn.matrix = answerHolder;
			return toReturn;
		}
		else{
			throw new IllegalStateException("ERROR. Matrix Mult is impossible on given matrices");
		}

	}
	
	public String toString(){
		String s = "";
		for(int i = 0; i < matrix.length; i++){
			s+= '\n';
			for(int j = 0; j < matrix[i].length; j++){
				s += " " + matrix[i][j];
			}
	}
		return s;
	}
	
	public int getRowSize(){
		return row;
	}
	
	public int getColSize(){
		return col;
	}
	
	public int[][] getMatrix(){
		return matrix;
	}

}
