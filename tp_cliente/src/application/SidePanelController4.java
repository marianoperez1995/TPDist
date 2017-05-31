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


public class SidePanelController4 implements Initializable {

    @FXML
    private JFXButton btnResumen;

    @FXML
    private JFXButton btnDevolverPrendas;

    @FXML
    private JFXButton btnVerAlmacenPrendas;

    @FXML
    private JFXButton btnAlmacenarPrendas;

    @FXML
    private JFXButton btnAjusteStock;

    @FXML
    private JFXButton btnEliminarPorDanos;

    @FXML
    private JFXButton btnNuevoPedidoInsumo;

    @FXML
    private JFXButton btnRecepcionInsumo;

    @FXML
    private JFXButton btnVerAlmacenInsumos;
    
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
            case "Resumen de almacen":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/ResumenAlmacen.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Ver almacen (sector prendas)":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/AlmacenPrendas.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Ver almacen (sector insumos)":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/AlmacenInsumos.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Almacenar prendas producidas":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PrendasAlmacenar.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Devolucion de prendas":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PrendasDevolucion.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Eliminar por daños":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/PrendasBajaDanos.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Ajuste de stock real":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/AjusteStock.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Nuevo pedido de insumos":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/InsumosPedidoNuevo.fxml"));
            	MainController.bodyPanelP.getChildren().setAll(body);
            break;
            case "Recepcion de insumos":
            	body = FXMLLoader.load(getClass().getResource("/fxmls/InsumosPedidoRecepcion.fxml"));
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
