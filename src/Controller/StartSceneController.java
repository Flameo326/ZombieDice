package Controller;

import java.util.ArrayList;

import Players.Player;
import Scene.GameScene;
import Scene.StartScene;
import UserNodes.PlayerField;
import javafx.scene.layout.VBox;

public class StartSceneController {
	
	private StartScene scene;
	
	public StartSceneController(StartScene s){
		scene = s;
	}
	
	public void createGame(){
		ArrayList<PlayerField> playersList = scene.getPlayerList();
		
		// create array of players
		Player[] players = new Player[playersList.size()];
		for(int i = 0; i < players.length; i++){
			String name = playersList.get(i).getPlayerInput();
			if(name.isEmpty()){
				players[i] = new Player("Player " + (i+1), i);
			} else{
				players[i] = new Player(name, i);
			}
		}
		
		int difficulty = scene.getDifficultySelection();
		
		GameScene game = new GameScene(players, difficulty);
		game.scene(scene.getStage());
	}
	
	public void addPlayer(){
		ArrayList<PlayerField> playersList = scene.getPlayerList();
		
		PlayerField temp = new PlayerField(playersList.size()+1);
		playersList.add(temp);
		scene.getPlayerAmo().set(playersList.size());
		
		VBox playerDisplay = scene.getPlayerDisplay();
		playerDisplay.getChildren().add(playersList.size(), temp);
		
		scene.getStage().sizeToScene();
		scene.getStage().centerOnScreen();
	}
	
	public void removePlayer(){
		ArrayList<PlayerField> playersList = scene.getPlayerList();
		playersList.remove(playersList.size()-1);
		scene.getPlayerAmo().set(playersList.size());
		
		VBox playerDisplay = scene.getPlayerDisplay();
		playerDisplay.getChildren().remove(playersList.size()+1);
		
		scene.getStage().sizeToScene();
		scene.getStage().centerOnScreen();
	}

}
