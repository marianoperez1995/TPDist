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


public class SidePanelController5 implements Initializable {

    @FXML
    private JFXButton btnNuevaFactura;

    @FXML
    private JFXButton btnResumen;

    @FXML
    private JFXButton btnPagoCliente;
    
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
            case "Ver pagos de cliente":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ResumenFacturacion.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Ver facturas generadas":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/FacturaNueva.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Registrar pago de cliente":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PagoCliente.fxml"));
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
