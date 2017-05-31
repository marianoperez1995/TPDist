package application;

import java.awt.Frame;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.jfoenix.controls.JFXTextField;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
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
    private JFXTextField txtCondicionesPago;
    
    @FXML
    private JFXTextField txtPisoDire;

    @FXML
    private JFXTextField txtRazon;

    @FXML
    private Label lblFechaRegistro;
    
    @FXML
    private JFXTextField txtTelefonoEncargado;
    
    @FXML
    private JFXTextField txtGeneroEncargado;

    @FXML
    private JFXTextField txtCuit;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField txtLimitePrecio;
    
    @FXML
    private JFXTextField txtNombreEncargado;

    
    @FXML
    void enviarTramite(ActionEvent event) {
    	
    	if(!todoCompletado()){
    		JOptionPane.showMessageDialog(new Frame(), "Eggs are not supposed to be green.");
    	}else{
	    	ClienteDTO cli = new ClienteDTO();
	    	CuentaCorrienteDTO ccte = new CuentaCorrienteDTO();
	    	
	    	cli.setNombre(txtRazon.getText());
	    	cli.setCuit(txtCuit.getText());
	    	cli.setTelefono(txtTelefono.getText());
	    	cli.setDireccion(txtDireccion.getText()+ " "+txtNumeroDire.getText()+" "+txtPisoDire.getText());
	    	cli.setEncargado(txtNombreEncargado.getText());
	    	cli.setTelEncargado(txtTelefonoEncargado.getText());
	    	cli.setMailEncargado(txtCorreoEncargado.getText());
	    	cli.setGeneroEncargado(txtGeneroEncargado.getText());
	    	cli.setEstado("Pendiente");
	    	cli.setSucursal(MainController.getSuc());
	    	ccte.setLimite(Float.parseFloat(txtLimitePrecio.getText()));
	    	ccte.setCondiciones(txtCondicionesPago.getText());
	    	ccte.setFecha(txtFechaPago.getText());
	    	ccte.setEstado("Pendiente");
	    	
	    	cli.setCuentaCorriente(ccte);
	    	
	    	try {
				BusinessDelegate.getInstancia().altaCliente(cli);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    }    
    
    private boolean todoCompletado() {
    	if(txtRazon.getText().isEmpty() || txtCuit.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNumeroDire.getText().isEmpty() || txtPisoDire.getText().isEmpty() || txtNombreEncargado.getText().isEmpty() || txtTelefonoEncargado.getText().isEmpty() || txtCorreoEncargado.getText().isEmpty() || txtCorreoEncargado.getText().isEmpty() || txtGeneroEncargado.getText().isEmpty() || txtLimitePrecio.getText().isEmpty() || txtCondicionesPago.getText().isEmpty() || txtFechaPago.getText().isEmpty())
    		return false;
    	else
    		return true;
	}

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
        txtGeneroEncargado.clear();

    }
}
