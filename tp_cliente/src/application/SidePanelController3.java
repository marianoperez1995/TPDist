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


public class SidePanelController3 implements Initializable {

    @FXML
    private JFXButton btnBuscarPedido;

    @FXML
    private JFXButton btnVerPedidos;
    
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
            case "Ver pedidos completos":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PedidosCompletos.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Buscar pedidos":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PedidosBuscar.fxml"));
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
