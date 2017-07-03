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
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class PrendaAltaController implements Initializable {
	@FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXButton btnEnviar;

    @FXML
    private Label lblFechaRegistro;

    @FXML
    private JFXButton btnLimpiar;

    @FXML
    private JFXTextField txtCostoProdActual;

    @FXML
    private JFXSlider sliderGanancia;

    @FXML
    private JFXTextField txtCantidad;

    @FXML
    private JFXTextField txtCosto;

    @FXML
    private JFXTextField txtNombre1;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField txtPrecio;

    @FXML
    private JFXTextField txtStockMin;
    
    @FXML
    private JFXComboBox<Label> comboTalle;

    @FXML
    private JFXComboBox<Label> comboEstado;

    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	lblFechaRegistro.setText("Fecha: " + df.format(Calendar.getInstance().getTime()));
    	
    	
    	comboTalle.getItems().add(new Label("S"));
    	comboTalle.getItems().add(new Label("M"));
    	comboTalle.getItems().add(new Label("L"));
    	comboTalle.getItems().add(new Label("XL"));
    	comboTalle.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    	
    	comboEstado.getItems().add(new Label("Discontinuo"));
    	comboEstado.getItems().add(new Label("En producción"));
    	comboEstado.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    	
    	
    	txtCosto.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtCosto.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
    	txtCostoProdActual.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtCostoProdActual.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
    	txtCantidad.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtCantidad.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    	
    	txtStockMin.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtStockMin.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
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
    	if(txtNombre.getText().isEmpty() || txtTalle.getText().isEmpty() || txtEstado.getText().isEmpty() || txtCosto.getText().isEmpty() || txtCostoProdActual.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtStockMin.getText().isEmpty())
    		return false;
    	else
    		return true;
	}

    
    @FXML
    void agregarPrenda(ActionEvent event) {

    }
    
	@FXML
    private void limpiarCampos(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        

    }
	
    private void limpiarCampos() {        

    }
}
