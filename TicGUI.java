//Class: View
//Tic-Tac-Toe Game
//Created by Abdurrahman Bakhshi

//This class deals with the visual aspect of the game. All GUI/View items are included in this class

import javax.swing.*;
import java.awt.*;

public class TicGUI extends JPanel{
  
  //Main frame
  final JFrame frame;
  
  final JPanel menuPanel; //Panel for menu
  final JPanel gamePanel; //Panel for game
  
   //Sub-panels for main Game Panel
   JPanel gameBoard;//main game board
   JPanel statePanel;//panel for restart and  return to main menu buttons
   JPanel resultPanel;//shows the result of the game

   //Buttons to be displayed on game panel
   JButton[][] slots;
   JButton restartButton;
   JButton returnToMenu;
  
   //Buttons to be displayed on main menu
   JButton lvlOne;
   JButton lvlTwo;
   JButton lvlThree;
   JButton pvpMode;
   JButton exitGame;
  
   ImageIcon bgImage;
   JLabel background;
 
  JTextArea turnInfo;
  JTextArea resultMsg;
  JTextArea timer;
  
  
  //Constructor
  public TicGUI()
  {
    frame = new JFrame("Tic-Tac-Toe Game");
    frame.setSize(new Dimension (600,600));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuPanel = new JPanel();
    gamePanel = new JPanel();
    
    gameBoard = new JPanel();
    statePanel = new JPanel();
    resultPanel = new JPanel();
    
    
    slots = new JButton[3][3];
    restartButton = new JButton("Reset");
    returnToMenu = new JButton("Main Menu");
    
    turnInfo = new JTextArea();
    resultMsg = new JTextArea();
    
    bgImage = new ImageIcon("yellowbg.jpg");
    background = new JLabel (bgImage);
    background.setBounds(0,0,600,600);
    
    menuLayout();
    gameLayout();
    
    frame.add(background);
    
    frame.setVisible(true);
  }//end of constructor
  
  
  //Layout for main menu
  public void menuLayout()
  {
    setLayout(null);
    
    //Level One Button
    ImageIcon lvl1Pic = new ImageIcon ("LevelOne.png");
    lvlOne = new JButton(lvl1Pic);
    lvlOne.setBounds(250,100,100,50);
    background.add(lvlOne);
    
    //Level Two Button
    ImageIcon lvl2Pic = new ImageIcon ("LevelTwo.png");
    lvlTwo = new JButton(lvl2Pic);
    lvlTwo.setBounds(250,200,100,50);
    background.add(lvlTwo);
   
    //Level Three Button
    ImageIcon lvl3Pic = new ImageIcon ("LevelThree.png");
    lvlThree = new JButton(lvl3Pic);
    lvlThree.setBounds(250,300,100,50);
    background.add(lvlThree);
    
    //Player vs Player Mode Button
    ImageIcon pvpPic = new ImageIcon ("PvpMode.png");
    pvpMode = new JButton(pvpPic);
    pvpMode.setBounds(175,400,250,50);
    background.add(pvpMode);
    
    //Exit Button
    ImageIcon exitPic = new ImageIcon ("ExitButton.png");
    exitGame = new JButton(exitPic);
    exitGame.setBounds(250,500,100,50);
    background.add(exitGame);
    
    
  }
  
  //Layout for game panel
  public void gameLayout()
  {
    
    //State panel
    statePanel.setLayout(new FlowLayout());//Setting layout for state panel
    statePanel.add(turnInfo);
    statePanel.add(returnToMenu);
    statePanel.add(restartButton);
    
    JPanel board = new JPanel();
    board.setLayout(new FlowLayout());
    gameBoard.setLayout(new GridLayout(3,3));//Setting layout for main game board
   
    //Setting up game board
    for (int row=0;row<3;row++)
    {
      for (int col=0;col<3;col++)
      {
        slots[row][col]= new JButton(); //initializing all new JButtons
        slots[row][col].setPreferredSize(new Dimension (30,30));//setting size of each slot
        slots[row][col].setText("");//setting empty text by default to all buttons
        gameBoard.add(slots[row][col]); //adding all slots/buttons to main gameboard
      }//for
    }//for
    
    resultPanel.setLayout(new FlowLayout());
    resultPanel.add(resultMsg);
    
    gamePanel.setLayout(new BorderLayout());//Setting layout for gamePanel
    gamePanel.add(gameBoard,BorderLayout.CENTER);//Adding gameBoard to main game panel
    gamePanel.add(statePanel,BorderLayout.NORTH);//Adding statePanel to main game panel
    gamePanel.add(resultPanel,BorderLayout.SOUTH);//Adding resultPanel to main game panel
    
  }
  

  public void update(int row, int col, char symbol, String message,boolean isWinner)
  {
    
    slots[row][col].setText(Character.toString(symbol));
    slots[row][col].setEnabled(false);
    
    if (isWinner)
    {
      for (row=0;row<3;row++)
      {
        for (col=0;col<3;col++)
        {
          slots[row][col].setEnabled(false);
        }
      }
    }
    resultMsg.setText(message);
  }
  
  //To reset the games GUI
  public void resetBoard()
  {
    for (int row=0;row<3;row++)
      {
        for (int col=0;col<3;col++)
        {
          slots[row][col].setEnabled(true);
          slots[row][col].setText("");
        }
      }
      setResultMsg("");
  }//end of resetBoard() method
  
  /************** Getter and Setter Methods ****************/
  
  
  public void setResultMsg(String outputMessage)
  {
    resultMsg.setText(outputMessage);
  }
  
  public JButton getLvlOne()
  {
    return lvlOne;
  }
  
   public JButton getLvlTwo()
  {
    return lvlTwo;
  }
   
    public JButton getLvlThree()
  {
    return lvlThree;
  }
    
    public JButton getPvpMode()
  {
    return pvpMode;
  }
  
    public JButton getExitGame()
  {
    return exitGame;
  }
    
    public JButton getReturnToMenu()
  {
    return returnToMenu;
  }
    
    public JButton getRestartButton()
    {
      return restartButton;
    }
  
}//class





