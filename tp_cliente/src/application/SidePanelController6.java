package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


public class SidePanelController6 implements Initializable {


    @FXML
    private JFXButton btnAltaSucursal;

    @FXML
    private JFXButton btnBuscarSucursal;

    @FXML
    private JFXButton btnAltaPrenda;

    @FXML
    private JFXButton btnAltaCliente;

    @FXML
    private JFXButton btnAltaInsumo;

    @FXML
    private JFXButton btnBuscarCliente;

    @FXML
    private JFXButton btnBuscarInsumo;

    @FXML
    private JFXButton btnBuscarPrenda;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void changeBody(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        
        AnchorPane body;
        switch(btn.getText())
        {
            case "Alta de cliente":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ClienteAlta.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Buscar cliente":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ClienteBuscar.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Alta de sucursal":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/SucursalAlta.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Buscar sucursal":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/SucursalBuscar.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Alta de prenda":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PrendaAlta.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Buscar prenda":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PrendaBuscar.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Alta de insumo":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/InsumoAlta.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Buscar insumo":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/InsumoBuscar.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
        }
        
        MainController.menuDrawerP.close();
        MainController.transitionP.setRate(MainController.transitionP.getRate()*-1);
        MainController.transitionP.play();
        
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}
