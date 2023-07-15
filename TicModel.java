//Class: Model
//Tic-Tac-Toe Game
//Created by Abdurrahman Bakhshi

//This Class includes all of the logic behind the game

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TicModel {
  
  TicGUI gui;
  
  int playerID;
  char[][] gameBoard = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
  int movesCount;
  String outputMessage;
  int firstTurn;
  char playerSign;
  char mode;
  // Timer for user's turn
  private Timer userTimer;
  private final int USER_TURN_TIME = 5; // 5 seconds
  
  
  //Constructor
  public TicModel(TicGUI gui)
  {
    this.gui=gui;
    this.playerID=1;
    this.movesCount = 9;
    this.outputMessage = "";
    this.firstTurn = (int)(Math.random() * 2) + 1;
    this.mode = ' ';
    
  }//end of constructor

  
  
  public void playerMove(int row, int col)
  {
    int id = getPlayerID();
    boolean isWinner=false;
      if (getMovesCount()>=0)
      {
        if (movesCount==0)
        {
          setOutputMessage("The game has ended in a draw.");
          gui.setResultMsg(this.outputMessage);
          isWinner=true;
        }//if 
        else 
        {
          if (getPlayerID()==1)
            {
              setOutputMessage("Player 1: X");
              setPlayerID(2);
            }
        
            else 
            {
             setOutputMessage("Player 2: O");
            setPlayerID(1);
            }

          if (id==1) gameBoard[row][col]= 'X';
          else gameBoard[row][col]='O';
      
          setMovesCount(--movesCount);
     
      
          if (isWinning('X')||isWinning('O'))
          {
            isWinner=true;
            setOutputMessage("player " + id + " is the winner!");
            gui.setResultMsg(this.outputMessage);
          }
    
         
        }//else
      }//if
      
      if(row!=-1 || col !=-1)
      gui.update(row,col,gameBoard[row][col],this.outputMessage,isWinner);
    
  }//end of playerMove() method
  
 
  
  public void levelOneMove()
  {
    if (gameBoard[0][0]==' ') playerMove(0,0);
    else if (gameBoard[2][2]==' ') playerMove(2,2);
    else if (gameBoard[1][1]==' ') playerMove(1,1);
    else if (gameBoard[1][0]==' ') playerMove(1,0);
    else if (gameBoard[0][2]==' ') playerMove(0,2);
    else if (gameBoard[1][2]==' ') playerMove(1,2);
    else if (gameBoard[2][0]==' ') playerMove(2,0);
    else if (gameBoard[2][1]==' ') playerMove(2,1);
    else playerMove(0,0);
    
    //Attempting to use randomly generated numbers
    
    /*List <Integer> computerMove = new ArrayList<Integer>();
    
    int row;
    int col;
    do 
    {
      row = (int)(Math.random() * 200) + 0;
      col = (int)(Math.random() * 200) + 0;
      
      if (gameBoard[row%3][col%3]==' ') break;
    }
    while(true);
    
    computerMove.add(row);
    computerMove.add(col);
    playerMove(row,col);
    
    return computerMove;*/
  }//end of levelOneMove()
  
  /*public void levelOne(List<Integer> computerMove)
  {
    int turn = getFirstTurn();//1 for player,2 for computer
    
    for (int i=0;i<4;i++)//total 9 moves, player1 has 5 turns, player 2 has 4 turns
    {
      if(turn==1)//user is player 1
      {
        
      }
    }
  }*/
  
  public boolean isWinning(char player)
  {
    for(int i=0;i<3;i++)
    {
      if (gameBoard[i][0]==player && gameBoard[i][1]==player && gameBoard[i][2]==player) return true;
    }
    
    for(int i=0;i<3;i++)
    {
      if (gameBoard[0][i]==player && gameBoard[1][i]==player && gameBoard[2][i]==player) return true;
    }
    
    for(int i=0;i<3;i++)
    {
      if (gameBoard[0][0]==player && gameBoard[1][1]==player && gameBoard[2][2]==player) return true;
    }
    
    for(int i=0;i<3;i++)
    {
      if (gameBoard[0][2]==player && gameBoard[1][1]==player && gameBoard[2][0]==player) return true;
    }
    return false;
  }//end of isWinning()
  
  
  public int minimax(char player) {
    // checking for the terminal states, win, lose and draw
    if (isWinning('O')) return 1;
    if (isWinning('X')) return -1;
    if (getMovesCount() == 0) return 0;

    int bestVal = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    int bestRow = -1, bestCol = -1;

    for (int row = 0; row < 3; row++) 
    {
        for (int col = 0; col < 3; col++) 
        {
            if (gameBoard[row][col] == ' ') 
            {
                gameBoard[row][col] = player;
                int val = minimax(player == 'O' ? 'X' : 'O');
                gameBoard[row][col] = ' ';

                if (player == 'O') 
                {
                    if (val > bestVal) 
                    {
                        bestVal = val;
                        bestRow = row;
                        bestCol = col;
                    }//if
                }//if
                else {
                    if (val < bestVal) 
                    {
                        bestVal = val;
                        bestRow = row;
                        bestCol = col;
                    }//if
                }//else
            }//if
        }//for
    }//for

    if (bestRow == -1 && bestCol == -1) 
    {
        return 0;
    }
    return bestVal;
}//end of minimax()

  public void findBestMove() 
  {
    int bestVal = Integer.MIN_VALUE;
    int bestRow = -1, bestCol = -1;

    for (int row = 0; row < 3; row++) 
    {
        for (int col = 0; col < 3; col++) {
            if (gameBoard[row][col] == ' ') 
            {
                gameBoard[row][col] = 'O';
                int val = minimax('X');
                gameBoard[row][col] = ' ';

                if (val > bestVal) 
                {
                    bestVal = val;
                    bestRow = row;
                    bestCol = col;
                }//if
            }//if
        }//for
    }//for
    playerMove(bestRow, bestCol);
    if ((!isWinning('X')) && (!isWinning('O')) && getMovesCount()>=0)
    startUserTimer();
}//end of findBestMove()
 
  
     public void startUserTimer() 
     {
        //Creating new timer
        userTimer = new Timer();
        userTimer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
              try
              {
                endUserTurn();
              }
              catch(InterruptedException ex){}
            }
        }
              , USER_TURN_TIME * 1000);
    }//end of startUserTimer()

    public void endUserTurn() throws InterruptedException{
        // Interrupt user's turn
        userTimer.cancel();
        if ((!isWinning('X')) && (!isWinning('O')) && getMovesCount()>=0){
        userMove();
        Thread.sleep(1000);//pause for one second
        findBestMove();
        }
    }//end of endUserTurn();
  
    public void userMove()
    {
      boolean flag=false;
      
      for (int i=0;i<3;i++)
      {
        for (int j=0;j<3;j++)
        {
          if (gameBoard[i][j]==' ')
          {
            playerMove(i,j);
            flag=true;
            break;
          }//if
        }//for
        if (flag==true) break;
      }//for
    }//end of serMove()
    
  
  //resets the board to its original setting/appearance
  public void resetGame()
  {
    
     for (int row=0;row<3;row++)
      {
        for (int col=0;col<3;col++)
        {
          gameBoard[row][col]=' ';//clearing game board
        }
      }
     //reset values of all variables
    this.movesCount = 9;
    this.outputMessage = "";
    //this.setPlayerID(1);
    gui.resetBoard();
    
  }//end of resetGame()
  
  
  //Creates a 5 second timer for each move
  public void timer() throws InterruptedException
  {
    for(int i=5;i>=0;i++)
    {
      gui.timer.setText(Integer.toString(i));
      Thread.sleep(1000);//Pause for one second
    }
  }//end of timer()
  
  
  
  /************** Getter and Setter Methods ****************/
  
  
  public char getMode()
  {
    return mode;
  }
  
  public void setMode(char mode)
  {
     this.mode=mode;
  }
  
  public int getFirstTurn()
  {
    return firstTurn;
  }
  
  public void setFirstTurn()
  {
    this.firstTurn=firstTurn;
  }
  
  public int getPlayerID()
  {
    return playerID;
  }
  
  public void setPlayerID(int playerID)
  {
    this.playerID = playerID;
  }
  
  public int getMovesCount()
  {
    return movesCount;
  }
  
  public void setMovesCount(int movesCount)
  {
    this.movesCount=movesCount;
  }
  
  public void setOutputMessage(String outputMessage)
  {
    this.outputMessage=outputMessage;
  }
  
  
  
  
}//class
