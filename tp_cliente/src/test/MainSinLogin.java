package test;
	
import application.MainController;
import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainSinLogin extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			EmpleadoDTO empleado = null;
	    	EmpleadoDTO env = new EmpleadoDTO();
	    	String usuario = "usuario1";
	    	String password = "123456";
	    	env.setUsuario(usuario);
	    	env.setPass(password);

	    	empleado = BusinessDelegate.getInstancia().buscarLogin(env);
	     	
	    		int idt = empleado.getIdTrabajador();
				int permisos = empleado.getPermisos();
				usuario = empleado.getUsuario();
				SucursalDTO suc = empleado.getSucursal();
				
	    		//creo la escena nueva para el menu y la muestro en pantalla completa
	    		Stage menuStage = new Stage();
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/MainWin.fxml"));
	    		menuStage.setScene(new Scene((AnchorPane) loader.load()));
				
	    		MainController controller = loader.<MainController>getController();
	    		controller.initData(usuario, idt, permisos, suc);
				
	    		//menuStage.setFullScreen(true);
				//menuStage.setFullScreenExitHint("");
				menuStage.initStyle(StageStyle.UNDECORATED);
				menuStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
