//Class: Board Controller
//Tic-Tac-Toe Game
//Created by Abdurrahman Bakhshi

//This class manages all the buttons on the game board itself

import java.awt.event.*;
public class BoardController 
{
  
  TicGUI gui;//GUI object
  TicModel model;//Model object
  
  //Constructor
  public BoardController(TicGUI gui,TicModel model) 
  { 
    this.gui=gui; //object for GUI class
    this.model=model;//object for Model class
  
    for (int row=0;row<3;row++)
    {
      for (int col=0;col<3;col++)
      {
        gui.slots[row][col].addActionListener(new Actions());//Assigning Action Listeners to all buttons on gameboard
      }//for
    }//for
  }//end of constructor
  
  
  //Inner Class
  public class Actions implements ActionListener
  {
    //Overriding actionPerformed() method
    public void actionPerformed(ActionEvent e)
    {
      for (int row=0;row<3;row++)
      {
        for (int col=0;col<3;col++)
        {
          if (e.getSource()==gui.slots[row][col])
          {
            if (model.getMode()=='p') //Player vs Player Mode
            {
              model.playerMove(row,col);
            }//if
            
            if (model.getMode()=='1')//Level 1
            {
              model.playerMove(row,col);
             if (!(model.isWinning('X')||model.isWinning('O')))
             model.levelOneMove();
            }//if
          
            if (model.getMode()=='2')//Level 2
            {
              model.playerMove(row,col);
                if (!(model.isWinning('X')||model.isWinning('O')))
                  model.findBestMove();
              
              }//if
            
            if (model.getMode()=='3')//Level 3
            {
              model.playerMove(row,col);
            
              if (!(model.isWinning('X')||model.isWinning('O')))
              { 
                model.findBestMove();
                //model.startUserTimer();
              }//if
            }//if
            
            
            
            
          }//if
        }//for
      }//for
      
    }
  }
  
}
