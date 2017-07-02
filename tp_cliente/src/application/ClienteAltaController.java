package application;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ClienteAltaController implements Initializable {
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
    private StackPane stackPane;

    @FXML
    private JFXTextField txtRazon;

    @FXML
    private Label lblFechaRegistro;

    @FXML
    private JFXTextField txtTelefonoEncargado;

    @FXML
    private JFXTextField txtCuit;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField txtGeneroEncargado;

    @FXML
    private JFXTextField txtLimitePrecio;

    @FXML
    private JFXTextField txtNombreEncargado;

   /* @SuppressWarnings("unchecked")
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	lblFechaRegistro.setText(df.format(Calendar.getInstance().getTime()));*/

    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	lblFechaRegistro.setText("Fecha: " + df.format(Calendar.getInstance().getTime()));
    }
    
    @FXML
    void enviarTramite(ActionEvent event) {
    	JFXDialogLayout content = new JFXDialogLayout();
    	Text titulo = new Text();
    	Text mensaje = new Text();
    	titulo.setFont(Font.font ("Verdana", 16));
    	content.setHeading(titulo);
    	JFXButton botOk = new JFXButton("OK");
    	JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.TOP);
    	botOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				dialog.close();
				btnLimpiar.setDisable(false);
	        	btnEnviar.setDisable(false);
			}
		});
    	content.setActions(botOk);
    	
    	
    	if(!todoCompletado()){
    		titulo.setText("Error");
    		mensaje.setText("Debe completar todos los campos\n" + "para enviar un nuevo cliente");
        	content.setBody(mensaje);
        	content.setHeading(titulo);
        	btnLimpiar.setDisable(true);
        	btnEnviar.setDisable(true);
        	
        	dialog.show();
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
	    	cli.setFechaRegistro(Calendar.getInstance().getTime());
	    	cli.setCuentaCorriente(ccte);
	    	
	    	try {
				BusinessDelegate.getInstancia().altaClientePendiente(cli);
				limpiarCampos();
				titulo.setText("Exito en la operación");
	    		mensaje.setText("El cliente fue agregado correctamente, el\n" + "personal de administración de clientes\n" + "debe revisar la información");
	        	content.setHeading(titulo);
	    		content.setBody(mensaje);
	        	btnLimpiar.setDisable(true);
	        	btnEnviar.setDisable(true);
	        	dialog.show();
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
	
    private void limpiarCampos() {        
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
