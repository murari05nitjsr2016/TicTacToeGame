package com.tictoegame;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGames {
	public static  String  IS_COMPUTER = "user";
	public static  String  IS_USER = "computer";
	static Scanner sc = new Scanner(System.in);
	static int uCount = 0;
	static int cCount = 0;
	static boolean flag;
	public static char[] playGame(char[] board,String playerType )
	{ 

		int slotNo;
		int cSlotNo;
		char move;
		char cMove = 1;
		char uMove = 1;
		int uSlotNo;
		String player = playerType;
		switch(player){
		case "computer":
			flag = false;
			System.out.println("calling3");
			System.out.println("enter computer the slot no between 1 to 9");
			cSlotNo = sc.nextInt();
			if(board[cSlotNo] == ' ')
			{
				System.out.println("you can mark this slot");
			}
			else {


				System.out.println("Already marked slot please select other slot");
				cSlotNo = sc.nextInt();
			}
			System.out.println("entercom the slot marker x or o");
			cMove = sc.next().charAt(0);
			cCount++;
			board[cSlotNo] = cMove;
			break;
		case "user":
			flag = true;
			System.out.println("enter user the slot no betewwn 1 to 9 ");
			uSlotNo = sc.nextInt();
			System.out.println("enter move x or o");
			cMove = sc.next().charAt(0);
			board[uSlotNo] = cMove;
			uCount++;
			break;
		}
		return board;
	}
/*	static String checkWinner(char[] board)
	{for (int a = 0; a < 8; a++) {
		String line = null;
		switch (a) {
		case 0:
			line = ""+board[1] + board[2] + board[3];
			break;
		case 1:
			line =""+ board[4] + board[5] + board[6];
			break;
		case 2:
			line = ""+board[7] + board[8] + board[9];
			break;
		case 3:
			line =""+ board[0] + board[3] + board[6];
			break;
		case 4:
			line =""+ board[1] + board[5] + board[9];
			break;
		case 5:
			line =""+ board[2] + board[5] + board[8];
			break;
		case 6:
			line =""+ board[1] + board[4] + board[7];
			break;
		case 7:
			line = ""+board[3] + board[5] + board[7];
			break;
		}
		//For X winner
		if (line.equals("XXX")) {
			return "X";
		}
		// For O winner
		else if (line.equals("OOO")) {
			return "O";
		}
	}
	return "Neither Wining";


	}     

*/
	//display the board
	static void showBoard(char[] board)
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[1] + " | "
				+ board[2] + " | " + board[3]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | "
				+ board[5] + " | " + board[6]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | "
				+ board[8] + " | " + board[9]
						+ " |");
		System.out.println("|---|---|---|");
	}


	public static  int WhoPlayFirst()
	{

		Random ran = new Random();


		System.out.println("enter 0 or 1");
		int choice =sc.nextInt();
		int toss = ran.nextInt(2);
		if(choice == toss)
		{
			return 1;
		}
		else {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println("welcome to Tic tac toe game");
		String player1 = "user";
		String player2 = "computer";
		String player = "";
		int maxUcount = 4;
		int maxCcount = 4;
		char[] board = new char[10];
		int slotNo = 0;
		char move ='\u0000';
		//iniitialization of board
		for(int i = 1 ; i < board.length ; i++)
		{
			board[i] = ' ';
		}
		//logic for toss
		int toss = WhoPlayFirst();
		if(toss == 1) {
			System.out.println("user will play first");
			maxUcount = 5;
			player = "user";

		}
		else {
			System.out.println("computer will play first");
			maxCcount = 5;
			player = "computer";
		}

		board = playGame(board,player);

		showBoard(board);
		while(uCount <= maxUcount && cCount <= maxCcount)
		{

			if(flag == false )
			{

				player = "user";
				board = playGame(board,player);
				showBoard(board);
			}
			else
			{
				System.out.println("calling2");
				player = "computer";
				board = playGame(board,player);
				showBoard(board);
			}

		}
		/*
		showBoard(board);
		String result = checkWinner(board);
		System.out.println(result);
*/

	}

}
