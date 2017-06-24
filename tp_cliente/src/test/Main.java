package test;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*Parent root = FXMLLoader.load(getClass().getResource("/fxmls/Login.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/fxmls/MainWin.fxml"));
			Scene scene = new Scen 	e(root,1366,768);
			scene.getStylesheets().add(getClass().getResource("/styles/application.css").toExternalForm());
			//primaryStage.setFullScreen(true);
			//primaryStage.setFullScreenExitHint("");
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Login.fxml"));
			
			Stage stage = new Stage(StageStyle.DECORATED);
			Scene scene = new Scene((AnchorPane) loader.load());
			stage.setScene(scene);
			//stage.setFullScreen(true);
			//stage.setFullScreenExitHint("");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
