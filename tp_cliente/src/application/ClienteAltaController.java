package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClienteAltaController {
    @FXML
    private JFXTextField txtCorreoEncargado;
    
    @FXML
    private JFXTextField txtFechaPago;

    @FXML
    private JFXButton btnEnviar;

    @FXML
    private JFXTextField txtNumeroDire;

    @FXML
    private JFXTextField txtDireccion;

    @FXML
    private JFXButton btnLimpiar;

    @FXML
    private Label lblNroTramite;

    @FXML
    private JFXTextField txtCondicionesPago;
    
    @FXML
    private JFXTextField txtPisoDire;

    @FXML
    private JFXTextField txtRazon;

    @FXML
    private JFXRadioButton radioMasculino;

    @FXML
    private JFXRadioButton radioOtro;

    @FXML
    private Label lblFechaRegistro;
    
    @FXML
    private JFXTextField txtTelefonoEncargado;

    @FXML
    private JFXTextField txtCuit;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField txtLimitePrecio;
    
    @FXML
    private JFXTextField txtNombreEncargado;

    @FXML
    private JFXRadioButton radioFemenino;

    @FXML
    private void limpiarCampos(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        
        txtCorreoEncargado.clear();
        txtFechaPago.clear();
        txtNumeroDire.clear();
        txtDireccion.clear();
        txtCondicionesPago.clear();
        txtPisoDire.clear();
        txtRazon.clear();
        txtTelefonoEncargado.clear();
        txtCuit.clear();
        txtTelefono.clear();
        txtLimitePrecio.clear();
        txtNombreEncargado.clear();
        

    }
}
