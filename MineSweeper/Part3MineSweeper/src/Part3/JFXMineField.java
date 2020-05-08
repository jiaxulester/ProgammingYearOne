package Part3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static java.awt.SystemColor.window;
import javafx.application.Application;
import javafx.application.Platform;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jiaxu
 */
public class JFXMineField extends Application {
    private GridPane root;
    private VBox layout;
    private Label message;
    private Button[][] buttons;
    private Minefield game;
    private int width = 10;
    private int height =15;
    private int numOfMine =20;
    
    @Override
    public void init() throws Exception {
        super.init(); 
        this.game =new Minefield(width,height,numOfMine);
    }
    
    @Override
    public void start(Stage primaryStage) {
        game = new Minefield(10,15,20);
        root = new GridPane();
        buttons = new Button[width][height];
        Scene scene = new Scene(root);
         
        game.populate(numOfMine);
            for (int i = 0; i < buttons.length; i++) {
  for (int j = 0; j< buttons[i].length; j++) {
    final int x = i;
    final int y = j;
    buttons[i][j] = new Button(" ");
    buttons[i][j].setOnMouseClicked(e -> {
    if (e.getButton() == MouseButton.PRIMARY) {
      if (!game.step(x,y)) {
          VBox layout = new VBox();
            Stage lose = new Stage();
            Scene loseLose =new Scene(layout,300,300);
            lose.initModality(Modality.APPLICATION_MODAL);
            lose.setMaxWidth(300);
            lose.setMaxHeight(150);
            Button nextButton = new Button("Next Game");   
            Button quitButton = new Button("Quit");  
            layout.getChildren().add(nextButton);
            layout.getChildren().add(quitButton); 
            quitButton.setOnAction(e1 -> {primaryStage.close(); lose.close();});
            nextButton.setOnAction(e2 -> {start(new Stage()); lose.close();primaryStage.close();});
            lose.setScene(loseLose);
            lose.setTitle("BOOM!!!");
            
            lose.show();
      } else {
        for (int a = 0; a < buttons.length; a++) {
          for (int b = 0; b < buttons[a].length; b++) {
            buttons[a][b].setText(game.getMineTile(a, b).toString());
          }
         }
        }
       } else if (e.getButton() == MouseButton.SECONDARY) {
           game.mark(x, y);
           buttons[x][y].setText(game.getMineTile(x, y).toString());
           if (game.areAllMinesFound()) {
               
            VBox layout = new VBox();
            Stage win = new Stage();
            Scene loseLose =new Scene(layout,300,300);
            win.initModality(Modality.APPLICATION_MODAL);
            win.setMaxWidth(300);
            win.setMaxHeight(150);
            Button nextButton = new Button("Next Game");   
            Button quitButton = new Button("Quit");  
            layout.getChildren().add(nextButton);
            layout.getChildren().add(quitButton); 
            quitButton.setOnAction(e1 -> {primaryStage.close(); win.close();});
            nextButton.setOnAction(e2 -> {start(new Stage()); win.close();primaryStage.close();});
            win.setScene(loseLose);
            win.setTitle("WIN!!!");
            win.show();
           }
          }
         });
        root.add(buttons[i][j], i, j);
        }
      }
        
        primaryStage.setTitle("MinesSwepper");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

    public static void main(String[] args) {
        launch(args);
    }
    
}
