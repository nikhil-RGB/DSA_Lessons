package tictactoe;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
public class TicTacToeMin {
	//0 1 2
	//3 4 5
	//6 7 8

	private boolean running=true;
	private String[] tokens= {"O","X"};
	public String currentTok="X";
	//TO-DO:REMOVE
	public ArrayList<TicTacToeMin> children;//pass null initially	
	public String[] board=new String[9];
	public JButton[] buttons;
	public static final String[] winCombos=new String[] {
	 "0 1 2",
	 "3 4 5",
	 "6 7 8",
	 "0 3 6",
	 "1 4 7",
	 "2 5 8",
	 "0 4 8",
	 "2 4 6"
	};
	//initializes or resets board.
	public void init() 
	{
		
		this.buttons=new JButton[9];
		ActionListener ar= (ev)->
		{
			if(!running) 
			{
				return;
			}
			JButton src=(JButton)(ev.getSource());
			int pos=Integer.parseInt(src.getActionCommand());
			String tok=src.getText();
			if(!tok.equals("")) 
			{
				return;
			}
			this.board[pos]=this.currentTok;
			src.setText(this.currentTok);
			src.setBackground(this.currentTok.equalsIgnoreCase("O")?Color.BLUE:Color.RED);
			this.switchToken();
		
			String winner[]=checkWinner(this.board);
			if(!winner[0].equals("")||emptySpaces(this.board).size()==0) 
			{
				this.running=false;
				if(emptySpaces(this.board).size()==0&&winner[0].equals("")) 
				{
					System.out.println("Nobody won! Draw!");
					return;
				}
				System.out.println(winner[0]+" won!");
			}
			else 
			{
				
				System.out.println(currentTok);
          		int position=minMax(cloneBoard(board),currentTok)[1];
 				buttons[position].setText(this.currentTok);
 				this.board[position]=this.currentTok;
 				buttons[position].setBackground(this.currentTok.equalsIgnoreCase("O")?Color.BLUE:Color.RED);
 				this.switchToken();
 				String winner1[]=checkWinner(this.board);
 				if(!winner1[0].equals("")||emptySpaces(this.board).size()==0) 
 				{
 					this.running=false;
 					if(emptySpaces(this.board).size()==0&&winner1[0].equals("")) 
 					{
 						System.out.println("Nobody won! Draw!");
 						return;
 					}
 					System.out.println(winner1[0]+" won!");
 				}
 				
				
			}
			
		};
		for(int i=0;i<9;++i) 
		{
			board[i]="";
			buttons[i]=new JButton();
			buttons[i].setActionCommand(i+"");
		    buttons[i].addActionListener(ar);
		    buttons[i].setFont(new Font("Times Roman", Font.BOLD, 28));
		}
	}
	//default constructor
	public TicTacToeMin() 
	{
      
    }
	
	//Checks the winner in the current configuration
	public static String[] checkWinner(String[] board) 
	{
		String[] tokens= {"O","X"};
		for(String combn:winCombos) 
		{
			
			TOKEN_SWITCHER:
			for(int i=0;i<2;++i) {
				String current=tokens[i];
				Scanner reader=new Scanner(combn);
		    while(reader.hasNextInt()) 
		    {
		    	int pos=reader.nextInt();
		    	if(!board[pos].equalsIgnoreCase(current)) 
		    	{
		    		reader.close();
		    		continue TOKEN_SWITCHER;
		    	}
		    }
		    reader.close();
		    String[] winner= {tokens[i],combn};
		    return winner;
			}
			
		}
		String[] noWin= {"",""};
		return noWin;//indicates no winner
	}
	
	//switches the current token
	public void switchToken() 
	{
	this.currentTok=(this.currentTok.equalsIgnoreCase("O"))?"X":"O";
	}
	
	public static void main(String[] args) 
	{
		
	 TicTacToeMin obj=new TicTacToeMin();
	 obj.init();
//	 obj.board[0]="O";
//	 obj.board[1]="O";
//	 obj.board[2]="X";
//	 obj.board[4]="O";
//	 obj.board[6]="X";
//	 obj.board[7]="O";
//	 String output[]=obj.checkWinner();
//	 System.out.println(output[0]+" "+output[1]);
	 JFrame frm=new JFrame("Tic-Tac-Toe");
	 frm.setSize(350, 350);
	 JPanel panel=new JPanel(new GridLayout(3,3));
	 frm.setContentPane(panel);
	 for(int i=0;i<9;++i) 
	 {
		 panel.add(obj.buttons[i]);
	 }
	 frm.setResizable(false);
	 frm.setVisible(true);
	}
	
	public String[] cloneTable()
	{
		String[] newTable=new String[9];
		for(int i=0;i<9;++i) 
		{
			newTable[i]=this.board[i];
		}
		return newTable;
	}
	
	//Special override - clones only the the barebones fields for uitilizing minimax with alpha beta pruning
	@Override
	public TicTacToeMin clone() 
	{
		TicTacToeMin obj=new TicTacToeMin();
		obj.board=this.cloneTable();
		obj.currentTok=this.currentTok;
		obj.buttons=null;
		return obj;
		//barebones clone completed
	}
	
	//Gets all empty spaces
	public static ArrayList<Integer> emptySpaces(String[] board)
	{
		ArrayList<Integer> arrs=new ArrayList<>(0);
		for(int i=0;i<9;i++) 
		{
			if(board[i].equals("")) 
			{
				arrs.add(i);
			}
		}
		return arrs;
	}	
	
	//Calculates score for a board, 1 for ai win, -1 for AI loss, 0 for draw and 1 for
	//AI win
	public static int score(String[] board) 
	{
		String result=checkWinner(board)[0];
		if(result.equals("")&&emptySpaces(board).size()==0) 
		{
			return 0;
		}
		else if(result.equals("O")) 
		{
			return 1;
		}
		else if(result.equals("X")) 
		{
			return -1;
		}
		else 
		{
			return -2;
		}
		
	}
	//Simulates all possible moves next move.
//	public ArrayList<TicTacToeMin> simulate()
//	{
//		String simulationToken=(this.currentTok.equals("O"))?"X":"O";
//		ArrayList<TicTacToeMin> arrs=new ArrayList<>(0);
//		ArrayList<Integer> obj=emptySpaces(this.board);
//		if(obj.size()==0) 
//		{
//			return arrs;
//		}
//		obj.forEach((element)->{
//			TicTacToeMin board=this.clone();
//			board.board[element]=simulationToken;
//			board.switchToken();
//			arrs.add(board);
//		});
//	 return arrs;
//	}
	//Checks if board is filled, true for yes, false for no
	public boolean isFilled() 
	{
		for(int i=0;i<9;++i) 
		{
			if(!this.board[i].equals("")) 
			{
				return false;
			}
		}
		return true;
	}
	
	public static String[] createBoard() 
	{
		String board[]=new String[9];
		for(int i=0;i<9;++i) 
		{
			board[i]="";
		}
		return board;
	}
	
	//Clone the current board and return a reference to the cloned board
	public static String[] cloneBoard(String[] board) 
	{
	  	String[] new_board=new String[9];
	  	for(int i=0;i<9;++i) 
	  	{
	  		new_board[i]=board[i];
	  	}
	  	return new_board;
	}
	public static String switchToken(String player) 
	{
		return player.equals("O")?"X":"O";
	}
 //Recursive function call for mini-max algorithm
	public static int[] minMax(String[] table,String player) 
	{
	 ArrayList<Integer> scores=new ArrayList<>(0);
	 ArrayList<Integer> moves=TicTacToeMin.emptySpaces(table);
	 if(moves.size()==0) 
	 {
	  return new int[] {score(table),-1};
	 }
	 
	 for(Integer move:moves) 
	 {
		 String[] board=cloneBoard(table);
		 board[move]=player;
		 int score=score(board);
			if(score==-2) 
			{
				score=minMax(board,switchToken(player))[0];
			}
			scores.add(score);
	 }
	 int optimalScore;
	 if(player.equals("O")) 
	 {
		 optimalScore=Collections.max(scores);
	 }
	 else 
	 {
		 optimalScore=Collections.min(scores);
	 }
	 
	 return new int[] {optimalScore,moves.get(scores.indexOf(optimalScore))};
	 
	}
	
}

