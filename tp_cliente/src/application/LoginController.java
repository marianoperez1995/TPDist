package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {
	
    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXTextField txtUser;

    @FXML
    private Label lblStatus;
    
    @FXML
    private Label txtOblig1;
    
    @FXML
    private ProgressIndicator progreso;
    
    @FXML
    private Label txtOblig2;
    
    @FXML
    private JFXPasswordField txtPassword;
       
    String usuario;
    String password;
    int idt;
    int permisos;
    SucursalDTO suc;
    
    @FXML
    void makeLogin(ActionEvent event) throws InterruptedException, IOException {
    	btnLogin.setDisable(true);
    	usuario = txtUser.getText();
    	password = txtPassword.getText();
		txtOblig1.setVisible(false);
		txtOblig2.setVisible(false);
    	if(!usuario.equalsIgnoreCase("") && !password.equalsIgnoreCase("")){
	    	EmpleadoDTO empleado = null;
	    	EmpleadoDTO env = new EmpleadoDTO();
	    	
	    	env.setUsuario(usuario);
	    	env.setPass(password);

	    	empleado = BusinessDelegate.getInstancia().buscarLogin(env);
	     	
	    	if(empleado != null){
	    		idt = empleado.getIdTrabajador();
				permisos = empleado.getPermisos();
				usuario = empleado.getUsuario();
				suc = empleado.getSucursal();
				
	    		lblStatus.setText("Login correcto. Iniciando sesión");
	    		progreso.setVisible(true);
	    		
	    		final int max = 35000000;
	    		
	    		Task task = new Task<Void>() {
	    		    @Override public Void call() throws IOException {
	    		        for (int i = 1; i <= max; i++) {
	    		            updateProgress(i, max);
	    		        }
	    				return null;
	    		    }
	    		};
	    		
	    		progreso.progressProperty().bind(task.progressProperty());
	    		Thread t = new Thread(task);
	    		t.start();
	    		
	    		loguear();
	    		
	    	}else{
	    		lblStatus.setText("Usuario o contraseña incorrectos");
	    		btnLogin.setDisable(false);
	    	}
    	}else{
    		if(usuario.equalsIgnoreCase(""))
    		txtOblig1.setVisible(true);
    		
    		if(password.equalsIgnoreCase(""))
    		txtOblig2.setVisible(true);
    		
    		btnLogin.setDisable(false);
    	}
    }
    
    public void loguear() throws IOException{
		//obtengo la escena del login y la cierro
		Stage loginStage = (Stage) btnLogin.getScene().getWindow();
		loginStage.hide();
		
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
    }
    
}
