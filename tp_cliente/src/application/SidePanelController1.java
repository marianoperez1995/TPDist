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


public class SidePanelController1 implements Initializable {

    @FXML
    private JFXButton btnResumen;

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
            case "Resumen de sucursal":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ResumenSucursal.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Alta de cliente":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ClienteAlta.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Buscar cliente":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ClienteBuscar.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Ver pedidos pendientes":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PedidosPendientes.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Buscar pedidos":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PedidosBuscar.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Nuevo reclamo":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ReclamosAlta.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Ver reclamos":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ReclamosBuscar.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Generar nueva novedad":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/NovedadAlta.fxml"));
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
