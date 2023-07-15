import java.awt.event.*;
public class TicController{
  
  TicGUI gui;
  TicModel model;
  
  public TicController(TicGUI gui, TicModel model)
  {
    this.gui=gui;
    this.model=model;
    
    gui.lvlOne.addActionListener(new Actions());
    gui.lvlTwo.addActionListener(new Actions());
    gui.lvlThree.addActionListener(new Actions());
    gui.pvpMode.addActionListener(new Actions());
    gui.exitGame.addActionListener(new Actions());
    gui.returnToMenu.addActionListener(new Actions());
    
    for (int row=0;row<3;row++)
    {
      for (int col=0;col<3;col++)
      {
        gui.slots[row][col].addActionListener(new Actions());
      }
    }
    
  }//end of constructor
  
  
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
      }
      
      else if (e.getSource()==gui.getLvlTwo())
      {
        //gui.gameLayout();
      }
      
      else if (e.getSource()==gui.getLvlThree())
      {
        //gui.gameLayout();
      }
      
      else if (e.getSource()==gui.getPvpMode())
      {
        gui.background.setVisible(false);
        gui.gamePanel.setVisible(true);
        gui.frame.add(gui.gamePanel);
      }
      
      else if (e.getSource()==gui.getExitGame())
      {
        System.exit(0);
      }
      
      else if (e.getSource()==gui.getReturnToMenu())
      {
       // gui.menuLayout();
        gui.gamePanel.setVisible(false);
        gui.background.setVisible(true);
      }
      
    }//end of actionPerfromed
  }
  
  
}


