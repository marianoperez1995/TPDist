package application;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class SucursalAltaController implements Initializable {
	@FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXButton btnEnviar;

    @FXML
    private JFXTextField txtDireccion;

    @FXML
    private JFXTextField txtPiso;

    @FXML
    private Label lblFechaRegistro;

    @FXML
    private JFXButton btnLimpiar;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXComboBox<Label> comboHasta;

    @FXML
    private JFXComboBox<Label> comboAbierto;

    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	lblFechaRegistro.setText("Fecha: " + df.format(Calendar.getInstance().getTime()));
    	
    	comboAbierto.getItems().add(new Label("9:00"));
    	comboAbierto.getItems().add(new Label("10:00"));
    	comboAbierto.getItems().add(new Label("11:00"));
    	comboAbierto.getItems().add(new Label("12:00"));
    	comboAbierto.getItems().add(new Label("13:00"));
    	comboAbierto.getItems().add(new Label("14:00"));
    	
    	comboAbierto.setPromptText("Select Java Version");
        comboAbierto.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    	
    	comboHasta.getItems().add(new Label("14:00"));
    	comboHasta.getItems().add(new Label("15:00"));
    	comboHasta.getItems().add(new Label("16:00"));
    	comboHasta.getItems().add(new Label("17:00"));
    	comboHasta.getItems().add(new Label("18:00"));
    	comboHasta.getItems().add(new Label("19:00"));
    	
    	comboHasta.setPromptText("Select Java Version");
    	comboHasta.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    	
    	
    	
    	txtPiso.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtPiso.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    	txtNumero.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtNumero.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    

    @FXML
    void enviarTramite(ActionEvent event) {

    }

    @FXML
    void limpiarCampos(ActionEvent event) {

    }
}
