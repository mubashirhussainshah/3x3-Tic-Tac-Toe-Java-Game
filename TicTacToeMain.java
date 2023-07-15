//Class:Main
//Tic-Tac-Toe Game
//Created by Abdurrahman Bakhshi

//Runs code from all other classes

public class TicTacToeMain 
{
  
  
  public static void main(String[] args) { 
    TicGUI gui = new TicGUI(); //object for View class
    TicModel model = new TicModel(gui);//Object for Model Class
    MenuController menuContoller = new MenuController(gui,model);//Object for MenuController Class
    BoardController boardController = new BoardController(gui,model);//Object for BoardController Class
  }//end of main method
  
}//end of class
