package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import dto.EmpleadoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	private String usuarioActual;
	private int idUsuarioActual;
	private int permisos; 
	
    @FXML
    private Label lblTitulo;
	
    @FXML
    private JFXHamburger hamburgerMenu;

    public static JFXHamburger hamburgerMenuP;

    @FXML
    private AnchorPane bodyPanel;
    
    public static AnchorPane bodyPanelP;
    
    @FXML
    private AnchorPane anchPane;

    @FXML
    private ImageView fullscreen;
    
    @FXML
    private JFXDrawer menuDrawer;
    
    public static JFXDrawer menuDrawerP;
    
    @FXML
    private Label lblUser;
    
    @FXML
    private JFXButton exit;
    
    @FXML
    private JFXButton minimize;
    
    public static HamburgerSlideCloseTransition transitionP;
    
    void initData(String usuario, int id, int permisos) {
        this.usuarioActual = usuario;
        this.idUsuarioActual = id;
        this.permisos = permisos;
        //lblUser.setText("usuario");
        
    	try {
	        VBox box = null;
	        
	        switch (permisos) {
			case 1:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_1.fxml"));
				lblTitulo.setText("Gut Gekleidet Wurst - Area comercial");
				break;
			case 2:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_2.fxml"));
				lblTitulo.setText("Gut Gekleidet Wurst - Adm. de clientes");
				break;
			case 3:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_3.fxml"));
				lblTitulo.setText("Gut Gekleidet Wurst - Despacho");
				break;
			case 4:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_4.fxml"));
				lblTitulo.setText("Gut Gekleidet Wurst - Almacen");
				break;
			case 5:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_5.fxml"));
				lblTitulo.setText("Gut Gekleidet Wurst - Facturacion");
				break;
			case 6:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_6.fxml"));
				lblTitulo.setText("Gut Gekleidet Wurst - Adm. General");
				break;
			default:
				break;
			}
        
	        menuDrawer.setSidePane(box);
	        
	    	} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      }
    
    public void initialize(URL url, ResourceBundle rb){
    	HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(hamburgerMenu);
    	bodyPanelP = bodyPanel;
    	menuDrawerP = menuDrawer;
    	hamburgerMenuP = hamburgerMenu;
    	transitionP = transition;
    	try {
    		VBox box = null;
			box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_1.fxml"));
    		
			switch (permisos) {
			case 1:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_1.fxml"));
				break;
			case 2:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_2.fxml"));
				break;
			case 3:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_3.fxml"));
				break;
			case 4:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_4.fxml"));
				break;
			case 5:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_5.fxml"));
				break;
			case 6:
				box = FXMLLoader.load(getClass().getResource("/fxmls/SideMenu_6.fxml"));
				break;
			default:
				break;
			}
			
			menuDrawer.setSidePane(box);
			 
	        transition.setRate(-1);
	        hamburgerMenu.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
	            transition.setRate(transition.getRate()*-1);
	            transition.play();
	            
	            if(menuDrawer.isShown())
	            {
	            	menuDrawer.close();
	            }else{
	            	menuDrawer.open();
	            }
	        });
	        
	        fullscreen.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
	        	Stage actualStage = (Stage)((ImageView)e.getSource()).getScene().getWindow();
	        	
	        	if(actualStage.isFullScreen())
	        	actualStage.setFullScreen(false);
	        	else
	            actualStage.setFullScreen(true);
	        });
	        
    	} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }    
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
        System.out.println("Closed");
    }
    
    @FXML
    private void minimize(ActionEvent event) {
        Stage stage = (Stage)((JFXButton)event.getSource()).getScene().getWindow();
        // is stage minimizable into task bar. (true | false)
        stage.setIconified(true);
        System.out.println("Minimizado");
    }
    
    @FXML
    private void MakeLogout(ActionEvent event) {
        System.exit(0);
    }
    
}
