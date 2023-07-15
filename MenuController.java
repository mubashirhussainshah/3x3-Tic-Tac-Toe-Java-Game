//Class: Menu Controller
//Tic-Tac-Toe Game
//Created by Abdurrahman Bakhshi

//This class manages all buttons on the main menu as well as the restart button

import java.awt.event.*;
public class MenuController
{
  
  TicGUI gui;//GUI object
  TicModel model;//Model object
  
  //Constructor
  public MenuController(TicGUI gui, TicModel model)
  {
    this.gui=gui;
    this.model=model;
    
    //Adding Action Listeners to all buttons
    gui.lvlOne.addActionListener(new Actions());
    gui.lvlTwo.addActionListener(new Actions());
    gui.lvlThree.addActionListener(new Actions());
    gui.pvpMode.addActionListener(new Actions());
    gui.exitGame.addActionListener(new Actions());
    gui.returnToMenu.addActionListener(new Actions());
    gui.restartButton.addActionListener(new Actions());
    
    for (int row=0;row<3;row++)
    {
      for (int col=0;col<3;col++)
      {
        gui.slots[row][col].addActionListener(new Actions());//Adding Action Listeners to all buttons on game board
      }
    }
    
  }//end of constructor
  
  
  //Inner Class
  public class Actions implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource()==gui.getLvlOne())
      {
        //gui.gameLayout();
        gui.background.setVisible(false);
        gui.gamePanel.setVisible(true);
        gui.frame.add(gui.gamePanel);
        model.setMode('1');
        
      }
      
    
      
      else if (e.getSource()==gui.getLvlTwo())
      {
        //gui.gameLayout();
        gui.background.setVisible(false);
        gui.gamePanel.setVisible(true);
        gui.frame.add(gui.gamePanel);
        model.setMode('2');
      }
      
      else if (e.getSource()==gui.getLvlThree())
      {
        //gui.gameLayout();
        gui.background.setVisible(false);
        gui.gamePanel.setVisible(true);
        gui.frame.add(gui.gamePanel);
        model.setMode('3');
       // model.startUserTimer();
      }
      
      else if (e.getSource()==gui.getPvpMode())
      {
        gui.background.setVisible(false);
        gui.gamePanel.setVisible(true);
        gui.frame.add(gui.gamePanel);
        model.setMode('p');
      }
      
      else if (e.getSource()==gui.getExitGame())
      {
        System.exit(0);
      }
      
      else if (e.getSource()==gui.getReturnToMenu())
      {
        gui.gamePanel.setVisible(false);
        gui.background.setVisible(true);
        gui.resetBoard();
        model.resetGame();
      }
      
      else if (e.getSource()==gui.getRestartButton())
      {
        model.resetGame();
       
      }
      
    }//end of actionPerfromed
  }
  
  
}


