package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    private JFXPasswordField txtPassword;

    @FXML
    private JFXSpinner loginSpinner;

    @FXML
    void makeLogin(ActionEvent event) throws InterruptedException, IOException {
    	String usuario = txtUser.getText();
    	String password = txtPassword.getText();
    	EmpleadoDTO empleado = null;
    	EmpleadoDTO env = new EmpleadoDTO();
    	
    	env.setUsuario(usuario);
    	env.setPass(password);

    	loginSpinner.setVisible(true);	
    	empleado = BusinessDelegate.getInstancia().buscarLogin(env);
     	
    	if(empleado != null){
    		int idt = empleado.getIdTrabajador();
			int permisos = empleado.getPermisos();
			usuario = empleado.getUsuario();
			SucursalDTO suc = empleado.getSucursal();
			
    		lblStatus.setText("Login correcto. Iniciando sesión");
    		loginSpinner.setVisible(false);
		
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
    		
    	}else{
    		loginSpinner.setVisible(false);
    		lblStatus.setText("Usuario o contraseña incorrectos");
    	}
    }
}
